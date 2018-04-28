package examples.TavernBot

import gdcn.ChillChat.BotMessages
import gdcn.ChillChat.ChatBot
import java.util.*

class TavernBot : ChatBot() {

    private val botName: String = "Трактирщик"
    private val description: String = "Играет роль гостеприимного трактирщика"
    private val content = Content()
    private val phrasesSize = content.getPhrases().size
    private val storiesSize = content.getStories().size
    private val dishesSize = content.getDishes().size
    private var random = Random()
    private var bufferDish = arrayOf<Dish>()
    private var number: Int = 0

    fun TavernBot() {
        BotMessages.setBot(this)
        BotMessages.start()
    }

    //Generation of offered dishes
    private fun findDishes(): String {
        bufferDish[0] = content.getDishes()[random.nextInt(dishesSize + 1)]
        bufferDish[1] = content.getDishes()[random.nextInt(dishesSize + 1)]
        bufferDish[2] = content.getDishes()[random.nextInt(dishesSize + 1)]
        val message = "Выбирай мудро " + "1. ${bufferDish[0]} " + "2. ${bufferDish[1]} "+ "3. ${bufferDish[2]}"
        return message
    }

    private fun cook(number: Int): String {
        val dish = bufferDish[number - 1]
        return "Прошу, " + dish.getDescription() //+ dish.getPhoto()
    }

    public fun tellStory(): List<String> {
        /*val story = content.getStories()[random.nextInt(storiesSize )]
        val storyList = mutableListOf<String>()
        var oneMessageString = ""

        for (i in 0..story.length) {
            if (i < story.length-150 || i%150 == 0) {
                for (j in i..(i + 150)) {
                    oneMessageString += story[j]
                }
                storyList.add(oneMessageString)
                oneMessageString = ""
            }
            else if (i >= story.length){
                for (j in i..story.length) {
                    oneMessageString += story[j]
                }
                storyList.add(oneMessageString)
                oneMessageString = ""
            }
        }
        return storyList*/
        TODO()
    }

    fun getContent(): Content{
        return content
    }

    override fun getName(): String {
        return botName
    }

    override fun getDescription(): String {
        return description
    }

    override fun incomingUserMessage(name: String?, text: String?, roomId: String?) {
        var message = String()
        if (text != null) {
            when {
                text == "Трактирщик, привет" ->
                    message = "И тебе привет, путник"
                text == "Трактирщик, обнови меню" -> {
                    content.refresh()
                    message = "Меню обновлено"
                }
                text == "Трактирщик, что сегодня на кухне?" ->
                    message = findDishes()
                text == "Трактирщик, расскажи историю" -> tellStory()
                text.matches(Regex("^Трактирщик,\\s*\\d$")) -> {
                    number = text.split(Regex(" "))[1].toInt()
                    message = content.getPhrases()[random.nextInt(phrasesSize + 1)]
                    sendMessage(message, roomId)
                    message = cook(number)
                }
            }
        }
        sendMessage(message, roomId)
    }

    override fun incomingServerMessage(text: String?, roomId: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun userDisconnected(name: String?, reason: String?, roomId: String?) {
        val message = "До скорой встречи, $name!"
        sendMessage(message, roomId)
    }

    override fun userConnected(name: String?, roomId: String?) {
        val message = "Добро пожаловать в таверну, $name! Мы всегда рады видеть новых гостей"
        sendMessage(message, roomId)
    }

    override fun userKicked(name: String?, reason: String?, roomId: String?) {
        val message = "Ой, как невежливо, $name! Впредь будь добрее с нашими друзьями"
        sendMessage(message, roomId)
    }

}