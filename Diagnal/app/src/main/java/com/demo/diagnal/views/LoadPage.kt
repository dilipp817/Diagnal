package com.demo.diagnal.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.demo.diagnal.R
import com.demo.diagnal.models.Content
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource

@Composable
fun LoadPage(
    movieList: List<Content>,
    pageTitle: String,
    onBackPressed: () -> Unit
) {
    var showSearchBar by rememberSaveable { mutableStateOf(false) }
    var searchedQuery by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = pageTitle,
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackPressed) {
                        Image(painterResource(R.drawable.back), "")
                    }
                },
                backgroundColor = colorResource(id = R.color.purple_500),
                contentColor = Color.White,
                elevation = dimensionResource(id = R.dimen.space_12),
                actions = {
                    IconButton(onClick = {
                        showSearchBar = !showSearchBar
                    }) {
                        Image(painterResource(R.drawable.search), "")
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            if (showSearchBar) {
                SearchBar(
                    searchbarPlaceHolder = {
                        Text(text = stringResource(id = R.string.search_something))
                    },
                    onTextChanged = {
                        searchedQuery = it
                    }
                )
            }
            MovieGrid(movieList, searchedQuery)
        }
    }
}

@Composable
fun SearchBar(
    searchbarPlaceHolder: @Composable (() -> Unit),
    onTextChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var searchQuery by rememberSaveable { mutableStateOf("") }

    TextField(
        modifier = modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.space_60)),
        value = searchQuery,
        onValueChange = {
            searchQuery = it
            onTextChanged(it)
        },
        singleLine = true,
        placeholder = searchbarPlaceHolder
    )
}
