package com.example.cars.mvc.repositories;
import com.example.cars.mvc.models.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends CrudRepository<Car, Long>, PagingAndSortingRepository<Car,Long> {//<class type, type of id in this class>
     List<Car> findAll();
     Car findCarByBrand(String brand);
     Page<Car> findByBrandContainingIgnoreCase(String brand, Pageable pageable);


//     Optional<Car> findByBrandContainingIgnoreCase(String brand);
///////////
//     @Query("SELECT c FROM Car c JOIN FETCH c.thefts t WHERE c.brand = :brand")
//     List<Car> findCarsWithTheftsByBrand(String brand);

}
