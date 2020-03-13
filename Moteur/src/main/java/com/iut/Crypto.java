/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iut;

import com.iut.coucheReseau.client.Client;
import com.iut.moteur.algorithme.compression.generateurdecles.GenerateurDeClesRLE;
import com.iut.moteur.exceptions.ExceptionConversionImpossible;
import com.iut.moteur.protocoles.ProtocoleSubstitution;
import com.iut.moteur.protocoles.ProtocoleTransposition;
import com.iut.moteur.protocoles.ProtocoleVigenere;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jm786386
 */
public class Crypto {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\033[1;31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    
    public static void main(String[] args)
    {
        try {
            Client client = new Client();
            while (client.receiveMessage() != "FIN")
            {
                String message = client.receiveMessage();
                System.out.println(message);
                if (message.charAt(0) != 'O' || message.charAt(0) != '-')
                {
                    int value = Integer.parseInt(message);
                    client.sendMessage("" + value);
                }
            }
            client.end();
        } catch (IOException ex) {
            Logger.getLogger(Crypto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
