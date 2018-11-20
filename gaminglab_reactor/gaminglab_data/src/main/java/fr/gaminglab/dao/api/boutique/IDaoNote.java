package fr.gaminglab.dao.api.boutique;

import fr.gaminglab.entity.boutique.Article;
import fr.gaminglab.entity.boutique.NoteArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 
 */
@Repository
public interface IDaoNote extends JpaRepository<NoteArticle, Integer> {

    /**
     * @param idArticle
     * @return
     */
    public List<NoteArticle> findByArticleIdArticleOrderByDateNote(Integer idArticle);

}