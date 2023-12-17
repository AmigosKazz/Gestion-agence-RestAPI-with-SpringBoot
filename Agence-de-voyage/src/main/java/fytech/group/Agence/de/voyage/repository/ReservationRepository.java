package fytech.group.Agence.de.voyage.repository;

import fytech.group.Agence.de.voyage.model.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reserve, Long> {
    
}
