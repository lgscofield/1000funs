/******************************************************************************
* Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
* All Rights Reserved.
* �����Ϊ����ǧ����ζ��˾�������ơ�
*****************************************************************************/
package com.funs.core.util.tools;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

/**
 * �ṩ���ڻ�����ʱ���ʽ����������
 *
 * @author �ƿ���
 * @since jdk6.0
 * @version  2012-12-16 �ƿ���
 */
public final class DateTimeFormatUtils {
	
	/** ��������ʱ���������ʱ���ʽ�ַ���: yyyy-MM-dd HH:mm:ss */
    public final static String ISO_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    
    /** ��������ʱ�ֵ�����ʱ���ʽ�ַ���: yyyy-MM-dd HH:mm */
    public final static String ISO_DATETIME_FORMAT_SHORT = "yyyy-MM-dd HH:mm";
    
    /** �������յ����ڸ�ʽ�ַ���: yyyy-MM-dd */
    public final static String ISO_DATE_FORMAT = "yyyy-MM-dd";
    
    /** �����µ����ڸ�ʽ�ַ���: yyyy-MM */
    public final static String ISO_SHORT_DATE_FORMAT = "yyyy-MM";
    
    /** ��ʱ�����ʱ���ʽ�ַ���: HH:mm:ss */
    public final static String ISO_TIME_FORMAT = "HH:mm:ss";
    
    /**
     * ���캯��
     */
    private DateTimeFormatUtils() {
    }
    
    /**
     * ��������ʱ���ʽyyyy-MM-dd HH:mm:ss����ȡָ���Ķ�����ַ�����Ϣ
     * 
     * @param value ��Ҫ��ת��������ʱ���������
     * @return ���ص��Ǹ�ʽ������ַ���
     */
    public static String formatDateTime(Date value) {
        return formatDateTime(value, ISO_DATETIME_FORMAT);
    }
    
    /**
     * ��������ʱ���ʽyyyy-MM-dd HH:mm����ȡָ���Ķ�����ַ�����Ϣ
     * 
     * @param value ��Ҫ��ת��������ʱ���������
     * @return ���ص��Ǹ�ʽ������ַ���
     */
    public static String formatShortDateTime(Date value) {
        return formatDateTime(value, ISO_DATETIME_FORMAT_SHORT);
    }
    
    /**
     * �������ڸ�ʽyyyy-MM-dd����ȡָ���Ķ�����ַ�����Ϣ
     * 
     * @param value ��Ҫ��ת��������ʱ���������
     * @return ���ص��Ǹ�ʽ������ַ���
     */
    public static String formatDate(Date value) {
        return formatDateTime(value, ISO_DATE_FORMAT);
    }
    
    /**
     * �������ڸ�ʽyyyy-MM����ȡָ���Ķ�����ַ�����Ϣ
     * 
     * @param value ��Ҫ��ת��������ʱ���������
     * @return ���ص��Ǹ�ʽ������ַ���
     */
    public static String formatShortDate(Date value) {
        return formatDateTime(value, ISO_SHORT_DATE_FORMAT);
    }
    
    /**
     * ����ʱ���ʽHH:mm:ss����ȡָ���Ķ�����ַ�����Ϣ
     * 
     * @param value ��Ҫ��ת��������ʱ���������
     * @return ���ص��Ǹ�ʽ������ַ���
     */
    public static String formatTime(Date value) {
        return formatDateTime(value, ISO_TIME_FORMAT);
    }
    
    /**
     * ����ָ��������ʱ���ʽ����ȡָ���Ķ�����ַ�����Ϣ
     * 
     * @param value ��Ҫ��ת��������ʱ���������
     * @param defaultFormat ָ��������ʱ���ʽ,Ϊ��ʱ��ʹ��Ĭ�ϵ�����ʱ���ʽyyyy-MM-dd HH:mm:ss
     * @return ���ص��Ǹ�ʽ������ַ���
     */
    public static String formatDateTime(Date value, String defaultFormat) {
        if (value == null) {
            return "";
        }
        String strFormatStyle = StringUtils.isEmpty(defaultFormat) ? ISO_DATETIME_FORMAT : defaultFormat;
        SimpleDateFormat objSimpleDateFormat = new SimpleDateFormat(strFormatStyle);
        return objSimpleDateFormat.format(value);
    }
    
    /**
     * ����ָ��������ʱ���ʽ����ȡָ���Ķ�����ַ�����Ϣ
     * 
     * @param value ��Ҫ��ת��������ʱ���������
     * @param format ָ��������ʱ���ʽ,Ϊ��ʱ��ʹ��Ĭ�ϵ�����ʱ���ʽyyyy-MM-dd HH:mm:ss
     * @return ���ص��Ǹ�ʽ������ַ���
     */
    public static String getCurrentFormatDateTime(Date value, String format) {
        return formatDateTime(new Date(), format);
    }
    
    /**
     * ��ȡָ���������ڵļ��ȡ�
     * 
     * <pre>
     * DateTimeFormatUtils.getQuarter(java.sql.Date.valueOf(&quot;2004-01-01&quot;)=1
     * DateTimeFormatUtils.getQuarter(java.sql.Date.valueOf(&quot;2004-05-01&quot;)=2
     * DateTimeFormatUtils.getQuarter(java.sql.Date.valueOf(&quot;2004-09-01&quot;)=3
     * DateTimeFormatUtils.getQuarter(java.sql.Date.valueOf(&quot;2004-12-01&quot;)=4
     * DateTimeFormatUtils.getQuarter(null) = 0;
     * </pre>
     * 
     * @param date ��Ҫ�жϵ�ʱ�䣬����Ϊjava.util.Date.
     * @return ����ָ���������ڵļ��ȡ�
     */
    public static int getQuarter(Date date) {
        if (date == null) {
            return 0;
        }
        Calendar objCalendar = Calendar.getInstance();
        objCalendar.setTime(date);
        int iMonth = objCalendar.get(Calendar.MONTH) + 1;
        if ((iMonth >= 1) && (iMonth <= 3)) {
            return 1;
        } else if ((iMonth >= 4) && (iMonth <= 6)) {
            return 2;
        } else if ((iMonth >= 7) && (iMonth <= 9)) {
            return 3;
        } else {
            return 4;
        }
    }
    
