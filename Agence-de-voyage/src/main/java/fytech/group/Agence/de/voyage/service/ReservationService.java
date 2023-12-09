package fytech.group.Agence.de.voyage.service;

import fytech.group.Agence.de.voyage.model.Destination;
import fytech.group.Agence.de.voyage.model.Reservation;
import fytech.group.Agence.de.voyage.model.StatusReservation;
import fytech.group.Agence.de.voyage.model.Utilisateur;
import fytech.group.Agence.de.voyage.repository.DestinationRepository;
import fytech.group.Agence.de.voyage.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;


    @Autowired
    public ReservationService(ReservationRepository reservationRepository,
                              DestinationRepository destinationRepository) {
        this.reservationRepository = reservationRepository;
        this.destinationRepository = destinationRepository;
    }

    @Autowired
    private EmailService emailService;
    private final DestinationRepository destinationRepository;

    public List<Reservation> listeReservation() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(Long id_reservation) {
        return reservationRepository.findById(id_reservation).orElse(null);
    }

    public Reservation ajouterReservation(Reservation reservation, Utilisateur utilisateur, Long destinationId) {
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(Long id_reservation) {
        reservationRepository.deleteById(id_reservation);
    }



    public Reservation confirmerReservation(Long idReservation) {
        Reservation reservation = reservationRepository.findById(idReservation).orElse(null);
        if (reservation != null) {
            reservation.setStatus(StatusReservation.CONFIRMEE);

            //Sent email to the user
            String to = reservation.getUtilisateur().getEmail_utilisateur();
            String subject = "Confirmation de réservation";
            String content = "Votre réservation a été confirmée";
            try {
                emailService.sendConfirmationEmail(to, subject, content);
            } catch (Exception e) {
                System.out.println("Erreur d'envoi de mail");
            }

            return reservationRepository.save(reservation);
        } else {
            return null;
        }
    }

    public Reservation rejeterReservation(Long idReservation) {
        Reservation reservation = reservationRepository.findById(idReservation).orElse(null);
        if (reservation != null) {
            reservation.setStatus(StatusReservation.REJETEE);
            return reservationRepository.save(reservation);
        } else {
            return null;
        }
    }

}
