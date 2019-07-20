<template>

    <v-layout align-space-around justify-start column>
        <post-form v-if="profile.id === this.$route.params.id"/>


        <v-layout align-space-around
                  justify-start column
                  fill-height>

            <post-row v-for="post in sortedPosts"
                      :key="post.id"
                      :post="post"/>
        </v-layout>

    </v-layout>


</template>

<script>
    import { mapGetters, mapActions } from 'vuex'
    import PostRow from 'components/PostRow.vue'
    import PostForm from 'components/PostForm.vue'

    export default {
        props: ["profile"],
        components: { PostRow, PostForm },
        computed: mapGetters(['sortedPosts']),
        methods: {
            ...mapActions(['getPostAction'])
        },
        created() {
            this.getPostAction(this.$route.params.id)
        }
    }
</script>

<style scoped>

</style>