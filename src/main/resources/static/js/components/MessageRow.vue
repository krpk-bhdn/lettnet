<template>
    <v-card flat >
        <v-card-text>
            <v-layout align-center mb-3>
                <v-avatar size="32px" class="mr-3">
                    <img :src="message.author.picture">
                </v-avatar>
                <span class="title font-weight-regular font-italic">{{ message.author.name }}</span>
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