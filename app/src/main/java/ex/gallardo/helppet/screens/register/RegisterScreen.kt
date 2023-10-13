package ex.gallardo.helppet.screens.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ex.gallardo.helppet.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen() {
   Scaffold {paddingValues ->
       Column (
           horizontalAlignment = Alignment.CenterHorizontally,
           modifier = Modifier
               .fillMaxSize()
               .padding(top = 20.dp)
               .padding(horizontal = 40.dp)
               .padding(paddingValues)
       ){
           ImageSection()
           Spacer(modifier = Modifier.height(30.dp))
           StepsSection()
           Spacer(modifier = Modifier.height(30.dp))
       }
   }
}

@Composable
private fun StepsSection() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            painter = painterResource(id = R.drawable.one),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .clip(CircleShape)
                .background(Color(0xFF2882f1))
                .padding(10.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.line),
            contentDescription = null,
            tint = Color(0xFF2882f1),
        )
        Icon(
            painter = painterResource(id = R.drawable.two_),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .clip(CircleShape)
                .background(Color(0xFF2882f1))
                .padding(10.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.line),
            contentDescription = null,
            tint = Color(0xFF2882f1),
        )
        Icon(
            painter = painterResource(id = R.drawable.three_),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .clip(CircleShape)
                .background(Color(0xFF2882f1))
                .padding(10.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.line),
            contentDescription = null,
            tint = Color(0xFF2882f1),
        )
        Icon(
            painter = painterResource(id = R.drawable.four_),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .clip(CircleShape)
                .background(Color(0xFF2882f1))
                .padding(10.dp)
        )
    }
}

@Composable
private fun ImageSection() {
    Image(
        painter = painterResource(id = R.drawable.logotipo),
        contentDescription = null
    )
    Spacer(modifier = Modifier.height(15.dp))
    Image(
        painter = painterResource(id = R.drawable.illustrations_friendpets),
        contentDescription = null
    )
}

@Preview
@Composable
fun RegisterScreenPreview() {
    RegisterScreen()
}