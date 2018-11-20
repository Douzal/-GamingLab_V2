package fr.gaminglab.dao.api.utilisateur;

import fr.gaminglab.entity.utilisateur.Badge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 */
@Repository
public interface IDaoBadge extends JpaRepository<Badge, Integer> {

}