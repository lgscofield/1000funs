/******************************************************************************
* Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
* All Rights Reserved.
* �����Ϊ����ǧ����ζ��˾�������ơ�
*****************************************************************************/
package com.funs.core.base.exception;

/**
 * �쳣����
 *
 * @author �ƿ���
 * @since jdk6.0
 * @version  2012-12-15 �ƿ���
 */
public class BaseException extends RuntimeException {
	
	/**
     * �쳣���캯��
     * 
     * @param message �쳣������Ϣ
     * @param throwable �������쳣��
     */
    public BaseException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
