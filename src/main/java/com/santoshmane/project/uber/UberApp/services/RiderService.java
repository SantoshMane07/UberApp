package com.santoshmane.project.uber.UberApp.services;

import com.santoshmane.project.uber.UberApp.dto.DriverDto;
import com.santoshmane.project.uber.UberApp.dto.RideDto;
import com.santoshmane.project.uber.UberApp.dto.RideRequestDto;
import com.santoshmane.project.uber.UberApp.dto.RiderDto;
import com.santoshmane.project.uber.UberApp.entities.Rider;
import com.santoshmane.project.uber.UberApp.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RiderService {
    RideRequestDto requestRide(RideRequestDto rideRequestDto);

    RideDto cancelRide(Long rideId);

    DriverDto rateDriver(Long rideId, Integer rating);

    RiderDto getMyProfile();

    Page<RideDto> getAllMyRides(PageRequest pageRequest);

    Rider createNewRider(User user);

    Rider getCurrentRider();
}
