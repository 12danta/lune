import Vue from 'vue'
import Router from 'vue-router'
import Header from '../components/layout/Header'
import Data from '../views/admin/Data'
import Users from '../views/admin/UserList'
import Music from '../views/admin/Music'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      redirect: '/data'
    },
    {
      path: '/index',
      component: Header,
      children: [
        {
          path: '/data',
          component: Data
        },
        {
          path: '/users',
          component: Users
        },
        {
          path: '/music',
          component: Music
        }
      ]
    }
  ]
})
