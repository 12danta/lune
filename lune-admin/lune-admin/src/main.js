// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import './assets/icon/iconfont.css'
import './assets/icon/iconfont.js'

import locale from 'element-ui/lib/locale/lang/en'
import videojs from 'video.js'
import 'video.js/dist/video-js.css'
import Vuex from 'vuex'

Vue.use(Vuex)

Vue.prototype.$video = videojs

// import echarts from 'echarts'
// Vue.prototype.$echarts = echarts
Vue.use(ElementUI, { locale })
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
