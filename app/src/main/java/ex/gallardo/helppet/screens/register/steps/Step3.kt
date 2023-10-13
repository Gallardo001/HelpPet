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
fun Step3(
    modifier: Modifier = Modifier,
    nameUser: String,
    namePet:String,
    onNameUserChange: (String) -> Unit,
    onNamePetChange: (String) -> Unit
    ) {
    var value by remember { mutableStateOf("") }
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Title(text = "Informacion")
        TitleBold(text = "General")
        Spacer(modifier = Modifier.height(30.dp))
        NormalTextField(
            value = nameUser,
            placeHolder = "Nombre del Dueño",
            onValueChange =onNameUserChange
        )
        Spacer(modifier = Modifier.height(30.dp))
        NormalTextField(
            value = namePet,
            placeHolder = "Nombre de la Mascota",
            onValueChange = onNamePetChange
        )

    }
}