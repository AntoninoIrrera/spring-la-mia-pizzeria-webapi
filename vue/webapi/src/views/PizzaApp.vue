<script>

import PizzaComp from '../components/PizzaComp.vue'

import axios from 'axios';

export default {
    components: {
        PizzaComp
    },
    data() {
        return {
            apiURL: 'http://127.0.0.1:8080/api/v1/pizza',
            pizze: [],
        }
    },
    methods: {
        getPizza() {
            axios.get(this.apiURL, {
                params: {

                }
            })
                .then((response) => {
                    console.log(response.data);
                    this.pizze = response.data;
                    


                })
        }
    },
    created() {
        this.getPizza();
    }
}


</script>

<template>
    <main class="mt-5 pt-1">
        <div class="container">
           
            <div class="row">
                <div class="col-12">
                    <router-link to="createPizza" class="btn btn-primary">createPizza</router-link>
                </div>
            </div>

            <div class="row altezza">
                <PizzaComp v-for="pizza in pizze" :nome="pizza.nome" :id="pizza.id" :descrizione="pizza.descrizione" :prezzo="pizza.prezzo" :fotoUrl="pizza.fotoUrl" :ingredienti="pizza.ingredienti" :offertaSpeciale="pizza.offertaSpeciales"/>
            </div>

            
        </div>
    </main>
</template>

<style scoped lang="scss"></style>
