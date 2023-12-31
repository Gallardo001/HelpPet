package ex.gallardo.helppet.screens.start

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ex.gallardo.helppet.R
import ex.gallardo.helppet.utils.WelcomeScreens

@Composable
fun StartScreen(navController: NavController) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 40.dp).padding(horizontal = 40.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logotipo),
            contentDescription = "Logo"
        )
        Spacer(modifier = Modifier.height(60.dp))
        Image(
            painter = painterResource(id = R.drawable.illustrations_pets),
            contentDescription = "Illustration")
        Spacer(modifier = Modifier.height(65.dp))
        Button(
            onClick =  {
                navController.navigate(WelcomeScreens.LoginScreen.route)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2882f1)
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Iniciar Sesión")
        }
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedButton(
            onClick = {
                navController.navigate(WelcomeScreens.RegisterScreen.route)
                      },
            modifier = Modifier.fillMaxWidth(),
            border = BorderStroke(1.dp, Color(0xFF2882f1))
        ) {
            Text(
                text = "Registrarse",
                color = Color(0xFF2882f1)
            )
        }
    }
}
