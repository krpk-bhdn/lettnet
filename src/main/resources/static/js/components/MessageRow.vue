<template>
    <v-card class="pa-3">
        <v-card-text class="pa-1">
            <v-layout align-center class="mb-0">
                <v-avatar size="32px" class="mr-3">
                    <img :src="message.author.picture">
                </v-avatar>
                <span>
                    <a class="subheading font-weight-regular" style="text-decoration: none" :href="`/profile/${message.author.id}`">
                        {{ message.author.name }}
                    </a>
                </span>
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