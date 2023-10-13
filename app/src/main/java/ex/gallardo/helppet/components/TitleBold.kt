package ex.gallardo.helppet.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun TitleBold(text:String) {
    Text(
        text = text,
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold
    )
}