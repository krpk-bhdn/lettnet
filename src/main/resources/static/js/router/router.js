import Vue from 'vue'
import VueRouter from 'vue-router'

import MessageList from 'components/MessageList.vue'
import Auth from 'pages/Auth.vue'

Vue.use(VueRouter)

const routes = [
    {path: '/', component: MessageList},
    {path: '/auth', component: Auth},
    {path: '*', component: MessageList}
]


export default new VueRouter({
    mode: 'history',
    routes
})