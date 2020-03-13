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
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Objects;

/**
 *
 * @author jm786386
 */
public class AlgorithmeSubstitution implements Algorithme {
    private HashMap<Character, Character> _alphabet = new HashMap<>();
    
    public AlgorithmeSubstitution(){}
    
    @Override
    public String getNom() {
        return "AlogrithmeSubstitution";
    }

    @Override
    public Message chiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionCryptographie {
        String messageUpper = message.asString().toUpperCase();
        String key = clesPrivees.getCle("cleSubstitution").asString();
        String encryptedMessage = "";
        buildAlphabet(key);
        for (int i = 0; i < messageUpper.length(); i++) {
            char c = messageUpper.charAt(i);
            if (c < 'A' || c > 'Z') encryptedMessage += c;
            else encryptedMessage += _alphabet.get(c);
        }
        return new MessageString(encryptedMessage);
    }
    
    private void buildAlphabet(String key)
    {
        for (int i = 0; i < key.length(); i++) {
            _alphabet.put((char)('A' + i), key.charAt(i));
        }
    }
    
    private Character getKey(char c)
    {
        HashMap<Character, Character> alphabet = _alphabet;
        for (Entry<Character, Character> entry : alphabet.entrySet())
        {
            if (Objects.equals(c, entry.getValue())) return entry.getKey();
        }
        return null;
    }

    @Override
    public Message dechiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionCryptographie {
        String encryptedMessage = message.asString();
        String key = clesPrivees.getCle("cleSubstitution").asString();
        String decryptedMessage = "";
        buildAlphabet(key);
        for (int i = 0; i < encryptedMessage.length(); i++) {
            char c = encryptedMessage.charAt(i);
            if (c < 'A' || c > 'Z') decryptedMessage += c;
            else decryptedMessage += getKey(c);
        }
        return new MessageString(decryptedMessage);
    }
    
}
