package fytech.group.Agence.de.voyage.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Reservation implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "id_reservation",
            updatable = true
    )
    private Long id_reservation;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_destination")
    private Destination destination;


    @Column(
            name = "date_depart",
            nullable = false
    )
    private Date date_depart;

    @Column(
            name = "date_retour",
            nullable = false
    )
    private Date date_retour;

    @Column(
            name = "nombre_personne",
            nullable = false
    )
    private Integer nombre_personne;

    @Column(
            name = "prix_total",
            nullable = false
    )
    private Double prix_total;


    public Reservation() {
    }

    public Reservation( Date date_depart, Date date_retour,Utilisateur utilisateur,
                        Destination destination, Integer nombre_personne) {
        this.utilisateur = utilisateur;
        this.destination = destination;
        this.date_depart = date_depart;
        this.date_retour = date_retour;
        this.nombre_personne = nombre_personne;
    }

    public void calculerPrixTotal() {
    	if (this.destination != null) {
    		this.prix_total = this.destination.getPrix_destination() * this.nombre_personne;
    	}
    }


    public Double getPrix_total() {
        return prix_total;
    }

    public void setPrix_total(Double prix_total) {
        this.prix_total = prix_total;
    }

    public Long getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(Long id_reservation) {
        this.id_reservation = id_reservation;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
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
        return "Reservation{" +
                "id_reservation=" + id_reservation +
                ", utilisateur=" + utilisateur +
                ", destination=" + destination +
                ", date_depart=" + date_depart +
                ", date_retour=" + date_retour +
                ", nombre_personne=" + nombre_personne +
                '}';
    }
}
