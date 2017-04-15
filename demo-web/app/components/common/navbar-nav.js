import Ember from 'ember';

export default Ember.Component.extend({
  modelMenu: null,
  init(){
    this._super(...arguments);
  },
  didInsertElement(){
    Ember.$('#drawer-btn').on('click', function () {
      Ember.$('.li-span').toggleClass('hidden');
      Ember.$('.nav-custom li i').toggleClass('hidden');
      Ember.$('.nav-custom').toggleClass('width300nav-custom');
      Ember.$('.navbar').toggleClass('left300pxnavOpen');
      Ember.$('.dashboard-alt').toggleClass('on-container-content-drawer-open');
      Ember.$('.pos-dashboard-wrapper').toggleClass('wrapper-container-content-drawer-open');
      if (Ember.$(".nav-custom").hasClass('width300nav-custom')) {
        Ember.$('.li-item-dropdown').removeClass('hidden');
      } else {
        Ember.$('.li-item-dropdown').addClass('hidden');
      }
    });

    Ember.$('.nav-item').on('click', function () {
      Ember.$(this).find('ul').toggleClass('hidden');
      Ember.$(this).find('.i-drop').toggleClass('rotate180');
    });

    this._super(...arguments);
  }
});
