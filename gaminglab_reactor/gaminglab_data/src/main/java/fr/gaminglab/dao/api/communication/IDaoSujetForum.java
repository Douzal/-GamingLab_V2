package fr.gaminglab.dao.api.communication;

import fr.gaminglab.entity.communication.CategorieForum;
import fr.gaminglab.entity.communication.SujetForum;
import fr.gaminglab.entity.jeu.Jeu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    /**
     * @param idUtilisateur
     * @return
     */
    public List<SujetForum> findByJoueurIdUtilisateur(Integer idUtilisateur);

}