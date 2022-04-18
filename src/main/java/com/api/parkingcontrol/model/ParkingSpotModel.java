package com.api.parkingcontrol.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_parking_spot")
public class ParkingSpotModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "parking_spot_number", nullable = false, unique = true, length = 10)
    private String parkingSpotNumber;
    @Column(name = "car_licence_plate", nullable = false, unique = true, length = 7)
    private String carLicencePlate;
    @Column(name = "car_brand", nullable = false, length = 70)
    private String carBrand;
    @Column(name = "car_model", nullable = false, length = 70)
    private String carModel;
    @Column(name = "car_color", nullable = false, length = 70)
    private String carColor;
    @Column(name = "registration_date", nullable = false)
    private LocalDateTime registrationDate;
    @Column(name = "responsible_name", nullable = false, length = 130)
    private String responsibleName;
    @Column(name = "apartment", nullable = false, length = 30)
    private String apartment;
    @Column(name = "block", nullable = false, length = 30)
    private String block;

    public UUID getId() {
        return id;
    }
    
    public void setId(UUID id) {
        this.id = id;
    }
    
    public String getParkingSpotNumber() {
        return parkingSpotNumber;
    }
    
    public void setParkingSpotNumber(String parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
    }
    
    public String getCarLicencePlate() {
        return carLicencePlate;
    }
    
    public void setCarLicencePlate(String carLicencePlate) {
        this.carLicencePlate = carLicencePlate;
    }
    
    public String getCarBrand() {
        return carBrand;
    }
    
    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }
    
    public String getCarModel() {
        return carModel;
    }
    
    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }
    
    public String getCarColor() {
        return carColor;
    }
    
    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }
    
    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }
    
    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
    
    public String getResponsibleName() {
        return responsibleName;
    }
    
    public void setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
    }
    
    public String getApartment() {
        return apartment;
    }
    
    public void setApartment(String apartment) {
        this.apartment = apartment;
    }
    
    public String getBlock() {
        return block;
    }
    
    public void setBlock(String block) {
        this.block = block;
    }
}
