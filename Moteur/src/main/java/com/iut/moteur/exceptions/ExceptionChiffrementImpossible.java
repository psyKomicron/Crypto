/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iut.moteur.exceptions;

import com.iut.moteur.algorithme.chiffrement.Algorithme;

/**
 * Exception lancee lorsque l'algorithme de chiffrement n'est pas capable
 * de crypter le message.
 * Peut se produire lorsque la cle de cryptage n'est pas fournie
 * @author ac542561
 */
public class ExceptionChiffrementImpossible extends ExceptionCryptographie {
    
    public ExceptionChiffrementImpossible(Algorithme algorithme){
        super("Chiffrement Impossible","Chiffrement de l'algo : '' Impossible");
    } 
    
}
