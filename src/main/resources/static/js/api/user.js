import Vue from 'vue'

const users = Vue.resource("/user{/id}")

export default {
    get: id => users.get({id}),
    update: user => users.update({id: user.id}, user),
    remove: id => users.delete({id})
}