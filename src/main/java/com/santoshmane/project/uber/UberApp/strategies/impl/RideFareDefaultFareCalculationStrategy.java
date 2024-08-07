package com.santoshmane.project.uber.UberApp.strategies.impl;

import com.santoshmane.project.uber.UberApp.dto.RideRequestDto;
import com.santoshmane.project.uber.UberApp.entities.RideRequest;
import com.santoshmane.project.uber.UberApp.services.DistanceService;
import com.santoshmane.project.uber.UberApp.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideFareDefaultFareCalculationStrategy implements RideFareCalculationStrategy {

    private final DistanceService distanceService;
    @Override
    public double calculateFare(RideRequest rideRequest) {
        Double distance = distanceService.calculateDistance(rideRequest.getPickupLocation(),rideRequest.getDropOffLocation());
        return distance*RIDE_FARE_MULTIPLIER;
    }
}
