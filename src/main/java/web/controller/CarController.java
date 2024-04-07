package web.controller;

import dao.CarDAO;
import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
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
    public String printCars(@RequestParam(name = "count", required = false, defaultValue = "0") int count,ModelMap cars ) {
        cars.addAttribute("cars", carDAO.carCount(count));
        return "cars";
    }
}
