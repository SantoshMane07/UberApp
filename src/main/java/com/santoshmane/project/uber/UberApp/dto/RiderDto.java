package com.santoshmane.project.uber.UberApp.dto;

import com.santoshmane.project.uber.UberApp.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RiderDto {

    private Long id;

    private Double rating;

    private UserDto user;
}
