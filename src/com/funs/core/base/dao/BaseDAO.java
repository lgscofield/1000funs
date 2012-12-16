/******************************************************************************
* Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
* All Rights Reserved.
* �����Ϊ����ǧ����ζ��˾�������ơ�
*****************************************************************************/
package com.funs.core.base.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;

import com.funs.core.base.exception.DAOException;

/**
 * DAO����
 *
 * @author �ƿ���
 * @since jdk6.0
 * @version  2012-12-15 �ƿ���
 */
public class BaseDAO {
	
	/**
     * SqlSessionTemplateģ����� sqlSessionTemplate
     */
    @Resource
    protected SqlSessionTemplate sqlSessionTemplate;
    
    /**
     * @param sqlSessionTemplate MyBatis��SqlSessionTemplateģ�����
     */
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
    
    /**
     * ���ݲ���������������
     * 
     * @param statementId MyBatis��statement��id
     * @param insertObject ��������������
     */
    public void insert(String statementId, Object insertObject) {
        try {
            sqlSessionTemplate.insert(statementId, insertObject);
        } catch (Exception e) {
            throw new DAOException("���ݲ���������������ʧ��,�����б�(statementId:" + statementId + " insertObject:" + insertObject + ")", e);
        }
    }
}
