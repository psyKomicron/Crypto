/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iut.moteur.exceptions;

import com.iut.moteur.entites.Personne;

/**
 * Exception lancee lorsque l'algorithme de Personne n'est pas defini
 * @author ac542561
 */
public class ExceptionAlgorithmeNonDefini extends ExceptionCryptographie{
    
    public ExceptionAlgorithmeNonDefini(Personne personne){
        super("Algorithme Non Defini","Erreur dans la personne : ");
    }
    
}
