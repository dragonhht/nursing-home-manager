package com.github.dragonhht.manager.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Description.
 * User: huang
 * Date: 18-10-14
 */
public class BeanUtil {

    /**
     * 获取制定属性名的getter方法(属性名命名需规范).
     * @param obj
     * @param fieldName
     * @return
     */
    public static Method getField(Object obj, String fieldName) {
        fieldName = "get" + fieldName.replaceFirst(fieldName.substring(0, 1), fieldName.substring(0, 1).toUpperCase());
        Class cls = obj.getClass();
        Method[] methods = cls.getMethods();
        for (Method method: methods) {
            if (method.getName().equals(fieldName)) {
                return method;
            }
        }
        return null;
    }

    public static <T> T getField(Object obj, Method method, Class<T> tClass) throws InvocationTargetException, IllegalAccessException {
        return (T) method.invoke(obj);
    }

}
