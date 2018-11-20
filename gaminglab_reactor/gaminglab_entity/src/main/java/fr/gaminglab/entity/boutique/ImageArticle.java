package fr.gaminglab.entity.boutique;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@Table
public class ImageArticle implements Serializable {

    /**
     * Default constructor
     */
    public ImageArticle() {
    }

    public ImageArticle(String libelle, String image, Article article) {
        this.libelle = libelle;
        this.image = image;
        this.article = article;
    }

    /**
     * 
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idImageArticle;

    /**
     * 
     */
    @Column(length = 150)
    private String libelle;

    /**
     * 
     */
    @Column(nullable = false, length = 150)
    private String image;

    /**
     * 
     */
    @ManyToOne
    @JoinColumn(name="idArticle")
	@JsonIgnore
    private Article article;

	public Integer getIdImageArticle() {
		return idImageArticle;
	}

	public void setIdImageArticle(Integer paramIdImageArticle) {
		idImageArticle = paramIdImageArticle;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String paramLibelle) {
		libelle = paramLibelle;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String paramImage) {
		image = paramImage;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article paramArticle) {
		article = paramArticle;
	}
    
    

}