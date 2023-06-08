<script>
import axios from 'axios';


export default {
    components: {

    },
    data() {
        return {
            pizza : '',
            id: '',
            nome: '',
            prezzo: '',
            descrizione: '',
            fotoUrl: '',
            // loading: false,
            errors: [],
            urlAddress: 'http://127.0.0.1:8080/api/v1/pizza',
            apiUrl: 'http://127.0.0.1:8080/api/v1/pizza'
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

                    this.id = this.pizza.id
                    this.nome = this.pizza.nome
                    this.descrizione = this.pizza.descrizione
                    this.prezzo = this.pizza.prezzo
                    this.fotoUrl = this.pizza.fotoUrl

                   

                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        editPizza() {
            // this.loading = true;
            axios.put(this.apiUrl, {
                id: this.id,
                nome: this.nome,
                prezzo: this.prezzo,
                descrizione: this.descrizione,
                fotoUrl: this.fotoUrl,
            })
                .then((response) => {



                   
                    // this.loading = false;

                    window.location.reload()





                }).catch(errors => {

                    console.log(errors.response.data.errors)

                    this.errors = errors.response.data.errors


                })
        }
    },
    created() {
        this.getPizza()
    },
}
</script>

<template>
    <div>
        <div class="alert alert-danger mt-2" v-if="errors.length != 0">
            <p v-for="error in errors" class="mb-0">{{ error }}</p>
        </div>
        <div class="mb-3">
                <label for="id" class="form-label">id:</label>
                <input type="number" class="form-control " id="id" v-model="id" >


            </div>
        <div class="mb-3">
            <label for="nome" class="form-label">nome:</label>
            <input type="text" class="form-control" id="nome" v-model="nome" >

        </div>
        <div class="mb-3">
            <label for="prezzo" class="form-label">prezzo:</label>
            <input type="number" class="form-control " id="prezzo" v-model="prezzo" >


        </div>
        <div class="mb-3">
            <label for="descrizione" class="form-label">descrizione:</label>
            <textarea class="form-control" id="descrizione" rows="15" v-model="descrizione"></textarea>


        </div>
        <div class="mb-3">
            <label for="fotoUrl" class="form-label">fotoUrl:</label>
            <textarea class="form-control" id="fotoUrl" rows="15" v-model="fotoUrl"></textarea>


        </div>
        <button type="submit" @click="editPizza" class="btn btn-primary">Modifica</button>
    </div>
</template>


<style lang="scss"></style>