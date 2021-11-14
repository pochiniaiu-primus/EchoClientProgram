package com.serhiihonchar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        System.out.println("Echo Server");
        try (ServerSocket serverSocket =
                     new ServerSocket(4004)) {//listening port
            System.out.println("Server work!");
            Socket clientSocket = serverSocket.accept();//waiting until client connect
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));//read the message from the client
                 PrintWriter out = new PrintWriter(
                         clientSocket.getOutputStream(), true)) {//reply to the client
//true means that text sent using the out object will automatically be flushed after each use
                String input;
                while ((input = in.readLine()) != null) {//reading a line from the client
//This text is displayed and then sent back to the client using the out object
                    System.out.println("Server: " + input);
                    out.println(input);
                }
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + 4004 + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}