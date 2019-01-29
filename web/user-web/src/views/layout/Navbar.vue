<template>
  <v-toolbar-items>
    <v-btn flat class="hidden-xs-only">Link One</v-btn>

    <v-menu offset-y nudge-right="100" nudge-bottom="5">
      <v-btn flat large icon slot="activator" color="primary" dark>
        <v-avatar>
          <img src="https://cdn.vuetifyjs.com/images/john.jpg" alt="avatar">
        </v-avatar>
      </v-btn>
      <v-list>
        <v-list-tile to="/">
          <v-list-tile-title>Dashboard</v-list-tile-title>
        </v-list-tile>
        <v-divider></v-divider>
        <v-list-tile @click="logout">
          <v-list-tile-title>Logout</v-list-tile-title>
        </v-list-tile>
      </v-list>
    </v-menu>
  </v-toolbar-items>
</template>

<script>
export default {
  name: 'Navbar',
  components: {},
  data() {
    return {
    };
  },
  methods: {
    handleClick() {},
    logout() {
      this.$router.push('/login');
    },
  },
};
</script>

<style lang="scss" scoped>
</style>
