package fr.gaminglab.orchestrateur.controller.angular;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.gaminglab.dto.Recherche;
import fr.gaminglab.orchestrateur.controller.java.RechercheWebService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/gaminglab/recherche")
public class RechercheAngularController {
	
	RechercheWebService wsRecherche = new RechercheWebService();

	@GetMapping("/{motsCles}")
    public Recherche recherche(@PathVariable String motsCles){
        return wsRecherche.recherche(motsCles);
    }
}
