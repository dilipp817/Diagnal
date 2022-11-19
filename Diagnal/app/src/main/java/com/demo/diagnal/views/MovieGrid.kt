package com.demo.diagnal.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.demo.diagnal.R
import com.demo.diagnal.models.Content

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MovieGrid(movieList: List<Content>, searchedQuery: String = "") {
    val filteredList = searchedQuery.let { query ->
        if (query.trim().length < 3)
            movieList
        else
            movieList.filter { it.name.contains(query, true) }
    }
    if(filteredList.isNotEmpty()) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(3),
        ) {
            items(
                items = filteredList,
                itemContent = {
                    MovieView(it)
                }
            )
        }
    }
    else {
        EmptyGrid()
    }
}

@Composable
fun EmptyGrid(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Center
    ) {
        Text(text = stringResource(id = R.string.empty_result))
    }
}