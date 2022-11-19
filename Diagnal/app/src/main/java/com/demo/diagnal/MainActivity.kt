package com.demo.diagnal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.demo.diagnal.ui.theme.DiagnalTheme
import com.demo.diagnal.viewmodels.MainViewModel
import com.demo.diagnal.views.LoadPage

class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiagnalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val movieList = mainViewModel.movieList.collectAsState()
                    val pageTitle = mainViewModel.pageTitle.collectAsState()
                    LaunchedEffect(key1 = Unit, block = {
                        mainViewModel.processAsset(
                            applicationContext,
                            fileName = "CONTENTLISTINGPAGE-PAGE1.json"
                        )
                    })
                    LoadPage(
                        movieList = movieList.value,
                        pageTitle = pageTitle.value,
                        onBackPressed = {}
                    )
                }
            }
        }
    }
}