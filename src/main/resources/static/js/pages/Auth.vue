<template>
    <v-container>
        <v-layout row wrap>
            <v-flex xs4 offset-xs4>
                <v-card>
                    <v-container>

                        <v-card-title>
                            <v-spacer/>
                            <span class="display-2">
                                Lett<b>Net</b>
                            </span><v-spacer/>

                        </v-card-title>

                        <v-card-text>
                        <v-text-field
                                label="Login"
                        >
                        </v-text-field>
                        <v-text-field
                                label="Password"
                                type="password"
                        >
                        </v-text-field>
                        <v-btn block>
                            Sign In
                        </v-btn>
                        <v-layout align-center justify-center row class="my-3">
                            <v-divider/>
                            <span class="mx-2">
                        OR
                    </span>
                            <v-divider/>
                        </v-layout>
                        <v-btn block href="/login/google">
                            Continue with Google
                        </v-btn>
                        </v-card-text>

                        <v-card-actions class="subheading">
                            <v-spacer/>
                            <span>Do not have an account yet? <registration-dialog/> </span>
                            <v-spacer/>
                        </v-card-actions>

                    </v-container>
                </v-card>
            </v-flex>
        </v-layout>


    </v-container>
</template>

<script>
    import RegistrationDialog from 'components/RegistrationDialog.vue'
    export default {
        components: {
            RegistrationDialog
        }
    }
</script>

<style scoped>

</style>