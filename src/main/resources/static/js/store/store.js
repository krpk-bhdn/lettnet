import Vue from 'vue'
import Vuex from 'vuex'
import messageApi from 'api/message'
import postApi from 'api/post'
import userApi from 'api/user'

Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        user: {},
        messages,
        ...frontendData
    },
    getters: {
        sortedMessages: state => (state.messages || []).sort((a, b) => - (a.id - b.id)),
        sortedPosts: state => (state.posts || []).sort((a, b) => - (a.id - b.id))
    },
    mutations: {
        addMessageMutation(state, message) {
            state.messages = [
                message,
                ...state.messages
            ]
        },
        removeMessageMutation(state, message) {

            const deletionIndex = state.messages.findIndex(item => item.id === message.id)

            if (deletionIndex > -1) {
                state.messages.splice(deletionIndex, 1)
            }
        },

        getPostMutation(state, posts) {
            state.posts = posts
        },
        addPostMutation(state, post) {
            state.posts = [
                post,
                ...state.posts
            ]
        },
        removePostMutation(state, post) {

            const deletionIndex = state.posts.findIndex(item => item.id === post.id)

            if (deletionIndex > -1) {
                state.posts.splice(deletionIndex, 1)
            }
        },

        getUserMutation(state, user) {
            state.user = user
        },

        updateProfileMutation(state, user) {
            state.profile = user;
        }
    },
    actions: {

        async addMessageAction({commit, state}, message) {
            const result = await messageApi.add(message)
            const data = await result.json()
            const index = state.messages.findIndex(item => item.id === data.id)

            if (index === -1) {
                commit('addMessageMutation', data)
            }
        },

        async removeMessageAction({commit, state}, message) {
            const result = await messageApi.remove(message.id)
            const data = await result.json()

            commit('removeMessageMutation', data)

        },


        async getPostAction({commit, state}, userId) {
            const result = await postApi.get(userId)
            const data = await result.json()

                commit('getPostMutation', data)

        },

        async addPostAction({commit, state}, post) {
            const result = await postApi.add(post)
            const data = await result.json()
            const index = state.posts.findIndex(item => item.id === data.id)

            if (index === -1) {
                commit('addPostMutation', data)
            }
        },

        async removePostAction({commit, state}, post) {
            const result = await postApi.remove(post.id)

            if (result.ok) {
                commit('removePostMutation', post)
            }
        },


        async getUserAction({commit, state}, userId) {
            const result = await userApi.get(userId)
            const data = await result.json()

            commit('getUserMutation', data)
        },

        async updateUserAction({commit, state}, user) {
            const result = await userApi.update(user)
            const data = await result.json()

            commit('updateProfileMutation', data)
        }
    }
})