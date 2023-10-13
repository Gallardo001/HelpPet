package ex.gallardo.helppet.screens.register

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ex.gallardo.helppet.components.Title

@Composable
fun Login() {
Title(text = "Inicio de sesion")
}

@Preview (showSystemUi = true)
@Composable
fun LoginPreview() {
    Login()
}