<template>
  <v-container fluid fill-height>
    <v-layout justify-center align-center style="margin-top:-100px">
      <v-flex xs12 sm6 md5 lg3>
        <v-card>
              <v-toolbar dark color="success">
                <v-toolbar-title>Login form</v-toolbar-title>
              </v-toolbar>
              <v-card-text>
        <v-form ref="form" v-model="valid" lazy-validation>
          <v-text-field
            v-model="loginForm.name"
            :counter="10"
            :rules="nameRules"
            prepend-icon="person"
            label="姓名"
            required/>
          <v-text-field
            v-model="loginForm.passwd"
            :rules="passwdRules"
            prepend-icon="lock"
            label="密码"
            :counter="16"
            required/>

          <v-btn :disabled="!valid" color="success" @click="validate">Validate</v-btn>

          <v-btn color="error" @click="reset">Reset Form</v-btn>

          <v-btn color="warning" @click="resetValidation">Reset Validation</v-btn>
        </v-form>
              </v-card-text>
        </v-card>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
export default {
  name: 'Login',
  components: {},
  data: () => ({
    valid: true,
    loginForm: {
      name: 'admin',
      passwd: '123456',
    },
    nameRules: [
      v => !!v || 'Name is required',
      v => (v && v.length <= 10) || 'Name must be less than 10 characters',
    ],
    passwdRules: [
      v => !!v || 'passwd is required',
      v => (v && v.length <= 16) || 'passwd must be less than 10 characters',
    ],
  }),
  methods: {
    validate() {
      if (this.$refs.form.validate()) {
        this.snackbar = true;
        this.$router.push('/');
      }
    },
    reset() {
      this.$refs.form.reset();
    },
    resetValidation() {
      this.$refs.form.resetValidation();
    },
  },
};
</script>

<style lang="scss" scoped>
</style>
