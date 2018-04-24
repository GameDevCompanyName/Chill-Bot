package examples;

import gdcn.ChillChat.ChatBot;

public class FSBbot extends ChatBot {

    @Override
    protected String getName() {
        return "Обычный пользователь, абсолютно ничем не отличается от обычных людей.";
    }

    @Override
    protected String getDescription() {
        return "Прошёл тест Тьюринга.";
    }

    @Override
    protected void incomingUserMessage(String name, String text, String roomId) {
        if (text.contains("путин") || text.contains("путен"))
            sendMessage("кхм-кхм", roomId);
    }
    //Бот на это никак не реагирует

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
        if (name.equals("Igorlo"))
            sendMessage("А можно ваши ключики?", roomId);
    }

    @Override
    protected void userKicked(String name, String reason, String roomId) {
        //Бот на это никак не реагирует
    }

}