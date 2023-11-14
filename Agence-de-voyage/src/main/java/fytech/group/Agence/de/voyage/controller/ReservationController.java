package fytech.group.Agence.de.voyage.controller;

import fytech.group.Agence.de.voyage.model.Reservation;
import fytech.group.Agence.de.voyage.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}