package ex.gallardo.helppet.screens.register

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import ex.gallardo.helppet.R
import ex.gallardo.helppet.models.Pets
import ex.gallardo.helppet.models.Users
import ex.gallardo.helppet.screens.register.steps.Step1
import ex.gallardo.helppet.screens.register.steps.Step2
import ex.gallardo.helppet.screens.register.steps.Step3
import ex.gallardo.helppet.screens.register.steps.Step4
import ex.gallardo.helppet.screens.register.steps.Step5
import ex.gallardo.helppet.utils.Const
import ex.gallardo.helppet.utils.WelcomeScreens
import ex.gallardo.helppet.viewmodels.UserViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPagerApi::class)
@Composable
fun RegisterScreen(navController: NavHostController, userViewModel: UserViewModel) {
    val pagerState = rememberPagerState(initialPage = 0)
    val scope = rememberCoroutineScope()

    var correo by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var nameUser by remember { mutableStateOf("") }
    var namePet by remember { mutableStateOf("") }
    var raza by remember { mutableStateOf("") }
    var especie by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }
    var color by remember { mutableStateOf("") }

    val user = Users(
        name = nameUser,
        email = correo,
        password = password,
        petName = namePet
    )

    val pet = Pets(
        name = namePet,
        race = raza,
        weight = peso,
        color = color
    )


   Scaffold {paddingValues ->
       Column (
           horizontalAlignment = Alignment.CenterHorizontally,
           modifier = Modifier
               .fillMaxSize()
               .padding(top = 20.dp)
               .padding(horizontal = 40.dp)
               .padding(bottom = 10.dp)
               .padding(paddingValues)
       ) {
           ImageSection()
           Spacer(modifier = Modifier.height(10.dp))
           StepsSection(pagerState)
           Spacer(modifier = Modifier.height(10.dp))
           OnBoardingEffect(
               pagerState = pagerState,
               modifier = Modifier.weight(1f),
               correo = correo,
               onEmailChange = { correo = it },
               password = password,
               confirmPassword = confirmPassword,
               onPasswordChange = { password = it },
               onConfirmPasswordChange = { confirmPassword = it },
               nameUser = nameUser,
               onNameUserChange = { nameUser = it },
               namePet = namePet,
               onNamePetChange = { namePet = it },
               raza = raza,
               onRazaChange = { raza = it },
               especie = especie,
               onEspecieChange = { especie = it },
               peso = peso,
               onPesoChange = { peso = it },
               color = color,
               onColorChange = { color = it }
           )
           Buttons(
               pagerState = pagerState,
               scope = scope ,
               navController = navController ,
               userViewModel = userViewModel,
               users = user,
               pets = pet
           )
       }
   }
}

