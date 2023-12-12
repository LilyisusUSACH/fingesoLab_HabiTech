<script setup>
const usuario = {
  initials: "PF",
  fullName: "John Doe",
  email: "john.doe@doe.com",
};
</script>

<template>
  <v-app class="layout">
    <v-app-bar
      class="navbar"
      color="transparent"
      elevation="1"
      style="padding: 0 5vw 0 10vw"
    >
      <template v-slot:append>
        <v-btn> Registrarse <v-icon icon="mdi-account"> </v-icon> </v-btn>
        <v-btn style="margin-right: 3rem">
          Iniciar Sesion <v-icon icon="mdi-account"> </v-icon
        ></v-btn>
      </template>
    </v-app-bar>
    <v-main>
      <!--Aca un div para el contenido de bienvenida-->
      <v-container class="card-bienvenida">
        <figure class="Logo-bienvenida" style="width: 100px">
          <img
            src="../public/assets/logo_habitech-removebg-preview.png"
            alt="ERROR"
          />
        </figure>
        <v-container class="pillars">
          <div class="Pilar1">
            Poseemos un software a la vanguardia para la solución de problemas
          </div>
          <div class="Pilar2">
            ¡Administra la comunidad de manera eficiente y eficaz!
          </div>
        </v-container>
      </v-container>
    </v-main>
  </v-app>
</template>

<style>
.layout {
  background: #f2f2f2;
}
.card-bienvenida {
  background: #ffffff;
  grid-area: card-bienvenida;
  display: block;
  justify-content: center;
}
.navbar {
  position: relative;
  grid-area: navbar;
}
.pillars {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  background: #f2f2f2;
  height: 30%;
}
.Logo-bienvenida {
  text-align: center;
  display: flex;
}
</style>
