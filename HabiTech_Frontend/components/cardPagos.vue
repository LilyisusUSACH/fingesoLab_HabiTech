<script setup>
const amount = "100.000";
const vencimiento = 10;
</script>

<template>
  <v-card
    class="myCardPagos"
    style="border-radius: 10px 10px 0px 0px !important"
  >
    <v-row>
      <v-col style="max-width: fit-content">
        <v-card
          class="superiorPagos"
          prepend-icon="mdi-clipboard-text-clock-outline"
          width="70"
          height="70"
        >
        </v-card>
      </v-col>
      <v-col cols="12" sm="">
        <h1
          class="monto titlePago"
          style="color: #5e5e5e !important; font-weight: lighter !important"
        >
          Pago reciente
        </h1>
      </v-col>
    </v-row>
    <v-divider class="border-opacity-75 mt-2"></v-divider>
    <v-row justify="space-around">
      <v-col align-self="center">
        <h5
          class="monto"
          style="
            font-weight: bolder !important;
            color: black !important;
            font-size: clamp(15px, 2.3vw, 3vw);
          "
        >
          Monto pagado:
        </h5>
      </v-col>
      <v-col align-self="center" cols="7" sm="5">
        <h1 class="monto" style="color: #35b73a">$ {{ amount }}</h1>
      </v-col>
      <v-col align-self="center" style="margin-right: 2%">
        <v-row class="mt-1" justify="center">
          <v-col cols="auto">
            <h5
              class="monto fechaPago"
              style="
                font-weight: lighter !important;
                color: #5e5e5e !important;
                font-size: clamp(13px, 1.5vw, 2vw);"
            >
              Fecha pago: 10/12/2023
            </h5>
          </v-col>
        </v-row>
        <v-row justify="center">
          <v-btn class="btnsPagos titlePago" color="#00CAE3">
            <h4 style="color: white">Ver detalle</h4></v-btn
          ></v-row
        >
      </v-col>
    </v-row>
  </v-card>
  <v-card
    class="myCardPagos"
    style="border-radius: 0px 0px 10px 10px !important"
  >
    <v-row align="end" justify="center">
      <v-row justify="space-around">
        <v-col align-self="center">
          <h5
            class="ml-2"
            style="
              font-weight: lighter !important;
              color: black !important;
              font-size: clamp(15px, 1.5vw, 4vw);
            "
          >
            Fecha pago: 10/12/2023
          </h5>
        </v-col>
        <v-col align-self="center" cols="7" sm="5">
          <h1 class="monto" style="color: #5e5e5e">$ {{ amount }}</h1>
        </v-col>
        <v-col align-self="center" style="margin-right: 2%">
          <v-row justify="center">
            <v-btn class="btn-detalle-abajo" color="#00CAE3">
              <h4 style="color: white">Ver detalle</h4></v-btn
            ></v-row>
        </v-col>
      </v-row>

      <v-divider class = "mt-2 mb-2"/>

      <v-row justify="space-around">
        <v-col align-self="center">
          <h5
            class="ml-2"
            style="
              font-weight: lighter !important;
              color: black !important;
              font-size: clamp(15px, 1.5vw, 4vw);
            "
          >
            Fecha pago: 10/12/2023
          </h5>
        </v-col>
        <v-col align-self="center" cols="7" sm="5">
          <h1 class="monto" style="color: #5e5e5e">$ {{ amount }}</h1>
        </v-col>
        <v-col align-self="center" style="margin-right: 2%">
          <v-row justify="center">
            <v-btn class="btn-detalle-abajo" color="#00CAE3">
              <h4 style="color: white">Ver detalle</h4></v-btn
            ></v-row>
        </v-col>
      </v-row>
      
      <v-btn
        style="
          height: 30px;
          width: 100%;
          background-color: #e91e63;
          font-weight: bold;
          color: white;
        "
      >
        ver más</v-btn
      >
    </v-row>

  </v-card>
</template>

<style>
.btnsPagos {
  min-height: fit-content;
  width: fit-content;
}

.btn-detalle-abajo{
    margin-right: 15px
}

@media only screen and (max-width: 600px) {
  .fechaPago {
    margin-top: -35px;
  }
  .titlePago {
    margin-top: -22px;
  }
  .btn-detalle-abajo{
    margin-bottom: 20px;
    margin-right: 0px;
}
}

.myCardPagos {
  overflow: initial;
  margin-top: 8px !important;
  margin-left: 10px;
  margin-right: 10px;
  min-width: 4.5cm;
  width: 70vw;
  max-width: 100%;

  max-height: 70vh;
  padding: 20px;
  z-index: 0;
  border-radius: 10px;

  box-shadow: 0 1px 3px 0 rgba(0, 0, 0, 0.14), 0 0 0 0 transparent,
    0 0 0 0 transparent;
}
.superiorPagos {
  background-color: #e91e63 !important;
  border-color: #e91e63 !important;
  z-index: 10;
  margin-top: -36px !important;
  border-radius: 4px !important;
  overflow: hidden !important;
  box-shadow: 0 3px 5px -1px rgba(0, 0, 0, 0.2),
    0 6px 10px 0 rgba(0, 0, 0, 0.14), 0 1px 18px 0 rgba(0, 0, 0, 0.12) !important;
  padding-top: 5px;
}

.monto {
  text-align: center;
  font-weight: bolder;
  font-size: clamp(25px, 3vw, 5vw);
}
</style>
