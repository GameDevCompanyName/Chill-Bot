package examples.TavernBot

import gdcn.ChillChat.ChatBot

class TavernBot : ChatBot() {

        private val botName: String = "Трактирщик"
        private val description: String = "Играет роль гостеприимного трактирщика"

        override fun getName(): String { return botName }

        override fun getDescription(): String { return description }

        override fun incomingUserMessage(name: String?, text: String?, roomId: String?) { TODO() }

        override fun incomingServerMessage(text: String?, roomId: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun userDisconnected(name: String?, reason: String?, roomId: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun userConnected(name: String?, roomId: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun userKicked(name: String?, reason: String?, roomId: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }


}