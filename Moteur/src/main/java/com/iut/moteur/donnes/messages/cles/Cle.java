/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iut.moteur.donnes.messages.cles;

import com.iut.moteur.exceptions.ExceptionConversionImpossible;

/**
 *
 * @author ac542561
 */
public interface Cle {
    
    /**
     * 
     * @return la representation sous forme de String de la Cle
     * @throws ExceptionConversionImpossible si la cle n'est pas convertible en
     * String
     */
    String asString() throws ExceptionConversionImpossible;
    
    /**
     * 
     * @return la representation sous forme d'entier de la Cle
     * @throws ExceptionConversionImpossible si la cle n'est pas convertible en
     * entier
     */
    int asInteger() throws ExceptionConversionImpossible;
}
