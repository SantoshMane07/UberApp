package com.santoshmane.project.uber.UberApp.services;

import com.santoshmane.project.uber.UberApp.dto.DriverDto;
import com.santoshmane.project.uber.UberApp.dto.SignupDto;
import com.santoshmane.project.uber.UberApp.dto.UserDto;
import org.springframework.stereotype.Service;


public interface AuthService {
    String[] login(String email, String password);

    UserDto signup(SignupDto signupDto);

    DriverDto onboardNewDriver(Long userId,String vehicleId);

    String refreshToken(String refreshToken);
}
