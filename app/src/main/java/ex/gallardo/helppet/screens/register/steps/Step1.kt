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
import ex.gallardo.helppet.components.NormalTextField
import ex.gallardo.helppet.components.Title
import ex.gallardo.helppet.components.TitleBold

@Composable
fun Step1(modifier: Modifier = Modifier) {
    var value by remember { mutableStateOf("") }
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Title(text = "Accede a tu")
        TitleBold(text = "Correo Electrónico")
        Spacer(modifier = Modifier.height(30.dp))
            NormalTextField(
                value = value ,
                placeHolder = "Correo Electrónico",
                onValueChange = { value = it }
            )
    }

}

@Preview(showSystemUi = true)
@Composable
fun Step1Preview() {
    Step1()
}