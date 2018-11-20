package fr.gaminglab.dao.api.jeu;

import fr.gaminglab.entity.jeu.CategorieJeu;
import fr.gaminglab.entity.jeu.Jeu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 
 */
@Repository
public interface IDaoJeu extends JpaRepository<Jeu, Integer> {

    /**
     * @param idCategorieJeu
     * @return
     */
    public List<Jeu> findByCategorieJeuIdCategorieJeu(Integer idCategorieJeu);

    /**
     * @param libelle
     * @return
     */
    public List<Jeu> findTop5ByLibelleStartingWith(String libelle);

    /**
     * @param idUtilisateur
     * @return
     */
    public List<Jeu> findByJoueurIdUtilisateur(Integer idUtilisateur);
    
}