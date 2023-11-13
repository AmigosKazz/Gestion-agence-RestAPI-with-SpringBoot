package fytech.group.Agence.de.voyage.controller;

import fytech.group.Agence.de.voyage.model.Destination;
import fytech.group.Agence.de.voyage.repository.DestinationRepository;
import fytech.group.Agence.de.voyage.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/destination")
public class DestinationController {
    private final DestinationService destinationService;

    @Autowired
    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @GetMapping("/listeDestination")
    public List<Destination> listeDestination(){
        return destinationService.listeDestination();
    }

    @GetMapping("/listeDestination/{id}")
    public Destination getDestinationById(Long id){
        return destinationService.getDestinationById(id);
    }


}
