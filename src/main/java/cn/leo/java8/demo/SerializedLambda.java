package cn.leo.java8.demo;

import java.io.Serializable;

public class SerializedLambda implements Serializable {
    private static final long serialVersionUID = 8025925345765570181L;


    private String implMethodName;

    public String getImplMethodName() {
        return implMethodName;
    }

    public void setImplMethodName(String implMethodName) {
        this.implMethodName = implMethodName;
    }
}

