import Ember from 'ember';
import ENV from '../../config/environment';

export default Ember.Route.extend({
  kabupatenService: Ember.inject.service(),
  provinsiService: Ember.inject.service(),
  model(){
    return Ember.RSVP.hash({
      provinsis: this.get('provinsiService').find(ENV.defaultOffset, 100),
      kabupatens: this.get('kabupatenService').find(ENV.defaultOffset, ENV.defaultLimit),
      kabupatenCount: this.get('kabupatenService').count()
    });
  },
  setupController(controller, model) {
    this.controllerFor('backend.master-kabupaten').set('provinsis', model.provinsis);
    this.controllerFor('backend.master-kabupaten').set('kabupatens', model.kabupatens);
    this.controllerFor('backend.master-kabupaten').set('kabupatenCount', model.kabupatenCount);
  }
});
