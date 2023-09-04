package com.example.composermtt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.composermtt.mydata.base.BaseViewModel
import com.example.composermtt.presentation.navigation.BuildNavGraph
import com.example.composermtt.presentation.ui.theme.ComposeRMTTTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainAction(viewModel = viewModel())
        }
    }
}

@Composable
fun MainAction(viewModel: BaseViewModel) {
    ComposeRMTTTheme {
        val navController = rememberNavController()
        BuildNavGraph(navController = navController, viewModel =viewModel )
    }
}