package fr.gaminglab.dao.api.utilisateur;

import fr.gaminglab.entity.utilisateur.Civilite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 */
@Repository
public interface IDaoCivilite extends JpaRepository<Civilite, Integer> {

}