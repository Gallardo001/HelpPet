package ex.gallardo.helppet.screens.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ex.gallardo.helppet.R
import ex.gallardo.helppet.components.PasswordTextField
import ex.gallardo.helppet.components.Title
import ex.gallardo.helppet.utils.WelcomeScreens


@Composable
fun ResetPass() {
  var value by remember { mutableStateOf("") }
  var value2 by remember { mutableStateOf("") }
  var hidden  by remember { mutableStateOf(true) }
  Column (
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 20.dp),
      horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Image(painter = painterResource(id = R.drawable.logotipo),
      contentDescription = null)
    Spacer(modifier = Modifier.height(20.dp))
    Image(painter = painterResource(id = R.drawable.illustration_resetpass),
      contentDescription = null)
    Title(text = "¿Olvidaste tu contraseña?")
    Spacer(modifier = Modifier.height(30.dp))
    PasswordTextField(
      value = value,
      placeHolder = "Contraseña",
      hidden = hidden,
      onClick = { hidden = !hidden },
      onValueChange = { value = it }
    )
    Spacer(modifier = Modifier.height(30.dp))
    PasswordTextField(
      value = value2,
      placeHolder = "Confirmar Contraseña",
      hidden = hidden,
      onClick = { hidden = !hidden },
      onValueChange = { value2 = it }
    )
      Spacer(modifier = Modifier.height(30.dp))
    Button(
      onClick =  {
      },
      colors = ButtonDefaults.buttonColors(
        containerColor = Color(0xFF2882f1)
      ),
      modifier = Modifier.fillMaxWidth()
    ) {
      Text(text = "Confirmar")
    }


  }
}

@Preview (showSystemUi = true)
@Composable
fun ResetPassPreview() {
    ResetPass()
}