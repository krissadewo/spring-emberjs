import Ember from 'ember';
import config from './config/environment';

const Router = Ember.Router.extend({
  location: config.locationType,
  rootURL: config.rootURL
});

Router.map(function () {
  this.route('common.not-found', {path: "*path"});
  this.route('backend.master-kabupaten', {path: 'master-kabupaten'});
  this.route('backend.master-provinsi', {path: 'master-provinsi'});
});

export default Router;
