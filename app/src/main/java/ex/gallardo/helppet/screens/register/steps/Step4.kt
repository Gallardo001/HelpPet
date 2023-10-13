package ex.gallardo.helppet.screens.register.steps

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import ex.gallardo.helppet.components.ComboBox
import ex.gallardo.helppet.components.NormalTextField
import ex.gallardo.helppet.components.Title
import ex.gallardo.helppet.components.TitleBold
import ex.gallardo.helppet.utils.Const

@Composable
fun Step4() {
    var day by remember { mutableStateOf("") }
    var year by remember { mutableStateOf("") }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Title(text = "Informacion basica")
        TitleBold(text = "Mascota")
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            NormalTextField(
                value = day ,
                placeHolder = "Dia" ,
                onValueChange = { day = it },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(10.dp))
            ComboBox(
                placeHolder ="Mes" ,
                items = Const.months,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(10.dp))
            NormalTextField(
                value = year ,
                placeHolder = "Año",
                onValueChange ={ year = it },
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        ComboBox(
            placeHolder ="Género" ,
            items = Const.gender,
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun Step4Preview() {
    Step4()
}