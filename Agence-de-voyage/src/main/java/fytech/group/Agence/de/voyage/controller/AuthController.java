package fytech.group.Agence.de.voyage.controller;

import fytech.group.Agence.de.voyage.model.Utilisateur;
import fytech.group.Agence.de.voyage.service.UtilisateurService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final UtilisateurService utilisateurService;
    private final HttpSession session;

    @Autowired
    public AuthController(UtilisateurService utilisateurService, HttpSession session) {
        this.utilisateurService = utilisateurService;
        this.session = session;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Utilisateur utilisateur) {
        Utilisateur existingUtilisateur = utilisateurService.getUtilisateurByUserName(utilisateur.getNom_utilisateur());
        if (existingUtilisateur != null && existingUtilisateur.getPassword_utilisateur().equals(utilisateur.getPassword_utilisateur())) {
            session.setAttribute("utilisateur", existingUtilisateur);
            return new ResponseEntity<>("Logged in successfully", HttpStatus.OK);
        } else {
            return  new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/utilisateur")
    public ResponseEntity<Utilisateur> getUtilsateur() {
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        if (utilisateur != null) {
            return new ResponseEntity<>(utilisateur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/agence")
    public ResponseEntity<String> agence() {
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        if (utilisateur != null && utilisateurService.hasPermission(utilisateur, "agence")) {
            return new ResponseEntity<>("Welcome to agence page", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("You don't have access to agence", HttpStatus.UNAUTHORIZED);
        }
    }

}
