export function initialize( application ) {
  application.inject('service:commonService','notificationService', 'service:notification-messages');
  application.inject('controller','commonService', 'service:common-service');
}

export default {
  name: 'inject-notifications',
  initialize
};
