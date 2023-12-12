<script setup>
const usuario = {
  initials: "PF",
  fullName: "John Doe",
  email: "john.doe@doe.com",
};
</script>

<template>
  <v-layout class="indexPage">
    <v-container>
      <v-app-bar :elevation="1">
        
        <NuxtLink to="/">
          <img
            class="Imglogo mt-3"
            style="display: flex;"
            src="../public/assets/logo_habitech-removebg-preview.png"
            alt="error"
          />
        </NuxtLink>

        <template v-slot:prepend>

        <v-btn> iniciar sesion </v-btn>
        <v-btn> menu </v-btn>
        </template> 
      </v-app-bar>
      <v-main>
        <v-row class="mt-1" justify="center" align="center">
          <v-card class="opsContainer" elevation="5"> </v-card>
        </v-row>
      </v-main>
    </v-container>
  </v-layout>
</template>

<style>
.indexPage {
  background: radial-gradient(
        ellipse at 70% 20%,
        rgba(115, 250, 169, 0.2) 60%,
        transparent 0
      )
      top right,
    radial-gradient(
        ellipse at -10% 90%,
        rgba(187, 62, 232, 0.2) 60%,
        transparent 0
      )
      bottom left;
  background-size: 75% 75%;
  background-repeat: no-repeat;
  height: 100vh;
}

.opsContainer {
  background-color: rgba(255, 255, 255, 0.5);
  min-height: calc(100vh - 110px);
  width: 95vw;
  border-radius: 20px;
}

.contenedor {
  justify-content: center;
}
.Imglogo {
  width: 100px;
}
</style>
