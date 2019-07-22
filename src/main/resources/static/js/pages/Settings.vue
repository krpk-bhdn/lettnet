<template>
    <v-container>
        <v-layout row wrap>
            <v-flex xs8 offset-xs2>
                <v-card class="mb-3">


                    <v-layout column>

                        <v-card-title>Settings</v-card-title>

                        <v-card-text>
                            <v-text-field v-model="name" label="Name"/>
                            <v-text-field v-model="headline" label="Headline"/>
                            <v-text-field v-model="bio" label="Bio"/>
                            <v-select
                                    v-model="locale"
                                    :items="items"
                                    label="Country"
                            ></v-select>
                        </v-card-text>

                        <v-card-actions>
                            <v-btn round @click="save">
                                Save
                            </v-btn>
                        </v-card-actions>
                    </v-layout>

                </v-card>

            </v-flex>

        </v-layout>
    </v-container>
</template>

<script>
    import { mapState, mapActions } from 'vuex'
    export default {
        computed: mapState(['profile']),
        data() {
            return {
                name: '',
                headline: '',
                bio: '',
                locale: '',
                items: [
                    'Afghanistan', 'Albania', 'Algeria', 'Andorra', 'Angola', 'Antigua and Barbuda', 'Argentina',
                    'Armenia', 'Australia', 'Austria', 'Azerbaijan', 'Bahamas', 'Bahrain', 'Bangladesh', 'Barbados',
                    'Belarus', 'Belgium', 'Belize', 'Benin', 'Bhutan', 'Bolivia', 'Bosnia and Herzegowina', 'Botswana',
                    'Brazil', 'Brunei Darussalam', 'Bulgaria', 'Burkina Faso', 'Burundi', 'Cambodia', 'Cameroon',
                    'Canada', 'Cape Verde', 'Central African Republic', 'Chad', 'Chile', 'China', 'Colombia', 'Comoros',
                    'Congo, Democratic Republic', 'Congo, People’s Republic', 'Costa Rica', 'Cote d`Ivoire',
                    'Croatia (Local Name: Hrvatska)', 'Cuba', 'Cyprus', 'Czech Republic', 'Denmark', 'Djibouti',
                    'Dominica', 'Dominican Republic', 'East Timor', 'Ecuador', 'El Salvador', 'Equatorial Guinea',
                    'Eritrea', 'Estonia', 'Ethiopia', 'Fiji', 'Finland', 'France', 'Gabon', 'Gambia', 'Georgia',
                    'Germany', 'Ghana', 'Greece', 'Grenada', 'Greenland', 'Guatemala', 'Guinea', 'Guinea-Bissau',
                    'Guyana', 'Haiti', 'Honduras', 'Hong Kong', 'Hungary', 'Iceland', 'India', 'Indonesia', 'Iran',
                    'Iraq', 'Ireland', 'Israel', 'Italy', 'Jamaica', 'Japan', 'Jordan', 'Kazakhstan', 'Kenya',
                    'Kiribati', 'Korea, Democratic People`s Republic', 'Korea, Republic', 'Kuwait', 'Kyrgyzstan',
                    'Laos', 'Latvia', 'Lebanon', 'Lesotho', 'Liberia', 'Libya', 'Liechtenstein', 'Lithuania',
                    'Luxembourg', 'Macedonia', 'Madagascar', 'Malawi', 'Malaysia', 'Maldives', 'Mali', 'Malta',
                    'Marshall Islands', 'Mauritania', 'Mauritius', 'Mexico', 'Micronesia', 'Moldova', 'Monaco',
                    'Mongolia', 'Morocco', 'Mozambique', 'Myanmar', 'Namibia', 'Nauru', 'Nepal', 'Netherlands',
                    'New Zealand', 'Nicaragua', 'Niger', 'Nigeria', 'Norway', 'Oman', 'Pakistan', 'Palau', 'Panama',
                    'Papua New Guinea', 'Paraguay', 'Peru', 'Philippines', 'Poland', 'Portugal', 'Qatar', 'Puerto Rico',
                    'Romania', 'Russian Federation', 'Rwanda', 'Saint Kitts and Nevis', 'Saint Lucia',
                    'Saint Vincent and the Grenadines', 'Samoa', 'San Marino', 'Sao Tome and Principe', 'Saudi Arabia',
                    'Senegal', 'Serbia and Montenegro', 'Seychelles', 'Sierra Leone', 'Singapore',
                    'Slovakia (Slovak Republic)', 'Slovenia', 'Solomon Islands', 'Somalia', 'South Africa',
                    'Spain', 'Sri Lanka', 'Sudan', 'Suriname', 'Swaziland', 'Sweden', 'Switzerland',
                    'Syrian Arab Republic', 'Tajikistan', 'Tanzania', 'Taiwan', 'Thailand', 'Togo', 'Tonga',
                    'Trinidad and Tobago', 'Tunisia', 'Turkey', 'Turkmenistan', 'Tuvalu', 'Uganda', 'Ukraine',
                    'United Arab Emirates', 'United Kingdom', 'United States', 'Uruguay'
                ]
            }
        },
        methods: {
            ...mapActions(['updateUserAction']),
            save() {
                this.updateUserAction({id: this.profile.id,
                    name,
                    headline: this.headline,
                    bio: this.bio,
                    locale: this.locale
                })
            }
        },
        mounted() {
            this.name = this.profile.name
            this.headline = this.profile.headline
            this.bio = this.profile.bio
            this.locale = this.profile.locale
        }
    }
</script>

<style scoped>

</style>