/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmes.generateurdecles;

import com.iut.moteur.algorithme.chiffrement.generateurdecles.GenerateurDeCleVigenere;
import com.iut.moteur.donnes.messages.cles.Cle;
import com.iut.moteur.donnes.messages.cles.Cles;
import com.iut.moteur.exceptions.ExceptionConversionImpossible;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Matthieu
 */
public class GenerateurDeClesVigenereTest {

    /**
     * Test of genererClePrivee method, of class GenerateurDeClesVigenere.
     */
    @Test
    public void testGenererClePrivee() throws ExceptionConversionImpossible {
        System.out.println("genererClePrivee");
        GenerateurDeCleVigenere instance = new GenerateurDeCleVigenere(10);
        Cles result = instance.genererClePrivee();
        
        Cle cle = result.getCle("cle-Vigenere");
        assertNotNull(cle);
        
        assertEquals(10,cle.asString().length());
        System.out.println(cle.asString());
        
        for(char c : cle.asString().toCharArray()) {
            if(c<'A' || c>'Z') {
                fail("La clé ne contient pas que des majuscules.");
            }
        }
    }
    
}
