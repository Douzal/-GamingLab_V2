package fr.gaminglab.service.impl.communication;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gaminglab.dao.api.communication.IDaoMessage;
import fr.gaminglab.entity.communication.Message;
import fr.gaminglab.entity.utilisateur.Joueur;
import fr.gaminglab.service.api.communication.IServiceMessage;

import javax.transaction.Transactional;

/**
 * 
 */
@Service
@Transactional
public class ServiceMessage implements IServiceMessage {

    /**
     * Default constructor
     */
    public ServiceMessage() {
    }

    /**
     * 
     */
    @Autowired
    private IDaoMessage daoMessage;

    /**
     * @param message 
     * @return
     */
    public Message envoyerMessage(Message message) {
        // TODO implement here
        return null;
    }

    /**
     * @param joueur 
     * @return
     */
    public List<Message> getMessageByJoueur(Joueur joueur) {
        // TODO implement here
        return null;
    }

    /**
     * @param libelle 
     * @return
     */
    public List<Message> getMessageByName(String libelle) {
        // TODO implement here
        return null;
    }

    /**
     * @param message 
     * @return
     */
    public boolean setMessageEstLu(Message message) {
        // TODO implement here
        return false;
    }

    /**
     * @param message 
     * @return
     */
    public boolean supprimerMessage(Message message) {
        // TODO implement here
        return false;
    }

}