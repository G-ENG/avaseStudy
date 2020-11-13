package com.grf.utils.bean_copy;

import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @ClassName BeanCopyUtil
 * @Author ceaome
 * @Date 2020/9/9
 **/
public class BeanCopyUtil {

    public static void copyBean(Object sourceBean, Object targetBean){
        Assert.notNull(sourceBean, "Source must not be null");
        Assert.notNull(targetBean, "Target must not be null");
        Class<?> targetBeanClass = targetBean.getClass();
        Field[] targetBeanFields = targetBeanClass.getDeclaredFields();
        for (Field field :
                targetBeanFields) {
            CopyFieldAlia annotation = field.getAnnotation(CopyFieldAlia.class);
            String mappedFieldName = (annotation == null || StringUtils.isEmpty(annotation.value())) ? field.getName() : annotation.value();
            try {
                Method readMethod = new PropertyDescriptor(mappedFieldName, sourceBean.getClass()).getReadMethod();
                Method writeMethod = new PropertyDescriptor(field.getName(), targetBeanClass).getWriteMethod();
                if (readMethod != null && writeMethod!=null &&
                        ClassUtils.isAssignable(writeMethod.getParameterTypes()[0], readMethod.getReturnType())) {
                    if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                        readMethod.setAccessible(true);
                    }
                    Object value = readMethod.invoke(sourceBean);
                    if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                        writeMethod.setAccessible(true);
                    }
                    writeMethod.invoke(targetBean, value);
                }
            } catch (IntrospectionException |IllegalAccessException | InvocationTargetException exception ) {
                throw new IllegalArgumentException("bean复制异常"+exception.getMessage(),exception);
            }
        }
    }
}
