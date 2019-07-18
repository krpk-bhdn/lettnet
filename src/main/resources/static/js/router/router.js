import Vue from 'vue'
import VueRouter from 'vue-router'

import MessageList from 'components/MessageList.vue'
import Auth from 'pages/Auth.vue'

Vue.use(VueRouter)

const routes = [
    {path: '/', MessageList},
    {path: '/auth', component: Auth},
    {path: '*', MessageList}
]


export default new VueRouter({
    mode: 'history',
    routes
})