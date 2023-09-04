package com.example.composermtt.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composermtt.R
import com.example.composermtt.presentation.navigation.NavigationRoad

@Composable
fun MainScreen(
  navController:NavController
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.backf),
                contentScale = ContentScale.FillBounds
            )
    ) {

        val (mainImg, characterImage,
            locationImage, episodeImage,
            episodeText, locationText, characterText) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "Image",
            modifier = Modifier
                .padding(top = 32.dp)
                .constrainAs(mainImg) {
                    top.linkTo(parent.top, margin = 30.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        Image(painter = painterResource(id = R.drawable.png_rick_and_morty),
            contentDescription = "",
            modifier = Modifier
                .width(148.dp)
                .height(148.dp)
                .constrainAs(characterImage) {
                    top.linkTo(mainImg.bottom, margin = 20.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .clickable(onClick = {
                    navController.navigate(NavigationRoad.Character.path)
                })
        )
        Text(
            text = "Characters", modifier = Modifier
                .constrainAs(characterText) {
                    top.linkTo(characterImage.bottom, margin = 10.dp)
                    start.linkTo(characterImage.start)
                    end.linkTo(characterImage.end)
                },
            color = Color.Green,
            fontSize = 24.sp
        )
        Image(painter = painterResource(id = R.drawable.png_rick),
            contentDescription = "",
            modifier = Modifier
                .width(148.dp)
                .height(148.dp)
                .constrainAs(episodeImage) {
                    top.linkTo(characterText.bottom, margin = 20.dp)
                    start.linkTo(parent.start, margin = 20.dp)
                }
                .clickable(
                    onClick = {
                        navController.navigate(NavigationRoad.Episode.path)
                    }
                )
        )
        Text(
            text = "Episodes", modifier = Modifier
                .constrainAs(episodeText) {
                    top.linkTo(episodeImage.bottom, margin = 10.dp)
                    start.linkTo(episodeImage.start)
                    end.linkTo(episodeImage.end)
                },
            color = Color.Green,
            fontSize = 24.sp
        )
        Image(painter = painterResource(id = R.drawable.png_morty),
            contentDescription = "",
            modifier = Modifier
                .width(148.dp)
                .height(148.dp)
                .constrainAs(locationImage) {
                    top.linkTo(characterText.bottom, margin = 20.dp)
                    end.linkTo(parent.end, margin = 20.dp)
                }
                .clickable(
                    onClick = {
                        navController.navigate(NavigationRoad.Location.path)
                    }
                )
        )
        Text(
            text = "Locations", modifier = Modifier
                .constrainAs(locationText) {
                    top.linkTo(locationImage.bottom, margin = 10.dp)
                    start.linkTo(locationImage.start)
                    end.linkTo(locationImage.end)
                },
            color = Color.Green,
            fontSize = 24.sp
        )
    }
}

@Preview
@Composable
private fun MainShow() {
    MainScreen(navController = rememberNavController())
}