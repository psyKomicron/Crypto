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
 * Sous classe de GenerateurDeCles, utilisee par l'algorithme de chiffrement
 * par transposition
 * @author jm786386
 */
public class GenerateurDeClesTransposition implements GenerateurDeCles {
    SecureRandom _generator;
    int _keySize;
    
    public GenerateurDeClesTransposition(int n) {
        _keySize = n;
        _generator = new SecureRandom();
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
            key += (char)(_generator.nextInt(26) + (_generator.nextBoolean() ? 'A' : 'a'));
        keys.addCle("cleTransposition", new CleString(key));
        return keys;
    }
    
}
