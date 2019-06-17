package cn.leo.java8.demo.liu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo01 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 5, 7);
        List<Integer> collect = list.stream().filter(t -> t > 3).collect(Collectors.toList());
        System.out.println(collect);
    }
}
