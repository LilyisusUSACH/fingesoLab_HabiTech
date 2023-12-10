<script setup>
const props = defineProps(['amount', 'vencimiento']);

const formatPrice = (value) => { 
        return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".");
    };

</script>

<template>
  <v-card class="myCard">
    <v-row>
      <v-col style="max-width: fit-content">
        <v-card class="superior" prepend-icon="mdi-bank" width="70" height="70">

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
      <v-col style="padding-left: 7%">
        <h1 class="monto">$ {{formatPrice(amount)}}</h1>
      </v-col>
    </v-row>
    <v-row class="btns-container" justify="space-around">
      <v-col cols="7" sm="auto">
        <v-btn class="btns" style="border-color: #E91E63 !important" color=#E91E63>Ver detalle</v-btn>
      </v-col>
      <v-col cols="4" sm="auto">
        <v-btn class="btns" style="border-color: #4CAF50 !important" color="green">Pagar</v-btn>
      </v-col>
    </v-row>
    <v-row align= "end" style="height: 3.5vh;">
      <v-col>
        <v-divider></v-divider>

        <h1 class= "monto" style="font-weight: lighter !important; color: #5e5e5e !important; font-size: clamp(10px, 2vw, 2vh);">Fecha de vencimiento: {{vencimiento}}</h1>
      </v-col>
    </v-row>
  </v-card>
</template>

<style>

.btns {
  min-height: fit-content;
  border-top: 10px solid;
  border-bottom: 10px solid;
  width: fit-content;
}

@media only screen and (max-width: 330px){
  .btns-container{
    justify-content: start !important;
  }

  .btns {
  min-height: 7vh;
  width: fit-content;
  font-size: x-small;
  }
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

  box-shadow: 0 1px 3px 0 rgba(0,0,0,.14), 0 0 0 0 transparent, 0 0 0 0 transparent;

}
.superior {
  background-color: #4caf50 !important;
  border-color: #4caf50 !important;
  z-index: 10;
  margin-top: -36px !important;
  border-radius: 4px !important;
  overflow: hidden !important;
  box-shadow: 0 3px 5px -1px rgba(0,0,0,.2),0 6px 10px 0 rgba(0,0,0,.14),0 1px 18px 0 rgba(0,0,0,.12)!important;
  padding-top: 5px;  
}

.monto {
  text-align: center;
  font-weight: bolder;
  font-size: clamp(20px, 3vw, 5vw);
}
</style>
