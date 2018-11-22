package fr.gaminglab.forum.data;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.gaminglab.forum.entity.CategorieForum;

/**
 * 
 */
@Repository
public interface IDaoCategorieForum extends JpaRepository<CategorieForum, Integer> {

}