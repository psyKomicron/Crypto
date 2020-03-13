/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmes.chiffrement;

import com.iut.moteur.algorithme.chiffrement.AlgorithmeTransposition;
import com.iut.moteur.donnes.messages.cles.Cle;
import com.iut.moteur.donnes.messages.cles.CleString;
import com.iut.moteur.donnes.messages.Message;
import com.iut.moteur.donnes.messages.MessageString;
import java.lang.reflect.Method;
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
public class RemplirTableauChiffrementTest {
    
    

    

    /**
     * Test of dechiffrer method, of class AlgorithmeTransposition.
     */
    @Test
    public void testRemplirTableauSansBourrage() throws Exception {
        System.out.println("Test du remplissage du tableau sans bourrage");
        Message message = new MessageString("Bonjour comment ca va ?x");
        Cle cleString = new CleString("Chat");
        
        AlgorithmeTransposition instance = new AlgorithmeTransposition();
        Method methode = instance.getClass().getDeclaredMethod("remplirTableauChiffrement", Message.class,Cle.class);
        methode.setAccessible(true);
        char[][] result = (char[][]) methode.invoke(instance, message,cleString);
        
        char[][] expResult = {
            {'B','o','n','j'},
            {'o','u','r',' '},
            {'c','o','m','m'},
            {'e','n','t',' '},
            {'c','a',' ','v'},
            {'a',' ','?','x'},
        };
        
        assertArrayEquals(expResult,result);
    }
    
    /**
     * Test of dechiffrer method, of class AlgorithmeTransposition.
     */
    @Test
    public void testRemplirTableauSansBourrage2() throws Exception {
        System.out.println("Test du remplissage du tableau sans bourrage");
        Message message = new MessageString("Bonjour, comment ca va ?");
        Cle cleString = new CleString("Chat");
        
        AlgorithmeTransposition instance = new AlgorithmeTransposition();
        Method methode = instance.getClass().getDeclaredMethod("remplirTableauChiffrement", Message.class,Cle.class);
        methode.setAccessible(true);
        char[][] result = (char[][]) methode.invoke(instance, message,cleString);
        
        char[][] expResult = {
            {'B','o','n','j'},
            {'o','u','r',','},
            {' ','c','o','m'},
            {'m','e','n','t'},
            {' ','c','a',' '},
            {'v','a',' ','?'},
        };
        
        assertArrayEquals(expResult,result);
    }
}
