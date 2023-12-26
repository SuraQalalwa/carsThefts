package com.example.cars.mvc.repositories;

import com.example.cars.mvc.models.Thefts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheftsRepository extends CrudRepository<Thefts,Long> {
    List<Thefts> findByCarId(Long carId); //to find thefts by car_id

}




