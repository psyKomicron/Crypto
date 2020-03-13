package com.iut.network.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private Socket _socket; 
    private PrintWriter _pw;
    private BufferedReader _bufr;
    
    public Client() throws IOException {
        _socket = new Socket("127.0.0.1", 1234);
        _pw = new PrintWriter(_socket.getOutputStream(), true);
        _bufr = new BufferedReader(new InputStreamReader(_socket.getInputStream()));
    }
    
    public void sendMessage(String message) {
        System.out.println(">>> " + message);
        _pw.println(message);
    }
        
    //Renvoie true si l'IA doit continuer
    public String receiveMessage() throws IOException {
        String str = _bufr.readLine();
        System.out.println("<<< " + str);
        return str;
    }
    
    public void end() throws IOException {
        _socket.close();
    }
    
}
