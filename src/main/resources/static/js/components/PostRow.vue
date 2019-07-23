<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <v-card class="mb-3">
        <v-container class="pa-2">
            <v-card-title class="pb-1">
                <v-layout align-center mb-3>
                    <v-avatar size="48px" class="mr-3">
                        <img :src="post.author.picture">
                    </v-avatar>
                    <span class="title font-weight-regular font-italic">{{ post.author.name }}</span>
                    <v-spacer></v-spacer>
                    <v-btn v-if="profile.id === post.author.id" icon @click="">
                        <v-icon>edit</v-icon>
                    </v-btn>
                    <v-btn v-if="profile.id === post.author.id" icon @click="del">
                        <v-icon>delete</v-icon>
                    </v-btn>
                </v-layout>
            </v-card-title>

            <v-container grid-list-sm fluid v-if="post.images">
                <v-layout row wrap>
                    <v-flex
                            v-for="img in post.images.split('/')"
                            v-if="img && img !== ''"
                            :key="img"
                            d-flex
                    >
                        <v-card flat tile class="d-flex">
                            <v-img
                                    :src="`http://localhost:8080/file/${img}`"
                                    aspect-ratio="1"
                                    class="grey lighten-2"
                                    style="min-width: 200px"
                            >
                                <template v-slot:placeholder>
                                    <v-layout
                                            fill-height
                                            align-center
                                            justify-center
                                            ma-0
                                    >
                                        <v-progress-circular indeterminate color="grey lighten-5"></v-progress-circular>
                                    </v-layout>
                                </template>
                            </v-img>
                        </v-card>
                    </v-flex>
                </v-layout>
            </v-container>

            <v-card-text class="pt-1 body-1" v-if="post.text">
                {{ post.text }}
            </v-card-text>

            <v-card-text class="py-1" v-if="post.files">
                <v-layout column>
                    <span>Files:</span>
                    <a v-for="file in post.files.split('/')"
                       :href="`http://localhost:8080/file/${file}`"
                       target="_blank"
                       class="px-3"
                    >
                        {{file}}
                    </a>
                </v-layout>
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
    import { mapActions, mapState } from 'vuex'
    export default {
        props: ['post'],
        computed: mapState(["profile"]),
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
