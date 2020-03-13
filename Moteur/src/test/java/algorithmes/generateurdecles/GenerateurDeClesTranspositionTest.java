/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmes.generateurdecles;

import com.iut.moteur.algorithme.chiffrement.generateurdecles.GenerateurDeClesTransposition;
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
 * @author simonetma
 */
public class GenerateurDeClesTranspositionTest {
    
    @Test
    public void testGenererClePublique() {
        System.out.println("Test de la génération de clé publique");
        GenerateurDeClesTransposition instance = new GenerateurDeClesTransposition(10);
        Cles expResult = null;
        Cles result = instance.genererClePublique();
        assertEquals(expResult, result);
    }

    /**
     * Test of genererClePrivee method, of class GenerateurDeClesTransposition.
     */
    @Test
    public void testGenererClePrivee() throws ExceptionConversionImpossible {
        System.out.println("Test de la génération de clé privée");
        GenerateurDeClesTransposition instance = new GenerateurDeClesTransposition(10);
        Cles result = instance.genererClePrivee();
        Cle cleResult = result.getCle("cleTransposition");
        assertEquals(10, cleResult.asString().length());
        Boolean valide = true;
        for(char c : cleResult.asString().toCharArray()) {
            if( (c<'a' || c>'z') && (c<'A' || c>'Z')) {
                valide = false;
            }
        }
        assertEquals(true,valide);
    }
    
}
