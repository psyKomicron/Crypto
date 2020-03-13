/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iut.moteur.exceptions;

/**
 * Exception lancee lorsque le message ne peut pas etre converti
 * @author ac542561
 */
public class ExceptionConversionImpossible extends ExceptionCryptographie {
    
    public ExceptionConversionImpossible(String message){
        super("Conversion impossible","Conversion du message : '' impossible");
    }
}
