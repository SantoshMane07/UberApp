package com.santoshmane.project.uber.UberApp.services;

import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;


public interface DistanceService {
    double calculateDistance(Point src, Point dest);
}
