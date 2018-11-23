package fr.gaminglab.forum.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.gaminglab.forum.entity.JoueurSujetForum;
import fr.gaminglab.forum.entity.SujetForum;


/**
 * 
 */
@Repository
public interface IDaoJoueurSujet extends JpaRepository<JoueurSujetForum, Integer> {

    /**
     * @param joueur 
     * @return
     */
    public boolean existsByIdJoueur(Integer idJoueur);
    
    //Modif Chris
    public JoueurSujetForum findByIdJoueurAndSujetForum(Integer joueur, SujetForum sujetForum); 

}