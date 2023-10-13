package ex.gallardo.helppet.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComboBox(
    placeHolder:String,
    items:List<String> ,
    modifier: Modifier = Modifier
) {
    var isExpanded by remember { mutableStateOf(false) }
    var value by remember { mutableStateOf("") }

    ExposedDropdownMenuBox(
        expanded = isExpanded,
        onExpandedChange = { isExpanded = it },
        modifier = modifier
            .fillMaxWidth()
        ) {
        TextField(
            value = value ,
            onValueChange = {},
            placeholder = {
                Text(
                    text = placeHolder,
                    color = Color.White,
                    maxLines = 1
                )
            },
            readOnly = true,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = isExpanded
                )
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors(
                containerColor = Color(0xFF2882f1) ,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedTrailingIconColor = Color.White,
                unfocusedTrailingIconColor = Color.White,
                textColor = Color.White
            ),
            shape = RoundedCornerShape(10.dp),
            maxLines = 1,
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
        )

        ExposedDropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false },
            ) {
            items.forEach { item ->
                DropdownMenuItem(
                    text = {
                           Text(text = item)
                    },
                    onClick = {
                        value = item
                        isExpanded = false
                    },
                    colors = MenuDefaults.itemColors(
                        textColor = Color.White
                    ),
                    modifier = Modifier
                        .background(Color(0xFF2882f1))
                )
            }
        }
    }
}

