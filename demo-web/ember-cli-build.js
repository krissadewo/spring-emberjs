/*jshint node:true*/
/* global require, module */
var EmberApp = require('ember-cli/lib/broccoli/ember-app');

module.exports = function (defaults) {
    var app = new EmberApp(defaults, {
        // Add options here
    });

    // Use `app.import` to add additional libraries to the generated
    // output files.
    //
    // If you need to use different assets in different
    // environments, specify an object as the first parameter. That
    // object's keys should be the environment name and the values
    // should be the asset to use in that environment.
    //
    // If the library that you are including contains AMD or ES6
    // modules that you would like to import into your application
    // please specify an object with the list of modules as keys
    // along with the exports of each module as its value.
    app.import('bower_components/bootstrap/js/tab.js');
    app.import('bower_components/bootstrap/js/modal.js');
    app.import('bower_components/jquery-ui/jquery-ui.js');
    app.import('bower_components/chart.js/dist/Chart.bundle.js');
    app.import('bower_components/font-awesome/fonts/fontawesome-webfont.ttf');
    app.import('bower_components/font-awesome/fonts/fontawesome-webfont.otf');
    app.import('bower_components/font-awesome/fonts/fontawesome-webfont.svg');
    app.import('bower_components/font-awesome/fonts/fontawesome-webfont.eot');
    app.import('bower_components/font-awesome/fonts/fontawesome-webfont.woff');
    app.import('bower_components/font-awesome/fonts/fontawesome-webfont.woff2');
    app.import('bower_components/bootstrap/dist/css/bootstrap.css');
    app.import('bower_components/jquery-ui/themes/base/jquery-ui.css');
    app.import('bower_components/jquery-ui/themes/base/theme.css');
    app.import('bower_components/simplePagination.js/jquery.simplePagination.js');
    app.import('bower_components/simplePagination.js/simplePagination.css');
    app.import('bower_components/animate.css/animate.css');
    return app.toTree();
};
