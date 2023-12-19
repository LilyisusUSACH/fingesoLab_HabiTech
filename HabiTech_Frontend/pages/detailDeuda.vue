<script setup>

const token = localStorage.getItem("token");

const data = await $fetch("http://127.0.0.1:8080/user/montoActual", {
  headers: {
    Authorization: `Bearer ${token}`,
  }
});

data.amount = Math.round(data.amount)

const deudas = await $fetch("http://localhost:8080/user/deudaActual", {
  headers: {
    Authorization: `Bearer ${token}`,
  }
});

const info = await $fetch("http://127.0.0.1:8080/user/user", {
  headers: {
    Authorization: `Bearer ${token}`,
  }
});

const lista = []

deudas.forEach(deuda => {
    const deudaFormat = {
        cuota: deuda.cuota + "/" + deuda.gastoComunAsociado.cuotas,
        descripcion: deuda.gastoComunAsociado.description,
        monto: Math.round(deuda.value),
        fechaInicio: deuda.fechaInicio,
        fechaTermino: deuda.fechaTermino
    }
    lista.push(deudaFormat);
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
            <div height="50px"></div>
            <DetailDeuda :total=data.amount :lista_desc=lista></DetailDeuda>
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