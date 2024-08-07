package com.santoshmane.project.uber.UberApp.strategies;

import com.santoshmane.project.uber.UberApp.dto.RideRequestDto;
import com.santoshmane.project.uber.UberApp.entities.RideRequest;

public interface RideFareCalculationStrategy {

    double RIDE_FARE_MULTIPLIER = 10.0;

    double calculateFare(RideRequest rideRequest);
}
