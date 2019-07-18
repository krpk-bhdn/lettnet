<template>
    <v-layout align-space-between justify-center row fill-height>
        <v-text-field
                label="Write something..."
                v-model="text"
                @keyup.enter="save"
        ></v-text-field>
        <v-btn flat round @click="save"><v-icon>send</v-icon></v-btn>
    </v-layout>
</template>

<script>
    import { mapActions } from 'vuex'
    export default {
        data() {
            return {
                text: ''
            };
        },
        watch: {
            messageAttr(newVal, oldVal) {
                this.text = newVal.text
            }
        },
        methods: {
            ...mapActions(['addMessageAction']),
            save() {
                const message = {
                    text: this.text
                }

                this.addMessageAction(message)

                this.text = ''
            }
        }
    }
</script>

<style scoped>

</style>