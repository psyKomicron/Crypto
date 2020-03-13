/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iut.moteur.algorithme.chiffrement.algorithmetransposition;

import java.util.Comparator;

/**
 * Permet de comparer deux couples en fonction de la position du caractere du
 * Couple et de la position du Couple
 * @author jm786386
 */
public class ComparateurCouple implements Comparator<Couple> {

    @Override
    public int compare(Couple arg0, Couple arg1) {
        if (arg0.getCaractere() == arg1.getCaractere())
        {
            if (arg0.getPosition() == arg1.getPosition())
                return 0;
            else if (arg0.getPosition() < arg1.getPosition())
                return -1;
            else if (arg0.getPosition() > arg1.getPosition())
                return 1;
        }
        else if (arg0.getCaractere() > arg1.getCaractere())
            return 1;
        else if (arg0.getCaractere() < arg1.getCaractere())
            return -1;
        return 0;
    }
    
}
