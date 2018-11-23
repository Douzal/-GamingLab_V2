package fr.gaminglab.forum.data;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.gaminglab.forum.entity.CommentaireForum;
import fr.gaminglab.forum.entity.SujetForum;

/**
 * 
 */
@Repository
public interface IDaoCommentaireForum extends JpaRepository<CommentaireForum, Integer> {

    /**
     * @param sujet 
     * @return
     */
    public List<CommentaireForum> findBySujetForum(SujetForum sujet);

    public List<CommentaireForum> findByIdJoueur(Integer idUtilisateur);
    
    public List<CommentaireForum> findBySujetForumAndCommentaireSupNotNull(SujetForum sujet);
    public List<CommentaireForum> findByIdCommentaireAndCommentaireSupNull(Integer commentaire);
  
}