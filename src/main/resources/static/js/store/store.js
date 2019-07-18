import Vue from 'vue'
import Vuex from 'vuex'
import messageApi from 'api/message'

Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        profile: frontendData.profile,
        messages: frontendData.messages
    },
    getters: {
        sortedMessages: state => (state.messages || []).sort((a, b) => - (a.id - b.id))
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
                state.messages = [
                    ...state.messages.splice(0, deletionIndex),
                    ...state.messages.splice(deletionIndex + 1)
                ]
            }
        }
    },
    actions: {
        async addMessageAction({commit, state}, message) {
            const result = await messageApi.add(message)
            const data = await result.json()
            const index = state.messages.findIndex(item => item.id === data.id)

            if (index == -1) {
                commit('addMessageMutation', data)
            }
        },

        async removeMessageAction({commit, state}, message) {
            const result = await messageApi.remove(message.id)

            if (result.ok) {
                commit('removeMessageMutation', message)
            }
        }

    }
})