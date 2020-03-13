/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iut.moteur.algorithme.chiffrement.algorithmetransposition;

import java.util.Comparator;

/**
 * Represente un caractere d'une CleString, avec sa position dans la cle
 * @author jm786386
 */
public class Couple {
    private char caractere;
    
    private int position;

    public Couple(char c, int i) {
        caractere = c;
        position = i;
    }

    public char getCaractere() {
        return caractere;
    }

    public void setCaractere(char caractere) {
        this.caractere = caractere;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
