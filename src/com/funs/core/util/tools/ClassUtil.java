/******************************************************************************
* Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
* All Rights Reserved.
* �����Ϊ����ǧ����ζ��˾�������ơ�
*****************************************************************************/
package com.funs.core.util.tools;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.funs.core.base.exception.ModelException;
import com.funs.core.base.model.BaseVO;

/**
 * class������
 *
 * @author �ƿ���
 * @since jdk6.0
 * @version  2012-12-16 �ƿ���
 */
public final class ClassUtil {

    /**
     * ���캯��
     */
    private ClassUtil() {
    }
    
    /**
     * ��־
     */
    protected final static Logger LOGGER = LoggerFactory.getLogger(ClassUtil.class);
    
    /**
     * ����ȡ��class�е�����
     * 
     * @param byClass Class
     * @return �ֶ��б�
     */
    public static List<Field> getFieldByClass(Class<?> byClass) {
        return getFieldByClass(byClass, null);
    }
    
    /**
     * ����ȡ��class�е�����
     * 
     * @param byClass ��������Class
     * @param classFieldFilter �����ֶ�
     * @return �ֶ��б�
     */
    public static List<Field> getFieldByClass(Class<?> byClass, ClassFieldFilter classFieldFilter) {
        List<Field> lstField = new ArrayList<Field>(10);
        if (byClass.getSuperclass() != Object.class) {
            lstField.addAll(getFieldByClass(byClass.getSuperclass()));
        }
        Field[] objFields = byClass.getDeclaredFields();
        for (Field objField : objFields) {
            if (classFieldFilter != null) {
                if (classFieldFilter.isFilter(byClass, objField)) {
                    lstField.add(objField);
                }
            } else {
                lstField.add(objField);
            }
        }
        return lstField;
    }
    
    /**
     * ����ȡ��class�е�����
     * 
     * @param byClass ��������Class
     * @param fieldName c
     * @return �ֶ�
     */
    public static Field getFieldByName(Class<?> byClass, String fieldName) {
        Field objResultField = null;
        try {
            objResultField = byClass.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            LOGGER.debug(byClass + "�����Ҳ����ֶ�" + fieldName);
        }
        if (objResultField == null) {
            if (byClass.getSuperclass() != Object.class) {
                objResultField = getFieldByName(byClass.getSuperclass(), fieldName);
            }
        }
        return objResultField;
    }
    
    /**
     * ȡ��VO��Tableע���name����ֵ��Ĭ��ΪVO����
     * 
     * @param t ʵ�����
     * @param <T> BaseVOʵ���������
     * @return Table����
     */
    public static <T extends BaseVO> String getTableName(T t) {
        return getTableName(t.getClass());
    }
    
    /**
     * ȡ��VO��Tableע���name����ֵ��Ĭ��ΪVO����
     * 
     * @param clazz ʵ�����class
     * @param <T> BaseVOʵ���������
     * @return Table����
     */
    public static <T extends BaseVO> String getTableName(Class<T> clazz) {
        String objResult = null;
        if (clazz.isAnnotationPresent(Table.class)) {
            Table objTableAnnotation = clazz.getAnnotation(Table.class);
            objResult = objTableAnnotation.name();
            if (StringUtils.isEmpty(objResult)) {
                objResult = clazz.getSimpleName();
            }
        }
        return objResult;
    }
    
    /**
     * ȡ��VO��Entityע���name����ֵ��Ĭ��ΪVO����
     * 
     * @param t ʵ�����
     * @param <T> BaseVOʵ���������
     * @return Entityʵ������
     */
    public static <T extends BaseVO> String getEntityName(T t) {
        return getEntityName(t.getClass());
    }
    
    /**
     * ȡ��VO��Entityע���name����ֵ��Ĭ��ΪVO����
     * 
     * @param clazz ʵ�����class
     * @param <T> BaseVOʵ���������
     * @return Entityʵ������
     */
    public static <T extends BaseVO> String getEntityName(Class<T> clazz) {
        String objResult = null;
        if (clazz.isAnnotationPresent(Entity.class)) {
            Entity objEntityAnnotation = clazz.getAnnotation(Entity.class);
            objResult = objEntityAnnotation.name();
            if (StringUtils.isEmpty(objResult)) {
                objResult = clazz.getSimpleName();
            }
        }
        return objResult;
    }
    
    /**
     * ȡ��VO��������
     * 
     * @param t ʵ�����
     * @param <T> BaseVOʵ���������
     * @return ����
     */
    public static <T extends BaseVO> String getPrimaryKeyName(T t) {
        return getPrimaryKeyName(t.getClass());
    }
    
    /**
     * ȡ��VO��������
     * 
     * @param clazz ʵ�����class
     * @param <T> BaseVOʵ���������
     * @return ����
     */
    public static <T extends BaseVO> String getPrimaryKeyName(Class<T> clazz) {
        Object objResult = null;
        Field[] objFields = clazz.getDeclaredFields();
        for (Field objField : objFields) {
            if (objField.isAnnotationPresent(Id.class)) {
                try {
                    objField.setAccessible(true);
                    objResult = objField.getName();
                } catch (SecurityException e) {
                    throw new ModelException("�����ȡ������������" + objField.getName() + "ʱ����", e);
                }
            }
        }
        return objResult != null ? objResult.toString() : StringUtils.EMPTY;
    }
    
    /**
     * ȡ��VO������ֵ
     * 
     * @param t ʵ�����
     * @param <T> BaseVOʵ���������
     * @return ����
     */
    public static <T extends BaseVO> String getPrimaryKeyValue(T t) {
        Object objResult = null;
        Field[] objFields = t.getClass().getDeclaredFields();
        for (Field objField : objFields) {
            if (objField.isAnnotationPresent(Id.class)) {
                try {
                    objField.setAccessible(true);
                    objResult = objField.get(t);
                } catch (IllegalAccessException e) {
                    throw new ModelException("�����ȡ��������" + objField.getName() + "ֵʱ����", e);
                }
            }
        }
        return objResult != null ? objResult.toString() : StringUtils.EMPTY;
    }
}
