package fr.gaminglab.dao.api.communication;


import fr.gaminglab.entity.communication.CategorieForum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 */
@Repository
public interface IDaoCategorieForum extends JpaRepository<CategorieForum, Integer> {

}