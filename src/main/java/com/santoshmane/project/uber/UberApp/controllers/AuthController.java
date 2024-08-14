package com.santoshmane.project.uber.UberApp.controllers;

import com.santoshmane.project.uber.UberApp.dto.DriverDto;
import com.santoshmane.project.uber.UberApp.dto.OnboardDriverDto;
import com.santoshmane.project.uber.UberApp.dto.SignupDto;
import com.santoshmane.project.uber.UberApp.dto.UserDto;
import com.santoshmane.project.uber.UberApp.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    ResponseEntity<UserDto> signUp(@RequestBody SignupDto signupDto) {
        return new ResponseEntity<>(authService.signup(signupDto), HttpStatus.CREATED);
    }

    @PostMapping("/onBoardNewDriver/{userId}")
    ResponseEntity<DriverDto> onBoardNewDriver(@PathVariable Long userId, @RequestBody OnboardDriverDto onboardDriverDto) {
        return new ResponseEntity<>(authService.onboardNewDriver(userId,
                onboardDriverDto.getVehicleId()), HttpStatus.CREATED);
    }
}
