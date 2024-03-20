package com.example.kotlin_web_scraping

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.firefox.FirefoxDriver

fun main() {
    //top30posts()

    titlePointsComments()
}

fun top30posts() {
    println("Getting top 30 posts on Hackernews")
    val driver = FirefoxDriver()
    driver.get("https://news.ycombinator.com/")

    val top30: MutableList<WebElement> = driver.findElements(By.xpath("//*[@class=\"title\"]"))
    for (post in top30) {
        println(post.text)
    }

    driver.quit()
}

fun titlePointsComments() {
    println("Getting list of posts sorted by comments")

    val driver = FirefoxDriver()
    driver.get("https://news.ycombinator.com/")

    val scrapedPostTitles: MutableList<WebElement> = driver.findElements(By.xpath("//*[@class=\"titleline\"]"))
    val scrapedPostPoints: MutableList<WebElement> = driver.findElements(By.xpath("//*[@class=\"subline\"]/span[1]"))
    val scrapedPostComments: MutableList<WebElement> = driver.findElements(By.xpath("//*[@class=\"subline\"]/a[3]"))

    val posts: ArrayList<HackernewsPost> = arrayListOf()

    for (i in scrapedPostTitles.indices) {
        val splitPostComments: List<String> = (scrapedPostComments[i].text).split(" ")
        val postCommentNumber: Int = splitPostComments[0].toInt()

        val filterPostPoints: String = scrapedPostPoints[i].text.filter { it.isDigit() }

        val splitPostPoints: List<String> = (scrapedPostPoints[i].text).split(" ")
        var postPointNumber: Int? = splitPostPoints[0].toIntOrNull()
        if (postPointNumber == null) {
            postPointNumber = 0
        }

        val fullPostData: HackernewsPost = HackernewsPost(scrapedPostTitles[i].text, postPointNumber, postCommentNumber)
        posts.add(fullPostData)
    }

    for (post in posts) {
        println(post)
    }



    driver.quit()
}

data class HackernewsPost(
    val title: String,
    val points: Int,
    val numberOfComments: Int): Comparable<HackernewsPost> {


        override fun compareTo(other: HackernewsPost): Int {
            return if (this.numberOfComments > other.numberOfComments) {
                1
            } else if (this.numberOfComments < other.numberOfComments) {
                -1
            } else {
                0
            }
        }
}
