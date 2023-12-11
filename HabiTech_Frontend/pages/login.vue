<script>
export default{

  data(){
    return{
      userData:{
        rut:" ",
        pass:" ",
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

    <img class="Imglogocard" src="../public/assets/logo_habitech-removebg-preview.png"  alt="error">

      <div class="input-container">
      <input class="input" type="text" v-model="rut" placeholder="Rut">
      </div>

      <div class="input-container">
      <input class="input" type="text" v-model="pass" placeholder="Contraseña">
      </div>
      <v-btn class="buttonConfirm"> INGRESAR</v-btn>
      <router-link to="/register" style="color: black; text-decoration: none"><p><strong>¿Eres Nuevo?</strong> </p></router-link>
      <router-link to="/restorePassword" style="color: black; text-decoration: none"><p><strong>¿Olvidaste tu contraseña?</strong></p></router-link>


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

.PrincipalContainer{
  background-color: #F2F2F2;
}
.contenedor{
  justify-content: center;
}
.buttonConfirm{
  text-align: center;
  background-color: #4BC850;
  width: 40%;
  align-self: center;

}
.Imglogocard{
  max-width: 250px;
}
.opsContainer{
  display: flex;
  align-items: center;
  flex-direction: column;
  justify-content:space-evenly;
  width: 45%;
  margin: 1%;

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
.input-container{
  position: relative;
  display: flex;
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

}



</style>