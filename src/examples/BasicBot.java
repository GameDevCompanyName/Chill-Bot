package examples;

import gdcn.ChillChat.ChatBot;

public class BasicBot extends ChatBot {

    private final String botName = "Бот-Здрователь";

    private final String description =
            "Бот здоровается со всеми подключающимися юзерами.";



    @Override
    protected String getName() {
        return botName;
    }

    @Override
    protected String getDescription() {
        return description;
    }

    @Override
    protected void incomingUserMessage(String name, String text, String roomId) {
        //Бот на это никак не реагирует
    }

    @Override
    protected void incomingServerMessage(String text, String roomId) {
        //Бот на это никак не реагирует
    }

    @Override
    protected void userDisconnected(String name, String reason, String roomId) {
        //Бот на это никак не реагирует
    }

    @Override
    protected void userConnected(String name, String roomId) {

        String message = "Привет, " + name + "!";
        sendMessage(message, roomId);

        //При входе нового пользователя, бот скажет ему "привет",
        //отправив сообщение в комнату, в которой произошло событие

    }

    @Override
    protected void userKicked(String name, String reason, String roomId) {
        //Бот на это никак не реагирует
    }

}
