package com.serhiihonchar.test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);
        while (true) {
            Socket socket = serverSocket.accept();
            String message = "Hello man, current time " + LocalDateTime.now();
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(message.getBytes());
        }
    }
}

