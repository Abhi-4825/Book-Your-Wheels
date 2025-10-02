package com.wheeler.app.controller;

import com.wheeler.app.model.vehicle;
import com.wheeler.app.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class vehicleController {
    private VehicleService service;
    public vehicleController(VehicleService service){
        this.service = service;
    }
    @PostMapping("insert")
    public void insertVehicle(@RequestBody vehicle vehicle) {
        service.insertVehicle(vehicle);
    }
    @GetMapping("getVehicles")
    public List<vehicle> getVehicles() {
        return service.findAllVehicles();
    }
}
