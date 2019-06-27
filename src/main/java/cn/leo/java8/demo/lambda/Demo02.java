package cn.leo.java8.demo.lambda;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Demo02 {
    static{
        System.setProperty("jdk.internal.lambda.dumpProxyClasses", ".");
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
    }

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> System.out.println("Hello"));
        thread1.start();
        Consumer consumer = System.out::println;
        consumer.accept("World");
    }

}
