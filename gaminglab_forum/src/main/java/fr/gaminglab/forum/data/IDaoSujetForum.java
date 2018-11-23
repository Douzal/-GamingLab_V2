package fr.gaminglab.forum.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.gaminglab.forum.entity.CategorieForum;
import fr.gaminglab.forum.entity.SujetForum;

/**
 * 
 */
@Repository
public interface IDaoSujetForum extends JpaRepository<SujetForum, Integer> {

    /**
     * @param cat 
     * @return
     */
    public List<SujetForum> findByCategorieForum(CategorieForum cat);

    /**
     * @param libelle 
     * @return
     */
    public List<SujetForum> findTop5ByLibelleStartingWith(String libelle);

//    /**
//     * @param idUtilisateur
//     * @return
//     */
//    public List<SujetForum> findByJoueurIdUtilisateur(Integer idUtilisateur);
    //coucou
    /**
     * @param jeu
     * @return
     */
    public List<SujetForum> findByIdJoueurCreateur(Integer idJoueur);
    
}