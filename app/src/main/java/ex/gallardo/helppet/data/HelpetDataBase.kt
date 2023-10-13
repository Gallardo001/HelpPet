package ex.gallardo.helppet.data

import androidx.room.Database
import androidx.room.RoomDatabase
import ex.gallardo.helppet.models.Pets
import ex.gallardo.helppet.models.Users

@Database(
    entities = [Users::class, Pets::class],
    version = 1,
    exportSchema = false
)
abstract class HelpetDataBase: RoomDatabase() {
    abstract fun helpetDao(): HelpetDao
}