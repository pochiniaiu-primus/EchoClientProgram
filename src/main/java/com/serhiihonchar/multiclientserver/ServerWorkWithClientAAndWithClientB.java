package com.serhiihonchar.multiclientserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerWorkWithClientAAndWithClientB {
    public static void main(String[] args) throws IOException {
        final int PORT = 4004;
        ServerSocket serverSocket = new ServerSocket(PORT);//listening port
        System.out.println("Server work!");
        while (true) {
            Socket clientSocket = serverSocket.accept();//waiting until client connect
            Thread thread = new Thread() {
                public void run() {
                    try (
                            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);//reply to the client
                            BufferedReader in = new BufferedReader(
                                    new InputStreamReader(clientSocket.getInputStream())))  //read the message from the client
                    {
                        String input;
//reading a line from the client. This text is displayed and
//then sent back to the client using the out object
                        while ((input = in.readLine()) != null) {
                            System.out.println(input);
                            out.println(input);
                            if (input.equalsIgnoreCase("exit")) {
                                break;
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            thread.start();
        }
    }
}