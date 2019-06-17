package cn.leo.java8.demo.lambda;

import jdk.management.resource.ResourceId;

import java.util.function.Supplier;

public class Demo02 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> print());
        Thread thread2 = new Thread(Demo02::print);
        thread1.start();
        thread2.start();
        Supplier supplier = () -> "Car";
        System.out.println(supplier.get());
    }

    public static void print() {
        System.out.println(Thread.currentThread().getName());
    }
}
