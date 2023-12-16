<script setup>

function submit(rut, pass) {
  const { data, pending, error, refresh } = useFetch(
    "http://127.0.0.1:8080/login",
    {
      method: "POST",
      onRequest({ request, options }) {
        // Set the request headers
        options.body = JSON.stringify({
          username: rut,
          password: pass,
        });
      },
      onRequestError({ request, options, error }) {
        // Handle the request errors
      },
      onResponse({ request, response, options }) {
        // Process the response data
        console.log(response._data.token);
        localStorage.setItem('token', response._data.token)
        //localStorage.setItem('token', response._data.token)
      },
      onResponseError({ request, response, options }) {
        // Handle the response errors
        console.log(response);
      },
    }
  );
}
</script>

<template>
  <v-btn type="submit" class="buttonConfirm" @click="submit('207220361',1234)"> INGRESAR </v-btn>
</template>
