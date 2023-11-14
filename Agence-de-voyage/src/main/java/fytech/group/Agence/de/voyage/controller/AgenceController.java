package fytech.group.Agence.de.voyage.controller;

import fytech.group.Agence.de.voyage.model.Agence;
import fytech.group.Agence.de.voyage.service.AgenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agence")
public class AgenceController {
    private final AgenceService agenceService;

    @Autowired
    public AgenceController(AgenceService agenceService) {
        this.agenceService = agenceService;
    }

    @PostMapping("/ajouterAgence")
    public ResponseEntity<Agence> ajouterAgence(@RequestBody Agence agence) {
        Agence newAgence = agenceService.ajouterAgence(agence);
        return new ResponseEntity<>(newAgence, org.springframework.http.HttpStatus.CREATED);
    }

    @GetMapping("/listeAgence")
    public List<Agence> listeAgence() {
        return agenceService.listeAgence();
    }

}
