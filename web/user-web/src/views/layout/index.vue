<template>
  <v-app>
    <v-navigation-drawer app clipped v-model="drawer" width="240" style="background-color:#EBEBEB">
      <side-menu/>
    </v-navigation-drawer>
    <v-toolbar app clipped-left>
      <v-toolbar-side-icon @click="handleIconClick"/>
      <v-toolbar-title>UserWeb</v-toolbar-title>
      <v-spacer></v-spacer>
      <navbar/>
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
import Navbar from './Navbar.vue';

export default {
  name: 'Layout',
  components: {
    SideMenu,
    Navbar,
  },
  data() {
    return {
      drawer: true,
    };
  },
  computed: {},
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
