//package com.example.cars.mvc.models;
//
//import lombok.Data;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//
//@Data
//@Entity
//@Table(name="thefts")
//public class Thefts {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//    @NotNull
//    private String state;
//    @NotNull
//    private int car_rank;
//    @NotNull
//    private String model;
//    private int year;
//    private int thefts_num;
//    @ManyToOne
//    @JoinColumn(name = "car_id")
//    private Car car;
//}



package com.example.cars.mvc.models;

import javax.persistence.*;

@Entity
@Table(name = "thefts")
public class Thefts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private int carRank;

    @Column(nullable = false)
    private String model;

    private int year;
    private int theftsNum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    // Getters and Setters
}
