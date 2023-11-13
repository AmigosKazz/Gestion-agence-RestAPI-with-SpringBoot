package fytech.group.Agence.de.voyage.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Agence implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "id_agence",
            updatable = false,
            nullable = false
    )
    private Long id_agence;

    @Column(
            name = "nom_agence",
            nullable = false
    )
    private String nom_agence;

    @Column(
            name = "email_agence",
            nullable = false
    )
    private String email_agence;

    public Agence() {
    }

    public Agence(String nom_agence, String email_agence) {
        this.nom_agence = nom_agence;
        this.email_agence = email_agence;
    }

    public Long getId_agence() {
        return id_agence;
    }

    public void setId_agence(Long id_agence) {
        this.id_agence = id_agence;
    }

    public String getNom_agence() {
        return nom_agence;
    }

    public void setNom_agence(String nom_agence) {
        this.nom_agence = nom_agence;
    }

    public String getEmail_agence() {
        return email_agence;
    }

    public void setEmail_agence(String email_agence) {
        this.email_agence = email_agence;
    }

    @Override
    public String toString() {
        return "Agence{" +
                "id_agence=" + id_agence +
                ", nom_agence='" + nom_agence + '\'' +
                ", email_agence='" + email_agence + '\'' +
                '}';
    }
}
