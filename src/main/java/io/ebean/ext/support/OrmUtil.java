package io.ebean.ext.support;

import io.ebean.SqlRow;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

public class OrmUtil {
    private static Logger logger = LoggerFactory.getLogger(OrmUtil.class);

    private static String column2Attribute(String column) {
        if (column == null || column.isEmpty()) {
            return column;
        }
        StringBuilder attribute = new StringBuilder(column.toLowerCase());
        // 将下划线后面的字符替换成大写
        int i = attribute.indexOf("_");
        int length = attribute.length();
        while (i > -1) {
            if (length > i + 1) {
                attribute.replace(i + 1, i + 2, attribute.substring(i + 1, i + 2).toUpperCase());
            }
            attribute.deleteCharAt(i);

            length--;
            i = attribute.indexOf("_", i);
        }
        return attribute.toString();
    }

    public static <T> T objMapping(SqlRow sqlRow, Class<T> clazz) {
        if (sqlRow == null) return null;

        try {
            T t = clazz.newInstance();
            for (String column : sqlRow.keySet()) {
                String column2 = column2Attribute(column);
                Field field;
                try {
                    field = clazz.getDeclaredField(column2);
                } catch (NoSuchFieldException e) {
                    continue;
                }
                String type = field.getGenericType().toString();
                if ("class java.lang.String".equals(type)) {
                    Object v = sqlRow.get(column);
                    if (v != null)
                        PropertyUtils.setProperty(t, column2, v.toString());
                } else if ("class java.lang.Long".equals(type)) {
                    PropertyUtils.setProperty(t, column2, sqlRow.getLong(column));
                } else if ("class java.lang.Integer".equals(type)) {
                    PropertyUtils.setProperty(t, column2, sqlRow.getInteger(column));
                } else if ("class java.lang.Short".equals(type)) {
                    Integer v = sqlRow.getInteger(column);
                    if (v != null)
                        PropertyUtils.setProperty(t, column2, v.shortValue());
                } else if ("class java.lang.Double".equals(type)) {
                    PropertyUtils.setProperty(t, column2, sqlRow.getDouble(column));
                } else if ("class java.lang.Float".equals(type)) {
                    PropertyUtils.setProperty(t, column2, sqlRow.getFloat(column));
                } else if ("long".equals(type)) {
                    Long v = sqlRow.getLong(column);
                    if (v == null) v = 0L;
                    PropertyUtils.setProperty(t, column2, v);
                } else if ("int".equals(type)) {
                    Integer v = sqlRow.getInteger(column);
                    if (v == null) v = 0;
                    PropertyUtils.setProperty(t, column2, v);
                } else if ("short".equals(type)) {
                    Integer v = sqlRow.getInteger(column);
                    if (v == null) v = 0;
                    PropertyUtils.setProperty(t, column2, v.shortValue());
                } else if ("double".equals(type)) {
                    Double v = sqlRow.getDouble(column);
                    if (v == null) v = 0D;
                    PropertyUtils.setProperty(t, column2, v);
                } else if ("float".equals(type)) {
                    Float v = sqlRow.getFloat(column);
                    if (v == null) v = 0F;
                    PropertyUtils.setProperty(t, column2, v);
                } else if ("class java.sql.Date".equals(type)) {
                    PropertyUtils.setProperty(t, column2, sqlRow.getDate(column));
                } else if ("class java.util.Date".equals(type)) {
                    PropertyUtils.setProperty(t, column2, sqlRow.getUtilDate(column));
                } else if ("class java.sql.Timestamp".equals(type)) {
                    PropertyUtils.setProperty(t, column2, sqlRow.getTimestamp(column));
                } else if ("class java.lang.Boolean".equals(type)) {
                    PropertyUtils.setProperty(t, column2, sqlRow.getBoolean(column));
                } else if ("boolean".equals(type)) {
                    Boolean v = sqlRow.getBoolean(column);
                    if (v == null) v = false;
                    PropertyUtils.setProperty(t, column2, v);
                } else if ("class java.math.BigDecimal".equals(type)) {
                    PropertyUtils.setProperty(t, column2, sqlRow.getBigDecimal(column));
                }
            }
            return t;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }
}
