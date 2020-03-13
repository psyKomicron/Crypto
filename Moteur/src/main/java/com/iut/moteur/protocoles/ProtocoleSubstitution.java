/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iut.moteur.protocoles;

import com.iut.Crypto;
import com.iut.moteur.algorithme.chiffrement.Algorithme;
import com.iut.moteur.algorithme.chiffrement.AlgorithmeSubstitution;
import com.iut.moteur.algorithme.chiffrement.AlgorithmeTransposition;
import com.iut.moteur.algorithme.chiffrement.generateurdecles.GenerateurDeCles;
import com.iut.moteur.algorithme.chiffrement.generateurdecles.GenerateurDeClesSubstitution;
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
 * @author MonsieurJ
 */
public class ProtocoleSubstitution extends Protocole implements IProtocole {

    @Override
    public void executer() {
        Cles keys = new GenerateurDeClesSubstitution().genererClePrivee();
        try {
            super.build(new Personne("Alice"), new Personne("Bob"), 
                    new AlgorithmeSubstitution(), 
                    null, new GenerateurDeClesSubstitution().genererClePrivee(), 
                    new MessageString(MessageTestContent.getContent()));
        } catch (ExceptionCryptographie ex) {
            Logger.getLogger(
                    ProtocoleTransposition.class.getName()).log(
                            Level.SEVERE, null, ex);
        }
        
    }
    
}
