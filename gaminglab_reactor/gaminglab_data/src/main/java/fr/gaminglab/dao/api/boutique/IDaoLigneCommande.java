package fr.gaminglab.dao.api.boutique;

import fr.gaminglab.entity.boutique.Commande;
import fr.gaminglab.entity.boutique.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 
 */
@Repository
public interface IDaoLigneCommande extends JpaRepository<LigneCommande, Integer> {

    /**
     * @param idCommande
     * @return
     */
    public List<LigneCommande> findByCommandeIdCommande(Integer idCommande);

}