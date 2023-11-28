<script setup>
const props = defineProps(["role", "name"]);
/*
    Separacion por rol asi cada rol tiene sus propias opciones
*/

const options = {
  residente: [
    {
      icon: "mdi-folder",
      title: "My Files",
      value: "myfiles",
    },
    {
      icon: "mdi-account-multiple",
      title: "Shared with me",
      value: "shared",
    },
    {
      icon: "mdi-star",
      title: "Starred",
      value: "stared",
    },
  ],
  admin: [
    {
      icon: "mdi-folder",
      title: "My Files",
      value: "myfiles",
    },
  ],
};
</script>

<template>
  <v-list lines="one" width="fit-content">
    <v-list-item
      prepend-avatar="https://randomuser.me/api/portraits/women/85.jpg"
      :title="name"
      :subtitle="name.replace(/\s/g, '') + '@gmail.com'"
    ></v-list-item>
  </v-list>

  <v-divider></v-divider>

  <v-list density="compact" nav>
    <v-list-item
      v-for="item in options[role]"
      :key="item.value"
      :prepend-icon="item.icon"
      :title="item.title"
      :value="item.value"
      @click="console.log(item.value)"
    ></v-list-item>
  </v-list>
</template>
