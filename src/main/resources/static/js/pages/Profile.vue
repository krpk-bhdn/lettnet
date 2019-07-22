<template>
    <v-container>
        <v-layout row wrap>
            <v-flex xs8 offset-xs2>
                <v-card class="mb-3">
                    <v-img
                            src="http://eguru.tk.te.ua/pluginfile.php/827/course/overviewfiles/6156603dafdf8e5.jpg"
                            aspect-ratio="6"
                    >

                    </v-img>

                    <v-layout row nowrap>
                        <v-flex (xs12 | sm5 | md3)>
                            <v-container style="margin-top: -100px;">

                                <v-avatar size="150px" >
                                    <v-img
                                            :src="user.picture"
                                    ></v-img>
                                </v-avatar>

                                <h3 class="headline mt-2">{{ user.name }}</h3>
                                <span>{{user.lastVisit}}</span>
                                <div class="mt-3" v-if="user.headline">
                                    <span>{{ user.headline }}</span>
                                </div>

                            </v-container>
                        </v-flex>

                        <v-flex (xs12 | sm5 | md5) offset-(xs0 | lg2) class="ma-3">
                            <div class="mb-1" v-if="user.email">
                                <span>E-mail: {{user.email}}</span>
                            </div>
                            <div class="mb-1" v-if="user.locale">
                                <span>Country: {{user.locale}}</span>
                            </div>
                            <div class="mb-1" v-if="user.bio">
                                <span>{{ user.bio }}</span>
                            </div>

                        </v-flex>

                    </v-layout>

                </v-card>

            </v-flex>

            <v-flex xs8 offset-xs2>
                <post-list :profile="profile"/>
            </v-flex>

        </v-layout>
    </v-container>
</template>

<script>
    import { mapState, mapActions } from 'vuex'
    import PostList from "../components/PostList.vue";
    import UploadFile from 'components/UploadFile.vue'
    export default {
        components: { PostList, UploadFile },
        computed: mapState(["profile", "user"]),
        methods: {
            ...mapActions(["getUserAction"])
        },
        created() {
            this.getUserAction(this.$route.params.id)
        }
    }
</script>

<style scoped>

</style>