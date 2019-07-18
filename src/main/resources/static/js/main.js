import Vue from 'vue'
import Vuetify from 'vuetify'
import '@babel/polyfill'
import router from 'router/router'
import App from 'pages/App.vue'
import 'vuetify/dist/vuetify.min.css'


Vue.use(Vuetify)

new Vue({
    el: '#app',
    render: a => a(App),
    router
})