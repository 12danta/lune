import Vue from 'vue'
import VueRouter from 'vue-router'
import Header from '../components/layout/Header'
import Dashboard from '../views/admin/Dashboard'
import Users from '../views/admin/UserList'
import Music from '../views/admin/Music'
import Composer from '../views/admin/Composer'

Vue.use(VueRouter)

export default new VueRouter({
  routes: [
    {
      path: '/',
      redirect: '/dashboard'
    },
    {
      path: '/index',
      component: Header,
      children: [
        {
          path: '/dashboard',
          component: Dashboard
        },
        {
          path: '/users',
          component: Users
        },
        {
          path: '/music',
          component: Music
        },
        {
          path: '/composer',
          component: Composer
        }
      ]
    }
  ]
})
