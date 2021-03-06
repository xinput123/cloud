package com.xinput.cloud.domain;

import com.google.common.collect.Maps;
import com.xinput.cloud.exception.ParamException;
import com.xinput.cloud.util.DateUtils;
import com.xinput.cloud.util.ObjectId;
import com.xinput.cloud.util.ValidateUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-17 15:18
 */
public abstract class BaseInfo {

    /**
     * 检查约束情况.
     */
    public abstract void checkConstraints() throws ParamException;

    protected void checkField() throws ParamException {
        ValidateUtils.validate(this);
    }

    /**
     * 接口签名需要的参数
     */
    public Map<String, Object> signatureParams() {
        Map<String, Object> params = this.toMap();
        this.addCommonParams(params);
        return params;
    }

    /**
     * 组装公共参数
     *
     * @param parameters
     */
    protected void addCommonParams(Map<String, Object> parameters) {
        parameters.put("Format", "json");
        parameters.put("Version", "2020-07-30");
        parameters.put("SignatureMethod", "HMAC-SHA1");
        parameters.put("Timestamp", DateUtils.formatIso8601Date(new Date()));
        parameters.put("SignatureVersion", "1.0");
        parameters.put("SignatureNonce", ObjectId.stringId());
    }

    public Map<String, Object> toMap() {
        Map<String, Object> retParametersMap = Maps.newHashMap();
        HashMap objectAsMap = Maps.newHashMap();

        try {
            BeanInfo info = Introspector.getBeanInfo(this.getClass());
            PropertyDescriptor[] var4 = info.getPropertyDescriptors();
            int var5 = var4.length;

            for (int var6 = 0; var6 < var5; ++var6) {
                PropertyDescriptor pd = var4[var6];
                Method reader = pd.getReadMethod();
                if (reader != null) {
                    String name = pd.getName();
                    Field field = getAccessibleField(this.getClass(), name);
                    if (field != null) {
                        As asFieldName = (As) field.getAnnotation(As.class);
                        if (asFieldName != null && !asFieldName.value().equals("")) {
                            name = asFieldName.value();
                        }
                    }

                    objectAsMap.put(captureName(name), reader.invoke(this));
                }
            }

            objectAsMap.remove("Class");
        } catch (Exception var18) {
            var18.printStackTrace();
        }

        Iterator var19 = objectAsMap.entrySet().iterator();

        while (true) {
            while (var19.hasNext()) {
                Map.Entry<String, Object> entry = (Map.Entry) var19.next();
                String key = entry.getKey();
                Object objValue = entry.getValue();
                if (objValue instanceof List) {
                    List list = (List) objValue;

                    for (int i = 0; i < list.size(); ++i) {
                        Class<? extends Object> cls = list.get(i).getClass();
                        if (!cls.equals(String.class) && !cls.equals(Integer.class) && !cls.equals(Double.class) && !cls.equals(Long.class) && !cls.equals(Float.class)) {
                            try {
                                BeanInfo info = Introspector.getBeanInfo(list.get(i).getClass());
                                PropertyDescriptor[] var27 = info.getPropertyDescriptors();
                                int var12 = var27.length;

                                for (int var13 = 0; var13 < var12; ++var13) {
                                    PropertyDescriptor pd = var27[var13];
                                    if (!pd.getName().equals("class") || !pd.getName().equals("Class")) {
                                        Method reader = pd.getReadMethod();
                                        if (reader != null) {
                                            Object v = reader.invoke(list.get(i));
                                            if (v != null) {
                                                retParametersMap.put(String.format("%s.%s.%s", key, i + 1, pd.getName()), v.toString());
                                            }
                                        }
                                    }
                                }
                            } catch (Exception var17) {
                                var17.printStackTrace();
                            }
                        } else {
                            retParametersMap.put(String.format("%s.%s", key, i), list.get(i).toString());
                        }
                    }
                } else if (objValue instanceof Integer) {
                    retParametersMap.put(key, String.valueOf((Integer) objValue));
                } else if (objValue instanceof String) {
                    retParametersMap.put(key, (String) objValue);
                } else if (objValue != null) {
                    retParametersMap.put(key, objValue.toString());
                }
            }

            return retParametersMap;
        }
    }

    private static Field getAccessibleField(Class clazz, String fieldName) {
        Class superClass = clazz;

        while (superClass != Object.class) {
            try {
                Field field = superClass.getDeclaredField(fieldName);
                makeAccessible(field);
                return field;
            } catch (NoSuchFieldException var4) {
                superClass = superClass.getSuperclass();
            }
        }

        return null;
    }

    private static void makeAccessible(Field field) {
        if ((!Modifier.isPublic(field.getModifiers())
                || !Modifier.isPublic(field.getDeclaringClass().getModifiers())
                || Modifier.isFinal(field.getModifiers()))
                && !field.isAccessible()) {
            field.setAccessible(true);
        }
    }

    /**
     * 首字母大写
     */
    public static String captureName(String name) {
        char[] cs = name.toCharArray();
        cs[0] -= 32;
        return String.valueOf(cs);
    }
}
