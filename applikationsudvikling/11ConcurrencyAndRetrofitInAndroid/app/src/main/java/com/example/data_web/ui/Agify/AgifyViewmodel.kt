package com.example.data_web.ui.Agify

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data_web.data.AgifyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AgifyViewmodel : ViewModel() {
    private val agifyRepository = AgifyRepository()



    var currentAge: Int by mutableIntStateOf(0)
        private set

    var name: String by mutableStateOf("Steve")

    var currentMessage: String by mutableStateOf("As $name Your age is $currentAge")

    fun getAge() {
        viewModelScope.launch {
            try {
                val data = withContext(Dispatchers.IO) {
                    currentAge = agifyRepository.getAgifyInfo().age
                }
            } catch (e: Exception) {
                currentMessage = e.message.toString()
            }
        }
    }
}
