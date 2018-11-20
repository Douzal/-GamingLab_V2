package fr.gaminglab.dao.api.utilisateur;

import fr.gaminglab.entity.utilisateur.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 
 */
@Repository
public interface IDaoVille extends JpaRepository<Ville, Integer> {

    /**
     * @param libelle 
     * @return
     */
    public List<Ville> findByNomVille(String libelle);

}