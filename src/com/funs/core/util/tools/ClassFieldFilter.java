/******************************************************************************
* Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
* All Rights Reserved.
* �����Ϊ����ǧ����ζ��˾�������ơ�
*****************************************************************************/
package com.funs.core.util.tools;

import java.lang.reflect.Field;

/**
 * ���ֶι��˽ӿ�
 *
 * @author �ƿ���
 * @since jdk6.0
 * @version  2012-12-16 �ƿ���
 */
public interface ClassFieldFilter {
	
	/**
     * �ֶι���
     * 
     * @param byClass ��������Class
     * @param field �ֶ���
     * @return �Ƿ����
     */
    boolean isFilter(Class<?> byClass, Field field);
}
