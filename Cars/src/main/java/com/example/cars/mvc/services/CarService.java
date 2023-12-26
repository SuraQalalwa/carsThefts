package com.example.cars.mvc.services;

import com.example.cars.mvc.models.Car;
import com.example.cars.mvc.models.Thefts;
import com.example.cars.mvc.repositories.CarRepository;
import com.example.cars.mvc.repositories.TheftsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CarService {
    private final CarRepository carRepository; //related to dependency injection
    private final TheftsRepository theftsRepository;


    public CarService(CarRepository carRepository, TheftsRepository theftsRepository) { //here we inject the service dependency in repository dependency
        this.carRepository = carRepository;
        this.theftsRepository = theftsRepository;
    }
    public List<Car> allCars(){
        return carRepository.findAll();
    }
    public Car findCarOrigin(String brand) {
        Car car = carRepository.findByBrandContainingIgnoreCase(brand, Pageable.unpaged())
                .stream()
                .findFirst()
                .orElse(null);
        if (car != null) {
            List<Thefts> thefts = theftsRepository.findByCarId(car.getId());
            car.setThefts(thefts);
            car.setTotalThefts(thefts.size());
            System.out.println("Total thefts for brand " +brand +" = "+car.getTotalThefts());
        }
        return car;
    }
    public Page<Car> findCarsByBrandPaginated(String brand, Pageable pageable) {
        System.out.println("total thefts for brand " +brand +" = "+carRepository.findCarByBrand(brand).getTotalThefts());
        return carRepository.findByBrandContainingIgnoreCase(brand, pageable);
    }


    ////////////////////////////////////////

//    public Car findCarOrigin(String brand) {
//        Optional<Car> optionalCar = carRepository.findByBrandContainingIgnoreCase(brand); // optional since it may not find nothing and to do not have error
//        if(optionalCar.isPresent()) {
//            return optionalCar.get();
//        } else {
//            return null;
//        }
//    }
}
