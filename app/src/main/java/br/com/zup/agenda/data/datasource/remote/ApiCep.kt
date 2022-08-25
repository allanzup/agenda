package br.com.zup.agenda.data.datasource.remote

import br.com.zup.agenda.data.model.CepResult
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiCep {
    @GET("v1/cep/{cep}")
    suspend fun getAddress(@Path("cep") cep:String): CepResult
}