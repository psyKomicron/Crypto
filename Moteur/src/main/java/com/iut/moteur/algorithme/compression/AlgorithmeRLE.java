/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iut.moteur.algorithme.compression;

import com.iut.moteur.algorithme.chiffrement.Algorithme;
import com.iut.moteur.donnes.messages.Message;
import com.iut.moteur.donnes.messages.cles.Cle;
import com.iut.moteur.donnes.messages.cles.Cles;
import com.iut.moteur.exceptions.ExceptionCryptographie;

/**
 *
 * @author MonsieurJ
 */
public class AlgorithmeRLE implements Algorithme{

    @Override
    public String getNom() {
        return "Algorithme RLE";
    }

    @Override
    public Message chiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionCryptographie {
        String content = message.asString();
        Cle key = clesPubliques.getCle("RLE");
        for (int i = 0; i < content.length(); i+= key.asString().length())
        {
            String substring = content.substring(i, i+key.asString().length());
            //for (Charac)
        }
        return null;
    }

    @Override
    public Message dechiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionCryptographie {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
