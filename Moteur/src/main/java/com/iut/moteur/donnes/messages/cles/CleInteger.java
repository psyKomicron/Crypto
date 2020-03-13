/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iut.moteur.donnes.messages.cles;

import com.iut.moteur.exceptions.ExceptionConversionImpossible;

/**
 * Sous classe de Cle (pour les cles sous forme d'entier)
 * @author ac542561
 */
public class CleInteger implements Cle{

    private int cle;
    
    public CleInteger(int cle){
        this.cle = cle;
    }
    
    @Override
    public String asString() throws ExceptionConversionImpossible {
        return Integer.toString(cle);
    }

    @Override
    public int asInteger() throws ExceptionConversionImpossible {
        return cle;
    }
    
}
