// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import Element from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import VueResource from 'vue-resource'

Vue.use(Element)
Vue.use(VueResource)
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({ //这个就是之前的Vue实例，只是没写var vm =
  el: '#app',
  data:{

  },
  methods:{

  },
  router,
  components: { App },
  template: '<App/>'
})
