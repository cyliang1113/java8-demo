package cn.leo.java8.demo.lambda;

public class Demo01 {
    public static void main(String[] args) {
        MathOperation add = (x, y) -> x + y;
        int operate = add.operate(1, 1);
        System.out.println(operate);

        MathOperation minus = (x, y) -> x - y;
        int operate1 = minus.operate(1, 1);
        System.out.println(operate1);


    }
}
