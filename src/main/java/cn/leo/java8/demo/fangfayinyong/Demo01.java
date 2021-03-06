package cn.leo.java8.demo.fangfayinyong;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Demo01 {
    static {
        System.setProperty("jdk.internal.lambda.dumpProxyClasses", ".");
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 5, 7);
        each(list, Demo01::print);
    }

    public static <T> void each(List<T> list, Consumer<T> opt) {
        for (T t : list) {
            opt.accept(t);
        }

    }

    public static void print(Object o){
        System.out.println(o);
    }
}
