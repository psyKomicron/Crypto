/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iut.moteur.algorithme.compression.generateurdecles;

import com.iut.moteur.algorithme.chiffrement.generateurdecles.GenerateurDeCles;
import com.iut.moteur.donnes.messages.cles.CleString;
import com.iut.moteur.donnes.messages.cles.Cles;
import java.security.SecureRandom;

/**
 *
 * @author MonsieurJ
 */
public class GenerateurDeClesRLE implements GenerateurDeCles{
    private SecureRandom _generator = new SecureRandom();
    private int _keySize;
    
    public GenerateurDeClesRLE(int keySize)
    {
        _keySize = keySize < 2 ? 2 : keySize;
    }
    
    public GenerateurDeClesRLE()
    {
        _keySize = 2;
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
        keys.addCle("RLE", new CleString(key));
        return keys;
    }
}
