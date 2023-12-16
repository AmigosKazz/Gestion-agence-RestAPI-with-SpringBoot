package fytech.group.Agence.de.voyage.controller;

import fytech.group.Agence.de.voyage.model.Destination;
import fytech.group.Agence.de.voyage.repository.DestinationRepository;
import fytech.group.Agence.de.voyage.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/destination")
public class DestinationController {
    private final DestinationService destinationService;

    @Autowired
    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @GetMapping("/listeDestination")
    public List<Destination> listeDestination() {
        return destinationService.listeDestination();
    }

    @GetMapping("/listeDestination/{id}")
    public ResponseEntity<Destination> getDestinationById(@PathVariable(value = "id") Long id_destination) {
        Destination destination = destinationService.getDestinationById(id_destination);
        if (destination != null) {
            return new ResponseEntity<>(destination, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/ajouterDestination")
    public Destination ajouterDestination(@RequestBody Destination destination) {
        return destinationService.ajouterDestination(destination);
    }

    @PutMapping("/modifierDestination/{id}")
    public ResponseEntity<Destination> updateDestination(@PathVariable(value = "id") Long id_destination, @RequestBody Destination destination) {
        Destination updatedDestination = destinationService.updateDestination(id_destination, destination);
        if (updatedDestination != null) {
            return new ResponseEntity<>(updatedDestination, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/supprimerDestination/{id}")
    public ResponseEntity<Void> supprimerDestination(@PathVariable("id") Long id_destination){
        destinationService.supprimerDestination(id_destination);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
