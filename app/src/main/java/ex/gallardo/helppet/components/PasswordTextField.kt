package ex.gallardo.helppet.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import ex.gallardo.helppet.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(value: String, placeHolder: String, hidden:Boolean, onClick : () -> Unit ,onValueChange: (String) -> Unit) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth()
            .border(2.dp, Color(0xFF2882f1), RoundedCornerShape(10.dp)),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            textColor = Color.Black,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            placeholderColor = Color.Gray
        ),
        placeholder = {
            Text(
                text = placeHolder,
            )
        },
        shape = RoundedCornerShape(10.dp),
        visualTransformation =
        if (hidden) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            IconButton(onClick = onClick
            ) {
                Icon(
                    painter = painterResource(id =
                    if (hidden)R.drawable.baseline_visibility_24 else R.drawable.baseline_visibility_off_24),
                    contentDescription = "Person",
                    tint = Color(0xFF2882f1)
                )

            }
        }
    )
}
