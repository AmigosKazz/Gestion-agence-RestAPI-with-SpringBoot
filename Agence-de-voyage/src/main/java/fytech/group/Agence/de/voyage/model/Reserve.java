package fytech.group.Agence.de.voyage.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Reserve implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "id_reservation",
            updatable = false
    )
    private Long id_reservation;

    @Column(
            name ="nom_utilsateur"
    )
    private String nom_utilisateur;

    @Column(
            name = "email_utilisateur"
    )
    private String email_utilisateur;

    @Column(
            name = "destination"
    )
    private String destination;

    @Column(
            name = "date_depart"
    )
    private Date date_depart;

    @Column(
            name = "date_retour"
    )
    private Date date_retour;

    @Column(
            name = "nombre_personne"
    )
    private Integer nombre_personne;

    public Reserve(){}

    public Reserve(String nom_utilisateur, String email_utilisateur, String destination, Date date_depart, Date date_retour, Integer nombre_personne) {
        this.nom_utilisateur = nom_utilisateur;
        this.email_utilisateur = email_utilisateur;
        this.destination = destination;
        this.date_depart = date_depart;
        this.date_retour = date_retour;
        this.nombre_personne = nombre_personne;
    }

    public Long getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(Long id_reservation) {
        this.id_reservation = id_reservation;
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

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDate_depart() {
        return date_depart;
    }

    public void setDate_depart(Date date_depart) {
        this.date_depart = date_depart;
    }

    public Date getDate_retour() {
        return date_retour;
    }

    public void setDate_retour(Date date_retour) {
        this.date_retour = date_retour;
    }

    public Integer getNombre_personne() {
        return nombre_personne;
    }

    public void setNombre_personne(Integer nombre_personne) {
        this.nombre_personne = nombre_personne;
    }

    @Override
    public String toString() {
        return "Reserve{" +
                "id_reservation=" + id_reservation +
                ", nom_utilisateur='" + nom_utilisateur + '\'' +
                ", email_utilisateur='" + email_utilisateur + '\'' +
                ", destination='" + destination + '\'' +
                ", date_depart=" + date_depart +
                ", date_retour=" + date_retour +
                ", nombre_personne=" + nombre_personne +
                '}';
    }
}
