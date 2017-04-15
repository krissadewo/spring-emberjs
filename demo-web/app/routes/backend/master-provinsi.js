import Ember from 'ember';
import ENV from '../../config/environment';

export default Ember.Route.extend({
  kabupatenService: Ember.inject.service(),
  provinsiService: Ember.inject.service(),
  model(){
    return Ember.RSVP.hash({
      kabupatens: this.get('kabupatenService').find(ENV.defaultOffset, ENV.defaultLimit),
      provinsis: this.get('provinsiService').find(ENV.defaultOffset, ENV.defaultLimit),
      provinsiCount: this.get('provinsiService').count()
    });
  },
  setupController(controller, model) {
    this.controllerFor('backend.master-provinsi').set('kabupatens', model.kabupatens);
    this.controllerFor('backend.master-provinsi').set('provinsis', model.provinsis);
    this.controllerFor('backend.master-provinsi').set('provinsiCount', model.provinsiCount);
  }
});
