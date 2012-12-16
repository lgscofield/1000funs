/******************************************************************************
* Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
* All Rights Reserved.
* �����Ϊ����ǧ����ζ��˾�������ơ�
*****************************************************************************/
package com.funs.core.util.tools;

import java.util.UUID;

/**
 * UUID������
 *
 * @author �ƿ���
 * @since jdk6.0
 * @version  2012-12-16 �ƿ���
 */
public final class UUIDUtil {

    /**
     * ���캯��
     */
    private UUIDUtil() {
    }
    
    /**
     * ����һ��32λ��UUID
     * 
     * @return ���ɵ�UUID
     */
    public static String generateUUID() {
        String strUUID = UUID.randomUUID().toString().replaceAll("-", StringUtils.EMPTY);
        return strUUID;
    }
}
