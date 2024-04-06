package model;

import java.util.Objects;

public class Car {
    private long id;
    private String model;
    private String number;

    public Car() {
    }

    public Car(long id, String model, String number) {
        this.id = id;
        this.model = model;
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return id == car.id && Objects.equals(model, car.model) && Objects.equals(number, car.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, number);
    }

    @Override
    public String toString() {
        return "Car " +
                "id=" + id +
                ", model='" + model + '\'' +
                ", number='" + number;
    }
}
