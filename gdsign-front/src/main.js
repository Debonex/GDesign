// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from "vue";
import VueCookies from "vue-cookies";
import App from "./App";
import router from "./router";

import api from "./api/api";
Vue.use(api);
Vue.use(VueCookies);

/**
 * bootstrap
 */
import { BootstrapVue, IconsPlugin } from "bootstrap-vue";
Vue.use(BootstrapVue);
Vue.use(IconsPlugin);
import "bootstrap/dist/css/bootstrap.css";
import "bootstrap-vue/dist/bootstrap-vue.css";
/**
 * less
 */
import less from "less";
Vue.use(less);

/**
 * vuex
 */
import store from "./store/index";

/**
 * plugins
 */
import gnotify from "./plugins/gnotify";
Vue.use(gnotify);

Vue.config.productionTip = false;

/* eslint-disable no-new */
new Vue({
  el: "#app",
  router,
  store,
  components: {
    App
  },
  template: "<App/>"
});
