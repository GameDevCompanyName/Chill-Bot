package examples.TavernBot

import gdcn.ChillChat.ChatBot
import java.util.*
import java.util.regex.Pattern.matches

class TavernBot : ChatBot() {

    private val botName: String = "Трактирщик"
    private val description: String = "Играет роль гостеприимного трактирщика"
    private val content = Content()
    private val phrasesSize = content.getPhrases().size
    private val storiesSize = content.getStories().size
    private val dishesSize = content.getDishes().size
    private var random = Random()

    private fun findDishes(): String {
        val message = content.getPhrases().get(random.nextInt(phrasesSize + 1)) +
                "1. ${content.getDishes().get(random.nextInt(dishesSize + 1))} " +
                "2. ${content.getDishes().get(random.nextInt(dishesSize + 1))} "
        "3. ${content.getDishes().get(random.nextInt(dishesSize + 1))}"
        return message
    }

    private fun cook() {
        //TODO
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
                text == "Трактирщик, привет" -> message = "И тебе привет, путник"
                text == "Трактирщик, что сегодня на кухне?" -> message = findDishes()
                text.matches(Regex("^Трактирщик,\\s*\\d$")) -> message = "Пару минут и все будет готово"
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