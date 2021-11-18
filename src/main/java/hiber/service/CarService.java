package hiber.service;

import hiber.model.Car;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Gaziz Bakyt
 */

public interface CarService {
    void add(Car car);
    List<Car> listCars();
}
