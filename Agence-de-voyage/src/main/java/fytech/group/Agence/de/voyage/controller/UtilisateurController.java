package fytech.group.Agence.de.voyage.controller;

import fytech.group.Agence.de.voyage.model.Utilisateur;
import fytech.group.Agence.de.voyage.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/utilisateur")
public class UtilisateurController {
    private final UtilisateurService utilisateurService;

    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/listUtilisateur")
        public List<Utilisateur> listeUtilisateur(){
            return utilisateurService.listUtilisateur();
        }

    @PostMapping("/ajouterUtilisateur")
        public Utilisateur ajouterUtilisateur(@RequestBody Utilisateur utilisateur){
            return utilisateurService.ajouterUtilisateur(utilisateur);
        }


}
