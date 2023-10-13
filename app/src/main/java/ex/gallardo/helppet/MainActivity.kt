package ex.gallardo.helppet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import ex.gallardo.helppet.data.HelpetDataBase
import ex.gallardo.helppet.navigation.WelcomeNavController
import ex.gallardo.helppet.ui.theme.HelpPetTheme
import ex.gallardo.helppet.viewmodels.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            val roomDatabase = Room
                .databaseBuilder(this, HelpetDataBase::class.java, "helpet_database")
                .build()
            val dao = roomDatabase.helpetDao()

            val userViewModel = UserViewModel(dao)

            HelpPetTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   WelcomeNavController(
                       navController = navController,
                       userViewModel
                   )
                }
            }
        }
    }
}