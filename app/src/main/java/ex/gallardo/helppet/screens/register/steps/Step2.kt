package ex.gallardo.helppet.screens.register.steps

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ex.gallardo.helppet.components.PasswordTextField
import ex.gallardo.helppet.components.Title
import ex.gallardo.helppet.components.TitleBold

@Composable
fun Step2(modifier: Modifier = Modifier) {
    var value by remember { mutableStateOf("") }
    var hidden  by remember { mutableStateOf(true) }
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Title(text = "Ingrese su")
        TitleBold(text = "Contraseña y Confirmela")
        Spacer(modifier = Modifier.height(30.dp))

        PasswordTextField(
            value = value,
            placeHolder = "Contraseña",
            hidden = hidden,
            onClick = { hidden = !hidden },
            onValueChange = { value = it }
        )
        Spacer(modifier = Modifier.height(30.dp))
    PasswordTextField(
        value = value,
        placeHolder = "Confirmar Contraseña",
        hidden = hidden,
        onClick = { hidden = !hidden },
        onValueChange ={ value = it }
    )
    }
}

@Preview (showSystemUi = true)
@Composable
fun Step2Preview() {
    Step2()
}