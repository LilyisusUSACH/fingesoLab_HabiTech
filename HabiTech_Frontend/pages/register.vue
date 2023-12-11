<script>

export default {
  data(){
    return {
      userData:{
        name:"",
        lastName1:"",
        LastName2:"",
        rut:"",
        email:"",
        pass:"",
        confirmPass:"",

      },

    };
  },
};

</script>


<template>
  <v-app class="PrincipalContainer">
    <!--Defino lo elementos basados en el figma-->
    <img class="Imglogo" src="../public/assets/logo_habitech-removebg-preview.png"  alt="error">
    <v-layout class="contenedor" column>
      <v-card class="opsContainer">
      <v-container>
        <img class="Imglogocard" src="../public/assets/logo_habitech-removebg-preview.png"  alt="error">
      <!--Acá ira el texto que acompaña al logo abajo-->

      </v-container>


      <v-container class="form">
        <div class="input-container">
          <input class="input" type="text" v-model="name" placeholder="Nombre">
        </div>

        <div class="input-container">
          <input class="input" type="text" v-model="Lastname1" placeholder="Primer Apellido">
        </div>

        <div class="input-container">
          <input class="input" type="text" v-model="LastName2" placeholder="Segundo Apellido">
        </div>

        <div class="input-container">
          <input class="input" type="text" v-model="rut" placeholder="Rut">
        </div>

        <div class="input-container">
          <input class="input" type="text" v-model="email" placeholder="Email">
        </div>

        <div class="input-container">
          <input class="input" type="text" v-model="pass" placeholder="Contraseña">
        </div>

        <div class="input-container">
          <input class="input" type="text" v-model="confirmPass" placeholder="Repetir contraseña">
        </div>


        <v-btn class="buttonConfirm">Enviar solicitud</v-btn>

        <router-link to="/login" style="color: black; text-decoration: none"><p><strong>¿Ya tienes cuenta aprobada? Inicia sesión</strong></p></router-link>
      </v-container>

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

<style>
.PrincipalContainer{
  background-color: #F2F2F2;
}
.contenedor{
  justify-content: center;
}
.buttonConfirm{
  text-align: center;
  background-color: #BB3EE8;
  color: white;

}
.Imglogocard{
  max-width: 250px;
}
.opsContainer{
  display: flex;
  align-items: center;
  flex-direction: row;
  justify-content:space-evenly;
  width: 80%;
  margin: .5%;

}

.input-container{
  position: relative;
  display: flex;
  justify-content: center;
}
.input{
  background-color: #F2F2F2;
  display: flex;
  margin:0;
  background-image: url("../public/assets/user-rounded-svgrepo-com.svg");
  background-size: 20px 20px;
  background-position: 10px center;
  background-repeat: no-repeat;
  padding-left: 40px;
  width: 80%;

}
.footerVue{
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  align-items: baseline;


}
.Imglogo{
  width: 100px;
  justify-self: center;
  align-self: center;
}
/*Estilos para el forms*/
.form{
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  height: 100%;
  text-align: center;
}
</style>