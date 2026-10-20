package com.example.demo.service;

import com.example.demo.model.RoadMap;
import com.example.demo.repository.RoadMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RoadMapService {

    @Autowired
    private RoadMapRepository roadMapRepository;

    // createRoadMap

    public RoadMap createRoadMap (RoadMap roadMap) {
        // SET ID roadMap to UUID
        roadMap.setId(UUID.randomUUID().toString());

        // call repository to use SAVE operation to save data to h2 db
        RoadMap createdRoadMap = roadMapRepository.save(roadMap);
        System.out.println("Service created roadMap: " + createdRoadMap);
        return createdRoadMap;
    }

    // getAllRoadMaps

    public Iterable<RoadMap> getAllRoadMaps() {
        return roadMapRepository.findAll();
    }

    // getRoadMapById

    public RoadMap getRoadMapById(String id) {

        Optional<RoadMap> foundRoadMap = roadMapRepository.findById(id);
        return foundRoadMap.orElse(null);
    }

    //deleteRoadMapById

    public void deleteRoadMapById (String id){
        roadMapRepository.deleteById(id);

    }

    // deleteAllRoadMaps

    public void deleteAllRoadMaps() {
        roadMapRepository.deleteAll();
    }

    // countRoadMaps

    public long countRoadMaps() {
        return roadMapRepository.count();
    }

    // updateRoadMap

    public RoadMap updateRoadMap(RoadMap incoming) {
        if (incoming.getId() == null) {
            return null;
        }
        RoadMap existing = getRoadMapById(incoming.getId());
        if (existing == null) {
            return null;
        }
        // merge only non-null fields from incoming (partial update semantics)
        if (incoming.getName() != null) {
            existing.setName(incoming.getName());
        }
        if (incoming.getDescription() != null) {
            existing.setDescription(incoming.getDescription());
        }
        if (incoming.getSteps() > 0) {
            existing.setSteps(incoming.getSteps());
        }
            existing.setCompleted(incoming.setCompleted());

        RoadMap updatedRoadMap = roadMapRepository.save(existing);
        System.out.println("Service updated roadMap: " + updatedRoadMap);
        return updatedRoadMap;
    }
}
