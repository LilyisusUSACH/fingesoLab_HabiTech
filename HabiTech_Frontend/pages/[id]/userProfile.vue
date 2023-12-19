<script>

export default {

  data(){
    return{
      user:{
        nombre: "Nicolas",
        email: "nicoolas.cartes@usach.cl"
      }
    };
}
};

</script>

<template>
  <v-app class="PrincipalContainer">
    <!--Defino lo elementos basados en el figma-->
    <div class="align-center" style="width: fit-content; align-self: center">
      <NuxtLink to="/">
        <img
            class="Imglogo"
            src="../../public/assets/logo_habitech-removebg-preview.png"
            alt="error"
        />
      </NuxtLink>
    </div>
    <v-layout class="contenedorProfile" column>
      <v-card
          class="opsContainerProfile align-center mt-1 mb-5"
          elevation="5"
          max-width="100%"
          rounded="lg"
          justify-self="center"
      >


        <div style="width: 80%">

        </div>

        <div class="infoUserContainer" style="width: 80%">
          <!--Aca va la data de usuario-->
          <div class="userNameContainer">

            <strong class="texto">{{user.nombre}}</strong>

          </div>
          <div class="userEmailcontainer">

            <strong class="texto">{{user.email}}</strong>

          </div>

        </div>
        <NuxtLink to="/home">
          <v-btn  class="buttonConfirm">
            VOLVER
          </v-btn>
        </NuxtLink>


      </v-card>
    </v-layout>
  </v-app>
</template>

<style scoped>
.PrincipalContainer {
  background-color: #f2f2f2;
}
.contenedorProfile {
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

.opsContainerProfile {
  max-height: 97%;
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  width: 40%;
  border-radius: 20px;
}
.infoUserContainer{
  width: 80%;
  display: flex;
  flex-direction: column;
  background-color: #f2f2f2;
}
.userNameContainer{
  display: flex;
  flex-direction: row;
}


@media only screen and (max-width: 960px) {
  .opsContainerProfile {
    max-height: 90% !important;
    display: flex;
    flex-direction: column;
    justify-content: space-evenly;
    width: 95% !important;
    border-radius: 20px;
  }
  .infoUserContainer{
    width: 80%;
    display: flex;
    flex-direction: column;
    background-color: #f2f2f2;
  }

  .Imglogo {
    width: 100px;
    justify-self: center;
    align-self: center;
  }

  .userNameContainer{
    display: flex;
    flex-direction: row;
  }

}
</style>