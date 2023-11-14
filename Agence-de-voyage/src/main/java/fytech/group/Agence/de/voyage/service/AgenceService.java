package fytech.group.Agence.de.voyage.service;

import fytech.group.Agence.de.voyage.model.Agence;
import fytech.group.Agence.de.voyage.repository.AgenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenceService {
    private final AgenceRepository agenceRepository;

    @Autowired
    public AgenceService(AgenceRepository agenceRepository) {
        this.agenceRepository = agenceRepository;
    }

    public Agence ajouterAgence(Agence agence){
        return agenceRepository.save(agence);
    }

    public List<Agence> listeAgence() {
        return agenceRepository.findAll();
    }
}
