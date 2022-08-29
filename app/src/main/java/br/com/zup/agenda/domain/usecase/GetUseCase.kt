package br.com.zup.agenda.domain.usecase

import android.app.Application
import br.com.zup.agenda.data.datasource.local.UserDatabase
import br.com.zup.agenda.data.model.UserResult
import br.com.zup.agenda.domain.repository.UserRepository
import br.com.zup.agenda.viewstate.ViewState

class GetUseCase(application: Application) {
    private val userDao = UserDatabase.getUserDatabase(application).userDAO()
    private val userRepository= UserRepository(userDao)
    suspend fun execute(user: String): UserResult {
        return userRepository.getUser(user)
    }

    suspend fun insertUser(userResult: UserResult): ViewState<UserResult> {
        return try {
            userRepository.insertUser(userResult)
            ViewState.Success(userResult)
        } catch (ex: Exception) {
            ex.printStackTrace()
            ViewState.Error(Exception("Não foi possível cadastrar o contato!"))
        }
    }
    suspend fun getAllUser(): ViewState<List<UserResult>> {
        return try {
            val user = userRepository.getAllUser()
            ViewState.Success(user)
        } catch (ex: Exception) {
            ViewState.Error(Exception("Não foi possível carregar a lista de Contatos!"))
        }
    }
}