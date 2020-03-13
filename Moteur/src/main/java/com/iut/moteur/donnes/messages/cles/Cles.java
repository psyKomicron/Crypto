/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iut.moteur.donnes.messages.cles;

import com.iut.moteur.entites.Personne;
import java.util.HashMap;

/**
 * Collection de Cle
 * @author ac542561
 */
public class Cles {
    
    HashMap<String,Cle> listeCles = new HashMap<String,Cle>();
    
    public Cles(){
        
    }
    
    /**
     * Permet de recuperer une cle stockee dans la collection
     * @param nom identifiant de la cle
     * @return la cle correspondant a l'identifant
     */
    public Cle getCle(String nom){
        return listeCles.get(nom);
    }
    
    /**
     * Ajoute une Cle a la collection de Cle en specifiant un identifiant.
     * @param nom identifiant de la cle
     * @param cle cle a stocker
     */
    public void addCle(String nom,Cle cle){
        listeCles.put(nom, cle);
    }
    
}
