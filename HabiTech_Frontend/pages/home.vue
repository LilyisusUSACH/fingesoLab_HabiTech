<script setup>
import { ref, onMounted } from "vue";

const token = localStorage.getItem("token");

const data = await $fetch("http://127.0.0.1:8080/user/montoActual", {
  headers: {
    Authorization: `Bearer ${token}`,
  }
});

data.amount = Math.round(data.amount)

const info = await $fetch("http://127.0.0.1:8080/user/user", {
  headers: {
    Authorization: `Bearer ${token}`,
  }
});

</script>

<template>
  <v-layout class="hpage">
    <v-container>
      <navBar
        :Pname= "info.name + ' ' + info.lastName"
        Prole="residente"
        :Pemail=info.email
        drawer="!drawer"
      ></navBar>
      <v-main>
        <div>
          <v-row> </v-row>
          <v-row justify="center">
            <v-col cols="auto">
              <card :amount=data.amount :vencimiento=data.fecha> </card>
            </v-col>
          </v-row>
          <v-row justify="center">
            <v-col cols="auto">
              <cardPagos :amount=data.amount :vencimiento=data.fecha align="center"></cardPagos>
            </v-col>
          </v-row>
        </div>
      </v-main>
    </v-container>
  </v-layout>
</template>

<style>
.hpage {
  background-color: #F2F2F2 !important;
  height: 100%;
}

@media only screen and (max-width: 682px){
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
