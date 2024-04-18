package com.example.data_web.data

import com.example.data_web.DTO.CatFact

class CatFactsRepository {
    private val retrofit = RetrofitInstance();

    suspend fun getCatFact(): CatFact {
        val fact: CatFact = retrofit.apiService.getFact()
        return fact;
    }
}
