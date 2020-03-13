/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iut.moteur.algorithme.chiffrement;

import com.iut.moteur.donnes.messages.Message;
import com.iut.moteur.donnes.messages.MessageString;
import com.iut.moteur.donnes.messages.cles.Cles;
import com.iut.moteur.exceptions.ExceptionCryptographie;

/**
 *
 * @author jm786386
 */
public class AlgorithmeVigenere implements Algorithme{

    public AlgorithmeVigenere()
    {
        
    }
    
    @Override
    public String getNom() {
        return "Algorithme Vigenere";
    }

    @Override
    public Message chiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionCryptographie {
        String messageUpper = message.asString().toUpperCase();
        String str = clesPrivees.getCle("cle Vigenere").asString();
        String key = repeatKey(str, messageUpper.length());
        char[][] array = createArray();
        String cryptedMessage = "";
        for (int i = 0; i < messageUpper.length(); i++) {
            char c = messageUpper.charAt(i);
            if (c > 'Z' || c < 'A')
                cryptedMessage += c;
            else
                cryptedMessage += array[c - 'A'][key.charAt(i) - 'A'];
        }
        return new MessageString(cryptedMessage);
    }
    
    private char[][] createArray()
    {
        char[][] array = new char[26][26];
        for (int i = 0; i < 26; i++)
            for (int j = 0; j < 26; j++)
                array[i][j] = (char)(((i + j) % 26) + 'A');
        return array;
    }
    
    private String repeatKey(String key, int length)
    {
        String repeat = "";
        for (int i = 0; i < length; i++)
            repeat += key.charAt(i % key.length());
        return repeat;
    }

    @Override
    public Message dechiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionCryptographie {
        String cryptedMessage = message.asString();
        String key = repeatKey(clesPrivees.getCle("cle Vigenere").asString(), cryptedMessage.length());
        char[][] array = createArray();
        String decryptedMessage = "";
        for (int i = 0; i < cryptedMessage.length(); i++) {
            char c = cryptedMessage.charAt(i);
            if (c > 'Z' || c < 'A')
                decryptedMessage += c;
            else
            {
                for (int j = 0; j < 26; j++) {
                    //System.out.println((char)array[key.charAt(i) - 'A'][j]);
                    if ((char)array[key.charAt(i) - 'A'][j] == c)
                        decryptedMessage += (char)array[0][j];
                }
            }
        }
        return new MessageString(decryptedMessage);
    }
    
}
