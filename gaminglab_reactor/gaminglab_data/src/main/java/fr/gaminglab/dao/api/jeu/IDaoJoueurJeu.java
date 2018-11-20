package fr.gaminglab.dao.api.jeu;

import fr.gaminglab.entity.jeu.Jeu;
import fr.gaminglab.entity.jeu.JoueurJeu;
import fr.gaminglab.entity.utilisateur.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 
 */
@Repository
public interface IDaoJoueurJeu extends JpaRepository<JoueurJeu, Integer> {

    /**
     * @param idutilisateur
     * @return
     */
    public List<JoueurJeu> findByJoueurIdUtilisateurOrderByDateJouerDesc(Integer idutilisateur);

    /**
     * @param idJeu
     * @return
     */
    public List<JoueurJeu> findByJeuIdJeuOrderByTempsJeu(Integer idJeu);

    /**
     * @param idJeu
     * @param idUtilisateur
     * @return
     */
    public JoueurJeu findByJeuIdJeuAndJoueurIdUtilisateur(Integer idJeu, Integer idUtilisateur);

}