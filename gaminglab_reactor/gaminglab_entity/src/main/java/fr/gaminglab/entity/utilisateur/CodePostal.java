package fr.gaminglab.entity.utilisateur;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@Table
public class CodePostal implements Serializable{

    /**
     * Default constructor
     */
    public CodePostal() {
    }

    public CodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    /**
     * 
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idCodePostal;

    /**
     * 
     */
    @Column(nullable = false, length = 50)
    private String codePostal;

    /**
     * 
     */
    @OneToMany(mappedBy="codePostal")
    @JsonIgnore
    private Set<VilleCodePostal> villesCodePostal;


    public Integer getIdCodePostal() {
        return idCodePostal;
    }

    public void setIdCodePostal(Integer idCodePostal) {
        this.idCodePostal = idCodePostal;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public Set<VilleCodePostal> getVillesCodePostal() {
        return villesCodePostal;
    }

    public void setVillesCodePostal(Set<VilleCodePostal> villesCodePostal) {
        this.villesCodePostal = villesCodePostal;
    }

}