package fr.gaminglab.dao.api.boutique;


import fr.gaminglab.entity.boutique.Commande;
import fr.gaminglab.entity.utilisateur.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 
 */
@Repository
public interface IDaoCommande extends JpaRepository<Commande, Integer> {

    /**
     * @param idUtilisateur
     * @return
     */
    public List<Commande> findByJoueurIdUtilisateurOrderByDateEnregistrementDesc(Integer idUtilisateur);

    /**
     * @param idUtilisateur
     * @return
     */
    public List<Commande> findByJoueurAndTermineeTrueOrderByDateEnregistrement(Integer idUtilisateur);

}