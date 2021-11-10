package com.serhiihonchar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClient {
    public static void main(String args[]) {
        System.out.println("Echo Client");
        try {
//            InetAddress localAddress = InetAddress.getLocalHost();
            try (Socket clientSocket = new Socket("localhost", 4004);
                 PrintWriter out = new PrintWriter(//writing to socket
                         clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(// reading from socket
                         new InputStreamReader(clientSocket.getInputStream()))) {
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    System.out.print("Enter text: ");
                    String inputLine = scanner.nextLine();
                    if ("quit".equalsIgnoreCase(inputLine)) {
                        break;
                    }
                    out.println(inputLine);
                    String response = in.readLine();
                    System.out.println("Echo " + response);
                }
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}