package com.santoshmane.project.uber.UberApp.entities;

import jakarta.persistence.*;
import lombok.*;
import org.locationtech.jts.geom.Point;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(indexes = {
        @Index(name = "idx_driver_vehicle_id", columnList = "vehicleId")
})
public class Driver {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private Long adharNo;

    private Double rating;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Boolean available;

    private String vehicleId;

    @Column(columnDefinition = "Geometry(Point,4326)")
    private Point currentLocation;
}
