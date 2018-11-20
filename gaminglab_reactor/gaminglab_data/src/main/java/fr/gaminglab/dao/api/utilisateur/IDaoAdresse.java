package fr.gaminglab.dao.api.utilisateur;


import fr.gaminglab.entity.utilisateur.Adresse;
import fr.gaminglab.entity.utilisateur.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 
 */
@Repository
public interface IDaoAdresse extends JpaRepository<Adresse, Integer> {

    /**
     * @param idUtilisateur
     * @return
     */
    public List<Adresse> findByJoueurIdUtilisateur(Integer idUtilisateur);

}