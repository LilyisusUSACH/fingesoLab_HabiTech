<script>
export default {
  data() {
    return {
      rut: "",
      pass: "",
      visible: false,
    };
  },
};
</script>
<script setup>

function submit(){
const {data, pending, error, refresh} = 
 useFetch(
  "http://localhost:8080/login",
  {
    method: "POST",
    onRequest({ request, options }) {
      // Set the request headers
      options.body = JSON.stringify({
        username: "207220361",
        password: "1234",
      });
    },
    onRequestError({ request, options, error }) {
      // Handle the request errors
    },
    onResponse({ request, response, options }) {
      // Process the response data
      console.log(options);
      //localStorage.setItem('token', response._data.token)
    },
    onResponseError({ request, response, options }) {
      // Handle the response errors
      console.log(response);
    },
  })
}

/*
function async() =
 
);
 */
/*
  await fetch("http://localhost:8080/login", {
        mode: "no-cors",
        method: "POST",
        headers: {
          "Content-Type": "application/json" ,
        },
        body: JSON.stringify({
          username: '207220361',
          password: '1234'
        })
      }).then(Response => console.log(Response.headers.get('Authorization')));
      */
</script>

<template>
  <v-app class="PrincipalContainer">
    <!--Defino lo elementos basados en el figma-->
    <div class="align-center" style="width: fit-content; align-self: center">
      <NuxtLink to="/">
        <img
          class="Imglogo"
          src="../public/assets/logo_habitech-removebg-preview.png"
          alt="error"
        />
      </NuxtLink>
    </div>
    <v-layout class="contenedorLogin" column>
      <v-card
        class="opsContainerLogin align-center mt-1 mb-5"
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
            v-model="rut"
          ></v-text-field>
        </div>

        <div style="width: 80%">
          <v-text-field
            density="compact"
            placeholder="Contraseña"
            prepend-inner-icon="mdi-key-variant"
            variant="solo-filled"
            v-model="pass"
            :type="visible ? 'text' : 'password'"
            :append-inner-icon="visible ? 'mdi-eye-off' : 'mdi-eye'"
            @click:append-inner="visible = !visible"
          ></v-text-field>
        </div>
        <div class="text-h">
          {{ data }}
        </div>
        <v-btn type="submit" class="buttonConfirm" @click="submit">
          INGRESAR
        </v-btn>
        <router-link to="/register" style="color: black; text-decoration: none"
          ><p><strong>¿Eres Nuevo?</strong></p></router-link
        >
        <router-link
          to="/restorePassword"
          style="color: black; text-decoration: none"
          ><p><strong>¿Olvidaste tu contraseña?</strong></p></router-link
        >
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
.contenedorLogin {
  justify-content: center;
  max-height: 90%;
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
.opsContainerLogin {
  max-height: 97%;
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
  .opsContainerLogin {
    max-height: 90% !important;
    display: flex;
    flex-direction: column;
    justify-content: space-evenly;
    width: 95% !important;
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
</style>
