<script setup>
const props = defineProps(["role", "name","email"]);
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
    <v-list-item class = "avatarIcon"
      :title="name"
      :subtitle="email"
    >
    <template  v-slot:prepend>
      <v-avatar>
      <img
        src="../public/assets/icon.jpg"
        alt="John"
        class="center"
        style="width: 180%;"
      />
    </v-avatar>
    </template>
  </v-list-item>
  </v-list>

  <v-divider :thickness="1" class="border-opacity-50" ></v-divider>

  <v-list density="compact" nav>
    <v-list-item style = "margin-top: 10px;"
      v-for="item in options[role]"
      :key="item.value"
      :prepend-icon="item.icon"
      :title="item.title"
      :value="item.value"
      @click="console.log(item.value)"
    ></v-list-item>
  </v-list>
</template>

<style>
  .v-list-item .v-icon{
    color: #e49d33;
  }
</style>
