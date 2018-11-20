package fr.gaminglab.service.api.boutique;

import fr.gaminglab.entity.boutique.Article;
import fr.gaminglab.entity.boutique.CategorieArticle;
import fr.gaminglab.entity.boutique.ImageArticle;
import fr.gaminglab.entity.boutique.NoteArticle;

import java.util.List;
import java.util.Optional;

/**
 * 
 */
public interface IServiceCatalogue {

    /**
     * @param article 
     * @return
     */
    public Article modifierArticle(Article article);

    /**
     * @return
     */
    public List<Article> getAllArticle();

    /**
     * @param idCategorieArticle
     * @return
     */
    public List<Article> getArticleByCategorie(Integer idCategorieArticle);

    /**
     * @param id 
     * @return
     */
    public Optional<Article> getArticleById(Integer id);

    /**
     * @param libelle 
     * @return
     */
    public List<Article> getArticleByLibelle(String libelle);

    /**
     * @return
     */
    public List<CategorieArticle> getAllCategorieArticle();

    /**
     * @param idArticle
     * @return
     */
    public List<ImageArticle> getImageByArticle(Integer idArticle);


    /**
     * @param idCategorieArticle
     * @return
     */
    public Optional<CategorieArticle> getCategorieArticleById(Integer idCategorieArticle);

}