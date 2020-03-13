/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iut.moteur.donnes.messages;

import com.iut.moteur.exceptions.ExceptionConversionImpossible;
import java.util.ArrayList;

/**
 * Sous classe de Message, utilisee pour les messages textuels
 * @author ac542561
 */
public class MessageString implements Message {
    private String message;

    public MessageString(String message){
        this.message = message;
    }
    
    @Override
    public String asString() throws ExceptionConversionImpossible {
        return message;
    }

    /**
     *
     * @return
     * @throws ExceptionConversionImpossible
     */
    @Override
    public int asInteger() throws ExceptionConversionImpossible {
        
        throw new ExceptionConversionImpossible(message);

    }

    @Override
    public ArrayList<Integer> getListAsciiCode() {
        ArrayList<Integer> tab = new ArrayList<Integer>();
        for(int i = 0;i<message.length()-1;i++){
            tab.add((int)(message.charAt(i)));
        }
        return tab;
    }
    
    
}
