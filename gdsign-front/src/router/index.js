import Vue from "vue";
import Router from "vue-router";
import routes from "./routes"

Vue.use(Router);

const originalPush = Router.prototype.push
Router.prototype.push = function push(location, onResolve, onReject) {
    if (onResolve || onReject) return originalPush.call(this, location, onResolve, onReject)
    return originalPush.call(this, location).catch(e => e)
}

const originalReplace = Router.prototype.replace
Router.prototype.replace = function replace(location, onResolve, onReject) {
    if (onResolve || onReject) return originalReplace.call(this, location, onResolve, onReject)
    return originalReplace.call(this, location).catch(e => e)
}

Router.prototype.reload = function reload(location, onResolve, onReject) {
    //TODO check if querystring or hash is already existed
    this.replace(location + "?reload=" + new Date())
    this.replace(location, onResolve, onReject)
}

const GRouter = new Router({
  routes
})

export default GRouter
