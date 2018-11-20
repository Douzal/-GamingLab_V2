package fr.gaminglab.dao.api.utilisateur;

import java.util.List;

import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.gaminglab.entity.utilisateur.Joueur;
import fr.gaminglab.entity.utilisateur.Utilisateur;

/**
 * 
 */
@Repository
public interface IDaoJoueur extends JpaRepository<Joueur, Integer> {

    /**
     * @param pseudo
     * @return
     */
    public List<Joueur> findTop5ByPseudoStartingWith(String pseudo);
}