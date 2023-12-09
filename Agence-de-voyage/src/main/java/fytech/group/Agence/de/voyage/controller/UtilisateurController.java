package fytech.group.Agence.de.voyage.controller;

import fytech.group.Agence.de.voyage.model.Utilisateur;
import fytech.group.Agence.de.voyage.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/listUtilisateur/{id}")
        public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable("id") Long id_utilisateur){
            Utilisateur utilisateur = utilisateurService.getUtilisateurById(id_utilisateur);
            if(utilisateur != null){
                return new ResponseEntity<>(utilisateur, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
    }

    @PostMapping("/ajouterUtilisateur")
        public Utilisateur ajouterUtilisateur(@RequestBody Utilisateur utilisateur){
            return utilisateurService.ajouterUtilisateur(utilisateur);
        }

    @DeleteMapping("/supprimerUtilisateur/{id}")
        public ResponseEntity<Void> supprimerUtilisateur(@PathVariable("id") Long id_utilisateur){
            utilisateurService.supprimerUtilisateur(id_utilisateur);
            return new ResponseEntity<>(HttpStatus.OK);
        }

    @PutMapping("/modifierUtilisateur/{id}")
        public ResponseEntity<Utilisateur> modifierUtilisateur(@PathVariable("id") Long id_utilisateur, @RequestBody Utilisateur utilisateur){
            Utilisateur utilisateur1 = utilisateurService.modifierUtilisateur(id_utilisateur, utilisateur);
            if(utilisateur1 != null){
                return new ResponseEntity<>(utilisateur1, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
}
