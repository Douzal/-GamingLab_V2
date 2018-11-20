package fr.gaminglab.dao.api.utilisateur;

import fr.gaminglab.entity.utilisateur.Joueur;
import fr.gaminglab.entity.utilisateur.JoueurBadge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 
 */
@Repository
public interface IDaoJoueurBadge extends JpaRepository<JoueurBadge, Integer> {

    /**
     * @param
     * @return
     */
    public List<JoueurBadge> findByJoueurIdUtilisateur(Integer idUtilisateur);

}