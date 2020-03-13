/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iut.moteur.protocoles.trials;

import com.iut.moteur.algorithme.chiffrement.generateurdecles.BinairyKeyGenerator;
import com.iut.moteur.exceptions.ExceptionConversionImpossible;
import com.iut.moteur.protocoles.IProtocole;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jm786386
 */
public class Trial_Random implements IProtocole {

    @Override
    public void executer() {
        for (int i = 0; i < 10; i++)
        {
            try {
                System.out.println(new BinairyKeyGenerator(10).genererClePrivee().getCle("RSA-key").asString());
            } catch (ExceptionConversionImpossible ex) {
                Logger.getLogger(Trial_Random.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
