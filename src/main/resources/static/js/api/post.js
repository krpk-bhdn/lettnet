import Vue from 'vue'

const posts = Vue.resource("/post{/id}")

export default {
    get: id => posts.get({id}),
    add: post => posts.save({}, post),
    update: post => posts.update({id: post.id}, post),
    remove: id => posts.remove({id})
}
