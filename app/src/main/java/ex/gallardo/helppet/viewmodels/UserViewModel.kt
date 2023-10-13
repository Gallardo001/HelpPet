package ex.gallardo.helppet.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ex.gallardo.helppet.data.HelpetDao
import ex.gallardo.helppet.models.Pets
import ex.gallardo.helppet.models.Users
import ex.gallardo.helppet.states.UserState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class UserViewModel(
    private val helpetDao: HelpetDao
): ViewModel() {

    var state by mutableStateOf(UserState())
        private set

    init {
        viewModelScope.launch {
            helpetDao.getUsers().collectLatest {
                state = UserState(
                    userList = it
                )
            }
            helpetDao.getPets().collectLatest {
                state = UserState(
                    petList = it
                )
            }
        }
    }

    fun insertUser(user: Users) {
        viewModelScope.launch {
            helpetDao.insertUser(user)
        }
    }

    fun insertPet(pet: Pets) {
        viewModelScope.launch {
            helpetDao.insertPet(pet)
        }
    }
}