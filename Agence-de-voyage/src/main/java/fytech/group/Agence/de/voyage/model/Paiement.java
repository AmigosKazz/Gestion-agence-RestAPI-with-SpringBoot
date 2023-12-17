package fytech.group.Agence.de.voyage.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Paiement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "id_paiement",
            updatable = false,
            nullable = false
    )
    private Long id_paiement;

    @Column(
            name = "numero_telephone",
            nullable = false
    )
    private String numero_telephone;
    @Column(
            name = "montant_paiement",
            nullable = false
    )
    private Double montant_paiement;


    public Paiement() {
    }

    public Paiement(String numero_telephone, Double montant_paiement) {
        this.numero_telephone = numero_telephone;
        this.montant_paiement = montant_paiement;
    }

    public Long getId_paiement() {
        return id_paiement;
    }

    public void setId_paiement(Long id_paiement) {
        this.id_paiement = id_paiement;
    }




    public String getNumero_telephone() {
        return numero_telephone;
    }

    public void setNumero_telephone(String numero_telephone) {
        this.numero_telephone = numero_telephone;
    }

    public Double getMontant_paiement() {
        return montant_paiement;
    }

    public void setMontant_paiement(Double montant_paiement) {
        this.montant_paiement = montant_paiement;
    }

    @Override
    public String toString() {
        return "Paiement{" +
                "id_paiement=" + id_paiement +
                ", numero_telephone='" + numero_telephone + '\'' +
                ", montant_paiement=" + montant_paiement +
                '}';
    }
}
