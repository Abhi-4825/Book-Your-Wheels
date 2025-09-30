package com.wheeler.app.service;

import com.wheeler.app.model.vehicle;
import com.wheeler.app.repo.VehicleRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class service {
    private VehicleRepository VehicleRepository;
    public service(VehicleRepository VehicleRepository) {
        this.VehicleRepository = VehicleRepository;
    }
    public void insertVehicle(vehicle vehicle) {
        VehicleRepository.save(vehicle);
    }
    public void  deleteVehicle(vehicle vehicle) {
        VehicleRepository.delete(vehicle);
    }
    public List<vehicle> findAllVehicles() {
        return VehicleRepository.findAll();
    }
    public vehicle findVehicleById(int id) {
        return VehicleRepository.findVehicleById(id);
    }
}
