package com.santoshmane.project.uber.UberApp.services;

import com.santoshmane.project.uber.UberApp.dto.DriverDto;
import com.santoshmane.project.uber.UberApp.dto.RideDto;
import com.santoshmane.project.uber.UberApp.dto.RiderDto;
import com.santoshmane.project.uber.UberApp.entities.Driver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DriverService {

    RideDto acceptRide(Long rideRequestId);

    RideDto cancelRide(Long rideId);

    RideDto startRide(Long rideId, String otp);

    RideDto endRide(Long rideId);

    RiderDto rateRider(Long rideId, Integer rating);

    DriverDto getMyProfile();

    Page<RideDto> getAllMyRides(PageRequest pageRequest);

    Driver getCurrentDriver();

    Driver updateDriverAvailability(Driver driver,boolean available);

    Driver createNewDriver(Driver driver);

}
