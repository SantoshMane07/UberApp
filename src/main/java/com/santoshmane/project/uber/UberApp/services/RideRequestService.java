package com.santoshmane.project.uber.UberApp.services;

import com.santoshmane.project.uber.UberApp.entities.RideRequest;

public interface RideRequestService {
    RideRequest findRideRequestById(Long rideRequestId);
    void update(RideRequest rideRequest);

}
