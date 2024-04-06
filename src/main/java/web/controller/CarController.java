package web.controller;

import dao.CarDAO;
import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    private CarDAO carDAO;
    @Autowired
    public CarController(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @GetMapping(value = "/cars")
    public String printCars(ModelMap cars) {
        cars.addAttribute("cars",carDAO.index());
        return "cars";
    }
    @GetMapping(value = "/cars/{count}")
    public String printCars(@RequestParam(name = "count", required = false, defaultValue = "0") int count, ModelMap cars) {
        cars.addAttribute("cars", carDAO.carCount(count));
        return "cars";
    }
/*
    @GetMapping(value = "/cars_m")
    public String printCars(@RequestParam("count") int count, ModelMap cars) {
        Car car1 = new Car(1,"BMW","Y255VC");
        Car car2 = new Car(2,"Volvo","F432GH");
        Car car3 = new Car(3,"Mers","R345HB");
        Car car4 = new Car(4,"YAZ","N456FG");
        Car car5 = new Car(5,"Jac","P887MM");
        List<String> carsList = new ArrayList<>();
        carsList.add(car1.toString());
        carsList.add(car2.toString());
        carsList.add(car3.toString());
        carsList.add(car4.toString());
        carsList.add(car5.toString());

        List<String> carsListCount = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            carsListCount.add(carsList.get(i));
        }

        cars.addAttribute("cars_m", carsList);

        return "cars";
    }*/
}
