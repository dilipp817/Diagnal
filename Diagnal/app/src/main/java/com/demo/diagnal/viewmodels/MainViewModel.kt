package com.demo.diagnal.viewmodels

import android.content.Context
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import com.demo.diagnal.Utils
import com.demo.diagnal.models.Content
import com.demo.diagnal.models.MovieData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.lang.reflect.Type
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel(), LifecycleObserver {

    private val _pageTitle = MutableStateFlow("")
    val pageTitle = _pageTitle.asStateFlow()
    private val _movieList = MutableStateFlow(emptyList<Content>())
    val movieList = _movieList.asStateFlow()

    fun processAsset(context: Context, fileName: String) {
        val jsonString = Utils.getJsonFromAssets(context, fileName)
        val gson = Gson()
        val listUserType: Type = object : TypeToken<MovieData?>() {}.type

        val movieData: MovieData = gson.fromJson(jsonString, listUserType)
        _movieList.value = movieData.page.contentItems.content
        _pageTitle.value = movieData.page.title
    }
}