
<template>
  <v-layout class="hpage">
    <v-container>
      <navBar Pname="Joaquin perez monsalva" Prole="residente" Pemail="joaco@gmail.com" drawer="!drawer"></navBar>
      <v-main>
        <div >
          <v-row> </v-row>
          <v-row justify="center">
            <v-col cols="auto">
              <card amount="15000000000" vencimiento="12/11/2023"> </card>
            </v-col>
          </v-row>
        </div>
      </v-main>
    </v-container>
  </v-layout>
</template>

<style>
.hpage {
  background-color: #f8f9fc !important;
  height: 100vh;
}
.navBar{
  z-index: -1;
}
.sideBar{
  z-index: 100;
}
</style>