package com.example.cars.mvc.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Data;
@Data
@Entity
@Table(name="cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long id;
    @NotNull
    private String brand;
    @NotNull
    private String origin;
    @JsonIgnore
    @OneToMany(mappedBy = "car")
    private List<Thefts> thefts;
    @Transient
    private int totalThefts;

    public int getTotalThefts(){
        return thefts != null? thefts.size():0;
    }
}

