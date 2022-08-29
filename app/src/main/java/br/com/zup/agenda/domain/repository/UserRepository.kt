package br.com.zup.agenda.domain.repository

import br.com.zup.agenda.data.datasource.local.dao.UserDAO
import br.com.zup.agenda.data.datasource.remote.RetrofitCep
import br.com.zup.agenda.data.model.UserResult

class UserRepository (private val userDAO: UserDAO){
    suspend fun getUser(user: String): UserResult {
        return RetrofitCep.api.getAddress(user)

    }
    suspend fun insertUser(userResult:UserResult) {
        userDAO.insertUser(userResult)
    }

    suspend fun deleteUser(userResult:UserResult){
        userDAO.deleteUser(userResult)
    }
    suspend fun getAllUser(): List<UserResult> = userDAO.getUser()
}