@Composable
@OptIn(ExperimentalPagerApi::class)
private fun OnBoardingEffect(
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    correo: String,
    onEmailChange: (String) -> Unit,
    password: String,
    confirmPassword: String,
    onPasswordChange: (String) -> Unit,
    onConfirmPasswordChange: (String) -> Unit,
    nameUser: String,
    onNameUserChange: (String) -> Unit,
    namePet: String,
    onNamePetChange: (String) -> Unit,
    raza: String,
    onRazaChange: (String) -> Unit,
    especie: String,
    onEspecieChange: (String) -> Unit,
    peso: String,
    onPesoChange: (String) -> Unit,
    color: String,
    onColorChange: (String) -> Unit
) {
    HorizontalPager(
        count = Const.steps.size,
        state = pagerState,
        modifier = modifier
    ) { page ->
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.background
            ),
            modifier = Modifier
                .graphicsLayer {
                    val pageOffSet = calculateCurrentOffsetForPage(page = page).absoluteValue
                    lerp(
                        start = 0.5f,
                        stop = 1f,
                        fraction = 1f - pageOffSet.coerceIn(0f, 1f)
                    )
                        .also { scale ->
                            scaleX = scale
                            scaleY = scale
                        }
                }
        ) {
            when (Const.steps[page]) {
                "Step 1" -> {
                    Step1(
                        value = correo,
                        onValueChange = onEmailChange
                    )
                }

                "Step 2" -> {
                    Step2(
                        password = password,
                        confirmPassword = confirmPassword,
                        onPasswordChange = onPasswordChange,
                        onConfirmPasswordChange = onConfirmPasswordChange
                    )
                }

                "Step 3" -> {
                    Step3(
                        nameUser = nameUser,
                        namePet = namePet,
                        onNameUserChange = onNameUserChange,
                        onNamePetChange = onNamePetChange
                    )
                }

                "Step 4" -> {
                    Step4()
                }

                "Step 5" -> {
                    Step5(
                        raza = raza,
                        especie = especie,
                        peso = peso,
                        color = color,
                        onRazaChange = onRazaChange,
                        onEspecieChange = onEspecieChange,
                        onPesoChange = onPesoChange,
                        onColorChange = onColorChange
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun StepsSection(pagerState: PagerState) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
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
            painter = painterResource(id = R.drawable.divider),
            contentDescription = null,
            tint = if (pagerState.currentPage > 0) Color(0xFF2882f1) else Color(0xFFD9D9D9),
            modifier = Modifier.width(30.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.two_),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .clip(CircleShape)
                .background(if (pagerState.currentPage > 0) Color(0xFF2882f1) else Color(0xFFD9D9D9))
                .padding(10.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.divider),
            contentDescription = null,
            tint = if (pagerState.currentPage > 1) Color(0xFF2882f1) else Color(0xFFD9D9D9),
            modifier = Modifier.width(30.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.three_),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .clip(CircleShape)
                .background(if (pagerState.currentPage > 1) Color(0xFF2882f1) else Color(0xFFD9D9D9))
                .padding(10.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.divider),
            contentDescription = null,
            tint = if (pagerState.currentPage > 2) Color(0xFF2882f1) else Color(0xFFD9D9D9),
            modifier = Modifier.width(30.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.four_),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .clip(CircleShape)
                .background(if (pagerState.currentPage > 2) Color(0xFF2882f1) else Color(0xFFD9D9D9))
                .padding(10.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.divider),
            contentDescription = null,
            tint = if (pagerState.currentPage > 3) Color(0xFF2882f1) else Color(0xFFD9D9D9),
            modifier = Modifier.width(30.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.five),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .clip(CircleShape)
                .background(if (pagerState.currentPage > 3) Color(0xFF2882f1) else Color(0xFFD9D9D9))
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
    Image(
        painter = painterResource(id = R.drawable.illustrations_friendpets),
        contentDescription = null
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun Buttons(
    pagerState: PagerState,
    scope: CoroutineScope,
    navController: NavHostController,
    userViewModel: UserViewModel,
    users: Users,
    pets: Pets
) {
    val buttonText = if (pagerState.currentPage == 4)  "Registrarse ya!!" else "Siguiente"
    Row {
        if (pagerState.currentPage != 0) {
            OutlinedButton(
                onClick = {
                      scope.launch {
                          pagerState.animateScrollToPage(
                              pagerState.currentPage - 1
                          )
                      }},
                modifier = Modifier.weight(1f),
                border = BorderStroke(1.dp, Color(0xFF2882f1))
            ) {
                Text(
                    text = "Atrás",
                    color = Color(0xFF2882f1)
                )
            }
        }
        Spacer(modifier = Modifier.width(5.dp))
        Button(
            onClick = {
                if (pagerState.currentPage < pagerState.pageCount - 1) {
                    scope.launch {
                        pagerState.animateScrollToPage(
                            pagerState.currentPage + 1
                        )
                    }
                }else{
                    userViewModel.insertUser(users)
                    userViewModel.insertPet(pets)
                    navController.navigate(WelcomeScreens.StartScreen.route)
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2882F1),
            ),
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = buttonText,
                color = Color.White,
                fontWeight = FontWeight.W500,
                fontSize = 15.sp
            )
        }
    }
}

