package com.iut.coucheReseau.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.stream.Stream;

public class Client {
    private Socket _socket; 
    private PrintWriter _pw;
    private BufferedReader _bufr;
    
    public Client() throws IOException {
        _socket = new Socket("127.0.0.1", 1234);
        _bufr = new BufferedReader(new InputStreamReader(_socket.getInputStream()));
        _pw = new PrintWriter(_socket.getOutputStream(), true);
    }
    
    public void sendMessage(String message) {
        System.out.println(">>> " + message);
        _pw.print(message);
    }
        
    //Renvoie true si l'IA doit continuer
    public String receiveMessage() throws IOException {
        //System.out.println("<<< " + _bufr.readLine());
        String str = _bufr.readLine();
        return str;
    }
    
    public void end() throws IOException {
        _socket.close();
    }
    
}
