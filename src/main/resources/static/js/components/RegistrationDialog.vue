<template>
    <v-layout row justify-center>
        <v-btn
                color="primary"
                dark
                @click.stop="dialog = true"
        >
            Open Dialog
        </v-btn>

        <v-dialog
                v-model="dialog"
                max-width="60vw"
        >
            <v-card>
                <v-card-title class="headline">Lett<b>Net</b></v-card-title>

                <v-stepper v-model="e1">
                    <v-stepper-header>
                        <v-stepper-step :complete="e1 > 1" step="1">Personal data</v-stepper-step>

                        <v-divider></v-divider>

                        <v-stepper-step :complete="e1 > 2" step="2">Contacts</v-stepper-step>

                        <v-divider></v-divider>

                        <v-stepper-step step="3">Completion</v-stepper-step>
                    </v-stepper-header>

                    <v-stepper-items>
                        <v-stepper-content step="1">
                            <v-card
                                    flat
                                    class="mb-3"
                                    hight="300px"
                            >

                                <v-text-field flat label="First name"/>
                                <v-text-field flat label="Last name"/>
                                <v-text-field flat label="Country"/>
                            </v-card>

                            <v-btn
                                    color="primary"
                                    @click="e1 = 2"
                            >
                                Continue
                            </v-btn>

                            <v-btn flat>Cancel</v-btn>
                        </v-stepper-content>

                        <v-stepper-content step="2">
                            <v-card
                                    class="mb-3"
                                    color="grey lighten-1"
                                    height="300px"
                            ></v-card>

                            <v-btn
                                    color="primary"
                                    @click="e1 = 3"
                            >
                                Continue
                            </v-btn>

                            <v-btn flat>Cancel</v-btn>
                        </v-stepper-content>

                        <v-stepper-content step="3">
                            <v-card
                                    class="mb-3"
                                    color="grey lighten-1"
                                    height="300px"
                            ></v-card>

                            <v-btn
                                    color="primary"
                                    @click="e1 = 1"
                            >
                                Continue
                            </v-btn>

                            <v-btn flat>Cancel</v-btn>
                        </v-stepper-content>
                    </v-stepper-items>
                </v-stepper>
            </v-card>
        </v-dialog>
    </v-layout>
</template>

<script>
    export default {
        data () {
            return {
                dialog: false,
                e1: 0
            }
        }
    }
</script>

<style scoped>

</style>