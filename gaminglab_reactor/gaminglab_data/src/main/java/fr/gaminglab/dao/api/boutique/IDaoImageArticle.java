package fr.gaminglab.dao.api.boutique;


import fr.gaminglab.entity.boutique.Article;
import fr.gaminglab.entity.boutique.ImageArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 
 */
@Repository
public interface IDaoImageArticle extends JpaRepository<ImageArticle, Integer> {

    /**
     * @param idArticle
     * @return
     */
    public List<ImageArticle> findByArticleIdArticle(Integer idArticle);

}