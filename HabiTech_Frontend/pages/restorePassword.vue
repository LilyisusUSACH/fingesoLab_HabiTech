<script>
export default{

  data(){
    return{
      userData:{
        rut:" ",
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

        <p><strong>Ingrese RUT asociado al usuario</strong> </p>

        <div class="input-container">
          <input class="input" type="text" v-model="rut" placeholder="Rut">
        </div>




        <v-btn class="buttonConfirm">Confirmar</v-btn>
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
  background-color: #E91E63;

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

.Imglogo{
  width: 100px;
  justify-self: center;
  align-self: center;
  display: flex;
}

.input-container{
  position: relative;
  display: flex;
}
.input{
  background-color: #F2F2F2;
  display: flex;
  margin:0;
  background-image: url("../public/assets/user-svgrepo-com.svg");
  background-size: 20px 20px;
  background-position: 10px center;
  background-repeat: no-repeat;
  padding-left: 40px;

}

.footerVue{
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  align-items: baseline;


}

</style>