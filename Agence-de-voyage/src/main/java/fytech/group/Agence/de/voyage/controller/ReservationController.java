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
@RequestMapping("api/reservation")
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
        Utilisateur utilisateur = reservation.getUtilisateur();
        Destination destination = reservation.getDestination();
        if (utilisateur.getId_utilisateur() == null || destination.getId_destination() == null) {
            // Handle null ID appropriately
            // Here, we return an error response
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        String email = utilisateur.getEmail_utilisateur();
        String nom = utilisateur.getNom_utilisateur();
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

    @PutMapping("/updateReservation/{id}")
        public ResponseEntity<Reservation> updateReservation(@PathVariable(value = "id") Long id_reservation, @RequestBody Reservation reservationDetails) {
            try {
                Reservation existingReservation = reservationService.getReservationById(id_reservation);
                if (existingReservation != null) {
                    existingReservation.setUtilisateur(reservationDetails.getUtilisateur());
                    existingReservation.setDestination(reservationDetails.getDestination());
                    existingReservation.setDate_depart(reservationDetails.getDate_depart());
                    existingReservation.setDate_retour(reservationDetails.getDate_retour());
                    existingReservation.setNombre_personne(reservationDetails.getNombre_personne());
                    existingReservation.calculerPrixTotal();

                    Reservation updatedReservation = reservationService.updateReservation(existingReservation);
                    return new ResponseEntity<>(updatedReservation, HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }


//    @PostMapping("/rejeterReservation/{id}")
//    public ResponseEntity<Reservation> rejeterReservation(@PathVariable(value = "id") Long id_reservation) {
//        Reservation reservation = reservationService.rejeterReservation(id_reservation);
//        if (reservation != null) {
//            return new ResponseEntity<>(reservation, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

}