package com.example.composermtt.presentation.screens.splash

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.composermtt.R
import com.example.composermtt.presentation.navigation.NavigationRoad
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavHostController
) {
   var startAnim by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnim) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        )
    )
    LaunchedEffect(key1 = true ){
        startAnim = true
        delay(3000)
        navController.popBackStack()
        navController.navigate(route = NavigationRoad.Main.path)
    }
    SplashUI(alpha = alphaAnim.value)

}
@Composable
private fun SplashUI(alpha:Float){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.backf),
                contentScale = ContentScale.FillBounds
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.splash_screen),
            contentDescription = "Image",
            modifier = Modifier
                .padding(top = 200.dp)
                .width(260.dp)
                .height(260.dp)
                .alpha(alpha)

        )
        Text(
            text = "Welcome",
            modifier = Modifier
                .padding(20.dp),
            color = Color.Green,
            fontSize = 30.sp
        )
    }
}

@Preview
@Composable
private fun ShowUI() {
    SplashUI(alpha = 1f)
}

@Preview(uiMode =UI_MODE_NIGHT_YES)
@Composable
private fun DarkThemeShow(){
    SplashUI(alpha = 1f)
}