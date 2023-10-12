package ex.gallardo.helppet.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
import ex.gallardo.helppet.utils.Const
import ex.gallardo.helppet.utils.WelcomeScreens
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPagerApi::class)
@Composable
fun WelcomeScreen(navController: NavHostController) {
    val pagerState = rememberPagerState(initialPage = 0)
    val scope = rememberCoroutineScope()

    Scaffold {paddingValues ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(20.dp)
        ) {
            LogoSection()
            CarouselCard(pagerState, modifier = Modifier.weight(2f))
            CircleIndicatorSection(pagerState, scope, navController)
        }
    }
}

@Composable
private fun LogoSection() {
    Text(
        "Bienvenido a",
        fontWeight = FontWeight.W800,
        fontSize = 32.sp
    )
    Spacer(modifier = Modifier.height(20.dp))
    Image(
        painter = painterResource(id = R.drawable.logotipo),
        contentDescription = "logo"
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun CircleIndicatorSection(
    pagerState: PagerState,
    scope: CoroutineScope,
    navController: NavHostController
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth(),
    ) {
        CircleIndicatorItems(pagerState, scope)

        Buttons(pagerState, scope, navController)
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun Buttons(
    pagerState: PagerState,
    scope: CoroutineScope,
    navController: NavHostController
) {
    val buttonText = if (pagerState.currentPage == 2) "Comenzar" else "Siguiente"
    Row {
        if (pagerState.currentPage != 0) {
            IconButton(
                onClick = {
                          scope.launch {
                              pagerState.animateScrollToPage(
                                  pagerState.currentPage - 1
                              )
                          }
                },
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color(0xFF2882F1))
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "Back",
                    tint = Color.White
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
                          navController.navigate(WelcomeScreens.StartScreen.route)
                      }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2882F1),
            )
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

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun CircleIndicatorItems(
    pagerState: PagerState,
    scope: CoroutineScope,
) {
    Row {
        repeat(Const.carouselItems.size) {
            val color = if (pagerState.currentPage == it) Color(0xFF2882F1) else Color(0xFFD9D9D9)
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .clip(CircleShape)
                    .size(15.dp)
                    .background(color)
                    .clickable {
                        scope.launch {
                            pagerState.animateScrollToPage(it)
                        }
                    }
            )
        }
    }
}

@Composable
@OptIn(ExperimentalPagerApi::class)
private fun CarouselCard(pagerState: PagerState, modifier: Modifier) {
    HorizontalPager(
        count = Const.carouselItems.size,
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
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(
                    painter = painterResource(id = Const.carouselItems[page].image),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = Const.carouselItems[page].text,
                    fontWeight = FontWeight.W500,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 70.dp)
                )

            }
        }
    }
}
