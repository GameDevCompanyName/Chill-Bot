package gdcn.ChillChat;

public interface ChatBot {

    /**
     * Данный блок методов содержит методы для отправки сообщений разных
     * типов серверу. Данные методы будут просто вызывать внешний класс
     * BotMessages, которым займётся Игорь.
     */

    void sendMessage(String text, String roomId);

    //TODO PATCH #2
    void sendAction(String action, String roomId);


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
    void incomingUserMessage(String name, String text, String roomId);

    /**
     * Сообщение от сервера
     */
    void incomingServerMessage(String text, String roomId);

    /**
     * Юзер вышел из комнаты
     */
    void userDisconnected(String name, String reason, String roomId);

    /**
     * Юзер подключился к комнате
     */
    void userConnected(String name, String roomId);

    /**
     * Юзера кикнули по причине [reason]
     */
    void userKicked(String name, String reason, String roomId);



    //TODO PATCH #2
    void userAction(String name, String action, String roomId);

    //TODO PATCH #2
    void serverEvent(String event, String roomId);

    //TODO PATCH #2
    void userColor(String user, String color);

}
