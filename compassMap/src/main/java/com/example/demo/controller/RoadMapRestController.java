package com.example.demo.controller;


import com.example.demo.model.Customer;
import com.example.demo.model.RoadMap;
import com.example.demo.service.RoadMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/roadmaps")
public class RoadMapRestController {

    @Autowired
    private RoadMapService roadMapService;

    @PostMapping("/create")
    public RoadMap createRoadMap(@RequestBody RoadMap roadMap) {
        // to do
        RoadMap newRoadMap = roadMapService.createRoadMap(roadMap);
        System.out.println("Service createdRoadMap: " + newRoadMap);
        return newRoadMap;
        }

    @GetMapping("/all")
    public Iterable<RoadMap> getAll(){

        // call service to get all roadMaps and return them
        Iterable<RoadMap> roadMaps =  roadMapService.getAllRoadMaps();
        System.out.println("Service getAllRoadMaps: " + roadMaps);
        return roadMaps;
    }

    @DeleteMapping("/byId")
    public RoadMap deleteById(@RequestParam String id) {
        // to do
        RoadMap foundRoadMap = roadMapService.getRoadMapById(id);
        if (foundRoadMap == null) return null;
        else {
            roadMapService.deleteRoadMapById(id);
            return foundRoadMap;
        }

    }

    @PutMapping("/byId")
    public void updateById(RoadMap roadMap){
        // to do
        if (roadMap.getId() == null || roadMapService.getRoadMapById(roadMap.getId()) == null) {
            return null;
            }

        RoadMap updatedRoadMap = roadMapService.updateRoadMap(roadMap);
        System.out.println("Service updateRoadMap: " + updatedRoadMap);
            return updatedRoadMap;
        }
}



