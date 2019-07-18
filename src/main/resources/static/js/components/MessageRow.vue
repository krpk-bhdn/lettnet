<template>
    <v-card flat >
        <v-card-text>
            <v-layout align-center mb-3>
                <v-avatar class="mr-3">
                    <img :src="message.author.picture">
                </v-avatar>
                <strong class="title">{{ message.author.name }}</strong>
                <v-spacer></v-spacer>
                <v-btn icon @click="del">
                    <v-icon>delete</v-icon>
                </v-btn>
            </v-layout>
            <div class="mx-5">{{ message.text }} </div>
        </v-card-text>
    </v-card>
</template>

<script>
    import { mapActions } from 'vuex'
    export default {
        props: ['message'],
        methods: {
            ...mapActions(['removeMessageAction']),
            del() {
                this.removeMessageAction(this.message)
            }
        }
    }
</script>

<style scoped>

</style>