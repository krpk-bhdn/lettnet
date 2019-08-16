<template>
    <v-card class="mb-1">
        <v-container class="pa-2">
            <v-card-title class="pb-0">
                <v-layout align-center mb-3>
                    <a :href="`/profile/${message.author.id}`"
                        style="text-decoration: none">
                        <v-avatar size="32px" class="mr-3">
                            <img :src="message.author.picture">
                        </v-avatar>
                        <span class="subheading font-weight-regular font-italic">{{ message.author.name }}</span>
                    </a>
                    <v-spacer></v-spacer>
                    <span class="mr-3">{{ message.publicationDate }}</span>
                    <v-btn v-if="profile.id === message.author.id" icon @click="del">
                        <v-icon>delete</v-icon>
                    </v-btn>
                </v-layout>
            </v-card-title>

            <v-container grid-list-sm fluid v-if="message.images">
                <v-layout row wrap>
                    <v-flex
                            v-for="img in message.images.split('/')"
                            v-if="img"
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

            <v-card-text class="pt-1 body-1" v-if="message.text">
                {{ message.text }}
            </v-card-text>

            <v-card-text class="py-1" v-if="message.files">
                <v-layout column>
                    <span>Files:</span>
                    <a v-for="file in message.files.split('/')"
                       :href="`http://localhost:8080/file/${file}`"
                       target="_blank"
                       class="px-3"
                    >
                        {{file}}
                    </a>
                </v-layout>
            </v-card-text>

        </v-container>

    </v-card>
</template>

<script>
    import { mapActions, mapState } from 'vuex'
    export default {
        props: ['message'],
        computed: mapState(["profile"]),
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