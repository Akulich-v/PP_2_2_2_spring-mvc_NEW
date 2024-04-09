package dao;

import model.Car;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImp implements CarDao {
    private static int carsCount;
    private List<Car> cars;
    {
        cars = new ArrayList<>();
        cars.add(new Car(++carsCount,"BMW","Y255VC"));
        cars.add(new Car(++carsCount,"Volvo","F432GH"));
        cars.add(new Car(++carsCount,"Mers","R345HB"));
        cars.add(new Car(++carsCount,"YAZ","N456FG"));
        cars.add(new Car(++carsCount,"Jac","P887MM"));
    }

    public List<Car> getCars(Integer count) {
        if (count != null) {
            return cars.stream().filter(car -> car.getId() <= count).collect((Collectors.toList()));
        }
        return cars;
    }
}
