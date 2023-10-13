package ex.gallardo.helppet.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ex.gallardo.helppet.models.Pets
import ex.gallardo.helppet.models.Users
import kotlinx.coroutines.flow.Flow

@Dao
interface HelpetDao {
    @Query("SELECT * FROM users")
    fun getUsers(): Flow<List<Users>>
    @Query("SELECT * FROM pets")
    fun getPets(): Flow<List<Pets>>

    @Insert
    suspend fun insertUser(user: Users)

    @Insert
    suspend fun insertPet(pet: Pets)
}