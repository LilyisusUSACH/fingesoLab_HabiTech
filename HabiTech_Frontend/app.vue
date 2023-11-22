<script></script>

<template>
  <v-layout class="hpage">
    <v-container>
      <v-app-bar color="transparent" elevation="0" style="padding:0 5vw 0 10vw;">
        <v-btn icon="mdi-home"></v-btn>

        <template v-slot:append>
          <v-btn icon="mdi-bell"></v-btn>
          <v-btn icon="mdi-message"></v-btn>
          <v-btn icon="mdi-account"></v-btn>

        </template>
      </v-app-bar>
      <v-main>
        <div >
          <v-row> </v-row>
          <v-row justify="center">
            <v-col cols="auto">
              <card> </card>
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
</style>
