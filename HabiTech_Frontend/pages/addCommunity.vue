<script>
export default {
  data() {
    return {
      ubication: "",
      nombre: "",
    };
  },
};
</script>
<script setup>
function submit(ubication,cantidadEdificios) {
  const { data, pending, error, refresh } = useFetch(
      "http://127.0.0.1:8080/addCommunity",
      {
        method: "POST",
        onRequest({ request, options }) {
          // Set the request headers
          options.body = JSON.stringify({
            edificios: cantidadEdificios,
            ubicacion: ubication,
          });
        },onRequestError({ request, options, error }) {
          // Handle the request errors
        },
        onResponse({ request, response, options }) {
          // Process the response data
          if(response.status == 200){
            navigateTo('/home')
          }
        },
        onResponseError({ request, response, options }) {
          // Handle the response errors
        },
      }
  );
}
</script>

<template>

  <v-app class="PrincipalContainerReg">
    <div class="align-center" style="width: fit-content; align-self: center">
      <NuxtLink to="/">
        <img
            class="ImglogoReg"
            src="../public/assets/logo_habitech-removebg-preview.png"
            alt="error"
        />
      </NuxtLink>
    </div>

    <v-layout class="contenedorReg">
      <v-card
          class="opsContainerReg mt-1 mb-5"
          elevation="5"
          max-width="100%"
          rounded="lg"
      >
        <v-row
            justify="space-around"
            align="center"
            style="height: 100%"
            no-gutters
        >

          <v-col cols="auto" md="5">
            <img
                class="ImglogoRegcardReg"
                src="../public/assets/logo_habitech-removebg-preview.png"
                alt="error"
            />
          </v-col>

          <v-col class="v-div-reg" cols="auto">
            <v-sheet width="25vw" min-width="280px" style="margin-right: 1vw">
              <v-form class="mediaForm" fast-fail @submit.prevent>
                <v-text-field
                    class="inputsFormReg"
                    density="compact"
                    placeholder="Ubicación"
                    prepend-inner-icon="mdi-map-marker"
                    variant="solo-filled"
                    v-model="ubication"
                >
                </v-text-field>
                <v-text-field
                    class="inputsFormReg"
                    density="compact"
                    placeholder="Nombre"
                    prepend-inner-icon="mdi-counter"
                    variant="solo-filled"
                    v-model="nombre"
                ></v-text-field>



                <v-btn type="submit" class="buttonConfirmReg" @click="submit(ubication,nombre)"
                >Registrar comunidad</v-btn>
              </v-form>
              <v-divider class="mt-4 mb-2"></v-divider>
            </v-sheet>
          </v-col>
        </v-row>
      </v-card>
    </v-layout>

  </v-app>

</template>

<style scoped>
.PrincipalContainerReg {
  background-color: #f2f2f2;
}
.contenedorReg {
  justify-content: center;
  max-height: 90%;
}



.buttonConfirmReg {
  text-align: center;
  background-color: #bb3ee8;
  color: white;
  width: fit-content;
  display: block;
  margin-left: auto;
  margin-right: auto;
}
.ImglogoRegcardReg {
  display: flex;
  align-items: center;
  justify-content: center;
  margin-left: auto;
  margin-right: auto;
  width: 100%;
}
.opsContainerReg {
  justify-content: space-around;
  width: 70%;
  border-radius: 20px;
}

.v-div-reg {
  margin-top: 10vh;
  margin-bottom: 5vh;
}



@media only screen and (max-width: 960px) {
  .opsContainerReg {
    max-height: 100% !important;
    display: flex;
    flex-direction: column;
    justify-content: space-evenly;
    width: 95% !important;
    border-radius: 20px;
  }

  .v-div-reg {
    margin-top: -8vh;
    margin-bottom: 2vh;
  }


  .ImglogoReg {
    width: 8svh !important;
    margin-bottom: -2vh !important;
  }
}

@media only screen and (max-width: 960px) and (max-height: 865px) {
  .ImglogoRegcardReg {
    width: 50%;
    margin-bottom: 4vh;
  }
}

@media only screen and (min-width: 960px) {
  .inputsFormReg {
    margin-top: 1vh;
    margin-bottom: 2vh;
  }

  .buttonConfirmReg {
    margin-bottom: 2vh;
  }
}
.ImglogoReg {
  width: 100px;
  margin-bottom: -2.5vh;
  justify-self: center;
  align-self: center;
}
</style>