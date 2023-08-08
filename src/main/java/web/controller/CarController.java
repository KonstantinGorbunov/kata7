package web.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import web.config.ApplicationContextProvider;
import web.model.Car;
import web.service.CarService;
import web.config.WebConfig;

import java.util.List;

@Controller
public class CarController {
    @GetMapping("/cars")
    public String printCars(ModelMap model, @RequestParam(required = false) final Integer count) {

        CarService carService = ApplicationContextProvider.getApplicationContext().getBean(CarService.class);

        List<Car> cars = carService.getCarList(count);
        model.addAttribute("cars", cars);
        return "Cars";
    }

    @GetMapping("/createcars")
    public String createCars(ModelMap modelMap) {
        CarService carService = ApplicationContextProvider.getApplicationContext().getBean(CarService.class);

        for (int i = 0; i < 10; i ++) {
            carService.addCar(new Car("bb" + Integer.toString(i), "1.5t", i + 212121));
        }

        return "createcars";
    }
}
