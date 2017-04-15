import Ember from 'ember';
import ENV from '../config/environment';

export default Ember.Service.extend({
  find(offset, limit) {
    let api = '/kabupatens';
    if (offset !== null || limit !== null) {
      api = '/kabupatens?offset=' + offset + '&limit=' + limit;
    }

    return Ember.$.getJSON(ENV.APP.API_HOST + api).then(
      function (response) {
        return response.data;
      }
    );
  },
  count() {
    return Ember.$.getJSON(ENV.APP.API_HOST + '/kabupatens/count').then(
      function (response) {
        return response.data;
      }
    );
  },
  save(data) {
    return new Ember.RSVP.Promise(
      function (resolve, reject) {
        Ember.$.ajax({
          type: 'POST',
          url: ENV.APP.API_HOST + '/kabupatens',
          contentType: 'application/json',
          data: JSON.stringify(data),
          success: function (response) {
            resolve(response);
          },
          error: function (error) {
            reject(error);
          }
        });
      });
  },
  delete(data) {
    return new Ember.RSVP.Promise(
      function (resolve, reject) {
        Ember.$.ajax({
          type: 'DELETE',
          url: ENV.APP.API_HOST + '/kabupatens/' + data,
          contentType: 'application/json',
          data: JSON.stringify(data),
          success: function (response) {
            resolve(response);
          },
          error: function (error) {
            reject(error);
          }
        });
      });
  }
});
