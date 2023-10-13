package ex.gallardo.helppet.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pets")
data class Pets(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_pet")
    val id: Int = 0,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "race")
    val race: String,
    @ColumnInfo(name = "weight")
    val weight: String,
    @ColumnInfo(name = "color")
    val color: String

)
