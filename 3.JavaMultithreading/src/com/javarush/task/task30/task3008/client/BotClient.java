package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Roman on 11.04.2017.
 */
public class BotClient extends Client {

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    public class BotSocketThread extends Client.SocketThread {

        @Override
        public void run() {
            super.run();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);

            if (message.contains(": ")) {

                String[] nameTextMessage = message.split(": ");
                String name = nameTextMessage[0];
                String text = nameTextMessage[1];

                SimpleDateFormat dateFormat = null;

                if (text.equals("дата")) {

                    dateFormat = new SimpleDateFormat("d.MM.YYYY");
                    sendTextMessage("Информация для " + name + ": " + dateFormat);
                } else if (text.equals("день")) {
                    dateFormat = new SimpleDateFormat("d");
                } else if (text.equals("месяц")) {
                    dateFormat = new SimpleDateFormat("MMMM");
                } else if (text.equals("год")) {
                    dateFormat = new SimpleDateFormat("YYYY");
                } else if (text.equals("время")) {
                    dateFormat = new SimpleDateFormat("H:mm:ss");
                } else if (text.equals("час")) {
                    dateFormat = new SimpleDateFormat("H");
                } else if (text.equals("минуты")) {
                    dateFormat = new SimpleDateFormat("m");
                } else if (text.equals("секунды")) {
                    dateFormat = new SimpleDateFormat("s");
                } else {
                    ConsoleHelper.writeMessage("Incorrect bot command.");
                }

                if (dateFormat != null) {
                    sendTextMessage("Информация для " + name + ": " + dateFormat.format(Calendar.getInstance().getTime()));
                }
            }

        }

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }
    }

    @Override
    public void run() {
        super.run();
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int) (100 * Math.random());
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        super.shouldSendTextFromConsole();
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        super.getSocketThread();
        return new BotSocketThread();
    }


}
