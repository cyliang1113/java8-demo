package cn.leo.java8.demo.lambda;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 *
 * () -> {}
 * lambda表达式 被编译成 静态方法 方法名为lambda$main$0,
 * 动态实现接口,
 * 接口的实现就是调用 lambda编译成的静态方法
 *
 *
 */
public class Demo01 {
    static {
        System.setProperty("jdk.internal.lambda.dumpProxyClasses", ".");
    }

    public static void main(String[] args) {
        MathOperation add = (x, y) -> x + y;
        System.out.println(add.operate(1, 1));
    }

    /**
     * 算数运算接口
     */
    interface MathOperation {
        int operate(int x, int y);
    }

}

