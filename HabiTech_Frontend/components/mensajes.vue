<script setup>

const props = defineProps({
  listaMensajes: Object,
});

</script>

<template>
  <v-card>
    <v-list lines="two" min-width="30vw">
      <v-list-item
        v-for="mensage in listaMensajes"
        :key="n"
        :title=mensage.sender
        :subtitle=mensage.message
      ></v-list-item>
    </v-list>
  </v-card>
</template>
