<script>
import axios from 'axios';

export default {
    props: {
        nome: String,
        descrizione: String,
        fotoUrl: String,
        prezzo: Number,
        ingredienti: Object,
        offertaSpeciale: Object,
        id: Number,
        show: Boolean
    },
    data() {
        return {
            apiUrl: 'http://127.0.0.1:8080/api/v1/pizza/'
        }
    },
    methods:{
        deletePizza(id){
            axios.delete(this.apiUrl + id).then(response =>{
                console.log(response)
                window.location.reload()
            })
        }
    }
}

</script>

<template>
    <div class="col-3 my-3">
        <div class="card" style="width: 18rem;">
            <div class="text-center">
                <img :src="fotoUrl" class="card-img-top w-50"
                    alt="...">
            </div>
            <div class="card-body">
                <h5 class="card-title">{{ nome }}</h5>
                <h3 class="card-title">{{ prezzo }}</h3>
                <p class="card-text">{{ descrizione }}</p>
                <p class="card-text">
                    <span v-for="offertaSpeciale in offertaSpeciale"> #{{ offertaSpeciale.titolo }} #{{ offertaSpeciale.percSconto }} <br> #{{ offertaSpeciale.dataDiInizio }} #{{ offertaSpeciale.dataDiFine }} </span>
                </p>
                <p class="card-text">{{ ingredienti }}</p>
                <router-link :to="{ name: 'pizzaShow', params: { id: id } }" class="btn btn-success me-2"
                   v-if="show != true">show</router-link>
                <router-link :to="{ name: 'editPizza', params: { id: id } }" v-if="show != true" class="btn btn-warning me-2">Modifica</router-link>
                <button v-if="show != true" class="btn btn-danger" @click="deletePizza(id)">Elimina</button>
            </div>
        </div>
    </div>
</template>

<style scoped lang="scss"></style>
