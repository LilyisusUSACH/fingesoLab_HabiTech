<script setup>
const route = useRoute();
console.log(route.params.id);



const lista = [
    {
        codigo: '0302',
        descripcion:"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse pharetra magna vel accumsan tempor. Nunc rutrum, nequeeu rhoncus tempus, sem sem blandit velit.",
        monto: 101000
    },
    {
        codigo: '0305',
        descripcion: 'Pago ascensores',
        monto: 101000
    },{
        codigo: '0309',
        descripcion: 'Pago ascensores',
        monto: 101000
    }
  ]
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
          <CardGastos codigo="0300" nombre="Gastos de reparacion" 
          :lista_desc=lista 
          ></CardGastos>
        </v-row>
      </v-main>
    </v-container>
  </v-layout>
</template>
<style>
.hpageDeuda{
  background-color: #e1e3e7 !important;
  min-height: 100vh;
  height: 100%;
}
</style>