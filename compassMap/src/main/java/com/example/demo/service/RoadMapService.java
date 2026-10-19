package com.example.demo.service;

import com.example.demo.repository.RoadMapRepository;
import com.example.demo.model.RoadMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoadMapService {

    // we are using here DEPENDENCE INJECTION
    @Autowired
    private RoadMapRepository roadMapRepository;

    public Iterable<RoadMap> getAllRoadMaps() {
        return roadMapRepository.findAll();
    }

    public RoadMap createRoadMap (RoadMap roadMap){
        // SET ID customer to UUID
        customer.setId(UUID.randomUUID().toString());

        // call repository to use SAVE operation to save data to h2 db
        RoadMap createdRoadMap = roadMapRepository.save(roadMap);
        System.out.println("Service created roadMap: " +  createdRoadMap);
        return createdRoadMap;
    }

    public void deleteCustomer (String id){
      customerRepository.deleteById(id);

    }

    public Customer getCustomerById(String id){

        Optional<Customer> foundCustomer = customerRepository.findById(id);

        return foundCustomer.get();
    }

    public void saveAll(ArrayList<Customer> customers) {
        customerRepository.saveAll(customers);
    }

    public void deleteAllCustomers() {
        customerRepository.deleteAll();
    }

    public long countRoadMaps() {
        return roadMapRepository.count();
    }

}