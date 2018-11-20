package fr.gaminglab.entity.boutique;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import fr.gaminglab.entity.jeu.Jeu;

/**
 * 
 */
@Entity
@Table
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idArticle", scope = Article.class)
public class Livre extends Article implements Serializable {

    /**
     * Default constructor
     */
    public Livre() {
    }

    public Livre(String libelle, String description, String imageArticle, Double prix, Integer credit, Integer quantiteDispo, Double moyenneNote, Boolean estLivre, CategorieArticle categorieArticle, Set<NoteArticle> notesArticle, Set<ImageArticle> imagesArticle, String auteur, String editeur, String collection, Integer nbPages, Integer prixNum, Date dateParution) {
        super(libelle, description, imageArticle, prix, credit, quantiteDispo, moyenneNote, estLivre, categorieArticle, notesArticle, imagesArticle);
        this.auteur = auteur;
        this.editeur = editeur;
        this.collection = collection;
        this.nbPages = nbPages;
        this.prixNum = prixNum;
        this.dateParution = dateParution;
    }

    @Column(nullable = false)
    private String auteur;

    @Column(nullable = false)
    private String editeur;

    @Column(nullable = false)
    private String collection;

    @Column(nullable = false)
    private Integer nbPages;

    @Column
    private Integer prixNum;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dateParution;

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public Integer getNbPages() {
        return nbPages;
    }

    public void setNbPages(Integer nbPages) {
        this.nbPages = nbPages;
    }

    public Integer getPrixNum() {
        return prixNum;
    }

    public void setPrixNum(Integer prixNum) {
        this.prixNum = prixNum;
    }

    public Date getDateParution() {
        return dateParution;
    }

    public void setDateParution(Date dateParution) {
        this.dateParution = dateParution;
    }
}