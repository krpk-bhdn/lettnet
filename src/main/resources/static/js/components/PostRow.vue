<template>
    <v-card class="mb-3">
        <v-container class="pa-2">
            <v-card-title class="pb-1">
                <v-layout align-center mb-3>
                    <v-avatar size="48px" class="mr-3">
                        <img :src="post.author.picture">
                    </v-avatar>
                    <span class="title font-weight-regular font-italic">{{ post.author.name }}</span>
                    <v-spacer></v-spacer>
                    <v-btn icon @click="del">
                        <v-icon>edit</v-icon>
                    </v-btn>
                    <v-btn icon @click="del">
                        <v-icon>delete</v-icon>
                    </v-btn>
                </v-layout>
            </v-card-title>
            <v-card-text class="pt-1 body-1">
                {{ post.text }}
            </v-card-text>

            <v-card-actions>
                <v-btn icon @click="">
                    <v-icon>favorite_border</v-icon>
                </v-btn>
                <v-btn icon @click="">
                    <v-icon>comment</v-icon>
                </v-btn>
                <v-spacer></v-spacer>
                <span class="mr-3">{{ post.publicationDate }}</span>
            </v-card-actions>

        </v-container>

    </v-card>
</template>

<script>
    import { mapActions } from 'vuex'
    export default {
        props: ['post'],
        methods: {
            ...mapActions(['removePostAction']),
            del() {
                this.removePostAction(this.post)
            }
        }
    }
</script>

<style scoped>

</style>
