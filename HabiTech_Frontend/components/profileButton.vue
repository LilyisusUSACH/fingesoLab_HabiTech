<script>
export default {
  props: ["initials", "name", "email"],

  data() {
    return {
      user: {
        initial: this.initials,
        fullName: this.name,
        email: this.email,
      },
    };
  },
};
</script>

<script setup>
function logout() {
  localStorage.clear();
}
</script>

<template>
  <v-row class = "mainAcc" justify="center">
    <v-menu min-width="70px" rounded>
      <template v-slot:activator="{ props }">
        <v-btn icon v-bind="props">
          <v-avatar color="black">
            <span class="text-h9">{{ user.initial }}</span>
          </v-avatar>
        </v-btn>
      </template>
      <v-card class = "accOptions">
        <v-card-text>
          <div class="mx-auto text-center">
            <v-avatar color="green">
              <span class="text-h7">{{ user.initial }}</span>
            </v-avatar>
            <h3>{{ user.fullName }}</h3>
            <v-divider class="my-3"></v-divider>
            <NuxtLink to="/userProfile">
              <v-btn rounded variant="text" color="black"> Mi perfil </v-btn>
            </NuxtLink>
           
            <v-divider class="my-3"></v-divider>
            <NuxtLink to="/">
              <v-btn rounded variant="text" color="black" @click="logout"> Cerrar sesion </v-btn>
            </NuxtLink>

          </div>
        </v-card-text>
      </v-card>
    </v-menu>
  </v-row>
</template>

<style>    
    .accOptions{
        background-color: rgba(3, 255, 234, 0.85) !important;
    }
    .accOptions:hover{
        background-color: rgba(3, 255, 234, 0.75) !important;
    }

    .mainAcc{
        margin-left: 0.5vh;
    }
</style>