    /**
     * �õ�ָ���������ڵ��ܡ�
     * 
     * @param dateValue ��Ҫ�жϵ��������͡�(java.util.Date)
     * @return �õ��������ڵ��ܡ�
     */
    public static String getWeekID(Date dateValue) {
        String strWeekID = "";
        Calendar objCalendar = Calendar.getInstance();
        objCalendar.setTime(dateValue);
        int iYear = objCalendar.get(Calendar.YEAR);
        int iWeek = objCalendar.get(Calendar.WEEK_OF_YEAR);
        if (iWeek >= 10) {
            strWeekID = iYear + String.valueOf(iWeek);
        } else {
            strWeekID = iYear + "0" + iWeek;
        }
        return strWeekID;
    }
    
    /**
     * �õ������ܵĵ�һ��
     * 
     * @param year ��Ҫ�жϵ���ݡ�
     * @param week ��Ҫ�жϵĵڼ��ܡ�
     * @return �õ�ָ����ݣ�ָ���ܵĵ�һ�졣
     */
    public static String firstDayOfWeek(int year, int week) {
        Calendar objCalendar = Calendar.getInstance();
        objCalendar.set(Calendar.YEAR, year);
        objCalendar.set(Calendar.WEEK_OF_YEAR, week);
        // ����Calendar.setFirstDayOfWeek()
        objCalendar.add(Calendar.DAY_OF_WEEK, (-1 * objCalendar.get(Calendar.DAY_OF_WEEK)) + 2);
        return formatDate(objCalendar.getTime());
    }
    
    /**
     * �õ������ܵ����һ��
     * 
     * @param year ��Ҫ�жϵ���ݡ�
     * @param week ��Ҫ�жϵĵڼ��ܡ�
     * @return �õ�ָ����ݣ�ָ���ܵ����һ�졣
     */
    public static String endDayOfWeek(int year, int week) {
        Calendar objCalendar = Calendar.getInstance();
        objCalendar.set(Calendar.YEAR, year);
        objCalendar.set(Calendar.WEEK_OF_YEAR, week);
        // ����Calendar.setFirstDayOfWeek()
        objCalendar.add(Calendar.DAY_OF_WEEK, (-1 * objCalendar.get(Calendar.DAY_OF_WEEK)) + 2 + 6);
        return formatDate(objCalendar.getTime());
    }
    
    /**
     * �õ�ָ�����������ܵ�ǰһ�ܻ�����һ��
     * 
     * @param year ��Ҫ�жϵ���ݡ�
     * @param week ��Ҫ�жϵĵڼ��ܡ�
     * @param direction true ��ȡǰһ�ܡ�<BR>
     *            false ��ȡ��һ��<BR>
     * @return �õ�ָ�����������ܵ�ǰһ�ܻ�����һ��
     */
    public static String rollWeek(int year, int week, boolean direction) {
        String strWeekID = "";
        Calendar objCalendar = Calendar.getInstance();
        objCalendar.set(Calendar.YEAR, year);
        objCalendar.set(Calendar.WEEK_OF_YEAR, week);
        if (direction) { //
            objCalendar.add(Calendar.DAY_OF_WEEK, 7);
        } else {
            objCalendar.add(Calendar.DAY_OF_WEEK, -7);
        }
        int iYear = objCalendar.get(Calendar.YEAR);
        int iWeek = objCalendar.get(Calendar.WEEK_OF_YEAR);
        if (iWeek < 10) {
            strWeekID = iYear + "0" + iWeek;
        } else {
            strWeekID = iYear + String.valueOf(iWeek);
        }
        return strWeekID;
    }
    
    /**
     * ���ص�ǰ�ܳ�ָ��������������ڼ���.
     * 
     * @param year ��Ҫ�жϵ���ݡ�
     * @param week ��Ҫ�жϵĵڼ��ܡ�
     * @param deviateDate ��Ҫ���ų��������ַ�������
     * @return ���ص�ǰ�ܳ�ָ��������������ڼ��ϡ�
     */
    public static String[] otherDayOfWeek(int year, int week, String[] deviateDate) {
        List<String> objDates = new Vector<String>();
        Calendar objCalendar = Calendar.getInstance();
        objCalendar.set(Calendar.YEAR, year);
        objCalendar.set(Calendar.WEEK_OF_YEAR, week);
        for (int i = 0; i < 7; i++) {
            objCalendar.add(Calendar.DAY_OF_WEEK, (-1 * objCalendar.get(Calendar.DAY_OF_WEEK)) + 2 + i);
            objDates.add(formatDate(objCalendar.getTime()));
        }
        if (deviateDate != null) {
            for (int j = 0; j < deviateDate.length; j++) {
                if (objDates.contains(deviateDate[j])) {
                    objDates.remove(deviateDate[j]);
                }
            }
        }
        String[] strRtn = new String[objDates.size()];
        for (int k = 0; k < objDates.size(); k++) {
            strRtn[k] = objDates.get(k);
        }
        return strRtn;
    }
}
