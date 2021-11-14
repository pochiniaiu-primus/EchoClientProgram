package com.serhiihonchar.multiclientserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientB {
    public static void main(String[] args) throws IOException {
        final int PORT = 4004;
        System.out.println("Client B work");
        try (Socket clientSocket = new Socket("localhost", PORT);//we can write port=0
             PrintWriter out = new PrintWriter(// writing to socket
                     clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(// reading from socket
                     new InputStreamReader(clientSocket.getInputStream()));
             Scanner scanner = new Scanner(System.in);
        ) {
            while (true) {
                System.out.print("Client B enter text: ");
                String input = scanner.nextLine();
                out.println(input);
                if (input.equalsIgnoreCase("exit")) {
                    break;
                } else {
                    System.out.println("echo: " + in.readLine());
                }
            }
        }
    }
}