package cn.leo.java8.demo.lambda;

import java.lang.reflect.Method;

public class Demo01 {
    public static void main(String[] args) {
        MathOperation add = (x, y) -> x + y;
        System.out.println(add.operate(1, 1));
        System.out.println(add.getClass());
        for (Method method : add.getClass().getMethods()) {
            System.out.println(method);
        }


        MathOperation minus = (x, y) -> x - y;
        System.out.println(minus.operate(1, 1));

        MathOperation add2 = Add::operate;
        System.out.println(add2.operate(1, 2));
    }


    /**
     * 算数运算接口
     */
    static interface MathOperation {
        public int operate(int x, int y);
    }

    static class Add {
        public static int operate(int x, int y) {
            return x + y;
        }
    }
}

