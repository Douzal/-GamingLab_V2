package fr.gaminglab.dao.api.boutique;


import fr.gaminglab.entity.boutique.Article;
import fr.gaminglab.entity.boutique.CategorieArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 
 */
@Repository
public interface IDaoArticle extends JpaRepository<Article, Integer> {

    /**
     * @param idCategorieArticle
     * @return
     */
    public List<Article> findByCategorieArticleIdCategorieArticle(Integer idCategorieArticle);

    /**
     * @param libelle 
     * @return
     */
    public List<Article> findTop5ByLibelleStartingWith(String libelle);

    /**
     * @param idCategorieArticle
     * @return
     */
    public List<Article> findByCategorieArticleIdCategorieArticleOrderByPrix(Integer idCategorieArticle);

}