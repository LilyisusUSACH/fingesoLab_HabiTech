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
                  placeholder="Nombre"
                  prepend-inner-icon="mdi-account"
                  variant="solo-filled"
                >
                </v-text-field>
                <v-text-field
                  class="inputsFormReg"
                  density="compact"
                  placeholder="Apellidos"
                  prepend-inner-icon="mdi-account"
                  variant="solo-filled"
                ></v-text-field>

                <v-text-field
                  class="inputsFormReg"
                  density="compact"
                  placeholder="Rut"
                  prepend-inner-icon="mdi-account"
                  variant="solo-filled"
                ></v-text-field>

                <v-text-field
                  class="inputsFormReg"
                  density="compact"
                  placeholder="Email"
                  prepend-inner-icon="mdi-account"
                  variant="solo-filled"
                ></v-text-field>

                <v-text-field
                  class="inputsFormReg"
                  density="compact"
                  placeholder="Contraseña"
                  prepend-inner-icon="mdi-key-variant"
                  variant="solo-filled"
                  :type="visible ? 'text' : 'password'"
                  :append-inner-icon="visible ? 'mdi-eye-off' : 'mdi-eye'"
                  @click:append-inner="visible = !visible"
                ></v-text-field>

                <v-text-field
                  class="inputsFormReg"
                  density="compact"
                  placeholder="Repetir Contraseña"
                  prepend-inner-icon="mdi-key-variant"
                  variant="solo-filled"
                  :type="visible ? 'text' : 'password'"
                  :append-inner-icon="visible ? 'mdi-eye-off' : 'mdi-eye'"
                  @click:append-inner="visible = !visible"
                ></v-text-field>

                <v-btn type="submit" class="buttonConfirmReg"
                  >Enviar solicitud</v-btn
                >
              </v-form>
              <v-divider class="mt-4 mb-2"></v-divider>
              <NuxtLink to="/login" style="color: black; text-decoration: none">
                <div class="textReg mb-1">
                  ¿Ya tienes cuenta aprobada? Inicia sesión
                </div>
              </NuxtLink>
            </v-sheet>
          </v-col>
        </v-row>
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
.PrincipalContainerReg {
  background-color: #f2f2f2;
}
.contenedorReg {
  justify-content: center;
  max-height: 90%;
}

.v-text-field .v-input__control .v-input__slot {
  min-height: auto !important;
  display: flex !important;
  align-items: center !important;
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

.textReg {
  font-weight: bold;
  text-align: center;
}

@media only screen and (min-width: 600px) and (max-width: 960px) {
  .footerVue {
    font-size: 2vw !important;
  }
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
  .textReg {
    font-size: small;
  }
  .v-div-reg {
    margin-top: -8vh;
    margin-bottom: 2vh;
  }

  .footerVue {
    font-size: 3vw;
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

.footerVue {
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  align-items: baseline;
  margin-bottom: 1vh;
}
.ImglogoReg {
  width: 100px;
  margin-bottom: -2.5vh;
  justify-self: center;
  align-self: center;
}
</style>
