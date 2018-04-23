package examples.TavernBot

fun main(args: Array<String>) {
    val bot = TavernBot()
    for(elem in bot.getContent().getPhrases())
        println (elem)
    for(elem in bot.getContent().getDishes()){
        println(elem.getName())
        println(elem.getDescription())
    }

}
