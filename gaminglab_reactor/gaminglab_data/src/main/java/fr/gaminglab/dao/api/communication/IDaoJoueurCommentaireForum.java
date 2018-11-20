package fr.gaminglab.dao.api.communication;

import fr.gaminglab.entity.communication.JoueurCommentaireForum;
import fr.gaminglab.entity.utilisateur.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * 
 */
@Repository
public interface IDaoJoueurCommentaireForum extends JpaRepository<JoueurCommentaireForum, Integer> {

    /**
     * @param joueur 
     * @return
     */
    public boolean existsByJoueur(Joueur joueur);

}