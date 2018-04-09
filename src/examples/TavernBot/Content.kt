package examples.TavernBot

import java.io.File
import java.io.InputStream
import java.util.SortedSet

class Content{
    private val phrases = this.loadStrings("resources/bots/TavernBot/phrases")
    private val stories = this.loadStrings("resources/bots/TavernBot/stories")
    private val dishes: SortedSet<Dish> = this.loadDishes("resources/bots/TavernBot/disheslist")

    private fun loadDishes(adress: String): SortedSet<Dish> { TODO() }

    private fun loadStrings (adress: String): List<String>{
        val inputstream: InputStream = File(adress).inputStream()
        val stringList = mutableListOf<String>()

        val input = inputstream.bufferedReader()
        var line = input.readLine()
        while (line != null) {
            if (input.readLine() == "***") continue
            else stringList.add(line)
            line = input.readLine()
        }
        return stringList
    }



}