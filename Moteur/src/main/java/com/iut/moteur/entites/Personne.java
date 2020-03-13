/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iut.moteur.entites;

import com.iut.moteur.algorithme.chiffrement.Algorithme;
import com.iut.moteur.donnes.messages.Message;
import com.iut.moteur.donnes.messages.cles.Cles;
import com.iut.moteur.exceptions.ExceptionChiffrementImpossible;
import com.iut.moteur.exceptions.ExceptionCryptographie;
/**
 * Represente une personne souhaitant crypter/decrypter un message
 * @author ac542561
 */
public class Personne {
        private String nom;
        private Algorithme algorithme;
        private Cles clesPrivees;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Algorithme getAlgorithme() {
        return algorithme;
    }

    public void setAlgorithme(Algorithme algorithme) {
        this.algorithme = algorithme;
    }

    public Cles getClesPrivee() {
        return clesPrivees;
    }

    public void setClesPrivees(Cles clesPrivee) {
        this.clesPrivees = clesPrivee;
    }
        
        
    public Personne(String nom){
        this.nom = nom;
    }
    
    /**
     * 
     * @param message message a chiffrer
     * @param clesPublique cles de chiffrement a utiliser
     * @return le message chiffrer par l'algorithme de la Personne
     * @throws ExceptionCryptographie 
     */
    public Message chiffrer(Message message,Cles clesPublique) throws ExceptionCryptographie{
        return this.algorithme.chiffrer(message, clesPublique, clesPrivees);
    }
    
    /**
     * 
     * @param message message a dechiffrer
     * @param clesPublique cles de chiffrement a utiliser
     * @return le message dechiffrer par l'algorithme de la Personne
     * @throws ExceptionCryptographie 
     */
    public Message dechiffrer(Message message,Cles clesPublique) throws ExceptionCryptographie
    {
        return this.algorithme.dechiffrer(message, clesPublique, clesPrivees);
    }
}
