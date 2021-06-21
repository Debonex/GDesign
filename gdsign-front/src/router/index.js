import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [{
    path: '/',
    redirect: '/main'
  }, {
    path: '/main',
    name: 'Main',
    component: () => import('@/views/layout/MainLayout')
  }, {
    path: '/recommend',
    name: 'Recommend',
    component: () => import('@/views/pages/RecommendPage')
  }, {
    path: '/compare',
    component: () => import('@/views/pages/ComparePage')
  }, {
    path: '/order',
    component: () => import('@/views/pages/OrderPage')
  }, {
    path: '/commodity',
    component: () => import('@/views/pages/CommodityPage')
  }]
})
