package fr.gaminglab.orchestrateur.controller.angular;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import fr.gaminglab.orchestrateur.controller.java.UploadWebService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/gaminglab")
public class UploadAngularController {


    UploadWebService wsUpload = new UploadWebService();

    @PostMapping("/file")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
    	return wsUpload.handleFileUpload(file);
    }

    @PostMapping("/image")
    public ResponseEntity<String> handleImageUpload(@RequestParam("image") MultipartFile file) {
        return wsUpload.handleImageUpload(file);
    }

    @GetMapping("/file")
    public ResponseEntity<List<String>> getListFiles(Model model) {
        return wsUpload.getListFiles(model);
    }

    @GetMapping("/file/{filename}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        return wsUpload.getFile(filename);
    }
}
