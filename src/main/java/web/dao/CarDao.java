package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.List;

public interface CarDao {
    List<Car> getCarList(Integer count);

    void addCar(Car car);
}
