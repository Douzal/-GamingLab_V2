package fr.gaminglab.dao.api.communication;

import fr.gaminglab.entity.communication.JoueurSujetForum;
import fr.gaminglab.entity.utilisateur.Joueur;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * 
 */
@Repository
public interface IDaoJoueurSujet extends JpaRepository<JoueurSujetForum, Integer> {

    /**
     * @param joueur 
     * @return
     */
    public boolean existsByJoueur(Joueur joueur);
    
    //coucou
    public List<JoueurSujetForum> findByJoueurAndSujetForum(Integer joueur, Integer sujetForum);   

}