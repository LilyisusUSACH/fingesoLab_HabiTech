<template>
  <v-card class="myCard">
    <v-row>
      <v-col style="max-width: fit-content">
        <v-card class="superior" prepend-icon="mdi-account" max-width="70">
        </v-card>
      </v-col>
      <v-col cols="12" sm="">
        <h1
          class="monto"
          style="color: #5e5e5e !important; font-weight: lighter !important"
        >
          Gasto Común
        </h1>
      </v-col>
    </v-row>
    <v-row>
      <v-col style="padding-left: 10%">
        <h1 class="monto">$ 100.000</h1>
      </v-col>
    </v-row>
    <v-row justify="space-around">
      <v-col cols="8" sm="auto">
        <v-btn class="btns" color="red">Ver detalle</v-btn>
      </v-col>
      <v-col cols="4" sm="auto">
        <v-btn class="btns" color="green">Pagar</v-btn>
      </v-col>
    </v-row>
    <v-row align= "end" style="height: 3vh;">
      <v-col>
        <hr />
        <h1 class= "monto" style="font-weight: lighter !important; color: #5e5e5e !important; font-size: clamp(10px, 2vw, 2vh);">Fecha de vencimiento: 15/11/2023</h1>
      </v-col>
    </v-row>
  </v-card>
</template>

<style>
.btns {
  min-height: 7vh;
  width: fit-content;
}
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

.monto {
  text-align: center;
  font-weight: bolder;
  font-size: clamp(20px, 3vw, 5vw);
}
</style>
