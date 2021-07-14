const _ = require('lodash')

const index = [
  {
    path: "/",
    redirect: "/login"
  },
  {
    path: "/login",
    component: () => import("@/views/pages/Login.vue")
  },
  {
    path: "/register",
    component: () => import("@/views/pages/Register.vue")
  }
];

const main = [
  {
    path: "/recommend",
    component: () => import("@/views/pages/RecommendPage")
  },
  {
    path: "/compare",
    component: () => import("@/views/pages/ComparePage")
  },
  {
    path: "/order",
    component: () => import("@/views/pages/OrderPage")
  },
  {
    path: "/commodity",
    component: () => import("@/views/pages/CommodityPage")
  }
];

const routes = _.concat(index, main);

export default routes;
