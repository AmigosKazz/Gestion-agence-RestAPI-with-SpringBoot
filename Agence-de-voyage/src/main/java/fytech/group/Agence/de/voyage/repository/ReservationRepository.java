package fytech.group.Agence.de.voyage.repository;

import fytech.group.Agence.de.voyage.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    
}
