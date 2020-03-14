/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iut.moteur.protocoles.trials;

import com.iut.Crypto;
import com.iut.moteur.protocoles.IProtocole;
import com.iut.network.client.Client;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jm786386
 */
public class Trial_1 implements ITrial {

    @Override
    public void execute(Client client) {
        try {
            while (!client.receiveMessage().equals("FIN"))
            {
                String message = client.receiveMessage();
                //System.out.println(message);
                if (message.charAt(0) != 'O' || message.charAt(0) != '-')
                {
                    try
                    {
                        int value = Integer.parseInt(message);
                        value++;
                        client.sendMessage("" + value);
                    }
                    catch (NumberFormatException e)
                    {
                        System.err.println("Cannot convert data");
                    }
                }
            }
            client.end();
        } catch (IOException ex) {
            Logger.getLogger(Crypto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
