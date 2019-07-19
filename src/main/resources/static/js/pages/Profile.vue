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
                                            :src="profile.picture"
                                    ></v-img>
                                </v-avatar>

                                <h3 class="headline mt-2">{{ profile.name }}</h3>
                                <span>{{profile.lastVisit}}</span>
                                <div class="mt-3">
                                    <span>Student from National University of Life and Environmental of Ukraine</span>
                                </div>

                            </v-container>
                        </v-flex>

                        <v-flex (xs12 | sm5 | md5) offset-(xs0 | lg2) class="ma-3">
                            <div class="mb-1">
                                <span>E-mail: {{profile.email}}</span>
                            </div>
                            <div class="mb-1">
                                <span>Country: {{profile.locale}}</span>
                            </div>
                            <div class="mb-1">
                                <span>Bio: Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sunt, unde!</span>
                            </div>

                        </v-flex>

                    </v-layout>

                </v-card>

            </v-flex>

        </v-layout>
    </v-container>
</template>

<script>
    import { mapState } from 'vuex'
    export default {
        computed: mapState(["profile"])
    }
</script>

<style scoped>

</style>