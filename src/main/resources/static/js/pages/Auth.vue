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

                        <v-card-actions>
                        <v-btn block href="/login">
                            Continue with Google
                        </v-btn>
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