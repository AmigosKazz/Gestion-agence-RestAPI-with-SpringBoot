package fytech.group.Agence.de.voyage.service;

import fytech.group.Agence.de.voyage.model.Utilisateur;
import fytech.group.Agence.de.voyage.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
