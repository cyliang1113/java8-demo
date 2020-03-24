package cn.leo.java8.demo.optional;

import java.util.Optional;

public class Demo01 {
    public static void main(String[] args) {
        Optional<Person> person = getPerson2();
        Optional<Car> car = person.flatMap(Person::getCar);
        Optional<CarBrand> carBrand = car.flatMap(Car::getBrand);
        Optional<String> carBrandName = carBrand.map(CarBrand::getName);
        System.out.println("1: " + carBrandName.orElse("Unknown"));
    }

    public static Optional<Person> getPerson0() {
        // 没有person
        Optional<Person> person = Optional.empty();
        return person;
    }

    public static Optional<Person> getPerson1() {
        // person没有car
        Optional<Car> car = Optional.empty();
        Optional<Person> person = Optional.of(new Person(car));
        return person;
    }


    public static Optional<Person> getPerson2() {
        // person有car, car没有carBrand
        Optional<CarBrand> carBrand = Optional.empty();
        Optional<Car> car = Optional.of(new Car(carBrand));
        Optional<Person> person = Optional.of(new Person(car));
        return person;
    }

    public static Optional<Person> getPerson3() {
        // person有car, car有carBrand
        Optional<CarBrand> carBrand = Optional.of(new CarBrand("geely"));
        Optional<Car> car = Optional.of(new Car(carBrand));
        Optional<Person> person = Optional.of(new Person(car));
        return person;
    }
}
