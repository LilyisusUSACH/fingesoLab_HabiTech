<script>
import { ref } from 'vue'

export default {
  data() {
    return {
      drawer: null,
    };
  },
  
};
</script>

<template>
  <v-navigation-drawer v-model="drawer" expand-on-hover rail location="left">
    <v-list>
      <v-list-item
        prepend-avatar="https://randomuser.me/api/portraits/women/85.jpg"
        title="Sandra Adams"
        subtitle="sandra_a88@gmailcom"
      ></v-list-item>
    </v-list>

    <v-divider></v-divider>

    <v-list density="compact" nav>
      <v-list-item
        prepend-icon="mdi-folder"
        title="My Files"
        value="myfiles"
      ></v-list-item>
      <v-list-item
        prepend-icon="mdi-account-multiple"
        title="Shared with me"
        value="shared"
      ></v-list-item>
      <v-list-item
        prepend-icon="mdi-star"
        title="Starred"
        value="starred"
      ></v-list-item>
    </v-list>
  </v-navigation-drawer>

  <v-app-bar color="transparent" elevation="0" style="padding: 0 5vw 0 10vw">
    <!--- <v-btn icon="mdi-home"></v-btn> --->

    <template v-slot:prepend>
      <v-app-bar-nav-icon
        v-if="true"
        @click="drawer = !drawer"
      ></v-app-bar-nav-icon>
    </template>

    <template v-slot:append>
      <v-btn icon="mdi-bell"></v-btn>
      <v-btn icon="mdi-message"></v-btn>
      <v-btn icon="mdi-account"></v-btn>
    </template>
  </v-app-bar>
</template>
