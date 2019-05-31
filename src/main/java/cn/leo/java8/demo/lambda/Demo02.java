package cn.leo.java8.demo.lambda;

public class Demo02 {
    public static void main(String[] args) {
        MathOperation add = Add::operate;
        int operate = add.operate(1, 2);
        System.out.println(operate);

    }
}
