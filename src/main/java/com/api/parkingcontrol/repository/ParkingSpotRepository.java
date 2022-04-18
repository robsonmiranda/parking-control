package com.api.parkingcontrol.repository;

import java.util.UUID;

import com.api.parkingcontrol.model.ParkingSpotModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID> {
    
    boolean existsByCarLicencePlate(String carLicencePlate);
    boolean existsByParkingSpotNumber(String parkingSpotNumber);
    boolean existsByApartmentAndBlock(String apartment, String block);
}
