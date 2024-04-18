package com.example.data_web.data

import com.example.data_web.DTO.AgifyData

class AgifyRepository {
    private val retrofit = AgeRetrofitInstance()

    suspend fun getAgifyInfo(): AgifyData {
        val age: AgifyData = retrofit.apiService.getAge("name")
        return age
    }

}

/*class GetAgeRepository {
    private val retrofit = AgeRetrofitInstance()

    suspend fun getAgifyInfo(): AgifyData {
        val age: AgifyData = retrofit.apiService.get
    }
}*/
