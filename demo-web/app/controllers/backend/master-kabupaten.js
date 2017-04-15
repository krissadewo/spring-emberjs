import Ember from 'ember';

export default Ember.Controller.extend({
  kabupatenService: Ember.inject.service(),
  selectedProvinsi: 0,
  actions: {
    onSelectedProvinsi(param){
      this.set('selectedProvinsi', param);
      console.log(this.get('selectedProvinsi'));
    },
    clearField(){
      this.set('id', 0);
      this.set('textFieldKode', null);
      this.set('textFieldNama', null);
    },
    doEdit(param){
      let kabupaten = this.get('kabupatens.[].' + param);

      this.set('id', kabupaten.id);
      this.set('textFieldKode', kabupaten.kode);
      this.set('textFieldNama', kabupaten.nama);
      this.set('selectedProvinsi', kabupaten.provinsi.id);

      this.debug('doEdit:' + this.get('selectedProvinsi'));
    },
    doSave(){
      console.log("ok");
      let data = {
        id: this.get('id'),
        kode: this.get('textFieldKode'),
        nama: this.get('textFieldNama'),
        provinsi: {
          id: this.get('selectedProvinsi')
        },
      };

      const context = this;
      if (this.get('textFieldKode') !== null && this.get('textFieldNama') !== 0 && this.get('selectedProvinsi') !== 0) {
        this.get('kabupatenService').save(data).then(
          function (response) {
            context.get('commonService').showNotification(response);
            context.get('target.router').refresh();

            Ember.$('#modal-save').modal('hide');
          }, function (e) {
            this.get('commonService').showNotification(e);
          });
      } else {
        alert("data tidak lengkap");
      }

      this.send('clearField');
    },
    doDelete(param){
      const context = this;
      this.get('kabupatenService').delete(param).then(
        function (response) {
          context.get('commonService').showNotification(response);
          context.get('target.router').refresh();

          Ember.$('#modal-confirmation-delete-' + param).modal('hide');
        }, function (e) {
          context.get('commonService').showNotification(e);
        });
    },
    doFind(offset, limit){
      const context = this;
      this.get('kabupatenService').find(offset, limit).then(
        function (response) {
          let kabupatens = response;
          context.debug(kabupatens);
          context.set('kabupatens', kabupatens);
        });
    }
  }
});
