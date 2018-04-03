package gdcn.ChillChat;

public abstract class ChatBot {

    public ChatBot(){
        BotMessages.setBot(this);
        BotMessages.start();
    }

    protected abstract String getName();

    protected abstract String getDescription();

    /**
     * Данный блок методов содержит методы для отправки сообщений разных
     * типов серверу. Данные методы будут просто вызывать внешний класс
     * BotMessages, которым займётся Игорь.
     */

    protected void sendMessage(String text, String roomId){
        BotMessages.sendMessage(text, roomId);
    }

    //TODO PATCH #2
    //void sendAction(String action, String roomId);

    /**
     * Следующий блок методов содержит методы, которые вызываются при
     * получении сообщения от сервера. Они будут вызываться внешним
     * классом, ожидающим сообщения от сервера. Вам не нужно их вызывать,
     * нужно лишь обрабатывать их вызовы.
     *
     * roomId - идентификатор комнаты, в которой произошло данное событие.
     * Подразумевается, что в будущем один запущенный бот будет обслуживать
     * две разные комнаты, храня необходимые для работы данные для каждой
     * из подключенных комнат. Пока что в roomId всегда будет приходить
     * идентификатор главной комнаты.
     */

    /**
     * Сообщение от пользователя
     */
    protected abstract void incomingUserMessage(String name, String text, String roomId);

    /**
     * Сообщение от сервера
     */
    protected abstract void incomingServerMessage(String text, String roomId);

    /**
     * Юзер вышел из комнаты
     */
    protected abstract void userDisconnected(String name, String reason, String roomId);

    /**
     * Юзер подключился к комнате
     */
    protected abstract void userConnected(String name, String roomId);

    /**
     * Юзера кикнули по причине [reason]
     */
    protected abstract void userKicked(String name, String reason, String roomId);


    //TODO PATCH #2

//    abstract void userAction(String name, String action, String roomId);

//    abstract void serverEvent(String event, String roomId);

//    abstract void userColor(String user, String color);

}
