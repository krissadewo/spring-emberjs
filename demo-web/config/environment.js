/* jshint node: true */

module.exports = function (environment) {

  var ENV = {
    modulePrefix: 'demo-web',
    environment: environment,
    defaultOffset: 0,
    defaultLimit: 10,
    rootURL: '/',
    locationType: 'auto',
    EmberENV: {
      FEATURES: {
        // Here you can enable experimental features on an ember canary build
        // e.g. 'with-controller': true
      },
      EXTEND_PROTOTYPES: {
        // Prevent Ember Data from overriding Date.parse.
        Date: false
      },
    },

    APP: {
      LOGGER: false,
      API_HOST: 'http://127.0.0.1:9090/demo'
      // Here you can pass flags/options to your application instance
      // when it is created
    }
  };

  return ENV;
};
