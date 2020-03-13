/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iut.moteur.protocoles;

import com.iut.Crypto;
import com.iut.moteur.algorithme.chiffrement.Algorithme;
import com.iut.moteur.donnes.messages.Message;
import com.iut.moteur.donnes.messages.cles.Cles;
import com.iut.moteur.entites.Personne;
import com.iut.moteur.entites.Univers;
import com.iut.moteur.exceptions.ExceptionCryptographie;

/**
 *
 * @author MonsieurJ
 */
public abstract class ProtocoleCryptographie {
    
    protected void build(Personne Alice, Personne Bob, 
            Algorithme algo, 
            Cles publicKeys, Cles privateKeys,
            Message message) 
            throws ExceptionCryptographie
    {
        Alice.setClesPrivees(privateKeys);
        Bob.setClesPrivees(privateKeys);
        Alice.setAlgorithme(algo);
        Bob.setAlgorithme(algo);

        String messageName = Alice.getNom() + "-" + algo.getNom();
        Univers.addMessage(messageName, 
                Alice.chiffrer(message, publicKeys));
        Message decryptedMessage = Bob.dechiffrer(
                Univers.getMessage(messageName), publicKeys);
        System.out.println(
                Crypto.ANSI_RED+"Encrypted Message : "+Crypto.ANSI_RESET);
        System.out.println(Univers.getMessage(messageName).asString());
        System.out.println(
                Crypto.ANSI_GREEN+"Decrypted Message : "+Crypto.ANSI_RESET);
        System.out.println(decryptedMessage.asString());
    }
}
