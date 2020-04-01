package com.lark.socket.api.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @auther: zhuqz
 * @date: 2020/3/9 14:04
 * @description: 常用工具方法
 */
public class CommonUtil {
    /**
     * 对象转Byte数组
     * @param obj
     * @return
     */
    public static byte[] objectToByteArray(Object obj) throws  Exception{
        byte[] bytes = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
            bytes = byteArrayOutputStream.toByteArray();

        } catch (IOException e) {
            System.err.println("objectToByteArray failed, " + e);
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    System.err.println("close objectOutputStream failed, " + e);
                }
            }
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    System.err.println("close byteArrayOutputStream failed, " + e);
                }
            }

        }
        return bytes;
    }

}