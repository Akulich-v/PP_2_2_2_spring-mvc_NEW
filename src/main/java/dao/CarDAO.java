package dao;

import model.Car;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarDAO {
    private static int CARS_COUNT;
    private List<Car> cars;
    {
        cars = new ArrayList<>();
        cars.add(new Car(++CARS_COUNT,"BMW","Y255VC"));
        cars.add(new Car(++CARS_COUNT,"Volvo","F432GH"));
        cars.add(new Car(++CARS_COUNT,"Mers","R345HB"));
        cars.add(new Car(++CARS_COUNT,"YAZ","N456FG"));
        cars.add(new Car(++CARS_COUNT,"Jac","P887MM"));
    }

    public List<Car> index() {
        return cars;
    }

    public List<Car> carCount (int count) {
        return cars.stream().filter(car -> car.getId() <= count).collect((Collectors.toList()));
    }
}
