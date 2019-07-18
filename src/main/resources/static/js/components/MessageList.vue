<template>
    <v-container>
        <v-layout align-space-around justify-start row>
            <v-flex :xs10="$vuetify.breakpoint.smAndUp"
                    :offset-xs1="$vuetify.breakpoint.smAndUp">
                <v-layout align-space-around justify-start column>
                    <message-row v-for="message in sortedMessages"
                                 :key="message.id"
                                 :message="message"/>
                    <message-form class="ma-3" />
                </v-layout>
            </v-flex>
        </v-layout>
    </v-container>

</template>

<script>
    import { mapGetters } from 'vuex'
    import MessageRow from 'components/MessageRow.vue'
    import MessageForm from 'components/MessageForm.vue'

    export default {
        components: { MessageRow, MessageForm },
        computed: mapGetters(['sortedMessages'])
    }
</script>

<style scoped>

</style>