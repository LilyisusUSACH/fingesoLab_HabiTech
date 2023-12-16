<script>
export default {
  data() {
    return {
      rut: "",
      email: "",
      nombre: "",
      lastName: "",
      pass: "",
      visible: false,

      password: "",
      password1: "",
      successPass: false,
      successPass1: false,

      invalidRut: false,
    };
  },
  methods: {
    // Valida el rut con su cadena completa "XXXXXXXX-X"
    validaRut: function (rutCompleto) {
      rutCompleto = rutCompleto.replace("‐", "-");
      if (!/^[0-9]+[-|‐]{1}[0-9kK]{1}$/.test(rutCompleto)) return false;
      var tmp = rutCompleto.split("-");
      var digv = tmp[1];
      var rut = tmp[0];
      if (digv == "K") digv = "k";

      this.invalidRut = this.dv(rut) == digv;
      console.log("digito Correcto ".concat(this.dv(rut)));
      return this.invalidRut;
    },

    dv: function (T) {
      var M = 0,
        S = 1;
      for (; T; T = Math.floor(T / 10))
        S = (S + (T % 10) * (9 - (M++ % 6))) % 11;

        return S ? S - 1 : "k";
    },

    required: function (value) {
      if (value) {
        return true;
      } else {
        return "Debe ingresar sus datos.";
      }
    },
    correctRut: function () {
      if (this.invalidRut) {
        return true;
      } else {
        return "Debe ingresar un RUT valido.";
      }
    },
    min6: function (value) {
      if (value.length >= 6) {
        return true;
      } else {
        return "Minimo 6 caracteres";
      }
    },
    matchingPasswords: function () {
      if (this.password === this.password1) {
        return true;
      } else {
        return "Diferentes contraseñas";
      }
    },
  },
  computed: {
    passRule: function () {
      if (this.password === "") {
        // field is empty
        this.successPass = false;
        return "";
      } else if (this.min6(this.password) === true) {
        // password ok
        this.successPass = true;
        return "mdi-check";
      } else {
        // password wrong
        this.successPass = false;
        return "mdi-close";
      }
    },
    passRule1: function () {
      if (this.password1 === "") {
        // field is empty
        this.successPass1 = false;
        return "";
      } else if (
        this.min6(this.password1) === true &&
        this.matchingPasswords() === true
      ) {
        // password ok
        this.successPass1 = true;
        return "mdi-check";
      } else {
        // password wrong
        this.successPass1 = false;
        return "mdi-close";
      }
    },
  },
};
</script>
<script setup>
// /register

function submit(email,name,lastName,rut,password) {
  const nrut = parseInt(rut.replace("-",""));
  const pwd = password.toString();
  const { data, pending, error, refresh } = useFetch(
    "http://127.0.0.1:8080/register",
    {
      method: "POST",
      onRequest({ request, options }) {
        // Set the request headers
        options.body = JSON.stringify({
          password: pwd,
          email: email,
          name: name,
          lastName: lastName,
          rut: nrut,
        });
      },onRequestError({ request, options, error }) {
        // Handle the request errors
      },
      onResponse({ request, response, options }) {
        // Process the response data
        if(response.status == 200){
          navigateTo('/login')
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
                  placeholder="Nombre"
                  prepend-inner-icon="mdi-account"
                  variant="solo-filled"
                  v-model="nombre"
                >
                </v-text-field>
                <v-text-field
                  class="inputsFormReg"
                  density="compact"
                  placeholder="Apellidos"
                  prepend-inner-icon="mdi-account"
                  variant="solo-filled"
                  v-model="lastName"
                ></v-text-field>

                <v-text-field
                  class="inputsFormReg"
                  density="compact"
                  placeholder="Rut"
                  prepend-inner-icon="mdi-account"
                  variant="solo-filled"
                  v-model="rut"
                  :rules="[correctRut, required]"
                  v-on:blur="validaRut(rut)"
                ><template v-slot:append-inner>
                  <v-icon 
                  :icon="invalidRut ? 'mdi-check' : 'mdi-close'"
                  :color="invalidRut ? 'green' : 'red' "
                  />
                </template>
              </v-text-field>

                <v-text-field
                  class="inputsFormReg"
                  density="compact"
                  placeholder="Email"
                  prepend-inner-icon="mdi-account"
                  variant="solo-filled"
                  v-model="email"
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
                  v-model="password"
                  :rules="[required, min6]"
                  :counter="6"
                >
                  <template v-slot:append-inner>
                    <v-icon v-if="successPass" color="green">{{
                      passRule
                    }}</v-icon>
                    <v-icon v-if="!successPass" color="red">{{
                      passRule
                    }}</v-icon>
                  </template>
                </v-text-field>

                <v-text-field
                  class="inputsFormReg"
                  density="compact"
                  placeholder="Repetir Contraseña"
                  prepend-inner-icon="mdi-key-variant"
                  variant="solo-filled"
                  :type="visible ? 'text' : 'password'"
                  :append-inner-icon="visible ? 'mdi-eye-off' : 'mdi-eye'"
                  @click:append-inner="visible = !visible"
                  v-model="password1"
                  :rules="[matchingPasswords]"
                  :counter="6"
                >
                  <template v-slot:append-inner>
                    <v-icon v-if="successPass1" color="green">{{
                      passRule1
                    }}</v-icon>
                    <v-icon v-if="!successPass1" color="red">{{
                      passRule1
                    }}</v-icon>
                  </template>
                </v-text-field>

                <v-btn type="submit" class="buttonConfirmReg" @click="submit(email,nombre,lastName,rut,password)"
                  >Enviar solicitud</v-btn>
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
