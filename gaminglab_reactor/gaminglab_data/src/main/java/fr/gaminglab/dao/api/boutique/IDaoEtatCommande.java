package fr.gaminglab.dao.api.boutique;


import fr.gaminglab.entity.boutique.EtatCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 */
@Repository
public interface IDaoEtatCommande extends JpaRepository<EtatCommande, Integer> {

}