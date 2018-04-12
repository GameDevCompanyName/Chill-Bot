package examples.TavernBot

import java.io.File
import java.io.InputStream
import java.util.TreeSet

class Content {
    private var phrases = this.loadStrings("resources/bots/TavernBot/phrases")
    private var stories = this.loadStrings("resources/bots/TavernBot/stories")
    private var dishes = this.loadDishes("resources/bots/TavernBot/disheslist")

    //Loading the list of dishes into TreeSet
    private fun loadDishes(adress: String): TreeSet<Dish> {
        val inputstream: InputStream = File(adress).inputStream()
        val dishesSet = TreeSet<Dish>()
        val input = inputstream.bufferedReader()
        var line = input.readLine()

        while (line != null) {
            val dish = Dish("", "", "")
            while (!line.matches(Regex("^\\*\\*\\*$"))) {
                if (line.matches(Regex("^name = \\w+$")))
                    dish.setName(line)
                if (line.matches(Regex("^describtion = \\w+$")))
                    dish.setDescription(line)
                if (line.matches(Regex("^photo = \\w+$")))
                    dish.setPhoto(line)
            }
            dishesSet.add(dish)
            line = input.readLine()
        }
        return dishesSet
    }

    //Loading the list of phrases or stories into mutableList
    private fun loadStrings(adress: String): List<String> {
        val inputstream: InputStream = File(adress).inputStream()
        val stringList = mutableListOf<String>()

        val input = inputstream.bufferedReader()
        var line = input.readLine()
        while (line != null) {
            if (line == "***") continue
            else stringList.add(line)
            line = input.readLine()
        }
        return stringList
    }

    fun getPhrases(): List<String> {
        return phrases
    }

    fun getStories(): List<String> {
        return stories
    }

    fun getDishes(): TreeSet<Dish> {
        return dishes
    }

    //Refreshing the data in all collections
    fun refresh(){
        phrases = this.loadStrings("resources/bots/TavernBot/phrases")
        stories = this.loadStrings("resources/bots/TavernBot/stories")
        dishes = this.loadDishes("resources/bots/TavernBot/disheslist")
    }
}