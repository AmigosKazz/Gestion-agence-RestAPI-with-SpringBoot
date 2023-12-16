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

    public Destination ajouterDestination(Destination destination){
        return destinationRepository.save(destination);
    }

    public Destination updateDestination(Long id_destination, Destination updateDestination) {
        Destination destination = destinationRepository.findById(id_destination).orElse(null);
        if (destination != null) {
            destination.setNom_destination(updateDestination.getNom_destination());
            destination.setPrix_destination(updateDestination.getPrix_destination());

            return destinationRepository.save(destination);
        }

        return null;
    }

}
