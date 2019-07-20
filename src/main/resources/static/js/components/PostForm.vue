<template>
    <v-card class="mb-3">
        <v-container class="pa-2">
            <v-card-text class="pb-1">
                <v-textarea
                        v-model="text"
                        label="Some new post"
                        @keyup.enter="save"
                        auto-grow
                        rows="1"
                ></v-textarea>
            </v-card-text>
            <v-card-actions class="pt-0">
                <v-btn flat icon @click=""><v-icon>attach_file</v-icon></v-btn>
                <v-btn flat icon @click=""><v-icon>insert_photo</v-icon></v-btn>
                <v-spacer></v-spacer>
                <v-btn round @click="save">Publish</v-btn>
            </v-card-actions>
        </v-container>
    </v-card>
</template>

<script>
    import { mapActions } from 'vuex'
    export default {
        data() {
            return {
                text: ''
            };
        },
        watch: {
            messageAttr(newVal, oldVal) {
                this.text = newVal.text
            }
        },
        methods: {
            ...mapActions(['addPostAction']),
            save() {
                const post = {
                    text: this.text
                }

                this.addPostAction(post)

                this.text = ''
            }
        }
    }
</script>

<style scoped>

</style>