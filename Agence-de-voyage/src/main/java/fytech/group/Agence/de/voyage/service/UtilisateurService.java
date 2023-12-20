package fytech.group.Agence.de.voyage.service;

import fytech.group.Agence.de.voyage.excption.ResourceNotFoundException;
import fytech.group.Agence.de.voyage.model.Utilisateur;
import fytech.group.Agence.de.voyage.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@Service
public class UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur){
        return utilisateurRepository.save(utilisateur);
    }

    public List<Utilisateur> listUtilisateur() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur getUtilisateurById(Long id_utilisateur) {
        return utilisateurRepository.findById(id_utilisateur).orElse(null);
    }

    public void supprimerUtilisateur(Long idUtilisateur) {
        utilisateurRepository.deleteById(idUtilisateur);
    }

    public Utilisateur modifierUtilisateur(Long id_utilisateur, Utilisateur utilisateur) {
        Utilisateur utilisateur1 = utilisateurRepository.findById(id_utilisateur)
                .orElseThrow( () -> new ResourceNotFoundException("Utilisateur", "id", id_utilisateur));

        utilisateur1.setNom_utilisateur(utilisateur.getNom_utilisateur());
        utilisateur1.setEmail_utilisateur(utilisateur.getEmail_utilisateur());
        utilisateur1.setPassword_utilisateur(utilisateur.getPassword_utilisateur());
        utilisateur1.setRole_utilisateur(utilisateur.getRole_utilisateur());

        Utilisateur updateUtilsateur = utilisateurRepository.save(utilisateur1);
        return updateUtilsateur;
    }

    public boolean verifierUtilisateur(Utilisateur utilisateur) {
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        for (Utilisateur u : utilisateurs) {
            if (u.getNom_utilisateur().equals(utilisateur.getNom_utilisateur())
                    && u.getPassword_utilisateur().equals(utilisateur.getPassword_utilisateur())
                    && u.getRole_utilisateur().equals(utilisateur.getRole_utilisateur())) {
                return true;
            }

        }

        return false;
    }


}

