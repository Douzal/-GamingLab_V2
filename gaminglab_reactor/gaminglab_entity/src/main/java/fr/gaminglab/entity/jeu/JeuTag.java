package fr.gaminglab.entity.jeu;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;

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
@Table(name = "Jeu_Tag")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idJeuTag", scope = JeuTag.class)
public class JeuTag implements Serializable {

    /**
     * Default constructor
     */
    public JeuTag() {
    }

    public JeuTag(Jeu jeu, Tag tag) {
        this.jeu = jeu;
        this.tag = tag;
    }

    /**
     * 
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idJeuTag;

    /**
     * 
     */
    @ManyToOne
    @JoinColumn(name="idJeu")
    @JsonIgnore
    private Jeu jeu;

    /**
     * 
     */
    @ManyToOne
    @JoinColumn(name="idTag")
    private Tag tag;

	public Integer getIdJeuTag() {
		return idJeuTag;
	}

	public void setIdJeuTag(Integer paramIdJeuTag) {
		idJeuTag = paramIdJeuTag;
	}

	public Jeu getJeu() {
		return jeu;
	}

	public void setJeu(Jeu paramJeu) {
		jeu = paramJeu;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag paramTag) {
		tag = paramTag;
	}
    
    

}