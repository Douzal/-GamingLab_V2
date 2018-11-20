package fr.gaminglab.dao.api.communication;

import fr.gaminglab.entity.communication.Message;
import fr.gaminglab.entity.utilisateur.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 
 */
@Repository
public interface IDaoMessage extends JpaRepository<Message, Integer> {

    /**
     * @param joueur 
     * @return
     */
    public List<Message> findByJoueurDestinataire(Joueur joueur);

}