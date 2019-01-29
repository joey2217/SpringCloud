<template>
  <v-container fluid text-xs-center>
    <v-layout wrap justify-space-around>
      <v-flex xs12 sm5>
        <v-card dark color="success">
          <v-card-text class="px-0">12</v-card-text>
        </v-card>
      </v-flex>
      <v-flex xs12 sm5>
        <v-card dark color="success">
          <v-card-text class="px-0">12</v-card-text>
        </v-card>
      </v-flex>
      <v-flex xs12 sm5>
        <v-card dark color="success">
          <v-card-text class="px-0">12</v-card-text>
        </v-card>
      </v-flex>
      <v-flex xs12 sm5>
        <v-card dark color="success">
          <v-card-text class="px-0">12</v-card-text>
        </v-card>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
export default {
  name: 'Dashboard',
  components: {},
  data() {
    return {};
  },
};
</script>

<style lang="scss" scoped>
.px-0 {
  height: 200px;
  margin: 20px;
}
</style>
