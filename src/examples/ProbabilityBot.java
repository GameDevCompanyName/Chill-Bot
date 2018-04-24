package examples;

import java.util.Random;
import gdcn.ChillChat.ChatBot;

public class ProbabilityBot extends ChatBot {

    @Override
    protected String getName() {
        return "Вероятностный бот";
    }

    @Override
    protected String getDescription() {
        return "Бот определяет вероятность события, о котором спрашивает пользователь.";
    }
    @Override
    protected void incomingUserMessage(String name, String text, String roomId) {
        if (text.contains("бот") && text.contains("вероятность")) {
            sendMessage(calculateProb(), roomId);
        }
    }
    //Бот на это никак не реагирует

    private String calculateProb(){
        Random rand = new Random();
        int n = rand.nextInt(100);
        return "Вероятность события будет" + n + "%";
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

        //При входе нового пользователя, бот скажет ему "привет",
        //отправив сообщение в комнату, в которой произошло событие

    }

    @Override
    protected void userKicked(String name, String reason, String roomId) {
        //Бот на это никак не реагирует
    }

}
