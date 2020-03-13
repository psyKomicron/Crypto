package algorithmes.chiffrement;

import com.iut.moteur.algorithme.chiffrement.Algorithme;
import com.iut.moteur.donnes.messages.Message;
import com.iut.moteur.donnes.messages.MessageString;
import com.iut.moteur.donnes.messages.cles.Cles;
import com.iut.moteur.exceptions.ExceptionCryptographie;



/**
 * Description de la classe
 * @author Matthieu
 */
public class AlgorithmeFake implements Algorithme {

    @Override
    public String getNom() {
       return "Algorithme de Test";
    }

    @Override
    public Message chiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionCryptographie {
        return new MessageString("Chiffre");
    }

    @Override
    public Message dechiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionCryptographie {
        return new MessageString("Dechiffre");
    }

}
