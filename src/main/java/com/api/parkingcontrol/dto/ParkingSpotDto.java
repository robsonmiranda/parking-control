package com.api.parkingcontrol.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ParkingSpotDto {
    
    @NotBlank
    private String parkingSpotNumber;
    @NotBlank
    @Size(max = 7)
    private String carLicencePlate;
    @NotBlank
    @Size(max = 70)
    private String carBrand;
    @NotBlank
    @Size(max = 70)
    private String carModel;
    @NotBlank
    @Size(max = 70)
    private String carColor;
    @NotBlank
    @Size(max = 130)
    private String responsibleName;
    @NotBlank
    @Size(max = 30)
    private String apartment;
    @NotBlank
    @Size(max = 30)
    private String block;

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
