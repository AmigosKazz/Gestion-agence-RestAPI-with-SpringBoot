package fytech.group.Agence.de.voyage.controller;

import fytech.group.Agence.de.voyage.model.Destination;
import fytech.group.Agence.de.voyage.model.Reservation;
import fytech.group.Agence.de.voyage.model.Utilisateur;
import fytech.group.Agence.de.voyage.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/listeReservation")
    public List<Reservation> listeReservation() {
        return reservationService.listeReservation();
    }

    @GetMapping("/listeReservation/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable(value = "id") Long id_reservation) {
        Reservation reservation = reservationService.getReservationById(id_reservation);
        if (reservation != null) {
            return new ResponseEntity<>(reservation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addReservation")
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation) {
        try{
            String email = reservation.getUtilisateur().getEmail_utilisateur();
            String nom = reservation.getUtilisateur().getNom_utilisateur();

            Destination destination = reservation.getDestination();
            String nomDestination = destination.getNom_destination();
            Double prixDestinationValue = destination.getPrix_destination();
            double prixDestination = prixDestinationValue != null ? prixDestinationValue : 0.0;

            // Calculate prix_total
            double prixTotal = reservation.getNombre_personne() * prixDestination;
            reservation.setPrix_total(prixTotal);

            Reservation newReservation = reservationService.addReservation(reservation);
            return new ResponseEntity<>(newReservation, HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteReservation/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable(value = "id") Long id_reservation) {
        reservationService.deleteReservation(id_reservation);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //L'agence confirme ou rejette une demande de réservation.
    @PostMapping("/confirmerReservation/{id}")
    public ResponseEntity<Reservation> confirmerReservation(@PathVariable(value = "id") Long id_reservation) {
        Reservation reservation = reservationService.confirmerReservation(id_reservation);
        if (reservation != null) {
            return new ResponseEntity<>(reservation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/rejeterReservation/{id}")
    public ResponseEntity<Reservation> rejeterReservation(@PathVariable(value = "id") Long id_reservation) {
        Reservation reservation = reservationService.rejeterReservation(id_reservation);
        if (reservation != null) {
            return new ResponseEntity<>(reservation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}