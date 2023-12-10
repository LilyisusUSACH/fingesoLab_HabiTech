<script setup>
 const usuario = {
        initials: 'PF',
        fullName: 'John Doe',
        email: 'john.doe@doe.com',
      }
</script>

<template>
  <v-app>
    <v-app-bar color="transparent" elevation="1" style="padding: 0 5vw 0 10vw">
      <template v-slot:append>
        <v-btn> Registrarse <v-icon icon="mdi-account"> </v-icon> </v-btn>
        <v-btn style="margin-right: 3rem;"> Iniciar Sesion <v-icon icon="mdi-account"> </v-icon></v-btn>
      </template>
    </v-app-bar>
  </v-app>
</template>
