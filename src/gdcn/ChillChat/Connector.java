package gdcn.ChillChat;

public class Connector extends Thread{

    private ChatBot bot;

    public Connector(ChatBot bot) {
        this.bot = bot;
    }

    @Override
    public void start() {
        //создание соединения
        //TODO
    }

    /**
     * В этом классе я позже пропишу создание соединения с сервером
     * и тому подобное.
     */

}
