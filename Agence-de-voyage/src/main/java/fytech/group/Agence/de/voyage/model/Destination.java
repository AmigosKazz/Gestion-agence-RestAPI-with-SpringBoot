package fytech.group.Agence.de.voyage.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Destination implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "id_destination",
            updatable = false,
            nullable = false
    )
    private Long id_destination;

    @Column(
            name = "nom_destination",
            nullable = false
    )
    private String nom_destination;

    @Column(
            name = "prix_destination",
            nullable = false
    )
    private Double prix_destination;


    public Destination() {
    }

    public Destination(String nom_destination, Double prix_destination) {
        this.nom_destination = nom_destination;
        this.prix_destination = prix_destination;
    }

    public Long getId_destination() {
        return id_destination;
    }

    public void setId_destination(Long id_destination) {
        this.id_destination = id_destination;
    }

    public String getNom_destination() {
        return nom_destination;
    }

    public void setNom_destination(String nom_destination) {
        this.nom_destination = nom_destination;
    }

    public Double getPrix_destination() {
        return prix_destination;
    }

    public void setPrix_destination(Double prix_destination) {
        this.prix_destination = prix_destination;
    }

    @Override
    public String toString() {
        return "Destination{" +
                "id_destination=" + id_destination +
                ", nom_destination='" + nom_destination + '\'' +
                ", prix_destination=" + prix_destination +
                '}';
    }
}
