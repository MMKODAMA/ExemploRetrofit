package br.senac.lojaretrofit.services

import br.senac.lojaretrofit.model.Pessoa
import br.senac.lojaretrofit.model.Produto
import retrofit2.Call
import retrofit2.http.GET

interface PessoaService {

    //USADO NO PROJETO
    @GET("/api/24beae997fa94c2ca76b9c4f0bb3d488/pessoa")
    fun listar(): Call<List<Pessoa>>

}