/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iut.moteur.algorithme.chiffrement.generateurdecles;

import com.iut.moteur.donnes.messages.cles.CleString;
import com.iut.moteur.donnes.messages.cles.Cles;
import java.security.SecureRandom;

/**
 *
 * @author jm786386
 */
public class GenerateurDeCleVigenere implements GenerateurDeCles {
    SecureRandom _generator = new SecureRandom();
    private int _keySize;
    
    public GenerateurDeCleVigenere(int keySize)
    {
        _keySize = keySize;
    }

    @Override
    public Cles genererClePublique() {
        return null;
    }

    @Override
    public Cles genererClePrivee() {
        String key = "";
        Cles keys = new Cles();
        for (int i = 0; i < _keySize; i++)
            key += (char)(_generator.nextInt(26) + 'A');
        keys.addCle("cle Vigenere", new CleString(key));
        return keys;
    }
    
}
