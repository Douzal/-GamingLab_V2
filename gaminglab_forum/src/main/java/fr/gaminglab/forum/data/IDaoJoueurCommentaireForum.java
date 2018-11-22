package fr.gaminglab.forum.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.gaminglab.forum.entity.JoueurCommentaireForum;


/**
 * 
 */
@Repository
public interface IDaoJoueurCommentaireForum extends JpaRepository<JoueurCommentaireForum, Integer> {

    /**
     * @param joueur 
     * @return
     */
    public boolean existsByIdJoueur(Integer idJoueur);

}