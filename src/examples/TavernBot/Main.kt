package examples.TavernBot
import examples.GooseBot

fun main(args: Array<String>) {
    val bot = TavernBot()
    for(elem in bot.getContent().getPhrases())
        println (elem)
    for(elem in bot.getContent().getDishes()){
        println(elem.getName())
        println(elem.getDescription())
    }


    val bot2 = GooseBot()
    println(bot2.getGooseList()[0])
    println("░ГУСЯ░▄▀▀▀▄░РАБОТЯГИ░░\n" +
    "▄███▀░◐░░░▌░░░░░░░\n" +
    "░░░░▌░░░░░▐░░░░░░░\n" +
    "░░░░▐░░░░░▐░░░░░░░\n" +
    "░░░░▌░░░░░▐▄▄░░░░░\n" +
    "░░░░▌░░░░▄▀▒▒▀▀▀▀▄\n" +
   "░░░▐░░░░▐▒▒▒▒▒▒▒▒▀▀▄\n" +
    "░░░▐░░░░▐▄▒▒▒▒▒▒▒▒▒▒▀▄\n" +
    "░░░░▀▄░░░░▀▄▒▒▒▒▒▒▒▒▒▒▀▄\n" +
    "░░░░░░▀▄▄▄▄▄█▄▄▄▄▄▄▄▄▄▄▄▀▄\n" +
    "░░░░░░░░░░░▌▌░▌▌░░░░░\n" +
    "░░░░░░░░░░░▌▌░▌▌░░░░░\n" +
    "░░░░░░░░░▄▄▌▌▄▌▌░░░░░\n")
}
