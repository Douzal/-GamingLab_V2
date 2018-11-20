package fr.gaminglab.dao.api.jeu;

import fr.gaminglab.entity.jeu.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 
 */
@Repository
public interface IDaoTag extends JpaRepository<Tag, Integer> {

    /**
     * @param libelle
     * @return
     */
    public List<Tag> findTop5ByLibelleStartingWith(String libelle);

}