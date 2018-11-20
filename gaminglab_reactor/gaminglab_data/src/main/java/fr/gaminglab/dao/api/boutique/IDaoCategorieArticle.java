package fr.gaminglab.dao.api.boutique;

import fr.gaminglab.entity.boutique.CategorieArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * 
 */
@Repository
public interface IDaoCategorieArticle extends JpaRepository<CategorieArticle, Integer> {

}