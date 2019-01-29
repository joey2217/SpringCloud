<template>
  <v-app>
    <v-navigation-drawer app :mini-variant.sync="mini" v-model="drawer">
      <side-menu/>
    </v-navigation-drawer>
    <v-toolbar app>
      <v-toolbar-side-icon @click="handleIconClick"/>
      <v-toolbar-title>Title</v-toolbar-title>
      <v-spacer></v-spacer>
      <v-toolbar-items class="hidden-sm-and-down">
        <v-btn flat>Link One</v-btn>
        <v-btn flat>Link Two</v-btn>
        <v-btn flat>Link Three</v-btn>
      </v-toolbar-items>
    </v-toolbar>
    <v-content>
      <v-container fluid>
        <router-view></router-view>
      </v-container>
    </v-content>
  </v-app>
</template>

<script>
// import { mapGetters } from 'vuex';
import SideMenu from './Menu.vue';

export default {
  name: 'Layout',
  components: {
    SideMenu,
  },
  data() {
    return {
      drawer: true,
      mini: false,
    };
  },
  computed: {
  },
  methods: {
    handleIconClick() {
      console.log(this.$vuetify.breakpoint);
      this.drawer = !this.drawer;
    },
  },
  mounted() {
    console.log(this.$vuetify.breakpoint);
  },
};
</script>

<style lang="scss" scoped>
</style>
