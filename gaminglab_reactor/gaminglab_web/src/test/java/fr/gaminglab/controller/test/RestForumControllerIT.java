package fr.gaminglab.controller.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import fr.gaminglab.entity.communication.CommentaireForum;
import fr.gaminglab.entity.communication.SujetForum;

public class RestForumControllerIT {
	private static RestTemplate restTemplate;
	private static final String BASE_URL="http://localhost:8181/gaminglab";
	
	@BeforeClass
	public static void init() {
		restTemplate = new RestTemplate();
	}
	
	//@Test
	public void testGetAllSujetForum() {
		String url=BASE_URL + "/forum/sujets";		
		String listeSujetAsJsonString = restTemplate.getForObject(url, String.class);		
		System.out.println("listeSujetAsJsonString= " + listeSujetAsJsonString);		
		SujetForum[] tabSujetForum = restTemplate.getForObject(url, SujetForum[].class);
		Assert.assertNotNull(tabSujetForum);
		for(SujetForum b : tabSujetForum) {
			System.out.println("\t" + b.toString());
		}
	}
	
	@Test
	public void testAllCommentaireBySujet() {
		String url=BASE_URL + "/forum/categorieSujet/1";
		String listeCommentaireAsJsonString = restTemplate.getForObject(url, String.class);		
		System.out.println("listeCommentaireAsJsonString= " + listeCommentaireAsJsonString);
		CommentaireForum[] tabCommentaireForum = restTemplate.getForObject(url, CommentaireForum[].class);
		Assert.assertNotNull(tabCommentaireForum);
		for(CommentaireForum b : tabCommentaireForum) {
			System.out.println("\t" + b.toString());
		}
	}
}
