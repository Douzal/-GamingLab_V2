package fr.gaminglab.dao.api.utilisateur;

import fr.gaminglab.entity.utilisateur.CodePostal;
import fr.gaminglab.entity.utilisateur.Ville;
import fr.gaminglab.entity.utilisateur.VilleCodePostal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 
 */
@Repository
public interface IDaoVilleCodePostal extends JpaRepository<VilleCodePostal, Integer> {

    /**
     * @param ville 
     * @return
     */
    public List<VilleCodePostal> findByVille(Ville ville);

    /**
     * @param cp 
     * @return
     */
    public List<VilleCodePostal> findByCodePostal(CodePostal cp);

}