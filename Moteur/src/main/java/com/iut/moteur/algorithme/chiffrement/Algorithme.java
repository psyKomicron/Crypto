/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iut.moteur.algorithme.chiffrement;

import com.iut.moteur.donnes.messages.Message;
import com.iut.moteur.donnes.messages.cles.Cles;
import com.iut.moteur.exceptions.ExceptionChiffrementImpossible;
import com.iut.moteur.exceptions.ExceptionCryptographie;

/**
 * Interface pour les algorithmes de chiffrement
 * @author ac542561
 */
public interface Algorithme {
    
    /**
     * Permet de connaitre le nom arbitraire de l'algorithme actuel
     * @return le nom de l'algorithme
     */
    String getNom();
    
    /**
     * Chiffre le message avec le tuple de cles privees et publiques si
     * l'algorithme le prend en charge
     * @param message message a chiffrer
     * @param clesPubliques cles publiques de chiffrement
     * @param clesPrivees cles privees de chiffrement
     * @return le message chiffre
     * @throws ExceptionCryptographie 
     */
    Message chiffrer(Message message, Cles clesPubliques,Cles clesPrivees) throws ExceptionCryptographie;
    Message dechiffrer(Message message, Cles clesPubliques,Cles clesPrivees) throws ExceptionCryptographie;

}
