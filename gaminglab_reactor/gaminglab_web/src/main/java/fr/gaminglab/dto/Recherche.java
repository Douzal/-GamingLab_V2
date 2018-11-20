package fr.gaminglab.dto;

import fr.gaminglab.entity.boutique.Article;
import fr.gaminglab.entity.communication.SujetForum;
import fr.gaminglab.entity.jeu.Jeu;
import fr.gaminglab.entity.jeu.Tag;
import fr.gaminglab.entity.utilisateur.Joueur;

import java.util.ArrayList;
import java.util.List;

public class Recherche {

    private List<Joueur> joueurs = new ArrayList<>();
    private List<Jeu> jeux = new ArrayList<>();
    private List<Article> articles = new ArrayList<>();
    private List<SujetForum> sujetForums = new ArrayList<>();

    public Recherche() {
    }

    public Recherche(List<Joueur> joueurs, List<Jeu> jeux, List<Article> articles, List<SujetForum> sujetForums) {
        this.joueurs = joueurs;
        this.jeux = jeux;
        this.articles = articles;
        this.sujetForums = sujetForums;
    }

    public List<Jeu> getJeux() {
        return jeux;
    }

    public void setJeux(List<Jeu> jeux) {
        this.jeux = jeux;
    }

    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<SujetForum> getSujetForums() {
        return sujetForums;
    }

    public void setSujetForums(List<SujetForum> sujetForums) {
        this.sujetForums = sujetForums;
    }
}
