package com.serhiihonchar.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 3000);
        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[200];
        int count = inputStream.read(buffer);
        String message = new String(buffer, 0, count);
        System.out.println(message);
    }
}