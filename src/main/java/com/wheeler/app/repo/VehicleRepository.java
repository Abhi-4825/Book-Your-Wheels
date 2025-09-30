package com.wheeler.app.repo;

import com.wheeler.app.model.vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<vehicle,Integer> {
    vehicle findVehicleById(int id);
}