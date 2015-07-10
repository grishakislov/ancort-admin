package com.mttch.admin.server.mybatis.helpers;


import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatabaseValueHelper {

    private static final Logger LOG = LoggerFactory.getLogger(DatabaseValueHelper.class);

    private DatabaseValueHelper() {

    }

    public static Object getDbValue(Enum<?> enumValue) {
        if (enumValue == null) {
            return null;
        }
        DatabaseValue dbValue;
        try {
            dbValue = (DatabaseValue) enumValue.getClass().getField(enumValue.name()).getAnnotation(DatabaseValue.class);
            if (dbValue == null) {
                throw new IllegalArgumentException("Enum value [" + enumValue + "] is not annotated with DBValue");
            }
            String stringValue = dbValue.stringValue();
            if (StringUtils.isNotBlank(stringValue)) {
                return stringValue;
            }
            return dbValue.intValue();
        } catch (SecurityException e) {
            LOG.warn(e.getMessage());
        } catch (NoSuchFieldException e) {
            LOG.warn(e.getMessage());
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static <E extends Enum<E>> E getEnumValueByDbValue(Class<E> enumClass, Object dbValue) {
        if (dbValue == null) {
            return null;
        }
        for (Enum<E> enumValue : enumClass.getEnumConstants()) {
            if (getDbValue(enumValue).toString().equals(dbValue)) {
                return (E) enumValue;
            }
        }
        return null;
    }

}
