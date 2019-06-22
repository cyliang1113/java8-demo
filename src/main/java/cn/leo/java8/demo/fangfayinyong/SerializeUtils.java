package cn.leo.java8.demo.fangfayinyong;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeUtils {
    public SerializeUtils() {
    }

    public static byte[] serialize(Object object) {
        if (object == null) {
            return null;
        } else {
            ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);
            try {
                ObjectOutputStream oos = new ObjectOutputStream(baos);
                oos.writeObject(object);
                oos.flush();
            } catch (IOException var3) {
                throw new IllegalArgumentException("Failed to serialize object of type: " + object.getClass(), var3);
            }

            return baos.toByteArray();
        }
    }


}
