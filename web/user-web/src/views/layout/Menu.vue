<template>
 <v-toolbar flat>
        <v-list>
          <v-list-tile>
            <v-list-tile-title class="title">Application</v-list-tile-title>
          </v-list-tile>

          <!-- <v-divider></v-divider> -->

          <v-list dense class="pt-0">
            <v-list-tile v-for="item in items" :key="item.title" @click="handleClick">
              <v-list-tile-action>
                <v-icon>{{ item.icon }}</v-icon>
              </v-list-tile-action>

              <v-list-tile-content>
                <v-list-tile-title>{{ item.title }}</v-list-tile-title>
              </v-list-tile-content>
            </v-list-tile>
          </v-list>
        </v-list>
      </v-toolbar>
</template>

<script>
export default {
  name: 'Menu',
  components: {

  },
  data() {
    return {
      items: [
        { title: 'Home', icon: 'dashboard' },
        { title: 'About', icon: 'question_answer' },
      ],
    };
  },
  methods: {
    handleClick() {
      console.log(this.$vuetify.breakpoint);
    },
  },
};
</script>

<style lang="scss" scoped>
</style>
