package com.example.cars.mvc.controllers;
import com.example.cars.mvc.models.Car;
import com.example.cars.mvc.services.CarService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//return text only to check frontend //it will not render or return pages only for testing Api's في حال ما بدي اعمل فرونت اند لافحص الشغل
public class CarApi {
    private final CarService carService;
    public CarApi(CarService carService){ // injecting dependency
        this.carService = carService;
    }
    @RequestMapping("/api/cars")
    public List<Car> showAllCars() {
        System.out.println("hi to cars list ");
        return carService.allCars();
    }
    @RequestMapping("/api/cars/{brand}")
    public Car showCarByBrand(@PathVariable("brand") String brand) {
        System.out.println("hi to brand "+ brand);
        Car car = carService.findCarOrigin(brand);
        return car;
    }

    @GetMapping("/api/cars/{brand}/paginated")
    public Page<Car> showCarByBrandPaginated(
            @PathVariable("brand") String brand,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize
            )
    {
        System.out.println("hi to brand " + brand + " with pagination " + pageSize);
        Pageable pageable = PageRequest.of(page, pageSize);
        return carService.findCarsByBrandPaginated(brand, pageable);
    }
}
