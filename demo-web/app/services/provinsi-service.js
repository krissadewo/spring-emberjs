import Ember from 'ember';
import ENV from '../config/environment';

export default Ember.Service.extend({
  find(offset, limit) {
    let api = '/provinsis';
    if (offset !== null || limit !== null) {
      api = '/provinsis?offset=' + offset + '&limit=' + limit;
    }

    return Ember.$.getJSON(ENV.APP.API_HOST + api).then(
      function (response) {
        return response.data;
      }
    );
  },
  count() {
    return Ember.$.getJSON(ENV.APP.API_HOST + '/provinsis/count').then(
      function (response) {
        return response.data;
      }
    );
  }
});
