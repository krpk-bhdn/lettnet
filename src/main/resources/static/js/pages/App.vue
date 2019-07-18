<template>
    <v-app>
        <v-toolbar>

            <v-toolbar-title>Lett<b>Net</b></v-toolbar-title>

            <v-spacer></v-spacer>
            <span v-if="profile">{{profile.name}}</span>
            <v-btn v-if="profile" icon href="/logout">
                <v-icon>exit_to_app</v-icon>
            </v-btn>
        </v-toolbar>
        <v-content>
            <router-view></router-view>
        </v-content>
    </v-app>
</template>

<script>
    export default {
        name: "App",
        data() {
            return {
                profile: frontendData.profile
            }
        },
        beforeMount() {
            if (!this.profile) {
                this.$router.replace('/auth')
            }
        }
    }

</script>

<style>

</style>