package fr.gaminglab.orchestrateur.controller.java;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

public class UploadWebService {

	private static final String FILE = "/file";
	private static final String IMAGE = "/image";
	private RestTemplate restTemplate;
	private String base_url = null;
	
	public UploadWebService() {
		restTemplate = new RestTemplate();
		try {
			Properties props = new Properties();
			InputStream is = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("ws_java_reactor.properties");
			props.load(is);
			is.close();
			this.base_url = props.getProperty("ws_java_reactor_upload.base_url");
			System.out.println("UploadJavaController -> base_url=" + base_url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * POST
	 * URL = /gaminglab/file
	 * @param file
	 * @return
	 */
    public ResponseEntity<String> handleFileUpload(MultipartFile file) {
        return restTemplate.postForEntity(base_url+FILE, file,String.class);
    }
    
    /**
     * POST
     * URL = /gaminglab/image
     * @param file
     * @return
     */
    public ResponseEntity<String> handleImageUpload(@RequestParam("image") MultipartFile file) {
    	return restTemplate.postForEntity(base_url+IMAGE, file, String.class);
    }

    /**
     * GET
     * URL = /gaminglab/file
     * @param model
     * @return
     */
    public ResponseEntity<List<String>> getListFiles(Model model) {
    	ResponseEntity<String[]> response = restTemplate.getForEntity(base_url+FILE, String[].class);
    	if(response.getBody().length > 0) {
    		List<String> listString = Arrays.asList(response.getBody());
        	return ResponseEntity.ok().body(listString);
    	}
    	else {
    		return ResponseEntity.notFound().build();
    	}
    	
    }

    /**
     * GET
     * URL = /gaminglab/file/{filename}
     * @param filename
     * @return
     */
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
    	return restTemplate.getForEntity(base_url+FILE, Resource.class);
    }
}
