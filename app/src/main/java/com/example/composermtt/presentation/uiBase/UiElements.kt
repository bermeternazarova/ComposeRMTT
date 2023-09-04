@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.composermtt.presentation.uiBase

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
 fun MyBottomBar(
    showPrevious:Boolean,
    showNext:Boolean,
    onPreviousPressed :()->Unit,
    onNextPressed :()->Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 2.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            TextButton(modifier = Modifier
                .weight(1f)
                .height(48.dp),
                enabled = showPrevious,
                onClick = onPreviousPressed
            ) {
                Text(text = "Button_Previous")
            }
            TextButton(modifier = Modifier
                .weight(1f)
                .height(48.dp),
                enabled = showNext,
                onClick = onNextPressed
            ) {
                Text(text = "Button_Next")
            }
        }
    }
}

@Composable
 fun ProgressIndicatorScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ){
        CircularProgressIndicator()
    }
}

@Composable
 fun MyTopBar(
   name:String
) {
    TopAppBar(
        title = {
            Text(
                text = name,
                textAlign = TextAlign.Center,
                modifier= Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor =MaterialTheme.colorScheme.surface)
    )
}
