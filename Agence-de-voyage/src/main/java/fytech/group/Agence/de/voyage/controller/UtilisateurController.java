package fytech.group.Agence.de.voyage.controller;

import fytech.group.Agence.de.voyage.model.Utilisateur;
import fytech.group.Agence.de.voyage.service.UtilisateurService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/utilisateur")
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

    @PostMapping("/login")
        public ResponseEntity<Utilisateur> login(@RequestBody Utilisateur utilisateur){
            Utilisateur utilisateur1 = utilisateurService.login(utilisateur.getNom_utilisateur(), utilisateur.getPassword_utilisateur());
            if(utilisateur1 != null){
                ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
                HttpSession session = attr.getRequest().getSession(true);
                session.setAttribute("utilisateur", utilisateur1);

                return new ResponseEntity<>(utilisateur1, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

    @PostMapping("/logout")
        public ResponseEntity<Void> logout(){
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession(true);
            session.removeAttribute("utilisateur");
            return new ResponseEntity<>(HttpStatus.OK);
        }
    @GetMapping("/agenceOnlyRoute")
    public ResponseEntity<Void> agenceOnlyRoute(){
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession(true);
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        if(utilisateur != null && utilisateur.getRole_utilisateur().equals("agence")){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

}
