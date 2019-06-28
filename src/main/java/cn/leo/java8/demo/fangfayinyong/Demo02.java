package cn.leo.java8.demo.fangfayinyong;

import lombok.Data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Demo02 {
    static {
        System.setProperty("jdk.internal.lambda.dumpProxyClasses", ".");
    }

    public static void main(String[] args) {
        List<Person> peopleList = Arrays.asList(new Person("Tom"), new Person("Davide"));
        each(peopleList, Person::getName);
//        each(peopleList, t -> t);
    }

    public static <T, R> void each(List<T> list, SFunction<T, R> func) {
        for (T t : list) {
            SerializedLambda resolve = SerializedLambda.resolve(func);
            System.out.println(resolve);
            func.apply(t);
        }
    }

    @Data
    public static class Person  implements Serializable {
        private static final long serialVersionUID = 8025925345765570181L;

        public Person(String name) {
            this.name = name;
        }
        public String name;
    }
}
