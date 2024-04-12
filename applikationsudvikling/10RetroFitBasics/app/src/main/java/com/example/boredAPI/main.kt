package com.example.boredAPI

import kotlinx.coroutines.runBlocking

fun main() {
    //exerciseA()
    //exerciseB()
    exerciseC()
}

fun exerciseA() {
    runBlocking {
        val instance = RetrofitInstance()
        val task = instance.apiService.getTask()
        println(task)
    }
}

fun exerciseB() {
    runBlocking {
        val instance = RetrofitInstance()
        println("Input number of participants:")
        val participants: Int? = readlnOrNull()?.toIntOrNull()
        if (participants == null) {
            println("Invalid number input, choosing random number of participants instead")
        }
        val task = instance.apiService.getTaskParticipants(participants)
        println(task)
    }
}

fun exerciseC() {
    runBlocking {
        val instance = RetrofitInstance()
        println("Input minimum accessibility as double (x.y):")
        val minaccessibility: Double? = readlnOrNull()?.toDoubleOrNull()
        println("Input maximum accessibility as double (x.y):")
        val maxaccessibility: Double? = readlnOrNull()?.toDoubleOrNull()
        println("Input minimum price as double (x.y):")
        val minprice: Double? = readlnOrNull()?.toDoubleOrNull()
        println("Input maximum price as double (x.y):")
        val maxprice: Double? = readlnOrNull()?.toDoubleOrNull()

        val task = instance.apiService.getTaskAccessibilityPrice(minaccessibility, maxaccessibility, minprice, maxprice)
        println(task)
    }
}
