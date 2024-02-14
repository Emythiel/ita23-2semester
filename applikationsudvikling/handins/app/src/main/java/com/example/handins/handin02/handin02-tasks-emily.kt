package com.example.handins.handin02

fun main() {
    // Task 1 -- Employee Salary
    h1employeeSalaries()

    // Task 2 -- Computer, Laptop, SmartPhone
    //h2computer()

    // Task 3 -- Product Category Identification
    //h3productCategory()

    // Task 4 -- Shapes and Perimeter/Area Calculation
    //h4shapes()
}


/*
    1)
    Create a class called employee that includes three peices
    of information as instance variables.
        - A first name
        - A last name
        - A monthly salary
    Class should have a constructor that inits the three variables.
    If the monthly salary is not positive, set it to 0.0.
    Create two employee objects and display each object's yearly salary.
    Then give each employee a 10% raise and display each
    employee's yearly salary again.
*/
fun h1employeeSalaries() {
    println("\nTask 1 -- Employee Salaries")
    val johnDoe = Employee("John", "Doe", 1200.00)
    val janeFoster = Employee("Jane", "Foster", 1600.50)

    johnDoe.printYearlySalary()
    janeFoster.printYearlySalary()

    johnDoe.adjustSalaryPercent(-50)
    janeFoster.adjustSalaryPercent(25)

    johnDoe.printYearlySalary()
    janeFoster.printYearlySalary()
}
class Employee(val firstname: String, val lastname: String, monthlySalary: Double) {
    private var _monthlySalary: Double = monthlySalary
    var monthlySalary: Double
        get() {
            return _monthlySalary
        }
        set(value: Double) {
            if (value >= 0.0) {
                _monthlySalary = value
            } else {
                _monthlySalary = 0.0
                println("ERROR: Salary cannot be negative. Setting Salary to 0 instead.")
            }
        }

    fun adjustSalaryPercent(percent: Int) {
        _monthlySalary *= ((percent.toDouble() / 100) + 1)
    }

    fun printYearlySalary() {
        println("${this.firstname} ${this.lastname}'s yearly salary is: ${_monthlySalary * 12}")
    }
}

/*
    2)
    Create a new class called Computer.
    Two additional classes will be needed: Laptop and SmartPhone.
        1. For a parent class, add 3 properties, 2 methods and
           a constructor.
        2. For a child class, add at least 1 additional property
           and 1 additional method.
    In the main method, create a Laptop and SmartPhone.
*/
fun h2computer() {
    println("\nTask 2 -- Computers, Laptops, and Smartphones")

}

/*
    3)
    Create a base class Product with attributes like name, price, and
    quantity, as well as a function identifyProductCategory.
    Subclass it to create specific product types like Shoe,
    T-shirt, and Book. Override the function such taht:
        - The shoe outputs "I am a shoe".
        - The T-shirt outputs "I am a T-shirt".
        - The book outputs "I am a book".
*/
fun h3productCategory() {
    println("\nTask 3 -- Products and Product Category Identification")

}

/*
    4)
    Create 3 classes, Circle, Rectangle, and Triangle, with parent
    class Shape.
        - Every shape has two attributes:
            - color
            - isTransparent
        - Every class has private attributes to calculate perimeter
          and area for each shape.
            - E.g. Rectangle has attributes: height, width, color &
              isTransparent.
                - The attributes are set in the constructor
        - The 3 classes overrides the following abstract
          methods from their parent class:
            - calculatePerimeter
            - calculateArea
        - The functions will return the perimeter or area of the shape.
*/
fun h4shapes() {
    println("\nTask 4 -- Shapes and Area/Perimeter Calculation")

}
