package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

/**
 * @author Gaziz Bakyt
 */
public interface CarDao {
    void add(Car car);
    List<Car> listCars();
}
