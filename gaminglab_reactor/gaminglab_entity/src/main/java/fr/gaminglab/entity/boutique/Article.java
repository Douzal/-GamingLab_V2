package fr.gaminglab.entity.boutique;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;
import fr.gaminglab.entity.jeu.Jeu;
import org.hibernate.annotations.Type;

/**
 * 
 */
@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idArticle", scope = Article.class)
public class Article implements Serializable {

    /**
     * Default constructor
     */
    public Article() {
    }

	public Article(String libelle, String description, String imageArticle, Double prix, Integer credit, Integer quantiteDispo, Double moyenneNote, Boolean estLivre, CategorieArticle categorieArticle, Set<NoteArticle> notesArticle, Set<ImageArticle> imagesArticle) {
		this.libelle = libelle;
		this.description = description;
		this.imageArticle = imageArticle;
		this.prix = prix;
		this.credit = credit;
		this.quantiteDispo = quantiteDispo;
		this.moyenneNote = moyenneNote;
		this.estLivre = estLivre;
		this.categorieArticle = categorieArticle;
		this.notesArticle = notesArticle;
		this.imagesArticle = imagesArticle;
	}

	/**
     * 
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idArticle;

    /**
     * 
     */
    @Column(nullable = false)
    private String libelle;

	/**
	 *
	 */
	@Column(nullable = false)
	@Type(type = "org.hibernate.type.TextType")
	private String description;

    /**
     * 
     */
    @Column(length = 150)
    private String imageArticle;

    /**
     * 
     */
    @Column(nullable = false, columnDefinition = "DECIMAL(10,2)")
    private Double prix;

    /**
     * 
     */
    @Column
    private Integer credit;

	/**
	 *
	 */
	@Column
	private Integer quantiteDispo;

	/**
	 *
	 */
	@Transient
	private Double moyenneNote;


	/**
	 *
	 */
	@Column(columnDefinition = "TINYINT(1)")
	private Boolean estLivre;

    /**
     * 
     */
    @OneToMany(mappedBy="article")
	@JsonIgnore
    private Set<LigneCommande> ligneCommandes;

    /**
     * 
     */
    @ManyToOne
    @JoinColumn(name="idCategorieArticle", nullable = false)
    private CategorieArticle categorieArticle;

    /**
     * 
     */
    @OneToMany(mappedBy="article")
    private Set<NoteArticle> notesArticle;

	/**
	 *
	 */
	@OneToMany(mappedBy="article")
	private Set<ImageArticle> imagesArticle;


	public static void calculMoyenneNote(Article article) {
		if (article.getNotesArticle().size() >= 1) {
			article.setMoyenneNote(article.getNotesArticle().stream().mapToDouble(NoteArticle::getNote).average().getAsDouble());
		} else {
			article.setMoyenneNote(0d);
		}
	}


	public Integer getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(Integer idArticle) {
		this.idArticle = idArticle;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getImageArticle() {
		return imageArticle;
	}

	public void setImageArticle(String imageArticle) {
		this.imageArticle = imageArticle;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public Integer getQuantiteDispo() {
		return quantiteDispo;
	}

	public void setQuantiteDispo(Integer quantiteDispo) {
		this.quantiteDispo = quantiteDispo;
	}

	public Double getMoyenneNote() {
		return moyenneNote;
	}

	public void setMoyenneNote(Double moyenneNote) {
		this.moyenneNote = moyenneNote;
	}

	public Set<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}

	public void setLigneCommandes(Set<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}

	public CategorieArticle getCategorieArticle() {
		return categorieArticle;
	}

	public void setCategorieArticle(CategorieArticle categorieArticle) {
		this.categorieArticle = categorieArticle;
	}

	public Set<NoteArticle> getNotesArticle() {
		return notesArticle;
	}

	public void setNotesArticle(Set<NoteArticle> notesArticle) {
		this.notesArticle = notesArticle;
	}

	public Set<ImageArticle> getImagesArticle() {
		return imagesArticle;
	}

	public void setImagesArticle(Set<ImageArticle> imagesArticle) {
		this.imagesArticle = imagesArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getEstLivre() {
		return estLivre;
	}

	public void setEstLivre(Boolean estLivre) {
		this.estLivre = estLivre;
	}
}