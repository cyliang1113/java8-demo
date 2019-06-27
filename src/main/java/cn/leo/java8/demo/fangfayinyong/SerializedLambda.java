package cn.leo.java8.demo.fangfayinyong;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SerializedLambda implements Serializable {
    private static final long serialVersionUID = 8025925345765570181L;
    private Class<?> capturingClass;
    private String functionalInterfaceClass;
    private String functionalInterfaceMethodName;
    private String functionalInterfaceMethodSignature;
    private String implClass;
    private String implMethodName;
    private String implMethodSignature;
    private int implMethodKind;
    private String instantiatedMethodType;
    private Object[] capturedArgs;
    private static final Pattern INSTANTIATED_METHOD_TYPE = Pattern.compile("\\(L(?<instantiatedMethodType>[\\S&&[^;)]]+);\\)L[\\S]+;");

    public SerializedLambda() {
    }

    public static SerializedLambda resolve(Function<?, ?> lambda) {
        if (!lambda.getClass().isSynthetic()) {
            throw new RuntimeException("该方法仅能传入 lambda 表达式产生的合成类");
        } else {
            try {
                ObjectInputStream objIn = new ObjectInputStream(new ByteArrayInputStream(SerializeUtils.serialize(lambda))) {
                    protected Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
                        Class<?> clazz = super.resolveClass(objectStreamClass);
                        return clazz == java.lang.invoke.SerializedLambda.class ? SerializedLambda.class : clazz;
                    }
                };
                Throwable var2 = null;

                SerializedLambda var3;
                try {
                    Object o = objIn.readObject();
                    Class<?> aClass = o.getClass();
                    var3 = (SerializedLambda) o;
                } catch (Throwable var13) {
                    var2 = var13;
                    throw var13;
                } finally {
                    if (objIn != null) {
                        if (var2 != null) {
                            try {
                                objIn.close();
                            } catch (Throwable var12) {
                                var2.addSuppressed(var12);
                            }
                        } else {
                            objIn.close();
                        }
                    }

                }

                return var3;
            } catch (IOException | ClassNotFoundException var15) {
                throw new RuntimeException(var15);
            }
        }
    }

    public String getFunctionalInterfaceClassName() {
        return this.normalName(this.functionalInterfaceClass);
    }

    public Class<?> getImplClass() {
        try {
            return Class.forName(this.getImplClassName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String getImplClassName() {
        return this.normalName(this.implClass);
    }

    public String getImplMethodName() {
        return this.implMethodName;
    }

    private String normalName(String name) {
        return name.replace('/', '.');
    }

    public Class getInstantiatedMethodType() {
        Matcher matcher = INSTANTIATED_METHOD_TYPE.matcher(this.instantiatedMethodType);
        if (matcher.find()) {
            try {
                return Class.forName(this.normalName(matcher.group("instantiatedMethodType")));
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new RuntimeException("无法解析调用实例。。。");
        }
    }

    public String toString() {
        return String.format("%s -> %s::%s", this.getFunctionalInterfaceClassName(), this.getImplClass().getSimpleName(), this.implMethodName);
    }
}

