import Ember from 'ember';

export function ng(params/*, hash*/) {
  let no = params[0]+1;
  return no;
}

export default Ember.Helper.helper(ng);
