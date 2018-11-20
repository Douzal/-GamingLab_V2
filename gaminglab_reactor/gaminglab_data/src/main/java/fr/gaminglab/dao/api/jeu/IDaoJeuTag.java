package fr.gaminglab.dao.api.jeu;

import fr.gaminglab.entity.jeu.JeuTag;
import fr.gaminglab.entity.jeu.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 
 */
@Repository
public interface IDaoJeuTag extends JpaRepository<JeuTag, Integer> {

    /**
     * @param tag 
     * @return
     */
    public List<JeuTag> findByTag(Tag tag);

}