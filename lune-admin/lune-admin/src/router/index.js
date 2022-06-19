import Vue from 'vue'
import VueRouter from 'vue-router'
import Header from '../components/layout/Header'
import Dashboard from '../views/admin/Dashboard'
import Users from '../views/admin/UserList'
import Music from '../views/admin/Music'
import Performer from '../views/admin/Performer'
import Composer from '../views/admin/Composer'
import Album from '../views/admin/Album'
import PDFView from '../views/admin/PDFView'
import VideoPlayer from '../views/admin/VideoPlayer'
import playMusic from '../components/playMusic'

Vue.use(VueRouter)

// 获取原型对象上的push函数
const originalPush = VueRouter.prototype.push
// 修改原型对象中的push方法
VueRouter.prototype.push = function push (location) {
  console.log('location', location)
  return originalPush.call(this, location).catch(err => err)
}

export default new VueRouter({
  routes: [
    {
      path: '/',
      redirect: '/dashboard'
    },
    {
      path: '/pdfView',
      component: PDFView
    },
    {
      path: '/video',
      component: VideoPlayer
    },
    {
      path: '/mscplay',
      component: playMusic
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
          path: '/performer',
          component: Performer
        },
        {
          path: '/composer',
          component: Composer
        },
        {
          path: '/album',
          component: Album
        }
      ]
    }
  ]
})
