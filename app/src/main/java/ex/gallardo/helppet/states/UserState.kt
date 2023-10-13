package ex.gallardo.helppet.states

import ex.gallardo.helppet.models.Pets
import ex.gallardo.helppet.models.Users

data class UserState(
    val userList: List<Users> = emptyList(),
    val petList: List<Pets> = emptyList()

)