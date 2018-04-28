package examples

import gdcn.ChillChat.BotMessages
import gdcn.ChillChat.ChatBot
import java.io.File
import java.io.InputStream
import java.util.*

class PapitchBot : ChatBot() {
    private val botName: String = "Сборище гусей"
    private val description: String = "Запускаем гуся, работяги"
    private val random = Random()

    fun GooseBot() {
        BotMessages.setBot(this)
        BotMessages.start()
    }

    fun getPapitchPhrases(): List<String> {
        val inputstream: InputStream = File("resources/bots/PapitchBot/phrases").inputStream()
        val stringList = mutableListOf<String>()
        val input = inputstream.bufferedReader()
        var line = input.readLine()

        while (line != null) {
            if (line == "***") {
                line = input.readLine()
                continue
            } else stringList.add(line)
            line = input.readLine()
        }
        return stringList
    }

    override fun getName(): String {
        return botName
    }

    override fun getDescription(): String {
        return description
    }

    override fun incomingUserMessage(name: String?, text: String?, roomId: String?) {
        var message = "ошибка"
        if (text != null) {
            val phrases = getPapitchPhrases()
            if (text.contains("папич"))
                message = phrases[random.nextInt(phrases.size)]
        }
        sendMessage(message, roomId)
    }

    override fun incomingServerMessage(text: String?, roomId: String?) {}

    override fun userDisconnected(name: String?, reason: String?, roomId: String?) {}

    override fun userConnected(name: String?, roomId: String?) {}

    override fun userKicked(name: String?, reason: String?, roomId: String?) {
        sendMessage("СОСАТЬ + ЛЕЖАТЬ", roomId)
    }


}