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
public class BinairyKeyGenerator implements GenerateurDeCles {
    private SecureRandom _generator = new SecureRandom();
    private int _keySize;

    public BinairyKeyGenerator(int keySize)
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
            key += (_generator.nextBoolean() ? '1' : '0');
        keys.addCle("RSA-key", new CleString(key));
        return keys;
    }
    
}
