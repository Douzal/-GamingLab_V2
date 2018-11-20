package fr.gaminglab.service.impl.boutique;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import fr.gaminglab.dao.api.boutique.IDaoArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gaminglab.dao.api.boutique.IDaoCategorieArticle;
import fr.gaminglab.dao.api.boutique.IDaoImageArticle;
import fr.gaminglab.dao.api.boutique.IDaoNote;
import fr.gaminglab.entity.boutique.Article;
import fr.gaminglab.entity.boutique.CategorieArticle;
import fr.gaminglab.entity.boutique.ImageArticle;
import fr.gaminglab.entity.boutique.NoteArticle;
import fr.gaminglab.service.api.boutique.IServiceCatalogue;

import javax.transaction.Transactional;

/**
 * 
 */
@Service
@Transactional
public class ServiceCatalogue implements IServiceCatalogue {

    /**
     * Default constructor
     */
    public ServiceCatalogue() {
    }

    /**
     *
     */
    @Autowired
    private IDaoArticle daoArticle;

    /**
     * 
     */
    @Autowired
    private IDaoImageArticle daoImageArticle;

    /**
     * 
     */
    @Autowired
    private IDaoCategorieArticle daoCategorieArticle;


    @Override
    public Article modifierArticle(Article article) {

        return daoArticle.save(article);
    }

    @Override
    public List<Article> getAllArticle() {
        List<Article> articles = daoArticle.findAll();
        for (Article article : articles) {
            Article.calculMoyenneNote(article);
        }
        return articles.stream().sorted(Comparator.comparing(Article::getMoyenneNote).reversed()).collect(Collectors.toList());
    }

    @Override
    public List<Article> getArticleByCategorie(Integer idCategorieArticle) {
        List<Article> articles = daoArticle.findByCategorieArticleIdCategorieArticle(idCategorieArticle);
        for (Article article : articles) {
            Article.calculMoyenneNote(article);
        }
        return articles.stream().sorted(Comparator.comparing(Article::getMoyenneNote).reversed()).collect(Collectors.toList());
    }

    @Override
    public Optional<Article> getArticleById(Integer idArticle) {

        return daoArticle.findById(idArticle);
    }

    @Override
    public List<Article> getArticleByLibelle(String libelle) {

        return daoArticle.findTop5ByLibelleStartingWith(libelle);
    }

    @Override
    public List<CategorieArticle> getAllCategorieArticle() {

        return daoCategorieArticle.findAll();
    }

    @Override
    public List<ImageArticle> getImageByArticle(Integer idArticle) {

        return daoImageArticle.findByArticleIdArticle(idArticle);
    }

    @Override
    public Optional<CategorieArticle> getCategorieArticleById(Integer idCategorieArticle) {

        return daoCategorieArticle.findById(idCategorieArticle);
    }


}