<script setup>
import { list } from 'postcss';

const props = defineProps({
    codigo: String,
    nombre: String,
    lista_desc: Object
})   
/*lista_desc :[
    Desc0: {
        codigo: '101',
        descripcion: 'Pago ascensores'
        monto: 101.000
    },Desc1: {
        codigo: '101',
        descripcion: 'Pago ascensores'
        monto: 101.000
    },Desc2: {
        codigo: '101',
        descripcion: 'Pago ascensores'
        monto: 101.000
    }
    ]
*/


// CAMBIAR FONDO
const formatPrice = (value) => {
  return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".");
};
</script>

<template>
  <v-card class="myCardGastos">
    <v-row>
      <v-col>
        <v-card class="superiorGastos" width="fit-content">
          <v-toolbar-items>
            <div class="tipo-gasto">{{codigo}}</div>
            <v-divider
              :thickness="2"
              class="border-opacity-75 mt-n2"
              vertical
            ></v-divider>
            <div class="tipo-gasto">{{nombre}}</div>
          </v-toolbar-items>
        </v-card>

        <v-row class="mt-1" justify="space-between">
          <v-col cols="auto" md="3" lg="auto">
            <div class="text-gastos">Cuenta</div>
          </v-col>
          <v-col cols="5" md="6" lg="9">
            <div class="text-desc">Descripcion</div>
          </v-col>
          <v-col cols="auto" md="2" lg="auto">
            <div class="text-gastos" justify="end">Monto</div>
          </v-col>
        </v-row>
        <v-divider
          class="border-opacity-100"
          thickness="3"
          style="z-index: 1 !important"
        >
        </v-divider>

        <v-row  v-for="desc in lista_desc" style="padding-top: 7px" justify="space-between">
          <v-col cols="auto" md="3" lg="auto">
            <div class="text-gastos" style="font-weight: lighter">{{desc.codigo}}</div>
          </v-col>
          <v-col cols="5" md="6" lg="9">
            <div class="text-desc" style="font-weight: lighter">
              {{desc.descripcion}}
            </div>
          </v-col>
          <v-col cols="auto" md="2" lg="auto">
            <div class="text-gastos" justify="end">${{ formatPrice(desc.monto)}}</div>
          </v-col>
        </v-row>
      </v-col>
    </v-row>
    <v-divider
      class="border-opacity-100"
      thickness="3"
      style="z-index: 1 !important"
    >
    </v-divider>
    <v-row justify="end" class="mt-1">
      <v-spacer></v-spacer>

      <v-col cols="5" md="3" lg="2" class="mr-n10">
        <div class="text-gastos" justify="end">Monto total</div>
      </v-col>
      <v-col cols="auto" md="2" lg="auto">
        <div class="text-gastos" justify="end">$971.439</div>
      </v-col>
    </v-row>
  </v-card>
</template>

<style>
.tipo-gasto {
  color: white;
  margin: 0px 10px 5px 10px;
  font-size: x-large;
}

.text-gastos {
  font-size: x-large;
  color: black;
  font-weight: bold;
}

.text-desc {
  overflow: visible;
  font-size: x-large;
  margin: 0px -30px -10px -15px;
  text-align: left;
  font-weight: bold;
  color: black;
  z-index: -1 !important;
}

@media only screen and (max-width: 430px) {
  .tipo-gasto {
    color: white;
    margin: 0px 5px 2px 8px;
    font-size: small;
  }
  .text-gastos {
    margin: -5px 10px 5px 10px;
    font-size: small;
    color: black;
  }
  .text-desc {
    margin: -5px -30px -10px -15px;
    font-size: small;
    color: black;
    z-index: -1 !important;
  }
  .myCardGastos {
    overflow: initial;
    margin-top: 0px !important;
    margin-left: 1px !important;
    margin-right: 1px !important;
    width: 100vw !important;
    z-index: 0;
    border-radius: 10px;
    box-shadow: 0 1px 3px 0 rgba(0, 0, 0, 0.14), 0 0 0 0 transparent,
      0 0 0 0 transparent;
  }
}

@media only screen and (min-width: 420px) and (max-width: 780px) {
  .myCardGastos {
    overflow: initial;
    margin-top: 10px !important;
    margin-left: 10px !important;
    margin-right: 10px !important;
    width: 100vw !important;
    z-index: 0;
    border-radius: 10px;
    box-shadow: 0 1px 3px 0 rgba(0, 0, 0, 0.14), 0 0 0 0 transparent,
      0 0 0 0 transparent;
  }

  .tipo-gasto {
    color: white;
    margin: 0px 8px 2px 10px;
    font-size: large;
  }
  .text-gastos {
    margin: -5px 10px 5px 10px;
    font-size: medium;
    color: black;
  }
  .text-desc {
    margin: -5px -30px -10px -15px;
    font-size: medium !important;
    color: black;
  }
}

.myCardGastos {
  overflow: initial;
  margin-top: 35px !important;
  margin-left: 1vw;
  margin-right: 1vw;
  min-width: 4.5cm;
  width: 85vw;
  max-width: 100%;

  max-height: fit-content;
  padding: 20px;
  z-index: 0;
  border-radius: 10px;

  box-shadow: 0 1px 3px 0 rgba(0, 0, 0, 0.14), 0 0 0 0 transparent,
    0 0 0 0 transparent;
  background: linear-gradient(90deg, #ffff 10%, rgba(0, 0, 0, 0) 10%),
    linear-gradient(90deg, #dddddd 89%, #ffff 89%);
}

@media only screen and (min-width: 600px) and (max-width: 1280px) {
  .myCardGastos {
    background: linear-gradient(90deg, #ffff 15%, rgba(0, 0, 0, 0) 15%),
      linear-gradient(90deg, #dddddd 82%, #ffff 80%);
  }
  .text-desc{
    margin-left: -10vw;
    margin-right: -4vw;
  }
} 

@media only screen and (min-width: 420px ) and (max-width: 600px) {
  .myCardGastos {
    background: linear-gradient(90deg, #ffff 23%, rgba(0, 0, 0, 0) 23%),
      linear-gradient(90deg, #dddddd 73%, #ffff 0%);
  }
} 
@media only screen and (min-width: 320px ) and (max-width: 420px) {
  .myCardGastos {
    background: linear-gradient(90deg, #ffff 24%, rgba(0, 0, 0, 0) 0%),
      linear-gradient(90deg, #dddddd 72%, #ffff 0%);
  }
} 

.superiorGastos {
  background-color: #e91e63 !important;
  border-color: #e91e63 !important;
  z-index: 10;
  margin-top: -36px !important;
  border-radius: 4px !important;
  overflow: hidden !important;
  box-shadow: 0 3px 5px -1px rgba(0, 0, 0, 0.2), 0 4px 5px 0 rgba(0, 0, 0, 0.1),
    0 0px 10px 0 rgba(0, 0, 0, 0.12) !important;
  padding-top: 5px;
}

.monto {
  text-align: center;
  font-weight: bolder;
  font-size: clamp(20px, 3vw, 5vw);
}
</style>
