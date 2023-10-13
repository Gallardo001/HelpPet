package ex.gallardo.helppet.screens.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
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
fun Step5() {
    var raza by remember { mutableStateOf("") }
    var especie by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }
    var color by remember { mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Title(text = "Informacion basica 2")
        TitleBold(text = "Mascota")
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            NormalTextField(
                value = raza ,
                placeHolder = "Raza" ,
                onValueChange = { raza = it },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(10.dp))
            NormalTextField(
                value = especie ,
                placeHolder = "Especie" ,
                onValueChange = { especie = it },
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            NormalTextField(
                value = peso ,
                placeHolder = "Peso" ,
                onValueChange = { peso = it },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(10.dp))
            NormalTextField(
                value = color ,
                placeHolder = "Color | pelaje" ,
                onValueChange = { color = it },
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun Step5Preview() {
    Step5()
}