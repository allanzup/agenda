package br.com.zup.agenda.domain.repository

import br.com.zup.agenda.data.datasource.remote.RetrofitCep
import br.com.zup.agenda.data.model.CepResult

class CepRepository {
    suspend fun getCep(cep: String): CepResult {
        return RetrofitCep.api.getAddress(cep)
    }
}