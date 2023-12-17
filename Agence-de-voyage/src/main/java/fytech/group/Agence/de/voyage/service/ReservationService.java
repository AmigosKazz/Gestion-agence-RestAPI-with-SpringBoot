package fytech.group.Agence.de.voyage.service;

import fytech.group.Agence.de.voyage.model.Reserve;
import fytech.group.Agence.de.voyage.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;


    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;

    }

    public List<Reserve> listeReservation() {
        return reservationRepository.findAll();
    }

    public Reserve getReservationById(Long id_reservation) {
        return reservationRepository.findById(id_reservation).orElse(null);
    }


    public void deleteReservation(Long id_reservation) {
        reservationRepository.deleteById(id_reservation);
    }


    public Reserve ajouterReservation(Reserve reserve) {
        return reservationRepository.save(reserve);
    }
}