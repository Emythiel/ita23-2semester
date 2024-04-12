package com.example.data_web.ui.CatFact

import android.annotation.SuppressLint
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data_web.DTO.CatFact
import com.example.data_web.data.CatFactsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@SuppressLint("MutableCollectionMutableState")
class CatFactsViewModel : ViewModel() {
    private val catFactsRepository = CatFactsRepository();
    var currentCatFactString: String by mutableStateOf("Loading Fact ${getRandomFact()}")
        private set;

    var likedFacts: MutableList<String> by mutableStateOf(mutableListOf())
        private set

    private var isFactLiked: Boolean = false

    fun getRandomFact() {
        viewModelScope.launch {
            try {
                val data = withContext(Dispatchers.IO) {
                    currentCatFactString = catFactsRepository.getCatFact().fact
                }
                isFactLiked = false
            } catch (e: Exception) {
                currentCatFactString = e.message.toString()
            }
        }
    }

    var likedFactsCount: String by mutableStateOf("")

    fun likeFact() {
        if (!isFactLiked) {
            likedFacts.add(currentCatFactString)
            likedFactsCount = "Liked facts: ${likedFacts.size}"
            isFactLiked = true
        }
    }
}

