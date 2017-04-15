import Ember from 'ember';

export default Ember.Component.extend({
  init(){
    this._super(...arguments);
  },
  didInsertElement(){
    this._super(...arguments);
    Ember.$('.nav-setting-btn').on('click', function () {
      Ember.$('.floating-drawer-settings').toggleClass('hidden');
    });
  }
});
