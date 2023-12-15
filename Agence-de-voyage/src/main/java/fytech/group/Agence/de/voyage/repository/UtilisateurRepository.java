package fytech.group.Agence.de.voyage.repository;

import fytech.group.Agence.de.voyage.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findUtilisateurByNomUtilisateurAndPasswordUtilisateur(String nomUtilisateur, String passwordUtilisateur);
}