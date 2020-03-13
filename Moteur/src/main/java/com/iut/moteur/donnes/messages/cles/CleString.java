/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iut.moteur.donnes.messages.cles;

import com.iut.moteur.exceptions.ExceptionConversionImpossible;

/**
 * Sous classe de Cle (pour les cles sous forme de chaine de caracteres)
 * @author jm786386
 */
public class CleString implements Cle {
    private String _cle;
    
    public CleString(String cle){
        _cle = cle;
    }
    
    @Override
    public String asString() throws ExceptionConversionImpossible {
        return _cle;
    }

    @Override
    public int asInteger() throws ExceptionConversionImpossible {
        throw new ExceptionConversionImpossible("Not supported yet.");
    }
    
}
