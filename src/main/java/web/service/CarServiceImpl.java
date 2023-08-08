package web.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import web.dao.CarDao;
import web.model.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.annotation.WebServlet;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private CarDao dao;
    @Transactional(readOnly = true)
    @Override
    public List<Car> getCarList(Integer count) {
        return dao.getCarList(count);
    }

    @Transactional
    @Override
    public void addCar(Car car) {
        dao.addCar(car);
    }

    @Autowired
    public void setDao(CarDao dao) {
        this.dao = dao;
    }
}
