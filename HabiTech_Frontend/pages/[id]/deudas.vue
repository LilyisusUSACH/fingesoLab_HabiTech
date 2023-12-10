<script setup>
const route = useRoute();
console.log(route.params.id);
</script>
<template>
  <v-layout class="hpageDeuda">
    <v-container>
      <navBar Pname="Joaquin perez monsalva" Prole="residente" Pemail="joaco@gmail.com" drawer="!drawer"></navBar>
      <v-main>
        <v-row justify="center">
          <div
            style="
              background-color: green;
              border-radius: 7px;
              padding: 0 15px 0 15px;
            "
          >
            <h1 style="text-align: center; color: white">Detalle deudas</h1>
          </div>
        </v-row>
        <v-row justify="center">
          <div height="50px"></div>
          <CardGastos amount="1000" vencimiento="10"></CardGastos>
          <CardGastos amount="1000" vencimiento="10"></CardGastos>
          <CardGastos amount="1000" vencimiento="10"></CardGastos>

        </v-row>
      </v-main>
    </v-container>
  </v-layout>
</template>
<style>
.hpageDeuda{
  background-color: #e1e3e7 !important;
  height: 100%;
}
</style>