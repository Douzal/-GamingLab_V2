package fr.gaminglab.dao.api.utilisateur;

import fr.gaminglab.entity.utilisateur.TypeCarte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 */
@Repository
public interface IDaoTypeCarte extends JpaRepository<TypeCarte, Integer> {

}