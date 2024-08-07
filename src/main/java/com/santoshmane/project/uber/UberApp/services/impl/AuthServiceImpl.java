package com.santoshmane.project.uber.UberApp.services.impl;

import com.santoshmane.project.uber.UberApp.dto.DriverDto;
import com.santoshmane.project.uber.UberApp.dto.SignupDto;
import com.santoshmane.project.uber.UberApp.dto.UserDto;
import com.santoshmane.project.uber.UberApp.entities.User;
import com.santoshmane.project.uber.UberApp.entities.enums.Role;
import com.santoshmane.project.uber.UberApp.exceptions.RunTimeConflictException;
import com.santoshmane.project.uber.UberApp.repositories.UserRepository;
import com.santoshmane.project.uber.UberApp.services.AuthService;
import com.santoshmane.project.uber.UberApp.services.RiderService;
import com.santoshmane.project.uber.UberApp.services.WalletService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final ModelMapper modelMapper;

    private final UserRepository userRepository;

    private final RiderService riderService;

    private final WalletService walletService;

    @Override
    public String login(String email, String password) {
        return "";
    }

    @Override
    @Transactional
    public UserDto signup(SignupDto signupDto) {

        //Check if email is already registered with app
        User user = userRepository.findByEmail(signupDto.getEmail()).orElse(null);
        if(user!=null){
           throw new RunTimeConflictException("Cannot signUp User already exists with email "+signupDto.getEmail());
        }

        User mappedUser = modelMapper.map(signupDto,User.class);
        mappedUser.setRoles(Set.of(Role.RIDER));
        User savedUser = userRepository.save(mappedUser);

        //Create user related entities
        riderService.createNewRider(savedUser);

        walletService.createNewWallet(savedUser);

        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public DriverDto onboardNewDriver(Long userId) {
        return null;
    }
}
