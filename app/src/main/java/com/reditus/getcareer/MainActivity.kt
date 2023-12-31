package com.reditus.getcareer

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.reditus.getcareer.presentation.view.career.CareerScreen
import com.reditus.getcareer.presentation.viewmodel.career.CareerViewModel
import com.reditus.getcareer.common.viewmodelFactory.MainViewModelFactory
import com.reditus.getcareer.presentation.theme.GetCareerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = ViewModelProvider(
                this,
                MainViewModelFactory())[CareerViewModel::class.java]
            GetCareerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(viewModel)
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(viewModel : CareerViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("네카라쿠배가즈아") },
                actions = {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = null
                    )
                }
            )
        },
    ) {
        CareerScreen(
            viewModel = viewModel,
            modifier = Modifier.fillMaxSize().padding(it),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GetCareerTheme {
        //Greeting()
    }
}