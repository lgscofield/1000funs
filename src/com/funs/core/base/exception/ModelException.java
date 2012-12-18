/******************************************************************************
* Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
* All Rights Reserved.
* �����Ϊ����ǧ����ζ��˾�������ơ�
*****************************************************************************/
package com.funs.core.base.exception;

/**
 * ģ���쳣
 *
 * @author �ƿ���
 * @since jdk6.0
 * @version  2012-12-16 �ƿ���
 */
public class ModelException extends BaseException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5321852505368443299L;

	/**
     * �쳣����
     * 
     * @param message �쳣��Ϣ
     * @param throwable ����쳣��
     */
    public ModelException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
