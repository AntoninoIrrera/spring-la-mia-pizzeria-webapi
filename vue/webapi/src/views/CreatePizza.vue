<script>
import axios from 'axios';


export default {
    components: {
        
    },
    data() {
        return {
            nome: '',
            prezzo: '',
            descrizione: '',
            fotoUrl: '',
            // loading: false,
            errors: [],
            apiUrl: 'http://127.0.0.1:8080/api/v1/pizza'
        }
    },
    methods: {
        createPizza() {
            // this.loading = true;
            axios.post(this.apiUrl, {
                nome: this.nome,
                prezzo: this.prezzo,
                descrizione: this.descrizione,
                fotoUrl: this.fotoUrl,
            })
                .then((response) => {



                    
                        this.nome = ''
                        this.prezzo = ''
                        this.descrizione = ''
                        this.fotoUrl = ''
                        // this.loading = false;
                   

                        

                        

                }).catch(errors => {
                    
                    console.log(errors.response.data.errors)

                    this.errors = errors.response.data.errors


                })
        }
    }
}
</script>

<template>
    <div>
        <div class="alert alert-danger mt-2" v-if="errors.length != 0">
                    <p v-for="error in errors" class="mb-0">{{ error }}</p>
                </div>

        <div class="mb-3">
            <label for="nome" class="form-label">nome:</label>
            <input type="text" class="form-control"  id="nome" v-model="nome">
           
        </div>
        <div class="mb-3">
            <label for="prezzo" class="form-label">prezzo:</label>
            <input type="number" class="form-control "  id="prezzo" v-model="prezzo">
          

        </div>
        <div class="mb-3">
            <label for="descrizione" class="form-label">descrizione:</label>
            <textarea class="form-control"  id="descrizione" rows="15"
                v-model="descrizione"></textarea>
           

        </div>
           <div class="mb-3">
                <label for="fotoUrl" class="form-label">fotoUrl:</label>
                <textarea class="form-control"  id="fotoUrl" rows="15"
                    v-model="fotoUrl"></textarea>
              

            </div>
        <button type="submit" @click="createPizza" class="btn btn-primary">Invia</button>
    </div>
</template>


<style lang="scss"></style>