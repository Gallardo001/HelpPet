package ex.gallardo.helppet.screens.register.steps

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ex.gallardo.helppet.components.NormalTextField
import ex.gallardo.helppet.components.Title
import ex.gallardo.helppet.components.TitleBold

@Composable
fun Step5(
    raza: String ,
    especie: String ,
    peso: String ,
    color: String ,
    onRazaChange: (String) -> Unit ,
    onEspecieChange: (String) -> Unit ,
    onPesoChange: (String) -> Unit ,
    onColorChange: (String) -> Unit
) {

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
                onValueChange = onRazaChange,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(10.dp))
            NormalTextField(
                value = especie ,
                placeHolder = "Especie" ,
                onValueChange = onEspecieChange,
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            NormalTextField(
                value = peso ,
                placeHolder = "Peso" ,
                onValueChange = onPesoChange,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(10.dp))
            NormalTextField(
                value = color ,
                placeHolder = "Color | pelaje" ,
                onValueChange = onColorChange ,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

