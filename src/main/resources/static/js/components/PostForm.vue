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
            <v-card-text class="py-1">
                <v-layout column>
                    <a v-for="img in images"
                       :key="img.name"

                        @click="removeItem(true, img)"
                    >
                        {{ img.name }} <v-icon small>clear</v-icon>
                    </a>
                    <a flat v-for="file in files"
                       :key="file.name"
                       @click="removeItem(false, file)">
                        {{ file.name }} <v-icon small>clear</v-icon>
                    </a>
                </v-layout>
            </v-card-text>
            <v-card-actions class="pt-0">
                <input style="display: none" type="file" multiple ref="img" @change="imgSelected">
                <input style="display: none" type="file" multiple ref="file" @change="fileSelected">
                <v-btn flat icon @click="$refs.file.click()"><v-icon>attach_file</v-icon></v-btn>
                <v-btn flat icon @click="$refs.img.click()"><v-icon>insert_photo</v-icon></v-btn>
                <v-spacer></v-spacer>
                <v-btn round @click="save">Publish</v-btn>
            </v-card-actions>
        </v-container>
    </v-card>
</template>

<script>
    import axios from 'axios'
    import { mapActions } from 'vuex'
    export default {
        data() {
            return {
                images: [],
                files: [],
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

                const files = this.upload(false)
                const images = this.upload(true)

                const post = {
                    text: this.text,
                    images,
                    files
                }

                this.addPostAction(post)

                this.text = ''
                this.images = []
                this.files = []
            },
            imgSelected(event) {
                let selectedFiles = event.target.files
                if(!selectedFiles.length) {
                    return false
                }

                for (let i = 0; i < selectedFiles.length; i++) {
                    this.images.push(selectedFiles[i])
                }
            },
            fileSelected(event) {
                let selectedFiles = event.target.files
                if(!selectedFiles.length) {
                    return false
                }

                for (let i = 0; i < selectedFiles.length; i++) {
                    this.files.push(selectedFiles[i])
                }
            },
            upload(isImages) {
                let files
                let resultFilenames = ''
                if (isImages) {
                    files = this.images
                } else {
                    files = this.files
                }

                for (let i = 0; i < files.length; i++) {
                    const fd = new FormData();
                    const filename = (`f${(~~(Math.random()*1e8)).toString() + '-' + files[i].name}`).replace(/ /g, "_")


                    resultFilenames += filename + '/'

                    fd.append('file', files[i], filename)

                    axios.post('http://localhost:8080/file', fd, {
                        onUploadProgress: uploadEvent => {
                            console.log('Upload progress' + uploadEvent.loaded + '/' + uploadEvent.total)
                        }
                    })
                        .then(res => {
                            console.log(res)
                        })
                }

                return resultFilenames
            },
            removeItem(isImage, item) {
                let index;
                if (isImage) {
                    index = this.images.findIndex(i => i === item)
                    this.images.splice(index, 1)
                } else {
                    index = this.files.findIndex(i => i === item)
                    this.files.splice(index, 1)
                }
            }
        }
    }
</script>

<style scoped>

</style>