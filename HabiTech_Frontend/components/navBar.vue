<script>
import { ref } from "vue";

export default {
  props: ["Pname", "Pemail", "Prole"],
  data() {
    return {
      drawer: null,
      name: this.Pname,
      email: this.Pemail,
      role: this.Prole,
    };
  },
  setup() {
    const mobile = false;
    return {
      mobile,
    };
  },
  mounted() {
    this.mobile = window.innerWidth<1280;
  }
};
</script>

<template>
  <v-navigation-drawer v-model= 'drawer' :expand-on-hover="!mobile" :rail="!mobile" scrim="false" location="left">
    <sideBar :role=role :name=name :email=email></sideBar>
  </v-navigation-drawer>

  <v-app-bar color="transparent" elevation="0" style="padding: 0 5vw 0 10vw">
    <!--- <v-btn icon="mdi-home"></v-btn> --->

    <template v-slot:prepend>
      <v-app-bar-nav-icon
        v-if="mobile"
        @click="drawer = !drawer"
      ></v-app-bar-nav-icon>
    </template>

    <template v-slot:append>
      <v-btn icon="mdi-bell"></v-btn>
      <v-btn icon="mdi-message"></v-btn>
      <ProfileButton         
        :initials = "name[0]"
        :name = "name"
        :email = "email"
        ></ProfileButton>
    </template>
  </v-app-bar>
</template>
