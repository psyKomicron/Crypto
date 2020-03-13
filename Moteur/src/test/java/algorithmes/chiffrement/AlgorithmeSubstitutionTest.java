/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmes.chiffrement;

import com.iut.moteur.algorithme.chiffrement.AlgorithmeSubstitution;
import com.iut.moteur.donnes.messages.cles.CleString;
import com.iut.moteur.donnes.messages.cles.Cles;
import com.iut.moteur.donnes.messages.Message;
import com.iut.moteur.donnes.messages.MessageString;
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
public class AlgorithmeSubstitutionTest {
    

    /**
     * Test of chiffrer method, of class AlgorithmeSubstitution.
     */
    @Test
    public void testChiffrer() throws Exception {
        System.out.println("chiffrer");
        Message message = new MessageString("BONJOUR, COMMENT CA VA ?");
        Cles clesPubliques = null;
        Cles clesPrivees = new Cles();
        CleString cle = new CleString("AZERTYUIOPQSDFGHJKLMWXCVBN");
        clesPrivees.addCle("cleSubstitution", cle);
        AlgorithmeSubstitution instance = new AlgorithmeSubstitution();
        
        String expResult = "ZGFPGWK, EGDDTFM EA XA ?";
        String result = instance.chiffrer(message, clesPubliques, clesPrivees).asString();
        assertEquals(expResult, result);
    }

    /**
     * Test of dechiffrer method, of class AlgorithmeSubstitution.
     */
    @Test
    public void testDechiffrer() throws Exception {
        System.out.println("chiffrer");
        Message message = new MessageString("ZGFPGWK, EGDDTFM EA XA ?");
        Cles clesPubliques = null;
        Cles clesPrivees = new Cles();
        CleString cle = new CleString("AZERTYUIOPQSDFGHJKLMWXCVBN");
        clesPrivees.addCle("cleSubstitution", cle);
        AlgorithmeSubstitution instance = new AlgorithmeSubstitution();
        
        String expResult = "BONJOUR, COMMENT CA VA ?";
        String result = instance.dechiffrer(message, clesPubliques, clesPrivees).asString();
        assertEquals(expResult, result);
    }
    
}
