import Ember from 'ember';

const responses = [];
responses['0010'] = "Data berhasil disimpan";
responses['0011'] = "Data sudah ada";
responses['0020'] = "Gagal menyimpan data"; // exception occurs in database level
responses['0014'] = "Data berhasil dihapus";
responses['0015'] = "Gagal menghapus data";
responses['0060'] = "Data tidak lengkap";

export default Ember.Service.extend({
  init(){
    this._super(...arguments);
    this.get('notificationService').setDefaultAutoClear(true);
  },
  showNotification(response) {
    let message = responses[response.status];
    if (message !== undefined) {
      this.get('notificationService').success(responses[response.status]);
    } else {
      this.get('notificationService').error('Jaringan bermasalah!');
    }

    this.debug(JSON.stringify(response));
  },
});
