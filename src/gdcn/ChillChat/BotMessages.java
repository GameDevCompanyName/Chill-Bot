package gdcn.ChillChat;

public class BotMessages {

    static ChatBot bot;
    static Connector connector;

    public static void setBot(ChatBot bot) {
        BotMessages.bot = bot;
    }

    public static void sendMessage(String text, String roomId){
        //TODO
    }

    public static void start() {
        connector = new Connector(bot);
        connector.start();
    }

    /**
     * Через этот метод
     */

}
