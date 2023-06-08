<script>
import axios from 'axios';

import PizzaComp from '../components/PizzaComp.vue'

export default {
    components:{
        PizzaComp
    },
    data() {
        return {
            pizza: '',
            urlAddress: 'http://127.0.0.1:8080/api/v1/pizza',
        }
    },
    methods: {
        getPizza() {
            axios.get(this.urlAddress + `/${this.$route.params.id}`, {
                params: {

                }
            })
                .then((response) => {
                    console.log(response.data)

                    this.pizza = response.data;
                })
                .catch(function (error) {
                    console.log(error);
                });
        },

    },
    created() {
        this.getPizza()
    },
}
</script>

<template>
    <h1>prova</h1>
    <PizzaComp :nome="pizza.nome" :id="pizza.id" :descrizione="pizza.descrizione" :prezzo="pizza.prezzo" :fotoUrl="pizza.fotoUrl" :ingredienti="pizza.ingredienti" :show="true" :offertaSpeciale="pizza.offertaSpeciales"/>
</template>

<style lang="scss"></style>