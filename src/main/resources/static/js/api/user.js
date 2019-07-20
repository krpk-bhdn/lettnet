import Vue from 'vue'

const users = Vue.resource("/user{/id}")

export default {
    get: id => users.get({id})
}