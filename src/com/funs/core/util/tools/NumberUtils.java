/******************************************************************************
* Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
* All Rights Reserved.
* �����Ϊ����ǧ����ζ��˾�������ơ�
*****************************************************************************/
package com.funs.core.util.tools;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;

/**
 * ��ֵ����������չ
 *
 * @author �ƿ���
 * @since jdk6.0
 * @version  2012-12-16 �ƿ���
 */
public final class NumberUtils {
	
	/**
     * ���캯��
     */
    private NumberUtils() {
    }
    
    /**
     * ת��StringΪint���ͣ�ת��ʧ�ܷ���Ĭ��ָ��������defaultValue
     * 
     * @param str ��ת�����ַ���
     * @param defaultValue ת��ʧ�ܷ��ص�Ĭ������
     * @return ת��������֣����ʧ�ܼ�ΪĬ��ָ������
     */
    public static int stringToInt(String str, int defaultValue) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return defaultValue;
        }
    }
    
    /**
     * �����ַ������������ֵ
     * 
     * @param string ���������ַ���
     * @return �ַ����а�����������ֵ
     */
    public static int getIntValue(String string) {
        int iValue = 0;
        if (StringUtils.isNotEmpty(string)) {
            StringBuffer sbBuffer = new StringBuffer();
            char[] chArs = string.toCharArray();
            for (int i = 0; i < chArs.length; i++) {
                char chChar = chArs[i];
                if (chChar >= '0' && chChar <= '9') {
                    sbBuffer.append(chChar);
                } else if (chChar == ',') {
                    continue;
                } else {
                    if (sbBuffer.length() != 0) {
                        break;
                    }
                }
            }
            if (StringUtils.isNotEmpty(sbBuffer.toString())) {
                iValue = Integer.parseInt(sbBuffer.toString());
            }
        }
        return iValue;
    }
    
    /**
     * ת��һ���ַ���ΪFloat������<br>
     * ����null�ַ����ͷ���null
     * 
     * @param str Ҫת�����ַ���������Ϊnull
     * @return ת�����Float�������֣�����null����null
     */
    public static Float createFloat(String str) {
        if (str == null) {
            return null;
        }
        return Float.valueOf(str);
    }
    
    /**
     * �����ַ������˫��������ֵ
     * 
     * @param string ���������ַ���
     * @return �ַ����а�����˫��������ֵ
     */
    public static double getDoubleValue(String string) {
        double dValue = 0;
        
        if (string != null && string.length() != 0) {
            StringBuffer sbBuffer = new StringBuffer();
            
            char[] chArs = string.toCharArray();
            for (int i = 0; i < chArs.length; i++) {
                char chChar = chArs[i];
                if (chChar >= '0' && chChar <= '9') {
                    sbBuffer.append(chChar);
                } else if (chChar == '.') {
                    if (sbBuffer.length() == 0) {
                        continue;
                    } else if (sbBuffer.indexOf(".") != -1) {
                        break;
                    } else {
                        sbBuffer.append(chChar);
                    }
                } else {
                    if (sbBuffer.length() != 0) {
                        break;
                    }
                }
            }
            if (StringUtils.isNotEmpty(sbBuffer.toString())) {
                dValue = Double.parseDouble(sbBuffer.toString());
            }
        }
        return dValue;
    }
    
    /**
     * ת���ַ���ΪInteger���ͣ���ת��8���ƣ�10���ƣ�16���Ƶ���ʽ�� 8���ƣ�070 �� 16 ���� ��0x10�� �������Ϊnull ����null
     * 
     * @param str ��ת�����ַ���,����Ϊnull��
     * @return ת��������֣�����Ϊnull����null��
     */
    public static Integer createInteger(String str) {
        if (str == null) {
            return null;
        }
        // decode() handles 0xAABD and 0777 (hex and octal) as well.
        return Integer.decode(str);
    }
    
    /**
     * ת���ַ���ΪShort���ͣ���ת��8���ƣ�10���ƣ�16���Ƶ���ʽ�� 8���ƣ�070 �� 16 ���� ��0x10�� �������Ϊnull ����null
     * 
     * @param str ��ת�����ַ���,����Ϊnull��
     * @return ת��������֣�����Ϊnull����null��
     */
    public static Short createShort(String str) {
        if (str == null) {
            return null;
        }
        return Short.decode(str);
    }
    
    /**
     * ת���ַ���ΪLong���͡� ����null����null��
     * 
     * @param str Ҫת�����ַ���
     * @return ת���������
     */
    public static Long createLong(String str) {
        if (str == null) {
            return null;
        }
        return Long.valueOf(str);
    }
    
    /**
     * ת���ַ���ΪBigInteger���͡� ����null����null��
     * 
     * @param str Ҫת�����ַ���
     * @return ת���������
     */
    public static BigInteger createBigInteger(String str) {
        if (str == null) {
            return null;
        }
        return new BigInteger(str);
    }
    
    /**
     * ת���ַ���ΪBigDecimal���͡� ����null����null��
     * 
     * @param str Ҫת�����ַ���
     * @return ת���������
     */
    public static BigDecimal createBigDecimal(String str) {
        if (str == null) {
            return null;
        }
        if (NumberUtils.isBlank(str)) {
            throw new NumberFormatException("A blank string is not a valid number");
        }
        return new BigDecimal(str);
    }
    
    /**
     * ����ַ����е�ÿ���ַ��Ƿ�Ϊ�հ�<br>
     * ���ڿհ׵Ķ���ο�jdk�ĵ���Character.isWhitespace���ڿհ׵Ķ���
     * 
     * @param str ������ַ���
     * @return true���ַ������ǿհף�false���ַ���Ϊ�հס�
     */
    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || str.length() == 0) {
            return true;
        }
        strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * ���һ��int�������е���Сֵ
     * 
     * @param array int���飬����Ϊnull���߲���������
     * @return �����е���Сֵ
     */
    public static int min(int[] array) {
        // Validates input
        if (array == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        int iMin = array[0];
        for (int j = 1; j < array.length; j++) {
            if (array[j] < iMin) {
                iMin = array[j];
            }
        }
        return iMin;
    }
    
    /**
     * ���һ��short�������е���Сֵ
     * 
     * @param array short���飬����Ϊnull���߲���������
     * @return �����е���Сֵ
     */
    public static short min(short[] array) {
        if (array == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        short sMin = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < sMin) {
                sMin = array[i];
            }
        }
        
        return sMin;
    }
    
    /**
     * ���һ��double�������е���Сֵ
     * 
     * @param array double���飬����Ϊnull���߲���������
     * @return �����е���Сֵ
     */
    public static double min(double[] array) {
        // Validates input
        if (array == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        double dMin = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < dMin) {
                dMin = array[i];
            }
        }
        return dMin;
    }
    
    /**
     * ���һ��float�������е���Сֵ
     * 
     * @param array float���飬����Ϊnull���߲���������
     * @return �����е���Сֵ
     */
    public static float min(float[] array) {
        if (array == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        float fMin = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < fMin) {
                fMin = array[i];
            }
        }
        
        return fMin;
    }
    
    /**
     * ���һ��long�������е����ֵ
     * 
     * @param array long���飬����Ϊnull���߲���������
     * @return �����е����ֵ
     */
    public static long max(long[] array) {
        // Validates input
        if (array == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        
        // Finds and returns max
        long lMax = array[0];
        for (int j = 1; j < array.length; j++) {
            if (array[j] > lMax) {
                lMax = array[j];
            }
        }
        
        return lMax;
    }
    
    /**
     * ���һ��int�������е����ֵ
     * 
     * @param array int���飬����Ϊnull���߲���������
     * @return �����е����ֵ
     */
    public static int max(int[] array) {
        // Validates input
        if (array == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        
        // Finds and returns max
        int iMax = array[0];
        for (int j = 1; j < array.length; j++) {
            if (array[j] > iMax) {
                iMax = array[j];
            }
        }
        
        return iMax;
    }
    
    /**
     * ���һ��short�������е����ֵ
     * 
     * @param array short���飬����Ϊnull���߲���������
     * @return �����е����ֵ
     */
    public static short max(short[] array) {
        // Validates input
        if (array == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        
        // Finds and returns max
        short sMax = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > sMax) {
                sMax = array[i];
            }
        }
        
        return sMax;
    }
    
    /**
     * ���һ��double�������е����ֵ
     * 
     * @param array double���飬����Ϊnull���߲���������
     * @return �����е����ֵ
     */
    public static double max(double[] array) {
        // Validates input
        if (array == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        
        // Finds and returns max
        double dMax = array[0];
        for (int j = 1; j < array.length; j++) {
            if (array[j] > dMax) {
                dMax = array[j];
            }
        }
        
        return dMax;
    }
    
    /**
     * ���һ��float�������е����ֵ
     * 
     * @param array float���飬����Ϊnull���߲���������
     * @return �����е����ֵ
     */
    public static float max(float[] array) {
        // Validates input
        if (array == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        
        // Finds and returns max
        float fMax = array[0];
        for (int j = 1; j < array.length; j++) {
            if (array[j] > fMax) {
                fMax = array[j];
            }
        }
        
        return fMax;
    }
    
    /**
     * ����3��long���������е���Сֵ
     * 
     * @param a ����1
     * @param b ����2
     * @param c ����3
     * @return 3��long���������е���Сֵ
     */
    public static long min(long a, long b, long c) {
        long lX = a;
        if (b < lX) {
            lX = b;
        }
        if (c < lX) {
            lX = c;
        }
        return lX;
    }
    
    /**
     * ����3��int���������е���Сֵ
     * 
     * @param a ����1
     * @param b ����2
     * @param c ����3
     * @return 3��int���������е���Сֵ
     */
    public static int min(int a, int b, int c) {
        int lX = a;
        if (b < lX) {
            lX = b;
        }
        if (c < lX) {
            lX = c;
        }
        return lX;
    }
    
    /**
     * ����3��short���������е���Сֵ
     * 
     * @param a ����1
     * @param b ����2
     * @param c ����3
     * @return 3��short���������е���Сֵ
     */
    public static short min(short a, short b, short c) {
        short sX = a;
        if (b < sX) {
            sX = b;
        }
        if (c < sX) {
            sX = c;
        }
        return sX;
    }
    
    /**
     * ����3��byte���������е���Сֵ
     * 
     * @param a ����1
     * @param b ����2
     * @param c ����3
     * @return 3��byte���������е���Сֵ
     */
    public static byte min(byte a, byte b, byte c) {
        byte byteX = a;
        if (b < byteX) {
            byteX = b;
        }
        if (c < byteX) {
            byteX = c;
        }
        return byteX;
    }
    
    /**
     * ����3��double���������е���Сֵ �����������NaN�ͷ���NaN��Infinity�ܱ�����
     * 
     * @param a ����1
     * @param b ����2
     * @param c ����3
     * @return 3��double���������е���Сֵ
     */
    public static double min(double a, double b, double c) {
        return Math.min(Math.min(a, b), c);
    }
    
    /**
     * ����3��float���������е���Сֵ �����������NaN�ͷ���NaN��Infinity�ܱ�����
     * 
     * @param a ����1
     * @param b ����2
     * @param c ����3
     * @return 3��float���������е���Сֵ
     */
    public static float min(float a, float b, float c) {
        return Math.min(Math.min(a, b), c);
    }
    
    /**
     * ����3��long���������е����ֵ
     * 
     * @param a ����1
     * @param b ����2
     * @param c ����3
     * @return 3��long���������е����ֵ
     */
    public static long max(long a, long b, long c) {
        long lX = a;
        if (b > lX) {
            lX = b;
        }
        if (c > lX) {
            lX = c;
        }
        return lX;
    }
    
    /**
     * ����3��int���������е����ֵ
     * 
     * @param a ����1
     * @param b ����2
     * @param c ����3
     * @return 3��int���������е����ֵ
     */
    public static int max(int a, int b, int c) {
        int iX = a;
        if (b > iX) {
            iX = b;
        }
        if (c > iX) {
            iX = c;
        }
        return iX;
    }
    
    /**
     * ����3��short���������е����ֵ
     * 
     * @param a ����1
     * @param b ����2
     * @param c ����3
     * @return 3��short���������е����ֵ
     */
    public static short max(short a, short b, short c) {
        short sX = a;
        if (b > sX) {
            sX = b;
        }
        if (c > sX) {
            sX = c;
        }
        return sX;
    }
    
    /**
     * ����3��byte���������е����ֵ
     * 
     * @param a ����1
     * @param b ����2
     * @param c ����3
     * @return 3��byte���������е����ֵ
     */
    public static byte max(byte a, byte b, byte c) {
        byte byteX = a;
        if (b > byteX) {
            byteX = b;
        }
        if (c > byteX) {
            byteX = c;
        }
        return byteX;
    }
    
    /**
     * ����3��double���������е����ֵ �����������NaN�ͷ���NaN��Infinity�ܱ�����
     * 
     * @param a ����1
     * @param b ����2
     * @param c ����3
     * @return 3��double���������е����ֵ
     */
    public static double max(double a, double b, double c) {
        return Math.max(Math.max(a, b), c);
    }
    
    /**
     * ����3��float���������е����ֵ �����������NaN�ͷ���NaN��Infinity�ܱ�����
     * 
     * @param a ����1
     * @param b ����2
     * @param c ����3
     * @return 3��float���������е����ֵ
     */
    public static float max(float a, float b, float c) {
        return Math.max(Math.max(a, b), c);
    }
    
    /**
     * �Ƚ�����double�������ݵĴ�С<br>
     * �����һ������С�ڵڶ�����������-1;<br>
     * �����һ���������ڵڶ�����������+1;<br>
     * �����һ���������ڵڶ�����������0;
     * <p>
     * ���ִӴ�С��˳������Ϊ��
     * <ul>
     * <li>NaN
     * <li>Positive infinity
     * <li>Maximum double
     * <li>Normal positve numbers
     * <li>+0.0
     * <li>-0.0
     * <li>Normal negative numbers
     * <li>Minimum double (<code>-Double.MAX_VALUE</code>)
     * <li>Negative infinity
     * </ul>
     * </p>
     * NaN��NaN�ȽϷ���0
     * 
     * @param lhs �Ƚ���1
     * @param rhs �Ƚ���2
     * @return -1��lhsС��+1��lhs��0��lhs��rhs���
     */
    public static int compare(double lhs, double rhs) {
        if (lhs < rhs) {
            return -1;
        }
        if (lhs > rhs) {
            return +1;
        }
        // Need to compare bits to handle 0.0 == -0.0 being true
        // compare should put -0.0 < +0.0
        // Two NaNs are also == for compare purposes
        // where NaN == NaN is false
        long lLhsBits = Double.doubleToLongBits(lhs);
        long lRhsBits = Double.doubleToLongBits(rhs);
        if (lLhsBits == lRhsBits) {
            return 0;
        }
        // Something exotic! A comparison to NaN or 0.0 vs -0.0
        // Fortunately NaN's long is > than everything else
        // Also negzeros bits < poszero
        // NAN: 9221120237041090560
        // MAX: 9218868437227405311
        // NEGZERO: -9223372036854775808
        if (lLhsBits < lRhsBits) {
            return -1;
        }
        return +1;
    }
    
    /**
     * �Ƚ�����float�������ݵĴ�С<br>
     * �����һ������С�ڵڶ�����������-1;<br>
     * �����һ���������ڵڶ�����������+1;<br>
     * �����һ���������ڵڶ�����������0;
     * <p>
     * ���ִӴ�С��˳������Ϊ��
     * <ul>
     * <li>NaN
     * <li>Positive infinity
     * <li>Maximum float
     * <li>Normal positve numbers
     * <li>+0.0
     * <li>-0.0
     * <li>Normal negative numbers
     * <li>Minimum float (<code>-Float.MAX_VALUE</code>)
     * <li>Negative infinity
     * </ul>
     * NaN��NaN�ȽϷ���0
     * 
     * @param lhs �Ƚ���1
     * @param rhs �Ƚ���2
     * @return -1��lhsС��+1��lhs��0��lhs��rhs���
     */
    public static int compare(float lhs, float rhs) {
        if (lhs < rhs) {
            return -1;
        }
        if (lhs > rhs) {
            return +1;
        }
        // Need to compare bits to handle 0.0 == -0.0 being true
        // compare should put -0.0 < +0.0
        // Two NaNs are also == for compare purposes
        // where NaN == NaN is false
        int iLhsBits = Float.floatToIntBits(lhs);
        int iRhsBits = Float.floatToIntBits(rhs);
        if (iLhsBits == iRhsBits) {
            return 0;
        }
        // Something exotic! A comparison to NaN or 0.0 vs -0.0
        // Fortunately NaN's int is > than everything else
        // Also negzeros bits < poszero
        // NAN: 2143289344
        // MAX: 2139095039
        // NEGZERO: -2147483648
        if (iLhsBits < iRhsBits) {
            return -1;
        }
        return +1;
    }
    
    /**
     * �ṩ��ȷ�ļӷ����㡣
     * 
     * @param v1 ������
     * @param v2 ����
     * @return ���������ĺ�
     */
    public static double doubleAdd(double v1, double v2) {
        BigDecimal objB1 = new BigDecimal(Double.toString(v1));
        BigDecimal objB2 = new BigDecimal(Double.toString(v2));
        return objB1.add(objB2).doubleValue();
    }
    
    /**
     * �ṩ��ȷ�ļ������㡣
     * 
     * @param v1 ������
     * @param v2 ����
     * @return ���������Ĳ�
     */
    public static double doubleSub(double v1, double v2) {
        BigDecimal objB1 = new BigDecimal(Double.toString(v1));
        BigDecimal objB2 = new BigDecimal(Double.toString(v2));
        return objB1.subtract(objB2).doubleValue();
    }
    
    /**
     * �ṩ��ȷ�ĳ˷����㡣
     * 
     * @param v1 ������
     * @param v2 ����
     * @return ���������Ļ�
     */
    public static double doubleMul(double v1, double v2) {
        BigDecimal objB1 = new BigDecimal(Double.toString(v1));
        BigDecimal objB2 = new BigDecimal(Double.toString(v2));
        return objB1.multiply(objB2).doubleValue();
    }
    
    /**
     * �ṩ����ԣ���ȷ�ĳ������㣬�����������������ʱ����ȷ�� С�����Ժ�10λ���Ժ�������������롣
     * 
     * @param v1 ������
     * @param v2 ����
     * @return ������������
     */
    public static double doubleDiv(double v1, double v2) {
        return doubleDiv(v1, v2, 10);
    }
    
    /**
     * �ṩ����ԣ���ȷ�ĳ������㡣�����������������ʱ����scale����ָ �����ȣ��Ժ�������������롣
     * 
     * @param v1 ������
     * @param v2 ����
     * @param scale ��ʾ��ʾ��Ҫ��ȷ��С�����Ժ�λ��
     * @return ������������
     */
    public static double doubleDiv(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal objB1 = new BigDecimal(Double.toString(v1));
        BigDecimal objB2 = new BigDecimal(Double.toString(v2));
        return objB1.divide(objB2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    
    /**
     * �ṩ��ȷ��С��λ�������봦��
     * 
     * @param v ��Ҫ�������������
     * @param scale С���������λ
     * @return ���������Ľ��
     */
    public static double round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal objB = new BigDecimal(Double.toString(v));
        return objB.divide(BigDecimal.ONE, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    
    /**
     * �ṩ��ȷ��С��λ�������봦��
     * 
     * @param v ��Ҫ�������������
     * @param scale С���������λ
     * @return ���������Ľ��
     */
    public static double doubleRound(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal objB = new BigDecimal(Double.toString(v));
        return objB.divide(BigDecimal.ONE, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    
    /**
     * �ṩ��ȷ��С��λ�������봦��
     * 
     * @param v ��Ҫ�������������
     * @param scale С���������λ
     * @return ���������Ľ��
     */
    public static String doubleRoundString(double v, int scale) {
        return Double.toString(doubleRound(v, scale));
    }
    
    /**
     * ��һ��������ת��Ϊһ������λС������ַ�����ͨ�����ڻ���֮���ת��
     * 
     * <pre>
     * NumberUtils.convertToMoney(0.0f)= 0.00
     * NumberUtils.convertToMoney(10.0f)= 10.00
     * NumberUtils.convertToMoney(1000.0f)= 1000.00
     * NumberUtils.convertToMoney(10.506f)= 10.52
     * NumberUtils.convertToMoney(5f)= 5.00
     * </pre>
     * 
     * @param money ��Ҫ��ת���ĸ�����
     * @return ���ر���ʽ���ĸ�����,ͨ���������ù������ڻ���֮���ת����
     */
    public static String convertToMoney(float money) {
        BigDecimal objB = new BigDecimal(Double.toString(money));
        return objB.divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).toString();
    }
    
    /**
     * ���ض���ʽ��ʾǮ��������eg:100,000.23
     * 
     * <pre>
     * NumberUtils.moneyFormat(&quot;10.23&quot;)= 10.23
     * NumberUtils.moneyFormat(&quot;100.23&quot;)= 100.23
     * NumberUtils.moneyFormat(&quot;1000.23&quot;)= 1,000.23
     * NumberUtils.moneyFormat(&quot;10000.23&quot;)= 10,000.23
     * NumberUtils.moneyFormat(&quot;100000.23&quot;)= 100,000.23
     * NumberUtils.moneyFormat(&quot;0&quot;)= 0.00
     * NumberUtils.moneyFormat(&quot;-1&quot;)= -1.00
     * NumberUtils.moneyFormat(&quot;0.25&quot;)= 0.25
     * </pre>
     * 
     * @param money ��Ҫ�������Ǯ�������ַ�����
     * @return ��Ҫ��ĳ���ض���ʽ����ת������ַ�����
     */
    public static String moneyFormat(String money) {
        String strFormatMoney = "0.00";
        BigDecimal objBigDec = new BigDecimal(money);
        
        BigInteger objX100BigInt = objBigDec.multiply(new BigDecimal(100)).toBigInteger();
        String strX100Str = objX100BigInt.abs().toString();
        while (strX100Str.length() < 3) {
            strX100Str = "0" + strX100Str;
        }
        String strFDot = strX100Str.substring(0, strX100Str.length() - 2);
        String strBDot = strX100Str.substring(strX100Str.length() - 2);
        int i = strFDot.length() % 3;
        int j = strFDot.length() / 3;
        if (i == 0) {
            i = 3;
            j--;
        }
        StringBuffer objBuffer = new StringBuffer(strFDot.substring(0, i));
        for (int k = 0; k < j; k++) {
            objBuffer.append("," + strFDot.substring(i + (3 * k), i + (3 * (k + 1))));
        }
        strFDot = objBuffer.toString();
        strFormatMoney = strFDot + "." + strBDot;
        if (objX100BigInt.signum() == -1) {
            strFormatMoney = "-" + strFormatMoney;
        }
        return strFormatMoney;
    }
    
    /**
     * ��ָ���ĸ�ʽ����ʽ�����֡�
     * 
     * <pre>
     * NumberUtils.formatDouble(0.25689d,&quot;#,##.#&quot;)= 0.3
     * NumberUtils.formatDouble(0.25689d,&quot;##,##.#&quot;)= 0.3
     * NumberUtils.formatDouble(0.25689d,&quot;###,##.##&quot;)= 0.26
     * NumberUtils.formatDouble(0.25689d,&quot;###,#,#.##&quot;)= 0.26
     * NumberUtils.formatDouble(0.25689d,&quot;#,#,#,##.##&quot;)= 0.26
     * NumberUtils.formatDouble(0.25689d,&quot;###,##.###&quot;)= 0.257
     * </pre>
     * 
     * @param value ��Ҫ����ʽ��������
     * @param format ָ����Ҫ����ʽ������ʽ
     * @return ���ر���ʽ������ַ�����
     */
    public static String formatDouble(double value, String format) {
        DecimalFormat objDecimalFormat = new DecimalFormat(format);
        return objDecimalFormat.format(value);
    }
    
    /**
     * ת��StringΪlong���ͣ�ת��ʧ�ܷ���Ĭ��ָ��������defaultValue
     * 
     * @param str ��ת�����ַ���
     * @param defaultValue ת��ʧ�ܷ��ص�Ĭ������
     * @return ת��������֣����ʧ�ܼ�ΪĬ��ָ������
     */
    public static long stringToLong(String str, long defaultValue) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException nfe) {
            return defaultValue;
        }
    }
    
    /**
     * �����ܼ�¼����ÿ���μ�¼����ȡ
     * 
     * @param sizeCount �ܼ�¼��
     * @param pageSize ÿ���μ�¼��
     * @return ��������
     */
    public static int getPageCount(int sizeCount, int pageSize) {
        if (sizeCount <= 0) {
            return 0;
        }
        if (pageSize <= 0) {
            throw new IllegalArgumentException("��Ч��ÿ���μ�¼��");
        }
        int iPageNo = (sizeCount % pageSize == 0) ? (sizeCount / pageSize) : (sizeCount / pageSize + 1);
        return iPageNo;
    }
}
