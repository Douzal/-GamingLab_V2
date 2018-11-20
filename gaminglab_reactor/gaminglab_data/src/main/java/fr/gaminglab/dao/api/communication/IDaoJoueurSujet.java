package fr.gaminglab.dao.api.communication;

import fr.gaminglab.entity.communication.JoueurSujetForum;
import fr.gaminglab.entity.utilisateur.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * 
 */
@Repository
public interface IDaoJoueurSujet extends JpaRepository<JoueurSujetForum, Integer> {

    /**
     * @param joueur 
     * @return
     */
    public boolean existsByJoueur(Joueur joueur);

}