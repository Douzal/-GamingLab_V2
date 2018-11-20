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
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idLigneCommande", scope = LigneCommande.class)
public class LigneCommande implements Serializable {

    /**
     * Default constructor
     */
    public LigneCommande() {
    }

    public LigneCommande(Integer quantite, Article article, Commande commande) {
        this.quantite = quantite;
        this.article = article;
        this.commande = commande;
    }

    /**
     * 
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idLigneCommande;

    /**
     * 
     */
    @Column(nullable = false)
    private Integer quantite;

    /**
     * 
     */
    @ManyToOne
    @JoinColumn(name="idArticle", nullable = false)
    private Article article;

    /**
     * 
     */
    @ManyToOne
    @JoinColumn(name="idCommande", nullable = false)
	@JsonIgnore
    public Commande commande;

	public Integer getIdLigneCommande() {
		return idLigneCommande;
	}

	public void setIdLigneCommande(Integer paramIdLigneCommande) {
		idLigneCommande = paramIdLigneCommande;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer paramQuantite) {
		quantite = paramQuantite;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article paramArticle) {
		article = paramArticle;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande paramCommande) {
		commande = paramCommande;
	}
    
    

}