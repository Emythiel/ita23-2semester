package com.example.handins.handin03

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun main() {
    // Task 1
    //articlePrint()

    // Task 2
    //fastFoods()

    // Task 3
    //carDriving()

    // Task 4
    //redditPosting()

    // Task 5
    //redditFrontPaging()

    // Task 6
    wordFrequency()
}

/*
 * 1)
 * Write a class: Article
 *   - Article has an author and title
 * Create 5 articles, add them into an ArrayList and print them by overriding .toString()
 */

fun articlePrint() {
    println("Task 1 - Articles")
    val article1: Article = Article("Johnny", "How to make a salad")
    val article2: Article = Article("Buzzfeed", "Top 10 top 10 lists, you won't believe top 4")
    val article3: Article = Article("FeedBuzz", "top 1 top 10 top 5 articles")
    val article4: Article = Article("Cons P. Iracy", "New science: Earth is a triangle")
    val article5: Article = Article("Dennis", "New phone, who dis")

    val listOfArticles: List<Article> = arrayListOf(article1, article2, article3, article4, article5)
    println(listOfArticles)
}
class Article(val author: String, val title: String) {
    override fun toString(): String {
        return "Author: $author, Title: $title"
    }
}

/*
 * 2)
 * Create an interface: FastFood (with appropriate methods)
 * Create Sandwich class, Pizza class and another class, that implements FastFood interface
 * Add some different FastFood objects to an array.
 * Iterate through the array and use some of the methods you have created above
 */
fun fastFoods() {
    println("Task 2 - Fast Food")
    val baconSandwich = Sandwich("White loaf", listOf("Bacon", "Cheese"), true)
    val pineapplePizza = Pizza("large", listOf("Pineapple, Chicken"))
    val bucketOfNuggets = Nuggets(18)

    println(baconSandwich.getDescription())
    println(baconSandwich.getPrice())

    println(pineapplePizza.getDescription())
    println(pineapplePizza.getPrice())

    println(bucketOfNuggets.getDescription())
    println(bucketOfNuggets.getPrice())
}
interface FastFood {
    fun getDescription(): String
    fun getPrice(): Double
}
class Sandwich(val bread: String, val ingredients: List<String>, val toasted: Boolean): FastFood {
    override fun getDescription(): String {
        val description: String = "Sandwich, with $ingredients, in between two slices of $bread"
        return if (toasted) {
            "A nice toasted $description"
        } else {
            "A nice cold $description"
        }
    }
    override fun getPrice(): Double {
        return (10 + (ingredients.size * 2)).toDouble()
    }
}
class Pizza(val size: String, val toppings: List<String>): FastFood {
    override fun getDescription(): String {
        return "A nice $size pizza with $toppings on top"
    }
    override fun getPrice(): Double {
        return when (size) {
            "large" -> (18 + (toppings.size * 2.5)).toDouble()
            "medium" -> (15 + (toppings.size * 2)).toDouble()
            "small" -> (12 + (toppings.size * 1.8)).toDouble()
            else -> {
                -1.0
            }
        }
    }
}
class Nuggets(val amount: Int): FastFood {
    override fun getDescription(): String {
        return "A bucket of $amount chicken nuggets"
    }
    override fun getPrice(): Double {
        return (1.4 * amount).toDouble()
    }
}

/*
 * 3)
 * Create a class that implements the following interface:
 * interface Vehicle {
 *   changeGear(int a)
 *   speedUp(int a)
 *   applyBrakes(int a)
 * }
 * Create two objects using the class created
 */
fun carDriving() {
    println("Task 3 - Vehicles")
    val valve = Truck("Volvo")
    val superTruck = Truck("Super Truck Brand")

    valve.changeGear(3)
    valve.speedUp()
    println(valve.currentGear)
    println(valve.currentSpeed)
    valve.speedUp()
    valve.speedUp()
    println(valve.currentSpeed)
    valve.applyBrakes()
    println(valve.currentSpeed)

    for (i in 1..12) {
        superTruck.speedUp()
    }
    println(superTruck.currentSpeed)
}
interface Vehicle {
    fun changeGear(gear: Int)
    fun speedUp()
    fun applyBrakes()
}
class Truck(val brand: String, var currentSpeed: Int = 0, var currentGear: Int = 0): Vehicle {
    override fun changeGear(gear: Int) {
        currentGear = gear
    }
    override fun speedUp() {
        currentSpeed += 10
        if (currentSpeed >= 100) {
            println("Speed limit reached, staying at 100")
            currentSpeed = 100
        }
    }
    override fun applyBrakes() {
        currentSpeed -= 10
        if (currentSpeed <= 0) {
            println("Stopped, cannot brake anymore")
            currentSpeed = 0
        }
    }
}

