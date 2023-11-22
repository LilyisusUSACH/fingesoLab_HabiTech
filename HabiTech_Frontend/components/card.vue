<template>
  <v-card class="myCard">
    <v-row>
      <v-col style="max-width: fit-content">
        <v-card class="superior" prepend-icon="mdi-account" max-width="70">
        </v-card>
      </v-col>
      <v-col cols = "12" sm="">
        <h1 class="monto" style="color: #5E5E5E !important; font-weight: lighter !important">Gasto Común</h1>
      </v-col>
    </v-row>
    <v-row>
      <v-col style="padding-left: 10%;">
        <h1 class="monto">$ 100.000</h1>
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="auto" style="min-width: fit-content">
        <v-btn>Ver detalle</v-btn>
      </v-col>
      <v-col cols="auto">
        <v-btn>Pagar</v-btn>
      </v-col>
    </v-row>
  </v-card>
</template>

<style>
.myCard {
  overflow: initial;
  margin-top: 20px !important;
  margin-left: 10px;
  margin-right: 10px;
  min-width: 4.5cm;
  width: 70vw;
  max-width: 100%;
  max-height: 70vh;
  padding: 20px;
  z-index: 0;
  border-radius: 10px;
}
.superior {
  background-color: #4caf50 !important;
  border-color: #4caf50 !important;
  z-index: 10;
  margin-top: -36px !important;
  border-radius: 4px !important;
  overflow: hidden !important;
}

.monto{
    text-align: center;
    font-weight: bolder;
    font-size: clamp(20px,3vw,5vw);
}

</style>
