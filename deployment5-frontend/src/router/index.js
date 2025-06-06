import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    // {
    //   path: '/',
    //   name: 'home',
    //   component: () => import('../views/AboutView.vue'),
    // },
    {
      path:'/',
      name:"Monitor",
      component: ()=> import('../views/NodesMonitor.vue')
    },
    {
      path:'/data',
      name:"Data Endpoints",
      component: ()=> import('../views/DataView.vue')
    }
  ],
})

export default router
