import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import login from "@/components/login";
import input from "@/components/input";
import Table from "@/components/table"
Vue.use(Router)
//这个地方写路由配置
//下面写路由配置相关路径，上面也必须相应导入
export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path:'/login',
      name:'login',
      component:login
    },
    {
      path:'/input123',
      name:'input',
      component:input
    },
    {
      path:'/Table',
      name:'table',
      component:Table
    }

  ]
})
