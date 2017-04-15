import Ember from 'ember';
import ENV from '../../config/environment';

export default Ember.Component.extend({
  offset: ENV.defaultOffset,
  limit: ENV.defaultLimit,
  currentNumber: 1,
  init(){
    this._super(...arguments);
  },
  didInsertElement(){
    this._super(...arguments);
    let context = this;
    Ember.$("#pagination-page").pagination({
      items: context.get('count'),
      itemsOnPage: context.get('limit'),
      cssStyle: 'light-theme',
      onPageClick: function (pageNumber) {
        if (pageNumber > context.get('currentNumber')) {
          let currentNumber = pageNumber - context.get('currentNumber');
          let offset = context.get('offset') + (context.get('limit') * currentNumber);

          context.set('offset', offset);
          context.set('currentNumber', pageNumber);
          context.debug(context.get('offset'));
          context.sendAction("action", offset, context.get('limit'));
        } else {
          let currentNumber = context.get('currentNumber') - pageNumber;
          let offset = context.get('offset') - (context.get('limit') * currentNumber);

          context.set('offset', offset);
          context.set('currentNumber', pageNumber);
          context.debug(context.get('offset'));
          context.sendAction("action", offset, context.get('limit'));
        }

        context.debug("count: " + context.get('count'));
      }
    });
  }
});

