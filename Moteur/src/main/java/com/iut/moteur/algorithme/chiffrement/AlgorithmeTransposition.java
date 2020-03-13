/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iut.moteur.algorithme.chiffrement;

import com.iut.moteur.algorithme.chiffrement.algorithmetransposition.ComparateurCouple;
import com.iut.moteur.algorithme.chiffrement.algorithmetransposition.Couple;
import com.iut.moteur.donnes.messages.Message;
import com.iut.moteur.donnes.messages.MessageString;
import com.iut.moteur.donnes.messages.cles.Cle;
import com.iut.moteur.donnes.messages.cles.Cles;
import com.iut.moteur.exceptions.ExceptionConversionImpossible;
import com.iut.moteur.exceptions.ExceptionCryptographie;
import static java.lang.Math.ceil;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.ArrayList;

/**
 * Sous classe de Algorithme, utilisant un algo de chiffrement par transposition
 * @author jm786386
 */
public class AlgorithmeTransposition implements Algorithme{
    SecureRandom generateur;
    
    public AlgorithmeTransposition() {
        
    }
    
    @Override
    public String getNom() {
        return "AlgorithmeTransposition";
    }

    @Override
    public Message chiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionCryptographie {
        char[][] array = remplirTableauChiffrement(message, clesPrivees.getCle("cleTransposition"));
        String s = "";
        int arrayHeigth = ((int)ceil((double)(message.asString().length() / clesPrivees.getCle("cleTransposition").asString().length())));
        ArrayList<Integer> order = getOrdreColonne(clesPrivees.getCle("cleTransposition"));
        for (Integer integer : order)
            for (int i = 0; i < arrayHeigth; i++)
                s += array[i][integer];
        return new MessageString(s);
    }

    @Override
    public Message dechiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionCryptographie {
        ArrayList<Integer> order = getOrdreColonne(clesPrivees.getCle("cleTransposition"));
        int keySize = clesPrivees.getCle("cleTransposition").asString().length();
        int arrayHeight = (message.asString().length() / keySize);
        char[][] decodedMessageArray = new char[arrayHeight][keySize];
        
        int position = 0;
        for (Integer j : order)
        {
            for (int i = 0; i < arrayHeight; i++) {
                decodedMessageArray[i][j] = message.asString().charAt(position);
                position++;
            }
        }
        String str = "";
        for(int i=0;i<arrayHeight;i++) {
            for(int j=0;j<keySize;j++) {
                str += decodedMessageArray[i][j];
            }
        }
        return new MessageString(str);
    }
    
    private char[][] remplirTableauChiffrement(Message message, Cle cle) throws ExceptionConversionImpossible {
        ByteBuffer b = ByteBuffer.allocate(4) ;
        b.putInt((cle.asString() + message.asString()).hashCode()) ;
        this.generateur = new SecureRandom(b.array());
        int keySize = cle.asString().length();
        int arrayHeight = ((int)ceil((double)(message.asString().length()) / keySize));
        char[][] codedMessage = new char[arrayHeight][keySize];
        for (int i = 0; i < arrayHeight; i++) {
            for (int j = 0; j < keySize; j++) {
                if (message.asString().length() <= j + (i * keySize))
                    codedMessage[i][j] = bourrage();
                else
                    codedMessage[i][j] = message.asString().charAt(j + (i * keySize));
            }
        }
        return codedMessage;
    }
    
    private char bourrage()
    {
        return (char)(generateur.nextInt(26) + (generateur.nextBoolean() ? 'A' : 'a'));
    }
    
    private ArrayList<Integer> getOrdreColonne(Cle cle) throws ExceptionConversionImpossible
    {
        ArrayList<Couple> couples = new ArrayList();
        ArrayList<Integer> order = new ArrayList();
        String key = cle.asString();
        for (int i = 0; i < key.length(); i++) {
            couples.add(new Couple(key.charAt(i), i));
        }
        couples.sort(new ComparateurCouple());
        for (Couple couple : couples)
            order.add(couple.getPosition());
        return order;
    }
}
