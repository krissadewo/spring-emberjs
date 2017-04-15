import Ember from 'ember';

export function nav(params/*, hash*/) {
  return "backend."+params;
}

export default Ember.Helper.helper(nav);
