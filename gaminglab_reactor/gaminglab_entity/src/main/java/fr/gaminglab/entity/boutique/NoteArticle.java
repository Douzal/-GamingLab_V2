package fr.gaminglab.entity.boutique;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.*;
import fr.gaminglab.entity.utilisateur.Joueur;

/**
 * 
 */
@Entity
@Table
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idNoteArticle", scope = NoteArticle.class)
public class NoteArticle implements Serializable {

    /**
     * Default constructor
     */
    public NoteArticle() {
    }

    public NoteArticle(Integer note, Date dateNote, String contenu, Article article, Joueur joueur) {
        this.note = note;
        this.dateNote = dateNote;
        this.contenu = contenu;
        this.article = article;
        this.joueur = joueur;
    }

    /**
     * 
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idNoteArticle;

    /**
     * 
     */
    @Column(nullable = false)
    private Integer note;

    /**
     * 
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dateNote;

    /**
     * 
     */
    @Column(length = 255)
    private String contenu;

    /**
     * 
     */
    @ManyToOne
    @JoinColumn(name="idArticle", nullable = false)
    @JsonIgnore
    private Article article;

    /**
     * 
     */
    @ManyToOne
    @JoinColumn(name="idJoueur", nullable = false)
    private Joueur joueur;

    public Integer getIdNoteArticle() {
        return idNoteArticle;
    }

    public void setIdNoteArticle(Integer idNoteArticle) {
        this.idNoteArticle = idNoteArticle;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public Date getDateNote() {
        return dateNote;
    }

    public void setDateNote(Date dateNote) {
        this.dateNote = dateNote;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }
    
    
}