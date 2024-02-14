package com.example.handins.handin02

fun main() {
    // Task 1 -- Employee Salary
    //h1employeeSalaries()

    // Task 2 -- Computer, Laptop, SmartPhone
    //h2computer()

    // Task 3 -- Product Category Identification
    h3productCategory()

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

    johnDoe.adjustSalaryPercent(10)
    janeFoster.adjustSalaryPercent(10)

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
    val myCoolLaptop = Laptop("Xtreme Super Top", "Red", 1000, 15.6)
    val myFastPhone = SmartPhone("UltraPhone", "Silver", 512, 80)

    myCoolLaptop.getPowerStatus()
    myCoolLaptop.togglePower()
    myCoolLaptop.toggleCharging()
    myCoolLaptop.printStorageLeft()
    myCoolLaptop.changeStorage = -400
    println("")
    myFastPhone.getPowerStatus()
    myFastPhone.togglePower()
    myFastPhone.batteryLeft = -90
    myFastPhone.batteryLeft = 60
}
open class Computer(val productName: String, val color: String, changeStorage: Int) {
    // Power on/off
    // Starts powered off
    var isPoweredOn: Boolean = false;
    fun togglePower() {
        this.isPoweredOn = !this.isPoweredOn
        if (isPoweredOn) {
            println("Turning ${this.productName} ON")
        } else {
            println("Turning ${this.productName} OFF")
        }
    }
    fun getPowerStatus() {
        if (isPoweredOn) {
            println("${this.productName} is currently powered ON")
        } else {
            println("${this.productName} is currently powered OFF")
        }
    }

    // Storage Amount
    private var _changeStorage = changeStorage
    var changeStorage: Int
        get() {
            return _changeStorage
        }
        set(value: Int) {
            if ((_changeStorage + value) < 0) {
                println("Oops, you'll be out of space! Cannot proceed with storage change")
            } else {
                _changeStorage += value
                println("Changed storage amount by ${value}GB. You now have ${_changeStorage}GB free.")
            }
        }
    // Print storage amount
    fun printStorageLeft() {
        println("You have ${this._changeStorage}GB free on this device.")
    }
}
class Laptop(productName: String, color: String, changeStorage: Int, val screenSize: Double): Computer(productName, color, changeStorage) {
    var isCharging: Boolean = false;
    fun toggleCharging() {
        this.isCharging = !this.isCharging
        if (isCharging) {
            println("Laptop is currently charging.")
        } else {
            println("Laptop is not being charged at the moment.")
        }
    }
}
class SmartPhone(productName: String, color: String, storageFree: Int, batteryLeft: Int): Computer(productName, color, storageFree) {
    private var _batteryLeft: Int = batteryLeft
    var batteryLeft: Int
        get() {
            return _batteryLeft
        }
        set(value: Int) {
            val currentCharge = _batteryLeft
            val newCharge = _batteryLeft + value
            if (newCharge < 1) {
                _batteryLeft = 0
                println("Oof, seems I'm out of battery juice. Goodnight.")
            } else if (newCharge > 100) {
                _batteryLeft = 100
                println("You can't go over 100% battery charge, or it'll blow up! I stopped it at 100% to save you :)")
            } else {
                _batteryLeft = newCharge
                if (newCharge > currentCharge) {
                    println("Finished charging! You now have ${newCharge}% left")
                } else {
                    println("You drained the battery a bit. There's now ${newCharge}% left.")
                }
            }
        }
}

/*
    3)
    Create a base class Product with attributes like name, price, and
    quantity, as well as a function identifyProductCategory.
    Subclass it to create specific product types like Shoe,
    T-shirt, and Book. Override the function such that:
        - The shoe outputs "I am a shoe"
        - The T-shirt outputs "I am a T-shirt".
        - The book outputs "I am a book".
*/
fun h3productCategory() {
    println("\nTask 3 -- Products and Product Category Identification")
    val coolShoe = Shoe("Super Jordans", 99.99, 2)
    val awesomeTshirt = Tshirt("Hello Kitty Shirt", 16.95, 87)
    val lotrBook = Book("Lord of The Rings", 29.05, 18)

    coolShoe.identifyProductCategory()
    awesomeTshirt.identifyProductCategory()
    lotrBook.identifyProductCategory()
}
open class Product(val name: String, var price: Double, var quantity: Int) {

    open fun identifyProductCategory() {
        println("I am a cool product!")
    }
}
class Shoe(name: String, price: Double, quantity: Int): Product(name, price, quantity) {
    override fun identifyProductCategory() {
        println("I am a shoe!")
    }
}
class Tshirt(name: String, price: Double, quantity: Int): Product(name, price, quantity) {
    override fun identifyProductCategory() {
        println("I am a T-Shirt!")
    }
}
class Book(name: String, price: Double, quantity: Int): Product(name, price, quantity) {
    override fun identifyProductCategory() {
        println("I am a nice book!")
    }
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
