import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Test from "../views/Test"
import Index from"../views/Index"
import Update from"../views/Update"
import Add from"../views/Add"

Vue.use(VueRouter)

const routes = [
    {
        path: '/add',
        name: 'Add',
        component: Add
    },
    {
        path: '/update',
        name: 'Update',
        component: Update
    },
    {
        path: '/index',
        name: 'Index',
        component: Index
    },
  {
    path: '/test',
    name: 'Test',
    component: Test
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
