package com.api.parkingcontrol.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.api.parkingcontrol.dto.ParkingSpotDto;
import com.api.parkingcontrol.model.ParkingSpotModel;
import com.api.parkingcontrol.service.ParkingSpotService;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
public class ParkingSpotController {
    
    final ParkingSpotService parkingSpotService;

    public ParkingSpotController(ParkingSpotService parkingSpotService) {
        this.parkingSpotService = parkingSpotService;
    }

    @PostMapping
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto) {
        if (parkingSpotService.existsByCarLicencePlate(parkingSpotDto.getCarLicencePlate())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Car Licence Plate is already in use");
        }
        if (parkingSpotService.existsByParkingSpotNumber(parkingSpotDto.getParkingSpotNumber())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot is already in use!");
        }
        if (parkingSpotService.existsByApartmentAndBlock(parkingSpotDto.getApartment(), parkingSpotDto.getBlock())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot already registred for this apartment/block");
        }
        ParkingSpotModel parkingSpotModel = new ParkingSpotModel();
        BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);
        parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModel));
    }

    @GetMapping
    public ResponseEntity<List<ParkingSpotModel>> getAllParkingSpots() {
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneParkingSpot(@PathVariable(value = "id") UUID id) {
        Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
        if (parkingSpotModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(parkingSpotModelOptional.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteParkingSpot(@PathVariable(value = "id") UUID id) {
        Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
        if (parkingSpotModelOptional.isPresent()) {
            parkingSpotService.delete(parkingSpotModelOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body("Parking Spot deleted successfully.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateParkingSpot(@PathVariable(value = "id") UUID id, @RequestBody @Valid ParkingSpotDto parkingSpotDto) {
        Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
        if (parkingSpotModelOptional.isPresent()) {
            ParkingSpotModel parkingSpotModel = parkingSpotModelOptional.get();
            parkingSpotModel.setParkingSpotNumber(parkingSpotDto.getParkingSpotNumber());
            parkingSpotModel.setCarLicencePlate(parkingSpotDto.getCarLicencePlate());
            parkingSpotModel.setCarBrand(parkingSpotDto.getCarBrand());
            parkingSpotModel.setCarModel(parkingSpotDto.getCarModel());
            parkingSpotModel.setCarColor(parkingSpotDto.getCarColor());
            parkingSpotModel.setResponsibleName(parkingSpotDto.getResponsibleName());
            parkingSpotModel.setApartment(parkingSpotDto.getApartment());
            parkingSpotModel.setBlock(parkingSpotDto.getBlock());
            return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.save(parkingSpotModel));

            /**
            ParkingSpotModel parkingSpotModel = new ParkingSpotModel();
            BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);
            parkingSpotModel.setId(parkingSpotModelOptional.get().getId());
            parkingSpotModel.setRegistrationDate(parkingSpotModelOptional.get().getRegistrationDate());
            return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.save(parkingSpotModel));
             */
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found");
    }
} 
