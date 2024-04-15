package web.controller;

import dao.CarDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.CarServiceImp;

@Controller
public class CarController {

    private CarServiceImp carServiceImp;

    @Autowired
    public CarController(CarServiceImp carServiceImp) {
        this.carServiceImp = carServiceImp;
    }

    @GetMapping(value = "/cars")
    public String printCars(@RequestParam(name = "count", required = false) Integer count, ModelMap cars) {
        cars.addAttribute("cars", carServiceImp.getCars(count));
        return "cars";
    }
}
