/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iut.moteur.algorithme.chiffrement;

import com.iut.moteur.donnes.messages.Message;
import com.iut.moteur.donnes.messages.cles.Cles;
import com.iut.moteur.exceptions.ExceptionCryptographie;

/**
 *
 * @author jm786386
 */
public class AlogrithmeSubstitution implements Algorithme {

    @Override
    public String getNom() {
        return "AlogrithmeSubstitution";
    }

    @Override
    public Message chiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionCryptographie {
        String messageUpper = message.asString().toUpperCase();
        String key = clesPrivees.getCle("cleSubstitution").asString();
        String cryptedMessage = "";
        for (int i = 0; i < messageUpper.length(); i++) {
            int offset = 'A' - key.charAt(i);
            cryptedMessage += (messageUpper.charAt(i) + offset) % 26;
        }
        return null;
    }

    @Override
    public Message dechiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionCryptographie {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
