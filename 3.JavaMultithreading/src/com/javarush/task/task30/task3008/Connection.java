package com.javarush.task.task30.task3008;

import java.io.*;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by Roman on 05.04.2017.
 */
public class Connection implements Closeable {
    private final Socket socket;

    private final ObjectInputStream in;

    private final ObjectOutputStream out;

    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
    }

    public void send(Message message) throws IOException {
        synchronized (out) {
            out.writeObject(message);
            out.flush();
        }
    }

    public Message receive() throws IOException, ClassNotFoundException {
        Message message;
        synchronized (in) {
            message =  (Message) in.readObject();
            return message;
        }
    }

    public SocketAddress getRemoteSocketAddress() {
        return socket.getRemoteSocketAddress();
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
        socket.close();
    }
}
