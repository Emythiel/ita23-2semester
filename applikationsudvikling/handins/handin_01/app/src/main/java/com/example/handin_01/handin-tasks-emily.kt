package com.example.handin_01

// Run the different handin tasks
fun main() {
        // Run Task 1 - Vote Checker
    //println(h1voteCheck())

        // Run Task 2 - Max / Min Checker
    //println(h2maxMinCheck(14, 19, 11, ::h2getMax))
    //println(h2maxMinCheck(11, 4, 46, ::h2getMin))

        // Run Task 3 - Average Calculator
    //println(h3calculateAverage(listOf(6, 8, 10, 12, 18, 2, 6)))

        // Run Task 4 - CPR Validator
        // Not perfect, doesn't check exact month/days (eg February 31st is valid)
    //println(h4validateCPR("100196-3224")) // True
    //println(h4validateCPR("320280-8175")) // False

        // Run Task 5 - FizzBuzz Numbers
    println(h5fizzBuzzNumbers())
}


/*
    1.
    A person is eligible to vote if his/her age is greater than or equal to 18.
    Define a method to find out if he/she is eligible to vote.
    Let the user input their age.
*/
fun h1voteCheck(): String {
    println("\nTask 1 -- Vote Check")
    print("Enter your age: ")
    val userAge: Int? = readlnOrNull()?.toIntOrNull();
    if (userAge == null) {
        return "Invalid number input"
    } else if (userAge >= 18) {
        return "You're eligible to vote!"
    } else {
        return "You're not eligible to vote yet!"
    }
}


/*
    2.
    Define two functions to print the maximum and the minimum number respectively,
    among three numbers.
*/
fun h2maxMinCheck(x: Int, y: Int, z: Int, func: (Int, Int, Int) -> Int): Int {
    println("\nTask 2 -- Max / Min number check")
    return func(x, y, z)
}
fun h2getMax(x: Int, y: Int, z: Int): Int {
    val numberList: List<Int> = listOf(x, y, z)
    var maxNumber: Int = numberList[0]
    for (number in numberList) {
        if (number > maxNumber) {
            maxNumber = number
        }
    }
    return maxNumber
}
fun h2getMin(x: Int, y: Int, z: Int): Int {
    val numberList: List<Int> = listOf(x, y, z)
    var minNumber: Int = numberList[0]
    for (number in numberList) {
        if (number < minNumber) {
            minNumber = number
        }
    }
    return minNumber
}


/*
    3.
    Write a Kotlin function named 'calculateAverage'
    that takes in a list of numbers and returns their average
*/
fun h3calculateAverage(listOfNumbers: List<Int>): Double {
    println("\nTask 3 -- Average Calculator")
    var sumOfNumbers: Double = 0.0
    for (number in listOfNumbers) {
        val numberAsDouble: Double = number.toDouble()
        sumOfNumbers += numberAsDouble
    }
    return sumOfNumbers / listOfNumbers.size
}

/*
    4.
    Write a number that returns if a user has input a valid CPR number.
    A valid CPR number has:
        - 10 Digits.
        - First 2 digits are not above 31
        - Middle 2 digits are not above 12
    The method returns true if the CPR number is valid, false if it is not.
*/
fun h4validateCPR(cpr: String): Boolean {
    println("\nTask 4 -- CPR Validator")
    return """^(0[1-9]|[12][0-9]|3[01])(0[1-9]|1[0-2])\d{2}-\d{4}$""".toRegex().matches(cpr)
}


/*
    5.
    Write a program that prints the numbers from 1 to 100.
    But for multiples of three, print "Fizz" instead of the number,
    and for multiples of five, print "Buzz".
    For numbers which are multiples of both three and five, print "FizzBuzz".
*/
fun h5fizzBuzzNumbers(): List<String> {
    println("\nTask 5 -- FizzBuzz Numbers")
    val listOfNumbers: MutableList<String> = mutableListOf()
    for (i in 1..100) {
        if (i % 3 == 0 && i % 5 == 0) {
            listOfNumbers.add("FizzBuzz")
        } else if (i % 3 == 0) {
            listOfNumbers.add("Fizz")
        } else if (i % 5 == 0) {
            listOfNumbers.add("Buzz")
        } else {
            listOfNumbers.add(i.toString())
        }
    }
    return listOfNumbers
}

/*
    6.
    Write a program that takes your full name as input and displays the
    abbreviations of the first and middle names except the last name which is
    displayed as it is.
    Eg. "Robert Brett Roser" becomes "R.B. Roser".
*/
fun h6nameToInitials() {
    println("\nTask 2 -- Max / Min number check")
    
}

/*
    7.
    Write a program that takes a numerical grade (0-100) as input and prints the
    corresponding American letter grade.
    Implement a function, 'calculateGrade', that takes an integer parameter
    representing the grade and returns a string representing the letter representing
    the letter grade according to the following scale:
        - 90-100: "A"
        - 80-89: "B"
        - 70-79: "C"
        - 60-69: "D"
        - Below 60: "F"
*/


/*
    8.
    Write a Kotlin function named filterWordsByLength that takes in a list of strings,
    and returns a a list containing only the words that have a length greater than
    or equal to the specified minimum length.
        - Use filter function and Lambda expressions
*/
