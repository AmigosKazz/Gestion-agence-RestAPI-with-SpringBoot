package fytech.group.Agence.de.voyage.controller;

import fytech.group.Agence.de.voyage.model.Reservation;
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

    @PostMapping("/ajouterReservation")
    public ResponseEntity<Reservation> ajouterReservation(@RequestBody Reservation reservation) {
        Reservation newReservation = reservationService.ajouterReservation(reservation);
        return new ResponseEntity<>(newReservation, HttpStatus.CREATED);
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