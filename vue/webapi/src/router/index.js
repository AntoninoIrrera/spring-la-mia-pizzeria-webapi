import { createRouter, createWebHistory } from 'vue-router'
// import HomeView from '../views/HomeView.vue'
import PizzaApp from '../views/PizzaApp.vue'
import HomeApp from '../views/HomeApp.vue'
import CreatePizza from '../views/CreatePizza.vue'
import PizzaShow from '../views/PizzaShow.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/home',
      name: 'home',
      component: HomeApp
    },
    {
      path: '/pizzaIndex',
      name: 'pizzaIndex',
      component: PizzaApp
    },
    {
      path: '/createPizza',
      name: 'createPizza',
      component: CreatePizza
    },
    {
      path: '/:id',
      name: 'pizzaShow',
      component: PizzaShow
    }

    // {
    //   path: '/about',
    //   name: 'about',
    //   // route level code-splitting
    //   // this generates a separate chunk (About.[hash].js) for this route
    //   // which is lazy-loaded when the route is visited.
    //   component: () => import('../views/AboutView.vue')
    // }
  ]
})

export default router
