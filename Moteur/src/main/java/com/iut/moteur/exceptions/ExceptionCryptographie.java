/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iut.moteur.exceptions;

/**
 * 
 * @author ac542561
 */
public abstract class ExceptionCryptographie extends Exception {
    
    private String nom;
    private String message;
    
    public ExceptionCryptographie(String nom,String message){
        this.nom = nom;
        this.message = message;
    }
    
    public void gerer(){
        
        System.out.println(nom + " : " + message);
        this.printStackTrace(System.err) ;
    }
    
}
