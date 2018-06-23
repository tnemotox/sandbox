import Vue from 'vue'
import App from './App.vue'
import sanitizeHTML from 'sanitize-html'

Vue.prototype.$sanitize = sanitizeHTML
new Vue({
  el: '#app',
  render: h => h(App)
})
