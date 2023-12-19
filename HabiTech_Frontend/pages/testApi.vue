<script setup>


// const token = localStorage.getItem("token");
const token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIyMDcyMjAzNjEiLCJpYXQiOjE3MDMwMDA5MTAsImV4cCI6MTcwMzAxMTcxMH0.5sgzuBW3VfDRThSuuLt30wc5xHJGL00GSYJAWViqZoA"
const mensajes = await $fetch("http://localhost:8080/test/getMessagesReceived", {
  headers: {
    Authorization: `Bearer ${token}`,
  }
});


const deudas = await $fetch("http://localhost:8080/user/deudaActual", {
  headers: {
    Authorization: `Bearer ${token}`,
  }
});

</script>

<template>
  <v-layout class="hpage">
    <v-container>
      <navBar
        Pname="pedr + ' ' + juan"
        Prole="residente"
        Pemail="aaa@gmail.com"
        drawer="!drawer"
      ></navBar>
      <v-main>
        <div>
          <v-row> </v-row>
          <v-row justify="center">
            <div height="50px"></div>
            <mensajes :listaMensajes='data'></mensajes>
          </v-row>
        </div>
      </v-main>
    </v-container>
  </v-layout>
</template>

<style>
.hpage {
  background-color: #f2f2f2 !important;
  height: 100vh;
}

@media only screen and (max-width: 682px) {
  .hpage {
    height: 100%;
  }
}
.navBar {
  z-index: -1;
}
.sideBar {
  z-index: 100;
}
</style>
