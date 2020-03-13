/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iut.moteur.protocoles;

import com.iut.Crypto;
import com.iut.moteur.algorithme.chiffrement.AlgorithmeTransposition;
import com.iut.moteur.algorithme.chiffrement.generateurdecles.GenerateurDeClesTransposition;
import com.iut.moteur.donnes.MessageTestContent;
import com.iut.moteur.donnes.messages.Message;
import com.iut.moteur.donnes.messages.MessageString;
import com.iut.moteur.donnes.messages.cles.Cles;
import com.iut.moteur.entites.Personne;
import com.iut.moteur.entites.Univers;
import com.iut.moteur.exceptions.ExceptionCryptographie;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jm786386
 */
public class ProtocoleTransposition extends ProtocoleCryptographie implements IProtocole {

    @Override
    public void executer() {
        try {
            super.build(new Personne("Alice"), new Personne("Bob"), 
                new AlgorithmeTransposition(), 
                null, new GenerateurDeClesTransposition(10).genererClePrivee(), 
                new MessageString(MessageTestContent.getContent()));
        } catch (ExceptionCryptographie ex) {
            Logger.getLogger(ProtocoleTransposition.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
