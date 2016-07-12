package com.littlesparkle.growler.library.bean;

import android.content.Context;

import com.littlesparkle.growler.library.log.Logger;
import com.littlesparkle.growler.library.preference.PrefHelper;

import java.lang.reflect.Field;

public class BeanHelper {
    public static void persist(Context context, Bean bean) {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            try {
                if (fields[i].getType() == String.class) {
                    PrefHelper.setString(context, fields[i].getName(), (String) fields[i].get(bean));
                } else if (fields[i].getType() == int.class || fields[i].getType() == Integer.class) {
                    PrefHelper.setInteger(context, fields[i].getName(), (int) fields[i].get(bean));
                } else if (fields[i].getType() == double.class || fields[i].getType() == Double.class) {
                    PrefHelper.setDouble(context, fields[i].getName(), (double) fields[i].get(bean));
                } else if (fields[i].getType() == long.class || fields[i].getType() == Long.class) {
                    PrefHelper.setLong(context, fields[i].getName(), (long) fields[i].get(bean));
                } else if (fields[i].getType() == boolean.class || fields[i].getType() == Boolean.class) {
                    PrefHelper.setBoolean(context, fields[i].getName(), (boolean) fields[i].get(bean));
                } else if (fields[i].getType() == float.class || fields[i].getType() == Float.class) {
                    PrefHelper.setFloat(context, fields[i].getName(), (float) fields[i].get(bean));
                } else {
//                    Logger.log("unsupported type: " + fields[i].getType().getName());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void load(Context context, Bean bean) {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            try {
                if (fields[i].getType() == String.class) {
                    fields[i].set(bean, PrefHelper.getString(context, fields[i].getName()));
                } else if (fields[i].getType() == int.class || fields[i].getType() == Integer.class) {
                    fields[i].set(bean, PrefHelper.getInteger(context, fields[i].getName()));
                } else if (fields[i].getType() == double.class || fields[i].getType() == Double.class) {
                    fields[i].set(bean, PrefHelper.getDouble(context, fields[i].getName(), 0));
                } else if (fields[i].getType() == long.class || fields[i].getType() == Long.class) {
                    fields[i].set(bean, PrefHelper.getLong(context, fields[i].getName(), 0));
                } else if (fields[i].getType() == boolean.class || fields[i].getType() == Boolean.class) {
                    fields[i].set(bean, PrefHelper.getBoolean(context, fields[i].getName(), false));
                } else if (fields[i].getType() == float.class || fields[i].getType() == Float.class) {
                    fields[i].set(bean, PrefHelper.getFloat(context, fields[i].getName(), 0));
                } else {
//                    Logger.log("unsupported type: " + fields[i].getType().getName());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void dump(Bean bean) {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            try {
                if (fields[i].getType() == String.class ||
                        fields[i].getType() == int.class || fields[i].getType() == Integer.class ||
                        fields[i].getType() == double.class || fields[i].getType() == Double.class ||
                        fields[i].getType() == long.class || fields[i].getType() == Long.class ||
                        fields[i].getType() == boolean.class || fields[i].getType() == Boolean.class ||
                        fields[i].getType() == float.class || fields[i].getType() == Float.class) {
                    Logger.log(fields[i].getName() + " = " + fields[i].get(bean));
                } else {
//                    Logger.log("unsupported type: " + fields[i].getType().getName());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void clean(Context context, Class<Bean> bean) {
        try {
            Field[] fields = bean.newInstance().getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                if (fields[i].getType() == String.class ||
                        fields[i].getType() == int.class || fields[i].getType() == Integer.class ||
                        fields[i].getType() == double.class || fields[i].getType() == Double.class ||
                        fields[i].getType() == long.class || fields[i].getType() == Long.class ||
                        fields[i].getType() == boolean.class || fields[i].getType() == Boolean.class ||
                        fields[i].getType() == float.class || fields[i].getType() == Float.class) {
                    Logger.log("########## delete " + fields[i].getName());
                    PrefHelper.delete(context, fields[i].getName());
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
