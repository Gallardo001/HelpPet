package ex.gallardo.helppet.screens.register

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.setValue


import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ex.gallardo.helppet.components.NormalTextField
import ex.gallardo.helppet.components.PasswordTextField
import ex.gallardo.helppet.components.Title


@Composable
fun LoginScreen() {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),


    horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        var value by remember { mutableStateOf("") }
        var hidden  by remember { mutableStateOf(true) }
       Title(text = "Iniciar sesion")
       Spacer(modifier = Modifier.height(30.dp))
       NormalTextField(
           value = value,
           placeHolder = "Usuario",
           onValueChange = { value = it })
        Spacer(modifier = Modifier.height(30.dp))
        PasswordTextField(
            value = value,
            placeHolder = "Contraseña",
            hidden = hidden,
            onClick = { hidden = !hidden },
            onValueChange = { value = it }
        )
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick =  { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF2882f1)
        ),modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Iniciar Sesión",

                )
        }
        TextButton(onClick = { /*TODO*/ }) {

                Text("¿Has olvidado tu contraseña?, Haga clic aqui.",
                    color = Color(0xFF2882f1))
        }
        Divider(modifier = Modifier.height(3.dp))
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "¿No te has registrado aun"
            , color = Color(0xFF2882f1))
        OutlinedButton(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth(),
            border = BorderStroke(1.dp, Color(0xFF2882f1))
        ) {
            Text(
                text = "Registrarse",
                color = Color(0xFF2882f1)
            )
        }

}
}

@Preview (showSystemUi = true)
@Composable
fun LoginPreview() {
    LoginScreen()
}