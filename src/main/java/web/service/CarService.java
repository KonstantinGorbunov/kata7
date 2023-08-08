package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.List;

public interface CarService {
    List<Car> getCarList(Integer count);

    public void addCar(Car car);
}
