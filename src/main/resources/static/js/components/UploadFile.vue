<template>
    <v-container>
        <input type="file" multiple @change="onFileSelected">
        <v-btn @click="onUpload">
            Upload
        </v-btn>
    </v-container>
</template>

<script>
    import axios from 'axios'
    export default {
        data() {
            return {
                attachments: []
            }
        },
        methods: {
            onFileSelected(event) {
                let selectedFiles = event.target.files
                if(!selectedFiles.length) {
                    return false
                }
                
                for (let i = 0; i < selectedFiles.length; i++) {
                    this.attachments.push(selectedFiles[i])
                }
            },
            onUpload() {
                for (let i = 0; i < this.attachments.length; i++) {
                    const fd = new FormData();
                    const filename = `f${(~~(Math.random()*1e8)).toString() + '-' + this.attachments[i].name}`

                    fd.append('file', this.attachments[i], filename)

                    axios.post('http://localhost:8080/file', fd, {
                        onUploadProgress: uploadEvent => {
                            console.log('Upload progress' + uploadEvent.loaded + '/' + uploadEvent.total)
                        }
                    })
                        .then(res => {
                            console.log(res)
                        })
                }
            }

        }
    }
</script>

<style>

</style>