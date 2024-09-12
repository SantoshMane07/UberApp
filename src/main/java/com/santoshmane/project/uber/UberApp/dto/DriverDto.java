package com.santoshmane.project.uber.UberApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverDto {

    private Long id;

    private Long adharNo;

    private UserDto user;

    private Double rating;

    private Boolean available;

    private String vehicleId;

}
