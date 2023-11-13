package fytech.group.Agence.de.voyage.service;

import fytech.group.Agence.de.voyage.model.Destination;
import fytech.group.Agence.de.voyage.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationService {

    private final DestinationRepository destinationRepository;

    @Autowired
    public DestinationService(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    public List<Destination> listeDestination(){
        return destinationRepository.findAll();
    }

    public Destination getDestinationById(Long id) {
        return destinationRepository.findById(id).orElse(null);
    }
}
