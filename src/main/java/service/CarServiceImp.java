package service;

import dao.CarDaoImp;
import model.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImp implements CarService {

    private final CarDaoImp carDaoImp;

    public CarServiceImp(CarDaoImp carDaoImp) {
        this.carDaoImp = carDaoImp;
    }

    @Override
    public List<Car> getCars(Integer count) {
        return carDaoImp.getCars(count);
    }
}
