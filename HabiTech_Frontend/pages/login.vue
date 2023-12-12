<script>
export default {
  data() {
    return {
      userData: {
        rut: " ",
        pass: " ",
      },
      visible: false,
    };
  },
};
</script>

<template>
  <v-app class="PrincipalContainer">
    <!--Defino lo elementos basados en el figma-->
    <div class="align-center" style="width: fit-content; align-self: center;">
      <NuxtLink to="/">
        <img
          class="Imglogo"
          src="../public/assets/logo_habitech-removebg-preview.png"
          alt="error"
        />
      </NuxtLink>
    </div>
    <v-layout class="contenedor" column>
      <v-card
        class="opsContainer align-center"
        elevation="5"
        max-width="100%"
        rounded="lg"
        justify-self="center"
      >
        <img
          class="Imglogocard"
          src="../public/assets/logo_habitech-removebg-preview.png"
          alt="error"
        />

        <div style="width: 80%">
          <v-text-field
            density="compact"
            placeholder="Rut"
            prepend-inner-icon="mdi-account"
            variant="solo-filled"
          ></v-text-field>
        </div>

        <div style="width: 80%">
          <v-text-field
            density="compact"
            placeholder="Contraseña"
            prepend-inner-icon="mdi-key-variant"
            variant="solo-filled"
            :type="visible ? 'text' : 'password'"
            :append-inner-icon="visible ? 'mdi-eye-off' : 'mdi-eye'"
            @click:append-inner="visible = !visible"
          ></v-text-field>
        </div>

        <v-btn class="buttonConfirm"> INGRESAR</v-btn>
        <router-link to="/register" style="color: black; text-decoration: none"
          ><p><strong>¿Eres Nuevo?</strong></p></router-link
        >
        <router-link
          to="/restorePassword"
          style="color: black; text-decoration: none"
          ><p><strong>¿Olvidaste tu contraseña?</strong></p></router-link
        >

        <!--La leyenda del final-->
      </v-card>
    </v-layout>

    <footer class="footerVue">
      <p>FaQ</p>
      <p>About us</p>
      <p>Contactanos</p>
      <p>Términos y condiciones de uso</p>
    </footer>
  </v-app>
</template>

<style scoped>
.PrincipalContainer {
  background-color: #f2f2f2;
}
.contenedor {
  justify-content: center;
}
.buttonConfirm {
  text-align: center;
  background-color: #4bc850;
  color: white;
  width: fit-content;
  align-self: center;
}
.Imglogocard {
  max-width: 250px;
}
.opsContainer {
  max-height: 90%;
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  width: 40%;
  border-radius: 20px;
}

@media only screen and (min-width: 600px) and (max-width: 900px) {
  .footerVue {
    font-size: 2vw !important;
  }
}

@media only screen and (max-width: 900px) {
  .opsContainer {
    max-height: 98%;
    display: flex;
    flex-direction: column;
    justify-content: space-evenly;
    width: 95%;
    border-radius: 20px;
  }

  .footerVue {
    font-size: 3vw;
  }
}

.footerVue {
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  align-items: baseline;
  margin-bottom: 1vh;
}
.Imglogo {
  width: 100px;
  justify-self: center;
  align-self: center;
}
.input-container {
  position: relative;
  display: flex;
}
.input {
  background-color: #f2f2f2;
  display: flex;
  margin: 0;
  background-image: url("../public/assets/user-rounded-svgrepo-com.svg");
  background-size: 20px 20px;
  background-position: 10px center;
  background-repeat: no-repeat;
  padding-left: 40px;
}
</style>
