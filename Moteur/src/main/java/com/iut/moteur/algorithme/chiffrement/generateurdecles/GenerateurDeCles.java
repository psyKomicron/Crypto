/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iut.moteur.algorithme.chiffrement.generateurdecles;

import com.iut.moteur.donnes.messages.cles.Cles;

/**
 * 
 * @author ac542561
 */
public interface GenerateurDeCles {
    
    /**
     * Genere une collection de cles publiques, generees "aleatoirement"
     * @return la collection de Cle sous la forme d'un objet Cles
     */
    Cles genererClePublique();
    
    /**
     * Genere une collection de cles privees, generees "aleatoirement"
     * @return la collection de Cle sous la forme d'un objet Cles
     */
    Cles genererClePrivee();
}
