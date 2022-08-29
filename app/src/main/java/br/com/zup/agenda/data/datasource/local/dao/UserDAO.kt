package br.com.zup.agenda.data.datasource.local.dao

import androidx.room.*
import br.com.zup.agenda.data.model.UserResult

@Dao
interface UserDAO {
    @Query("SELECT * FROM tableUser ORDER BY name ASC")
    fun getUser():List<UserResult>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(userResult: UserResult)
    @Delete
    fun deleteUser(userResult: UserResult)
}