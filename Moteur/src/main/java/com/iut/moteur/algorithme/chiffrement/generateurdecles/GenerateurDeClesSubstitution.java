/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iut.moteur.algorithme.chiffrement.generateurdecles;

import com.iut.moteur.donnes.messages.cles.CleString;
import com.iut.moteur.donnes.messages.cles.Cles;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jm786386
 */
public class GenerateurDeClesSubstitution implements GenerateurDeCles {
    SecureRandom _generator = new SecureRandom();
    private int _keySize;
    
    @Override
    public Cles genererClePublique() {
        return null;
    }

    @Override
    public Cles genererClePrivee() {
        Cles keys = new Cles();
        keys.addCle("cleSubstitution", new CleString(shuffle("ABCDEFGHIJKLMNOPQRSTUVWXYZ")));
        return keys;
    }
    
    private String shuffle(String input){
        List<Character> characters = new ArrayList<Character>();
        for(char c:input.toCharArray()){
            characters.add(c);
        }
        StringBuilder output = new StringBuilder(input.length());
        while(characters.size()!=0){
            int randPicker = (int)(Math.random()*characters.size());
            output.append(characters.remove(randPicker));
        }
        return output.toString();
    }
}
