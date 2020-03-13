/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iut.moteur.donnes.messages;

import com.iut.moteur.exceptions.ExceptionConversionImpossible;
import java.util.ArrayList;

/**
 *
 * @author ac542561
 */
public interface Message {
    
    /**
     * 
     * @return la representation en String du message
     * @throws ExceptionConversionImpossible si le message n'est pas convertible
     * en String
     */
    String asString() throws ExceptionConversionImpossible;
    
    /**
     * 
     * @return la representation en String du message
     * @throws ExceptionConversionImpossible si le message n'est pas convertible
     * en int
     */
    int asInteger() throws ExceptionConversionImpossible;
    
    /**
     * 
     * @return retourne la representation de chaque caractere d'un String sous
     * forme ASCII
     */
    ArrayList<Integer> getListAsciiCode();
}
