package fytech.group.Agence.de.voyage.model;

import jakarta.persistence.*;

import javax.management.relation.Role;
import java.io.Serializable;

@Entity
public class Utilisateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "id_utilisateur",
            updatable = false,
            nullable = false
    )
    private Long id_utilisateur;

    @Column(
            name = "nom_utilisateur",
            nullable = false
    )
    private String nom_utilisateur;

    @Column(
            name = "email_utilisateur",
            nullable = false
    )
    private String email_utilisateur;

    @Column(
            name = "password_utilisateur",
            nullable = false
    )
    private String password_utilisateur;

    @Column(
            name = "role_utilisateur",
            nullable = false
    )
    private Role role_utilisateur;


    public Utilisateur() {
    }

    public Utilisateur(String nom_utilisateur, String email_utilisateur, String password_utilisateur, Role role_utilisateur) {
        this.nom_utilisateur = nom_utilisateur;
        this.email_utilisateur = email_utilisateur;
        this.password_utilisateur = password_utilisateur;
        this.role_utilisateur = role_utilisateur;
    }

    public Long getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(Long id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public String getNom_utilisateur() {
        return nom_utilisateur;
    }

    public void setNom_utilisateur(String nom_utilisateur) {
        this.nom_utilisateur = nom_utilisateur;
    }

    public String getEmail_utilisateur() {
        return email_utilisateur;
    }

    public void setEmail_utilisateur(String email_utilisateur) {
        this.email_utilisateur = email_utilisateur;
    }

    public String getPassword_utilisateur() {
        return password_utilisateur;
    }

    public void setPassword_utilisateur(String password_utilisateur) {
        this.password_utilisateur = password_utilisateur;
    }

    public Role getRole_utilisateur() {
        return role_utilisateur;
    }

    public void setRole_utilisateur(Role role_utilisateur) {
        this.role_utilisateur = role_utilisateur;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id_utilisateur=" + id_utilisateur +
                ", nom_utilisateur='" + nom_utilisateur + '\'' +
                ", email_utilisateur='" + email_utilisateur + '\'' +
                ", password_utilisateur='" + password_utilisateur + '\'' +
                ", role_utilisateur=" + role_utilisateur +
                '}';
    }
}
