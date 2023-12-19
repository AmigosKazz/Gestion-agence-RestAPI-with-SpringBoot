package fytech.group.Agence.de.voyage.controller;

import fytech.group.Agence.de.voyage.model.Reserve;
import fytech.group.Agence.de.voyage.service.EmailService;
import fytech.group.Agence.de.voyage.service.ReservationService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reserve")
public class ReservationController {
    private final ReservationService reservationService;
    private final EmailService emailService;


    @Autowired
    public ReservationController(ReservationService reservationService, EmailService emailService) {
        this.reservationService = reservationService;
        this.emailService = emailService;
    }

    @GetMapping("/listeReservation")
    public List<Reserve> listeReservation() {
        return reservationService.listeReservation();
    }

    @GetMapping("/listeReservation/{id}")
    public ResponseEntity<Reserve> getReservationById(@PathVariable(value = "id") Long id_reservation) {
        Reserve reserve = reservationService.getReservationById(id_reservation);
        if (reserve != null) {
            return new ResponseEntity<>(reserve, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // recherche par id_client
    @GetMapping("/recherche/{destination}")
    public List<Reserve> getReservationByDestination(@PathVariable(value = "destination") String destination) {
        return reservationService.getReservationsByDestination(destination);
    }

    //ajout reserve
    @PostMapping("/ajouterReservation")
    public Reserve ajouterReservation(@RequestBody Reserve reserve) {
        return reservationService.ajouterReservation(reserve);
    }

    @DeleteMapping("/deleteReservation/{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable(value = "id") Long id_reservation) {
        reservationService.deleteReservation(id_reservation);
        return new ResponseEntity<>("Reservation deleted successfully", HttpStatus.OK);
    }

    @PostMapping("/confirmerReservation/{id}")
    public ResponseEntity<Void> confirmerReservation(@PathVariable(value = "id") Long id_reservation) {
        Reserve reserve = reservationService.getReservationById(id_reservation);
        if (reserve != null) {
            try {
                emailService.sendConfirmationEmail(reserve);
                reservationService.deleteReservation(id_reservation);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (MessagingException e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}