/*
 * 4)
 * Write class: RedditPost
 * RedditPost has:
 *   - Date which it has been posted
 *   - An author
 *   - Balance of upvotes / downvotes
 *   - Title
 * When a new instance of RedditPost is instantiated:
 *   - Current date will be generated
 *   - Balance of upvotes and downvotes start at 1
 *   - Title and author has to be provided by the constructor
 * Ensure all attributes are private, but accessible by getters and setters
 * Implement functionality such that reddit posts can be sorted by upvotes/downvotes
 */
fun redditPosting() {
    println("Task 4 - Reddit Posting")
    val muskPost = RedditPost("Elon Musk", "Why I'm good at running Twitter and why you're all wrong")
    val mobaPost = RedditPost("ITA", "Discussing why Dota is clearly better than LoL")
    val dogPost = RedditPost("Dog", "Look at my neat dog")
    val catPost = RedditPost("Cat", "Cutie Cat")
    muskPost.downvote()
    muskPost.downvote()
    muskPost.downvote()
    println(muskPost.votes)
    mobaPost.upvote()
    mobaPost.upvote()
    println(mobaPost.votes)
    dogPost.upvote()
    dogPost.upvote()
    dogPost.upvote()
    dogPost.upvote()
    dogPost.upvote()
    println(dogPost.votes)
    catPost.upvote()

    println(catPost.votes)

    // Sort posts by up/down-votes
    val listOfPosts: List<RedditPost> = listOf(muskPost, mobaPost, dogPost, catPost)
    println(listOfPosts.sortedDescending())
}
class RedditPost(val author: String, val title: String): Comparable<RedditPost> {
    var votes: Int
    val date: String

    private fun setDate(): String {
        val dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm")
        return LocalDateTime.now().format(dateFormatter)
    }
    init {
        date = setDate()
        votes = 1
    }

    fun upvote() {
        votes += 1
    }
    fun downvote() {
        votes -= 1
    }

    override fun compareTo(other: RedditPost): Int {
        return if (this.votes > other.votes) {
            1
        } else if (this.votes < other.votes) {
            -1
        } else {
            0
        }
    }
    override fun toString(): String {
        return title
    }
}


/*
 * 4.5)
 * Write class: RedditFrontPage
 * RedditFrontPage has:
 *   - List of all RedditPosts
 *   - Method to delete RedditPost from the list, by index method
 */
fun redditFrontPaging() {
    println("Task 4.5 - Reddit Front Page")
    val muskPost = RedditPost("Elon Musk", "Why I'm good at running Twitter and why you're all wrong")
    val mobaPost = RedditPost("ITA", "Discussing why Dota is clearly better than LoL")
    val dogPost = RedditPost("Dog", "Look at my neat dog")
    val catPost = RedditPost("Cat", "Cutie Cat")
    val redditFrontPage = RedditFrontPage(mutableListOf(muskPost, mobaPost, dogPost, catPost))
    println(redditFrontPage.frontPage)
    redditFrontPage.deletePost(0)
    println(redditFrontPage.frontPage)
}
class RedditFrontPage(val frontPage: MutableList<RedditPost>) {
    fun deletePost(index: Int) {
        frontPage.removeAt(index)
    }
}


/*
 * 5)
 * Write a program that takes a list of words as input and prints frequency of each word.
 *   - Hint: Use a MutableMap
 */
fun wordFrequency() {
    println("Task 5 - Word Frequency")
    val words = listOf("apple", "banana", "apple", "orange", "banana", "apple",
                       "orange", "banana", "apple","banana", "apple", "orange",
                       "banana","banana", "apple", "orange", "apple", "orange", "banana")
    val wordFrequencyMap = mutableMapOf<String, Int>()

    for (word in words) {
        val currentCount = wordFrequencyMap[word] ?: 0
        wordFrequencyMap[word] = currentCount + 1
    }

    // Print the word frequencies
    for ((word, count) in wordFrequencyMap) {
        println("$word: $count")
    }
}
