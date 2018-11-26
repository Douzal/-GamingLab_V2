package fr.gaminglab.orchestrateur.controller.java;

import java.io.InputStream;
import java.util.Properties;

import org.springframework.web.client.RestTemplate;

import fr.gaminglab.dto.Recherche;

public class RechercheWebService {
	
	private static final String SLASH = "/";
	private RestTemplate restTemplate;
	private String base_url = null;
	
	public RechercheWebService() {
		restTemplate = new RestTemplate();
		try {
			Properties props = new Properties();
			InputStream is = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("ws_java_reactor.properties");
			props.load(is);
			is.close();
			this.base_url = props.getProperty("ws_java_reactor_recherche.base_url");
			System.out.println("RechercheJavaController -> base_url=" + base_url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * GET
	 * URL = /gaminglab/recherche/{motsCles}
	 * @param motsCles
	 * @return
	 */
    public Recherche recherche(String motsCles){
        return restTemplate.getForObject(base_url+SLASH+motsCles, Recherche.class);
    }

}
