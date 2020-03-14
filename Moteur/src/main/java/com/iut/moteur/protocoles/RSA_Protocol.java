/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iut.moteur.protocoles;

import com.iut.moteur.protocoles.trials.Trial_Random;
import com.iut.network.client.Client;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MonsieurJ
 */
public class RSA_Protocol implements IProtocole
{

    @Override
    public void executer()
    {
        Client client = null;
        try
        {
            client = new Client();
            while (!client.receiveMessage().equals("FIN"))
            {
                String message = client.receiveMessage();
                if (message.contains("Random avec bornes"))
                    new Trial_Random().execute(client);
            }
        } catch (IOException ex)
        {
            System.out.println("Cannot contruct client\n" + ex);
        }
        
        try {
            client.end();
        } catch (IOException ex) {
            Logger.getLogger(RSA_Protocol.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
