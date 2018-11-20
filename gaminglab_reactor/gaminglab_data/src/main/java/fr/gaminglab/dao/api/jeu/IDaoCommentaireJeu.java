package fr.gaminglab.dao.api.jeu;

import fr.gaminglab.entity.jeu.CommentaireJeu;
import fr.gaminglab.entity.jeu.Jeu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 
 */
@Repository
public interface IDaoCommentaireJeu extends JpaRepository<CommentaireJeu, Integer> {

    /**
     * @param jeu
     * @return
     */
    public List<CommentaireJeu> findByJeuIdJeu(Integer idJeu);

    public List<CommentaireJeu> findByJoueurIdUtilisateur(Integer idUtilisateur);

}