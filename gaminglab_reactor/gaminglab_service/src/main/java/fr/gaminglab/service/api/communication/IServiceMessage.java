package fr.gaminglab.service.api.communication;

import fr.gaminglab.entity.communication.Message;
import fr.gaminglab.entity.utilisateur.Joueur;

import java.util.List;

/**
 * 
 */
public interface IServiceMessage {

    /**
     * @param message 
     * @return
     */
    public Message envoyerMessage(Message message);

    /**
     * @param joueur 
     * @return
     */
    public List<Message> getMessageByJoueur(Joueur joueur);

    /**
     * @param libelle 
     * @return
     */
    public List<Message> getMessageByName(String libelle);

    /**
     * @param message 
     * @return
     */
    public boolean setMessageEstLu(Message message);

    /**
     * @param message 
     * @return
     */
    public boolean supprimerMessage(Message message);

}