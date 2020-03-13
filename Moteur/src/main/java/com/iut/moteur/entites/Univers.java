/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iut.moteur.entites;

import com.iut.moteur.donnes.messages.Message;
import com.iut.moteur.donnes.messages.cles.Cles;
import java.util.HashMap;

/**
 * Represente une situation, par exemple sur internet.
 * S'utilise comme un singleton
 * @author ac542561
 */
public class Univers {
    private HashMap<String,Cles> listeClesPubliques = new HashMap<String,Cles>();
    private HashMap<String,Message> listeMessagesPublics = new HashMap<String,Message>();
    private static Univers instance = new Univers();
    
    private Univers(){
        
    }
    
    public static Univers get(){
        if(instance == null)
            instance = new Univers();
        
        return instance;
    }
    
    /**
     * Ajoute des cles (publiques)
     * @param identifiant identifiant de la cle, afin de la recuperer plus tard
     * @param cles cles
     */
    public static void addCles(String identifiant,Cles cles){
        Univers u = get();
        u.listeClesPubliques.put(identifiant, cles);
    }
    
    /**
     * Retourne la collection de cles (Cles) ayant le bon indentifiant 
     * @param identifiant
     * @return 
     */
    public static Cles getCles(String identifiant){
        Univers u = get();
        return u.listeClesPubliques.get(identifiant);
    }
    
    /**
     * Ajoute un message a l'univers. Simule un envoi de message
     * @param identifiant identifiant du message, a utiliser lors du getMessage
     * @param message message a ajouter
     */
    public static void addMessage(String identifiant,Message message){
        Univers u = get();
        u.listeMessagesPublics.put(identifiant, message);
    }
    
    /**
     * Recuperer le message ayant le bon identifiant
     * @param identifiant utilise lors de l'ajout (via addMessage)
     * @return le message
     */
    public static Message getMessage(String identifiant){
        Univers u = get();
        return u.listeMessagesPublics.get(identifiant);
    }
}
