package fr.gaminglab.forum.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.gaminglab.forum.entity.JoueurSujetForum;


/**
 * 
 */
@Repository
public interface IDaoJoueurSujet extends JpaRepository<JoueurSujetForum, Integer> {

    /**
     * @param joueur 
     * @return
     */
    public boolean existsByIdJoueur(Integer idJoueur);

}