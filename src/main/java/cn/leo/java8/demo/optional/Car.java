package cn.leo.java8.demo.optional;

import java.util.Optional;

public class Car {
    private Optional<CarBrand> brand;


    public Car(Optional<CarBrand> brand) {
        this.brand = brand;
    }

    public Optional<CarBrand> getBrand() {
        return brand;
    }
}
