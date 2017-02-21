package zookeeper.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * <p>Title: 类的名称</p>
 * <p>Description: 类的实现描述<p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company:人人行科技 </p>
 *
 * @author JensenZz
 * @version 1.0
 * @date 2017/2/17
 */

public class ReflectionUtils {
    private static final Logger logger = LoggerFactory.getLogger(ReflectionUtils.class);

    public ReflectionUtils() {
    }

    public static Method getDeclaredMethod(Object object, String methodName, Class... parameterTypes) {
        Method method = null;
        Class clazz = object.getClass();

        while (clazz != Object.class) {
            try {
                method = clazz.getDeclaredMethod(methodName, parameterTypes);
                return method;
            } catch (Throwable var6) {
                clazz = clazz.getSuperclass();
            }
        }

        return null;
    }

    public static Object invokeMethod(Object object, String methodName, Class<?>[] parameterTypes, Object[] parameters) {
        Method method = getDeclaredMethod(object, methodName, parameterTypes);

        try {
            if (null != method) {
                method.setAccessible(true);
                return method.invoke(object, parameters);
            }
        } catch (IllegalArgumentException var6) {
            LogUtils.error(logger, "invokeMethod %s process methodName:[%s] error[%s]. ", new Object[]{object, methodName, var6.getMessage()});
        } catch (IllegalAccessException var7) {
            LogUtils.error(logger, "invokeMethod %s process methodName:[%s] error[%s]. ", new Object[]{object, methodName, var7.getMessage()});
        } catch (InvocationTargetException var8) {
            LogUtils.error(logger, "invokeMethod %s process methodName:[%s] error[%s]. ", new Object[]{object, methodName, var8.getMessage()});
        }

        return null;
    }

    public static Field getDeclaredField(Object object, String fieldName) {
        Field field = null;
        Class clazz = object.getClass();

        while (clazz != Object.class) {
            try {
                field = clazz.getDeclaredField(fieldName);
                return field;
            } catch (Throwable var5) {
                clazz = clazz.getSuperclass();
            }
        }

        return null;
    }

    public static void setFieldValue(Object object, String fieldName, Object value) {
        Field field = getDeclaredField(object, fieldName);
        field.setAccessible(true);

        try {
            field.set(object, value);
        } catch (IllegalArgumentException var5) {
            LogUtils.error(logger, "setFieldValue %s process fieldName:[%s] error[%s]. ", new Object[]{object, fieldName, var5.getMessage()});
        } catch (IllegalAccessException var6) {
            LogUtils.error(logger, "setFieldValue %s process fieldName:[%s] error[%s]. ", new Object[]{object, fieldName, var6.getMessage()});
        }

    }

    public static Object getFieldValue(Object object, String fieldName) {
        Field field = getDeclaredField(object, fieldName);
        field.setAccessible(true);

        try {
            return field.get(object);
        } catch (Exception var4) {
            LogUtils.error(logger, "getFieldValue %s process fieldName:[%s] error[%s]. ", new Object[]{object, fieldName, var4.getMessage()});
            return null;
        }
    }

    public static void writeField(String fieldName, Object obj, Object value) {
        try {
            Class ex = obj.getClass();
            Field field = ex.getDeclaredField(fieldName);
            if (field != null) {
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), ex);
                Method method = pd.getWriteMethod();
                method.invoke(obj, new Object[]{value});
                logger.debug("field:" + field.getName() + "---getValue:" + value);
            }
        } catch (Exception var7) {
            logger.error("set field[%s] error", fieldName, var7);
        }

    }
}
