package fr.gaminglab.dao.api.utilisateur;

import fr.gaminglab.entity.utilisateur.Joueur;
import fr.gaminglab.entity.utilisateur.JoueurCarte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 
 */
@Repository
public interface IDaoJoueurCarte extends JpaRepository<JoueurCarte, Integer> {

    /**
     * @param idUtilisateur
     * @return
     */
    public List<JoueurCarte> findByJoueurIdUtilisateur(Integer idUtilisateur);

}