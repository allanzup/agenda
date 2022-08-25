package br.com.zup.agenda.domain.usecase

import br.com.zup.agenda.data.model.CepResult
import br.com.zup.agenda.domain.repository.CepRepository

class GetCepUseCase(private val repository: CepRepository) {
    suspend fun execute(cep: String): CepResult {
        return repository.getCep(cep)
    }
}