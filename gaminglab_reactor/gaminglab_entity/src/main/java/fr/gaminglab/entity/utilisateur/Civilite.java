package fr.gaminglab.entity.utilisateur;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

/**
 * 
 */
@Entity
@Table
public class Civilite implements Serializable {

    /**
     * Default constructor
     */
    public Civilite() {
    }

    public Civilite(String libelle) {
        this.libelle = libelle;
    }

    /**
     * 
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idCivilite;

    /**
     * 
     */
    @Column(nullable = false, length = 15)
    private String libelle;

    /**
     * 
     */
    @OneToMany(mappedBy="civilite")
    @JsonIgnore
    private Set<Utilisateur> utilisateurs;

    public Integer getIdCivilite() {
        return idCivilite;
    }

    public void setIdCivilite(Integer idCivilite) {
        this.idCivilite = idCivilite;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Set<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(Set<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }
}