import Ember from 'ember';

export default Ember.Component.extend({
  actions: {
    click(){
      this.sendAction("action", this.get('param'));
    }
  }
});
