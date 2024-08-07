package com.santoshmane.project.uber.UberApp.strategies;

import com.santoshmane.project.uber.UberApp.strategies.impl.DriverMatchingHighestRatedDriverStrategy;
import com.santoshmane.project.uber.UberApp.strategies.impl.DriverMatchingNearestDriverStrategy;
import com.santoshmane.project.uber.UberApp.strategies.impl.RideFareDefaultFareCalculationStrategy;
import com.santoshmane.project.uber.UberApp.strategies.impl.RideFareSurgePricingFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class RideStrategyManager {
    private final RideFareDefaultFareCalculationStrategy rideFareDefaultFareCalculationStrategy;
    private final RideFareSurgePricingFareCalculationStrategy rideFareSurgePricingFareCalculationStrategy;
    private final DriverMatchingNearestDriverStrategy driverMatchingNearestDriverStrategy;
    private final DriverMatchingHighestRatedDriverStrategy driverMatchingHighestRatedDriverStrategy;

    public DriverMatchingStrategy driverMatchingStrategy(double riderRating){
        if (riderRating>=4.8){
            return driverMatchingHighestRatedDriverStrategy;
        }else {
            return driverMatchingNearestDriverStrategy;
        }
    }

    public RideFareCalculationStrategy rideFareCalculationStrategy(){
        LocalTime surgeStartTime = LocalTime.of(10,0);
        LocalTime surgeEndTime = LocalTime.of(21,0);
        LocalTime currentTime = LocalTime.now();

        boolean isSurgeTime = currentTime.isAfter(surgeStartTime) && currentTime.isBefore(surgeEndTime);
        if (isSurgeTime){
            return rideFareSurgePricingFareCalculationStrategy;
        }else{
            return rideFareDefaultFareCalculationStrategy;
        }
    }

}
