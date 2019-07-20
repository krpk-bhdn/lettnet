<template>
    <v-app class="grey lighten-4">
        <v-toolbar>
            <v-toolbar-title>Lett<b>Net</b></v-toolbar-title>
            <v-spacer></v-spacer>
            <v-toolbar-items v-if="profile">
                <v-btn flat small href="/logout">
                    <v-layout align-center justify-center column>
                        <v-icon>exit_to_app</v-icon>
                        Log out
                    </v-layout>
                </v-btn>
            </v-toolbar-items>
        </v-toolbar>

        <v-content id="content">
            <v-layout>
                <v-flex xs2 v-if="profile">
                    <v-navigation-drawer
                            class="grey lighten-4"
                            stateless
                            value="true"
                    >
                        <v-list>
                            <v-list-tile @click="showProfile">
                                <v-list-tile-action>
                                    <v-avatar size="32px">
                                        <img :src="profile.picture">
                                    </v-avatar>
                                </v-list-tile-action>
                                <v-list-tile-title>{{ profile.name }}</v-list-tile-title>
                            </v-list-tile>

                            <v-divider></v-divider>

                            <v-list-tile>
                                <v-list-tile-action>
                                    <v-icon>list</v-icon>
                                </v-list-tile-action>
                                <v-list-tile-title>News</v-list-tile-title>
                            </v-list-tile>

                            <v-list-tile>
                                <v-list-tile-action>
                                    <v-icon>people</v-icon>
                                </v-list-tile-action>
                                <v-list-tile-title>Friends</v-list-tile-title>
                            </v-list-tile>

                            <v-list-tile @click="showMessages">
                                <v-list-tile-action>
                                    <v-icon>chat</v-icon>
                                </v-list-tile-action>
                                <v-list-tile-title>Messages</v-list-tile-title>
                            </v-list-tile>

                            <v-divider></v-divider>

                            <v-list-tile>
                                <v-list-tile-action>
                                    <v-icon>settings</v-icon>
                                </v-list-tile-action>
                                <v-list-tile-title>Settings</v-list-tile-title>
                            </v-list-tile>

                        </v-list>
                    </v-navigation-drawer>
                </v-flex>
                <v-flex>
                    <v-container>
                        <router-view></router-view>
                    </v-container>
                </v-flex>
            </v-layout>

        </v-content>
    </v-app>
</template>

<script>
    import { mapState, mapMutations } from 'vuex'
    import { addHandler} from 'util/ws'

    export default {
        computed: mapState(['profile']),
        methods: {
            ...mapMutations([
                'addMessageMutation',
                'removeMessageMutation'
            ]),
            showMessages() {
                this.$router.push('/')
            },
            showProfile() {
                this.$router.push(`/profile/${this.profile.id}`)
                this.$router.go()
            }
        },
        created() {
            addHandler(data => {
                if (data.objectType === 'MESSAGE') {
                    switch (data.eventType) {
                        case 'CREATE':
                            this.addMessageMutation(data.body)
                            break
                        case 'UPDATE':
                            break
                        case 'REMOVE':
                            this.removeMessageMutation(data.body)
                            break
                        default:
                            console.error(`Looks like the event type if unknown "${data.eventType}"`)
                    }
                } else {
                    console.error(`Looks like the object type if unknown "${data.objectType}"`)
                }
            })
        },
        beforeMount() {
            if (!this.profile) {
                this.$router.replace('/auth')
            } else if (this.$route.path === '/auth') {
                this.$router.replace('/')
            }
        }
    }

</script>

<style>

</style>