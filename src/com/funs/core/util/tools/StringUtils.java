/******************************************************************************
* Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
* All Rights Reserved.
* �����Ϊ����ǧ����ζ��˾�������ơ�
*****************************************************************************/
package com.funs.core.util.tools;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.WordUtils;

/**
 * �ַ�����������
 *
 * @author �ƿ���
 * @since jdk6.0
 * @version  2012-12-16 �ƿ���
 */
public final class StringUtils {
	
	/**
     * ���ַ���ʹ�ó���EMPTY������: <code>""</code>.
     */
    public static final String EMPTY = "";
    
    /**
     * <p>
     * �ɱ䳤��string������չ����󳤶ȳ���.
     * </p>
     */
    public static final int PAD_LIMIT = 8192;
    
    /**
     * <p>
     * һ����������<code>String</code>����.
     * </p>
     * <p>
     * ���ڸ�Ч�Ŀռ����. ������Ҫ��չÿ��string�ĳ���.
     * </p>
     */
    private static final String[] CONSTANTS_PADDING = new String[Character.MAX_VALUE];
    
    /** ���ַ������� */
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    
    static {
        // space padding is most common, start with 64 chars
        CONSTANTS_PADDING[32] = "                                                                ";
    }
    
    /**
     * <p>
     * <code>StringUtils</code> ���г��˹��캯�������Ķ��Ǿ�̬���� �����ڳ����в�Ӧ����������ʵ�� Ӧ������ʹ��:<code>StringUtils.trim(" foo ");</code>.
     * </p>
     * <p>
     * Ĭ�ϵĹ��췽����Ϊ�� JavaBean �Ĳ�����
     * </p>
     */
    private StringUtils() {
    }
    
    /**
     * <p>
     * ���string�ĳ����Ƿ�Ϊ0(���ַ���)����string�Ƿ�Ϊnull.
     * </p>
     * 
     * <pre>
     * StringUtils.isEmpty(null)      = true
     * StringUtils.isEmpty(&quot;&quot;)        = true
     * StringUtils.isEmpty(&quot; &quot;)       = false
     * StringUtils.isEmpty(&quot;bob&quot;)     = false
     * StringUtils.isEmpty(&quot;  bob  &quot;) = false
     * </pre>
     * 
     * @param string ��Ҫ����string, ����Ϊnull
     * @return <code>true</code> ���stringΪnull����string�ĳ���Ϊ0
     */
    public static boolean isEmpty(String string) {
        return org.apache.commons.lang.StringUtils.isEmpty(string);
    }
    
    /**
     * <p>
     * �Ƿ�string�ĳ��Ȳ�Ϊ0(���ַ���)����string��Ϊnull.
     * </p>
     * 
     * <pre>
     * StringUtils.isNotEmpty(null)      = false
     * StringUtils.isNotEmpty(&quot;&quot;)        = false
     * StringUtils.isNotEmpty(&quot; &quot;)       = true
     * StringUtils.isNotEmpty(&quot;bob&quot;)     = true
     * StringUtils.isNotEmpty(&quot;  bob  &quot;) = true
     * </pre>
     * 
     * @param string ��Ҫ����string, ����Ϊnull
     * @return <code>true</code> ���string��Ϊnull����string�ĳ��Ȳ�Ϊ0���ǿո�
     */
    public static boolean isNotEmpty(String string) {
        return org.apache.commons.lang.StringUtils.isNotEmpty(string);
    }
    
    /**
     * <p>
     * ���string�Ƿ��ǿհ׻���stringΪnull.
     * </p>
     * 
     * <pre>
     * StringUtils.isBlank(null)      = true
     * StringUtils.isBlank(&quot;&quot;)        = true
     * StringUtils.isBlank(&quot; &quot;)       = true
     * StringUtils.isBlank(&quot;bob&quot;)     = false
     * StringUtils.isBlank(&quot;  bob  &quot;) = false
     * </pre>
     * 
     * @param string ��Ҫ����string, ����Ϊnull
     * @return <code>true</code> ���stringΪnull����string������Ϊ�հ�
     * @since 2.0
     */
    public static boolean isBlank(String string) {
        return org.apache.commons.lang.StringUtils.isBlank(string);
    }
    
    /**
     * <p>
     * �Ƿ�string��Ϊ�հף�string�ĳ��Ȳ�Ϊ0��string��Ϊnull.
     * </p>
     * 
     * <pre>
     * StringUtils.isNotBlank(null)      = false
     * StringUtils.isNotBlank(&quot;&quot;)        = false
     * StringUtils.isNotBlank(&quot; &quot;)       = false
     * StringUtils.isNotBlank(&quot;bob&quot;)     = true
     * StringUtils.isNotBlank(&quot;  bob  &quot;) = true
     * </pre>
     * 
     * @param string ��Ҫ����string, ����Ϊnull
     * @return <code>true</code> ���string��Ϊnull���� string��Ϊ�հף�string�ĳ��Ȳ�Ϊ0.
     * @since 2.0
     */
    public static boolean isNotBlank(String string) {
        return org.apache.commons.lang.StringUtils.isNotBlank(string);
    }
    
    /**
     * <p>
     * ��ȥstringǰ�����ߵĿ����ַ�(char &lt;= 32) ������ <code>null</code> ʱ����һ����string("").
     * </p>
     * 
     * <pre>
     * StringUtils.clean(null)          = &quot;&quot;
     * StringUtils.clean(&quot;&quot;)            = &quot;&quot;
     * StringUtils.clean(&quot;abc&quot;)         = &quot;abc&quot;
     * StringUtils.clean(&quot;    abc    &quot;) = &quot;abc&quot;
     * StringUtils.clean(&quot;     &quot;)       = &quot;&quot;
     * </pre>
     * 
     * @see java.lang.String#trim()
     * @param str ��Ҫ��տհ׵�string, ����Ϊnull
     * @return ����տհ׵�string,����в������κε�<code>null</code>
     * @deprecated ʹ�����ָ������ķ���: {@link #trimToEmpty(String)}. �� Commons Lang 3.0. �˷������ᱻȡ��
     */
    @Deprecated
    public static String clean(String str) {
        return str == null ? EMPTY : str.trim();
    }
    
    /**
     * <p>
     * ��ȥstringǰ�����ߵĿ����ַ� (char &lt;= 32) ������ <code>null</code> ʱ����null.
     * </p>
     * <p>
     * ������stringǰ��հ׵ķ���ʹ���� {@link String#trim()}. �����stringǰ����ַ�(char &lt;= 32) Ҫ����հ��ַ�����ѡ�� {@link #strip(String)}.
     * </p>
     * <p>
     * ���string���������ƶ����ַ�,�����"abc"�е�"a"���Ϊ"bc", ʹ�� {@link #strip(String, String)} ����.
     * </p>
     * 
     * <pre>
     * StringUtils.trim(null)          = null
     * StringUtils.trim(&quot;&quot;)            = &quot;&quot;
     * StringUtils.trim(&quot;     &quot;)       = &quot;&quot;
     * StringUtils.trim(&quot;abc&quot;)         = &quot;abc&quot;
     * StringUtils.trim(&quot;    abc    &quot;) = &quot;abc&quot;
     * </pre>
     * 
     * @param string ��Ҫ���д����string,����Ϊ��
     * @return ������˿հ׵�string, ������Ϊnullʱ����<code>null</code>
     */
    public static String trim(String string) {
        return org.apache.commons.lang.StringUtils.trim(string);
    }
    
    /**
     * <p>
     * �Ƴ�string�����˵Ŀ����ַ�(char &lt;= 32) stringΪnull,string���ַ���Ϊ�հ�(&lt;= 32)����string�ĳ���Ϊ0ʱ ���صĽ��Ϊ<code>null</code>
     * <p>
     * ������stringǰ��հ׵ķ���ʹ���� {@link String#trim()}. �����stringǰ���(char &lt;= 32)�ַ�. Ҫ����հ׿���ʹ�� {@link #stripToNull(String)}
     * .
     * </p>
     * 
     * <pre>
     * StringUtils.trimToNull(null)          = null
     * StringUtils.trimToNull(&quot;&quot;)            = null
     * StringUtils.trimToNull(&quot;     &quot;)       = null
     * StringUtils.trimToNull(&quot;abc&quot;)         = &quot;abc&quot;
     * StringUtils.trimToNull(&quot;    abc    &quot;) = &quot;abc&quot;
     * </pre>
     * 
     * @param string ��Ҫ���д����string,����Ϊ��
     * @return ���ش��������� �������string���ַ���Ϊ�հ�(&lt;= 32),string�ĳ���Ϊ0 ����stringΪnullʱ����<code>null</code>
     * @since 2.0
     */
    public static String trimToNull(String string) {
        return org.apache.commons.lang.StringUtils.trimToNull(string);
    }
    
    /**
     * <p>
     * �Ƴ�stringǰ�����˵Ŀ����ַ� (char &lt;= 32) ��stringΪ<code>null</code>,string�ĳ���Ϊ0 ����string�е������ַ���Ϊ�հ�ʱ. �������("").
     * <p>
     * ������stringǰ��հ׵ķ���ʹ���� {@link String#trim()}. �����stringǰ���(char &lt;= 32)�ַ�. Ҫ����հ׿���ʹ��
     * {@link #stripToEmpty(String)}.
     * </p>
     * 
     * <pre>
     * StringUtils.trimToEmpty(null)          = &quot;&quot;
     * StringUtils.trimToEmpty(&quot;&quot;)            = &quot;&quot;
     * StringUtils.trimToEmpty(&quot;     &quot;)       = &quot;&quot;
     * StringUtils.trimToEmpty(&quot;abc&quot;)         = &quot;abc&quot;
     * StringUtils.trimToEmpty(&quot;    abc    &quot;) = &quot;abc&quot;
     * </pre>
     * 
     * @param string ��Ҫ���д����string,����Ϊ��
     * @return ���ش���������, ����Ϊ<code>null</code>ʱ����""
     * @since 2.0
     */
    public static String trimToEmpty(String string) {
        return org.apache.commons.lang.StringUtils.trimToEmpty(string);
    }
    
    /**
     * <p>
     * ���string���˵Ŀհ׵��ַ�.
     * </p>
     * <p>
     * ���������{@link #trim(String)}����,�������Ƴ�whitespace. Whitespace �Ķ����� {@link Character#isWhitespace(char)}.
     * </p>
     * <p>
     * <code>null</code> ��String���뽫���� <code>null</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.strip(null)     = null
     * StringUtils.strip(&quot;&quot;)       = &quot;&quot;
     * StringUtils.strip(&quot;   &quot;)    = &quot;&quot;
     * StringUtils.strip(&quot;abc&quot;)    = &quot;abc&quot;
     * StringUtils.strip(&quot;  abc&quot;)  = &quot;abc&quot;
     * StringUtils.strip(&quot;abc  &quot;)  = &quot;abc&quot;
     * StringUtils.strip(&quot; abc &quot;)  = &quot;abc&quot;
     * StringUtils.strip(&quot; ab c &quot;) = &quot;ab c&quot;
     * </pre>
     * 
     * @param string ��Ҫ�Ƴ��հ׵�string,����Ϊnull
     * @return �����Ľ��, ����Ϊnullʱ����<code>null</code>
     */
    public static String strip(String string) {
        return org.apache.commons.lang.StringUtils.strip(string);
    }
    
    /**
     * <p>
     * ���string���˵Ŀհ׵��ַ� ����<code>null</code> ��stringΪnull,string����Ϊ0����string���ַ���Ϊ�հ�.
     * </p>
     * <p>
     * ���������{@link #trimToNull(String)}����,�������Ƴ�whitespace. Whitespace �Ķ����� {@link Character#isWhitespace(char)}.
     * </p>
     * 
     * <pre>
     * StringUtils.strip(null)     = null
     * StringUtils.strip(&quot;&quot;)       = null
     * StringUtils.strip(&quot;   &quot;)    = null
     * StringUtils.strip(&quot;abc&quot;)    = &quot;abc&quot;
     * StringUtils.strip(&quot;  abc&quot;)  = &quot;abc&quot;
     * StringUtils.strip(&quot;abc  &quot;)  = &quot;abc&quot;
     * StringUtils.strip(&quot; abc &quot;)  = &quot;abc&quot;
     * StringUtils.strip(&quot; ab c &quot;) = &quot;ab c&quot;
     * </pre>
     * 
     * @param string ��Ҫ�Ƴ��հ׵�string,����Ϊnull
     * @return �����Ľ��, ����<code>null</code>������Ϊnull,string����Ϊ0����string���ַ���Ϊ�հ�
     * @since 2.0
     */
    public static String stripToNull(String string) {
        return org.apache.commons.lang.StringUtils.stripToNull(string);
    }
    
    /**
     * <p>
     * ���string���˵Ŀհ׵��ַ� �������Ϊ<code>null</code>����("").
     * </p>
     * <p>
     * ��������� {@link #trimToEmpty(String)}����,�������Ƴ�whitespace. Whitespace �Ķ����� {@link Character#isWhitespace(char)}.
     * </p>
     * 
     * <pre>
     * StringUtils.strip(null)     = &quot;&quot;
     * StringUtils.strip(&quot;&quot;)       = &quot;&quot;
     * StringUtils.strip(&quot;   &quot;)    = &quot;&quot;
     * StringUtils.strip(&quot;abc&quot;)    = &quot;abc&quot;
     * StringUtils.strip(&quot;  abc&quot;)  = &quot;abc&quot;
     * StringUtils.strip(&quot;abc  &quot;)  = &quot;abc&quot;
     * StringUtils.strip(&quot; abc &quot;)  = &quot;abc&quot;
     * StringUtils.strip(&quot; ab c &quot;) = &quot;ab c&quot;
     * </pre>
     * 
     * @param string ��Ҫ�Ƴ��հ׵�string,����Ϊnull
     * @return �����Ľ��, ����<code>null</code>ʱ����"".
     * @since 2.0
     */
    public static String stripToEmpty(String string) {
        return org.apache.commons.lang.StringUtils.stripToEmpty(string);
    }
    
    /**
     * <p>
     * ���string��ָ�����ַ�. ��������� {@link String#trim()}����,�������ѡ������Ҫ�Ƴ����ַ�.
     * </p>
     * <p>
     * ��һ����������<code>null</code>ʱ����<code>null</code>. ���� ("")ʱ����("").
     * </p>
     * <p>
     * ����ڶ�������Ϊ<code>null</code>, ��{@link Character#isWhitespace(char)}�ж����whitespace�����Ƴ�. ��ʹ��{@link #strip(String)}һ��.
     * </p>
     * 
     * <pre>
     * StringUtils.strip(null, *)          = null
     * StringUtils.strip(&quot;&quot;, *)            = &quot;&quot;
     * StringUtils.strip(&quot;abc&quot;, null)      = &quot;abc&quot;
     * StringUtils.strip(&quot;  abc&quot;, null)    = &quot;abc&quot;
     * StringUtils.strip(&quot;abc  &quot;, null)    = &quot;abc&quot;
     * StringUtils.strip(&quot; abc &quot;, null)    = &quot;abc&quot;
     * StringUtils.strip(&quot;  abcyx&quot;, &quot;xyz&quot;) = &quot;  abc&quot;
     * </pre>
     * 
     * @param string ��Ҫ�Ƴ��ַ���string,����Ϊnull
     * @param stripChars ѡ��Ҫ�Ƴ����ַ�, null������whitespace����
     * @return �����Ƴ���Ľ��, �����һ������Ϊnull����<code>null</code>
     */
    public static String strip(String string, String stripChars) {
        return org.apache.commons.lang.StringUtils.strip(string, stripChars);
    }
    
    /**
     * <p>
     * �Ƴ�string�Ŀ�����ָ�����ַ�.
     * </p>
     * <p>
     * ��һ������Ϊ<code>null</code>ʱ����<code>null</code>. ����Ϊ ("") ʱ���� ("").
     * </p>
     * <p>
     * �ڶ�������Ϊ <code>null</code>, ��{@link Character#isWhitespace(char)}�ж����whitespace�����Ƴ�.
     * </p>
     * 
     * <pre>
     * StringUtils.stripStart(null, *)          = null
     * StringUtils.stripStart(&quot;&quot;, *)            = &quot;&quot;
     * StringUtils.stripStart(&quot;abc&quot;, &quot;&quot;)        = &quot;abc&quot;
     * StringUtils.stripStart(&quot;abc&quot;, null)      = &quot;abc&quot;
     * StringUtils.stripStart(&quot;  abc&quot;, null)    = &quot;abc&quot;
     * StringUtils.stripStart(&quot;abc  &quot;, null)    = &quot;abc  &quot;
     * StringUtils.stripStart(&quot; abc &quot;, null)    = &quot;abc &quot;
     * StringUtils.stripStart(&quot;yxabc  &quot;, &quot;xyz&quot;) = &quot;abc  &quot;
     * </pre>
     * 
     * @param string ��Ҫ�Ƴ��ַ���string,����Ϊnull
     * @param stripChars ѡ��Ҫ�Ƴ����ַ�, null������whitespace����
     * @return �����Ƴ���Ľ��, �����һ������Ϊnull����<code>null</code>
     */
    public static String stripStart(String string, String stripChars) {
        return org.apache.commons.lang.StringUtils.stripStart(string, stripChars);
    }
    
    /**
     * <p>
     * �Ƴ�string��ĩβ��ָ�����ַ�.
     * </p>
     * <p>
     * ��һ������Ϊ<code>null</code>ʱ����<code>null</code>. ����Ϊ ("") ʱ���� ("").
     * </p>
     * <p>
     * �ڶ�������Ϊ <code>null</code>, ��{@link Character#isWhitespace(char)}�ж����whitespace�����Ƴ�.
     * </p>
     * 
     * <pre>
     * StringUtils.stripEnd(null, *)          = null
     * StringUtils.stripEnd(&quot;&quot;, *)            = &quot;&quot;
     * StringUtils.stripEnd(&quot;abc&quot;, &quot;&quot;)        = &quot;abc&quot;
     * StringUtils.stripEnd(&quot;abc&quot;, null)      = &quot;abc&quot;
     * StringUtils.stripEnd(&quot;  abc&quot;, null)    = &quot;  abc&quot;
     * StringUtils.stripEnd(&quot;abc  &quot;, null)    = &quot;abc&quot;
     * StringUtils.stripEnd(&quot; abc &quot;, null)    = &quot; abc&quot;
     * StringUtils.stripEnd(&quot;  abcyx&quot;, &quot;xyz&quot;) = &quot;  abc&quot;
     * </pre>
     * 
     * @param string ��Ҫ�Ƴ��ַ���string,����Ϊnull
     * @param stripChars ѡ��Ҫ�Ƴ����ַ�, null������whitespace����
     * @return �����Ƴ���Ľ��, �����һ������Ϊnull����<code>null</code>
     */
    public static String stripEnd(String string, String stripChars) {
        return org.apache.commons.lang.StringUtils.stripEnd(string, stripChars);
    }
    
    /**
     * <p>
     * �Ƴ�string������ÿ��string�����˵Ŀհ��ַ�. Whitespace �Ķ����� {@link Character#isWhitespace(char)}.
     * </p>
     * <p>
     * ÿ�ζ�����һ���µ�����, ��������ĳ���Ϊ0ʱ. һ��<code>null</code>���齫����<code>null</code>. �����齫����������. ������Ϊ<code>null</code>������Ԫ�ؽ�������.
     * </p>
     * 
     * <pre>
     * StringUtils.stripAll(null)             = null
     * StringUtils.stripAll([])               = []
     * StringUtils.stripAll([&quot;abc&quot;, &quot;  abc&quot;]) = [&quot;abc&quot;, &quot;abc&quot;]
     * StringUtils.stripAll([&quot;abc  &quot;, null])  = [&quot;abc&quot;, null]
     * </pre>
     * 
     * @param strs ��Ҫ�����string����,����Ϊnull
     * @return ���ش�����,�������Ϊnull������<code>null</code>
     */
    public static String[] stripAll(String[] strs) {
        return org.apache.commons.lang.StringUtils.stripAll(strs);
    }
    
    /**
     * <p>
     * �Ƴ�string������ÿ��string�����˵�ָ���ַ� .
     * </p>
     * Whitespace �Ķ����� {@link Character#isWhitespace(char)}. </p>
     * <p>
     * ÿ�ζ�����һ���µ�����, ��������ĳ���Ϊ0ʱ. һ��<code>null</code>���齫����<code>null</code>. �����齫����������. ������Ϊ<code>null</code>������Ԫ�ؽ�������.
     * �ڶ�������Ϊ<code>null</code>ʱ���Ƴ��� {@link Character#isWhitespace(char)}�����whitespace .
     * </p>
     * 
     * <pre>
     * StringUtils.stripAll(null, *)                = null
     * StringUtils.stripAll([], *)                  = []
     * StringUtils.stripAll([&quot;abc&quot;, &quot;  abc&quot;], null) = [&quot;abc&quot;, &quot;abc&quot;]
     * StringUtils.stripAll([&quot;abc  &quot;, null], null)  = [&quot;abc&quot;, null]
     * StringUtils.stripAll([&quot;abc  &quot;, null], &quot;yz&quot;)  = [&quot;abc  &quot;, null]
     * StringUtils.stripAll([&quot;yabcz&quot;, null], &quot;yz&quot;)  = [&quot;abc&quot;, null]
     * </pre>
     * 
     * @param strs ��Ҫ�����string����,����Ϊnull
     * @param stripChars Ҫ���Ƴ����ַ�, null����Ϊ��whitespace
     * @return �����Ľ��, ����null������ʱ����<code>null</code>
     */
    public static String[] stripAll(String[] strs, String stripChars) {
        return org.apache.commons.lang.StringUtils.stripAll(strs, stripChars);
    }
    
    /**
     * <p>
     * �Ƚ�����string, ���ʱ����<code>true</code>.
     * </p>
     * <p>
     * �ܴ���Ƚ�����Ϊ<code>null</code>�����. ����<code>null</code> �Ƚ�ʱ��Ϊ����ȵ�. �Ƚ�ʱ�����ִ�Сд��.
     * </p>
     * 
     * <pre>
     * StringUtils.equals(null, null)   = true
     * StringUtils.equals(null, &quot;abc&quot;)  = false
     * StringUtils.equals(&quot;abc&quot;, null)  = false
     * StringUtils.equals(&quot;abc&quot;, &quot;abc&quot;) = true
     * StringUtils.equals(&quot;abc&quot;, &quot;ABC&quot;) = false
     * </pre>
     * 
     * @see java.lang.String#equals(Object)
     * @param str1 ��һ��string����,����Ϊnull
     * @param str2 �ڶ���string����,����Ϊnull
     * @return <code>true</code> ������string���ʱ, ���ִ�Сд, ���� ͬΪ<code>null</code>
     */
    public static boolean equals(String str1, String str2) {
        return org.apache.commons.lang.StringUtils.equals(str1, str2);
    }
    
    /**
     * <p>
     * �Ƚ�����string, ���Դ�Сдʱ��ȷ��� <code>true</code>.
     * </p>
     * <p>
     * �ܴ���Ƚ�����Ϊ<code>null</code>�����. ����<code>null</code> �Ƚ�ʱ��Ϊ����ȵ�. �Ƚ�ʱ�ǲ����ִ�Сд��.
     * </p>
     * 
     * <pre>
     * StringUtils.equalsIgnoreCase(null, null)   = true
     * StringUtils.equalsIgnoreCase(null, &quot;abc&quot;)  = false
     * StringUtils.equalsIgnoreCase(&quot;abc&quot;, null)  = false
     * StringUtils.equalsIgnoreCase(&quot;abc&quot;, &quot;abc&quot;) = true
     * StringUtils.equalsIgnoreCase(&quot;abc&quot;, &quot;ABC&quot;) = true
     * </pre>
     * 
     * @see java.lang.String#equalsIgnoreCase(String)
     * @param str1 ��һ��string����,����Ϊnull
     * @param str2 �ڶ���string����,����Ϊnull
     * @return <code>true</code> ����string���, �����ִ�Сд, ���� ͬΪ<code>null</code>
     */
    public static boolean equalsIgnoreCase(String str1, String str2) {
        return org.apache.commons.lang.StringUtils.equalsIgnoreCase(str1, str2);
    }
    
    /**
     * <p>
     * ����string�е�һ��ָ���ַ���λ��, �ܴ���<code>null</code>�����. �������ʹ���� {@link String#indexOf(int)}.
     * </p>
     * <p>
     * һ��<code>null</code>�ַ�������("")�ַ������᷵��<code>-1</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.indexOf(null, *)         = -1
     * StringUtils.indexOf(&quot;&quot;, *)           = -1
     * StringUtils.indexOf(&quot;aabaabaa&quot;, 'a') = 0
     * StringUtils.indexOf(&quot;aabaabaa&quot;, 'b') = 2
     * </pre>
     * 
     * @param string ��Ҫ�����string,����Ϊnull
     * @param searchChar Ҫ���м������ַ�
     * @return ��һ�����ּ������ַ���λ��, -1 string ��û��ָ�����ַ���������<code>null</code>���ַ���
     * @since 2.0
     */
    public static int indexOf(String string, char searchChar) {
        return org.apache.commons.lang.StringUtils.indexOf(string, searchChar);
    }
    
    /**
     * <p>
     * ������string�д���ʼλ��ʼ��һ��ָ���ַ���λ��,�ܴ���<code>null</code>�����. �������ʹ���� {@link String#indexOf(int, int)}.
     * </p>
     * <p>
     * Ϊ<code>null</code>�����ַ���Ϊ("")������<code>-1</code>. �����ʼλΪ�����������ӵ�һλ��ʼ����. �����ʼ��λ�ñ�string�ĳ��ȴ󽫷��� <code>-1</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.indexOf(null, *, *)          = -1
     * StringUtils.indexOf(&quot;&quot;, *, *)            = -1
     * StringUtils.indexOf(&quot;aabaabaa&quot;, 'b', 0)  = 2
     * StringUtils.indexOf(&quot;aabaabaa&quot;, 'b', 3)  = 5
     * StringUtils.indexOf(&quot;aabaabaa&quot;, 'b', 9)  = -1
     * StringUtils.indexOf(&quot;aabaabaa&quot;, 'b', -1) = 2
     * </pre>
     * 
     * @param string ��Ҫ�����string,����Ϊnull
     * @param searchChar Ҫ���м������ַ�
     * @param startPos ��ʼλ�ã�������������
     * @return ��һ�����ּ������ַ���λ��, -1 string ��û��ָ�����ַ���������<code>null</code>���ַ���
     * @since 2.0
     */
    public static int indexOf(String string, char searchChar, int startPos) {
        return org.apache.commons.lang.StringUtils.indexOf(string, searchChar, startPos);
    }
    
    /**
     * <p>
     * ����string�е�һ��ָ���ַ���λ��, �ܴ��� <code>null</code>�����. T�������ʹ���� {@link String#indexOf(String)}.
     * </p>
     * <p>
     * Ϊ<code>null</code> ��String ���� <code>-1</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.indexOf(null, *)          = -1
     * StringUtils.indexOf(*, null)          = -1
     * StringUtils.indexOf(&quot;&quot;, &quot;&quot;)           = 0
     * StringUtils.indexOf(&quot;aabaabaa&quot;, &quot;a&quot;)  = 0
     * StringUtils.indexOf(&quot;aabaabaa&quot;, &quot;b&quot;)  = 2
     * StringUtils.indexOf(&quot;aabaabaa&quot;, &quot;ab&quot;) = 1
     * StringUtils.indexOf(&quot;aabaabaa&quot;, &quot;&quot;)   = 0
     * </pre>
     * 
     * @param string ��Ҫ�����string,����Ϊnull
     * @param searchStr Ҫ���м������ַ�,����Ϊnull
     * @return ��һ�����ּ������ַ���λ��, -1 string ��û��ָ�����ַ���������<code>null</code>���ַ���
     */
    public static int indexOf(String string, String searchStr) {
        return org.apache.commons.lang.StringUtils.indexOf(string, searchStr);
    }
    
    /**
     * <p>
     * ������string�д�ָ��λ��ʼ��һ��ָ���ַ���λ��, �ܴ��� <code>null</code>�����. �������ʹ���� {@link String#indexOf(String, int)}.
     * </p>
     * <p>
     * Ϊ<code>null</code> ��String ���� <code>-1</code>. �����ļ���λ�õ�����. �յ��ַ�("") ������������.
     * ���������λ�ô���string�ĳ���,ֻ�е�����������Ϊ("")ʱ���ܷ��ؽ�� .
     * </p>
     * 
     * <pre>
     * StringUtils.indexOf(null, *, *)          = -1
     * StringUtils.indexOf(*, null, *)          = -1
     * StringUtils.indexOf(&quot;&quot;, &quot;&quot;, 0)           = 0
     * StringUtils.indexOf(&quot;aabaabaa&quot;, &quot;a&quot;, 0)  = 0
     * StringUtils.indexOf(&quot;aabaabaa&quot;, &quot;b&quot;, 0)  = 2
     * StringUtils.indexOf(&quot;aabaabaa&quot;, &quot;ab&quot;, 0) = 1
     * StringUtils.indexOf(&quot;aabaabaa&quot;, &quot;b&quot;, 3)  = 5
     * StringUtils.indexOf(&quot;aabaabaa&quot;, &quot;b&quot;, 9)  = -1
     * StringUtils.indexOf(&quot;aabaabaa&quot;, &quot;b&quot;, -1) = 2
     * StringUtils.indexOf(&quot;aabaabaa&quot;, &quot;&quot;, 2)   = 2
     * StringUtils.indexOf(&quot;abc&quot;, &quot;&quot;, 9)        = 3
     * </pre>
     * 
     * @param string ��Ҫ�����string,����Ϊnull
     * @param searchStr Ҫ���м������ַ�,����Ϊnull
     * @param startPos ��ʼλ�ã�������������
     * @return ��һ�����ּ������ַ���λ��, -1 string ��û��ָ�����ַ���������<code>null</code>���ַ���
     */
    public static int indexOf(String string, String searchStr, int startPos) {
        return org.apache.commons.lang.StringUtils.indexOf(string, searchStr, startPos);
    }
    
    /**
     * <p>
     * ����string�����һ��ָ���ַ���λ��, �ܴ��� <code>null</code>�����. �������ʹ���� {@link String#lastIndexOf(int)}.
     * </p>
     * <p>
     * <code>null</code>��string����("") String ���� <code>-1</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.lastIndexOf(null, *)         = -1
     * StringUtils.lastIndexOf(&quot;&quot;, *)           = -1
     * StringUtils.lastIndexOf(&quot;aabaabaa&quot;, 'a') = 7
     * StringUtils.lastIndexOf(&quot;aabaabaa&quot;, 'b') = 5
     * </pre>
     * 
     * @param string ��Ҫ�����string,����Ϊnull
     * @param searchChar Ҫ���м������ַ�
     * @return �����ּ������ַ���λ��, -1 string ��û��ָ�����ַ���������<code>null</code>���ַ���
     * @since 2.0
     */
    public static int lastIndexOf(String string, char searchChar) {
        return org.apache.commons.lang.StringUtils.lastIndexOf(string, searchChar);
    }
    
    /**
     * <p>
     * ������string�д�ָ��λ��ʼ���һ��ָ���ַ���λ��, �ܴ��� <code>null</code>�����. �������ʹ���� {@link String#lastIndexOf(int, int)}.
     * </p>
     * <p>
     * <code>null</code>��string����("") String ���� <code>-1</code>. �����ʼλ��Ϊ����������<code>-1</code>.
     * ��ʼλ�ô���string�ĳ��Ƚ���������string.
     * </p>
     * 
     * <pre>
     * StringUtils.lastIndexOf(null, *, *)          = -1
     * StringUtils.lastIndexOf(&quot;&quot;, *,  *)           = -1
     * StringUtils.lastIndexOf(&quot;aabaabaa&quot;, 'b', 8)  = 5
     * StringUtils.lastIndexOf(&quot;aabaabaa&quot;, 'b', 4)  = 2
     * StringUtils.lastIndexOf(&quot;aabaabaa&quot;, 'b', 0)  = -1
     * StringUtils.lastIndexOf(&quot;aabaabaa&quot;, 'b', 9)  = 5
     * StringUtils.lastIndexOf(&quot;aabaabaa&quot;, 'b', -1) = -1
     * StringUtils.lastIndexOf(&quot;aabaabaa&quot;, 'a', 0)  = 0
     * </pre>
     * 
     * @param string ��Ҫ�����string,����Ϊnull
     * @param searchChar ��Ҫ��ѯ���ַ�
     * @param startPos ��ѯ����ʼλ��
     * @return ���һ��ָ���ַ���λ��, -1 string ��û��ָ�����ַ���������<code>null</code>���ַ���
     * @since 2.0
     */
    public static int lastIndexOf(String string, char searchChar, int startPos) {
        return org.apache.commons.lang.StringUtils.lastIndexOf(string, searchChar, startPos);
    }
    
    /**
     * <p>
     * ������string�����һ��ָ���ַ���λ��, �ܴ��� <code>null</code>�����. �������ʹ���� {@link String#lastIndexOf(String)}.
     * </p>
     * <p>
     * <code>null</code>��String ������ <code>-1</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.lastIndexOf(null, *)          = -1
     * StringUtils.lastIndexOf(*, null)          = -1
     * StringUtils.lastIndexOf(&quot;&quot;, &quot;&quot;)           = 0
     * StringUtils.lastIndexOf(&quot;aabaabaa&quot;, &quot;a&quot;)  = 0  ---
     * StringUtils.lastIndexOf(&quot;aabaabaa&quot;, &quot;b&quot;)  = 2  ---
     * StringUtils.lastIndexOf(&quot;aabaabaa&quot;, &quot;ab&quot;) = 1  ---
     * StringUtils.lastIndexOf(&quot;aabaabaa&quot;, &quot;&quot;)   = 8
     * </pre>
     * 
     * @param string ��Ҫ�����string,����Ϊnull
     * @param searchStr ��Ҫ���ҵ�string, ����Ϊnull
     * @return the last index of the search String, -1 string ��û��ָ�����ַ���������<code>null</code>���ַ���
     * @since 2.0
     */
    public static int lastIndexOf(String string, String searchStr) {
        return org.apache.commons.lang.StringUtils.lastIndexOf(string, searchStr);
    }
    
    /**
     * <p>
     * �������ַ���str��ָ��λ��startPos��ǰ���ַ����� �ض��ַ�searchStr�����ֵ�λ��, �ܴ��� <code>null</code>�����. �������ʹ����
     * {@link String#lastIndexOf(String, int)}.
     * </p>
     * <p>
     * <code>null</code> ��String ������ <code>-1</code>. �����ʼλ��Ϊ���������� <code>-1</code>. ������ʼλ��Ϊ����,��ô�յ�string("")��������ƥ��.
     * �����ʼλ������string�ĳ��Ƚ�������string���м���.
     * </p>
     * 
     * <pre>
     * StringUtils.lastIndexOf(null, *, *)          = -1
     * StringUtils.lastIndexOf(*, null, *)          = -1
     * StringUtils.lastIndexOf(&quot;aabaabaa&quot;, &quot;a&quot;, 8)  = 7
     * StringUtils.lastIndexOf(&quot;aabaabaa&quot;, &quot;b&quot;, 8)  = 5
     * StringUtils.lastIndexOf(&quot;aabaabaa&quot;, &quot;ab&quot;, 8) = 4
     * StringUtils.lastIndexOf(&quot;aabaabaa&quot;, &quot;b&quot;, 9)  = 5
     * StringUtils.lastIndexOf(&quot;aabaabaa&quot;, &quot;b&quot;, -1) = -1
     * StringUtils.lastIndexOf(&quot;aabaabaa&quot;, &quot;a&quot;, 0)  = 0
     * StringUtils.lastIndexOf(&quot;aabaabaa&quot;, &quot;b&quot;, 0)  = -1
     * </pre>
     * 
     * @param string ��Ҫ�����string,����Ϊnull
     * @param searchStr ��Ҫ��ѯ��string, ����Ϊnull
     * @param startPos ��ʼ��ѯ��λ��, ����������
     * @return ��������λ��, -1 string ��û��ָ�����ַ���������<code>null</code>���ַ���
     * @since 2.0
     */
    public static int lastIndexOf(String string, String searchStr, int startPos) {
        return org.apache.commons.lang.StringUtils.lastIndexOf(string, searchStr, startPos);
    }
    
    /**
     * <p>
     * ����ַ���str�Ƿ����ָ�����ַ�searchChar, �ܴ��� <code>null</code>�����. �������ʹ���� {@link String#indexOf(int)}.
     * </p>
     * <p>
     * <code>null</code>�ַ����߿��ַ���("")������ <code>false</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.contains(null, *)    = false
     * StringUtils.contains(&quot;&quot;, *)      = false
     * StringUtils.contains(&quot;abc&quot;, 'a') = true
     * StringUtils.contains(&quot;abc&quot;, 'z') = false
     * </pre>
     * 
     * @param string ��Ҫ�����string,����Ϊnull
     * @param searchChar Ҫ���ҵ��ַ�
     * @return true string�а���Ҫ���ҵ��ַ�, false û��Ҫ���ҵ��ַ���������λ <code>null</code>
     * @since 2.0
     */
    public static boolean contains(String string, char searchChar) {
        return org.apache.commons.lang.StringUtils.contains(string, searchChar);
    }
    
    /**
     * <p>
     * ���string�Ƿ����ָ�����ַ���, �ܴ��� <code>null</code>�����. �������ʹ���� {@link String#indexOf(int)}.
     * </p>
     * <p>
     * <code>null</code> ��String ���� <code>false</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.contains(null, *)     = false
     * StringUtils.contains(*, null)     = false
     * StringUtils.contains(&quot;&quot;, &quot;&quot;)      = true
     * StringUtils.contains(&quot;abc&quot;, &quot;&quot;)   = true
     * StringUtils.contains(&quot;abc&quot;, &quot;a&quot;)  = true
     * StringUtils.contains(&quot;abc&quot;, &quot;z&quot;)  = false
     * </pre>
     * 
     * @param string ��Ҫ�����string,����Ϊnull
     * @param searchStr ��Ҫ���ҵ��ַ���, ����Ϊnull
     * @return true string�а���Ҫ���ҵ��ַ���, false û��Ҫ���ҵ��ַ���������λ <code>null</code>
     * @since 2.0
     */
    public static boolean contains(String string, String searchStr) {
        return org.apache.commons.lang.StringUtils.contains(string, searchStr);
    }
    
    /**
     * <p>
     * �������ַ���str�е�һ�������ַ�����searchChars�������ַ���λ�� .
     * </p>
     * <p>
     * <code>null</code> ��String ����<code>-1</code>. <code>null</code> �����ַ�����ĳ���Ϊ�㷵��<code>-1</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.indexOfAny(null, *)                = -1
     * StringUtils.indexOfAny(&quot;&quot;, *)                  = -1
     * StringUtils.indexOfAny(*, null)                = -1
     * StringUtils.indexOfAny(*, [])                  = -1
     * StringUtils.indexOfAny(&quot;zzabyycdxx&quot;,['z','a']) = 0
     * StringUtils.indexOfAny(&quot;zzabyycdxx&quot;,['b','y']) = 3
     * StringUtils.indexOfAny(&quot;aba&quot;, ['z'])           = -1
     * </pre>
     * 
     * @param string ��Ҫ�����string,����Ϊnull
     * @param searchChars ��Ҫ���ҵ��ַ�, ����Ϊnull
     * @return ���ص�һ����������λ��, û���ʺϵĻ�������null��������-1
     * @since 2.0
     */
    public static int indexOfAny(String string, char[] searchChars) {
        return org.apache.commons.lang.StringUtils.indexOfAny(string, searchChars);
    }
    
    /**
     * <p>
     * �������ַ���str�е�һ�������ַ���searchChars�������ַ���λ�� .
     * </p>
     * <p>
     * <code>null</code> ��String ����<code>-1</code>. ��Ҫ������stringΪ<code>null</code> ���� <code>-1</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.indexOfAny(null, *)            = -1
     * StringUtils.indexOfAny(&quot;&quot;, *)              = -1
     * StringUtils.indexOfAny(*, null)            = -1
     * StringUtils.indexOfAny(*, &quot;&quot;)              = -1
     * StringUtils.indexOfAny(&quot;zzabyycdxx&quot;, &quot;za&quot;) = 0
     * StringUtils.indexOfAny(&quot;zzabyycdxx&quot;, &quot;by&quot;) = 3
     * StringUtils.indexOfAny(&quot;aba&quot;,&quot;z&quot;)          = -1
     * </pre>
     * 
     * @param string ��Ҫ�����string,����Ϊnull
     * @param searchChars ��Ҫ���ҵ��ַ�, ����Ϊnull
     * @return ���ص�һ����������λ��, û���ʺϵĻ�������null��������-1
     * @since 2.0
     */
    public static int indexOfAny(String string, String searchChars) {
        return org.apache.commons.lang.StringUtils.indexOfAny(string, searchChars);
    }
    
    /**
     * <p>
     * �������ַ���str�е�һ�����ֲ����ַ�����searchChars���ַ���λ�� .
     * </p>
     * <p>
     * <code>null</code> ��String ���� <code>-1</code>. <code>null</code> �����ַ��ĳ���Ϊ�㷵��<code>-1</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.indexOfAnyBut(null, *)           = -1
     * StringUtils.indexOfAnyBut(&quot;&quot;, *)             = -1
     * StringUtils.indexOfAnyBut(*, null)           = -1
     * StringUtils.indexOfAnyBut(*, [])             = -1
     * StringUtils.indexOfAnyBut(&quot;zzabyycdxx&quot;,'za') = 3
     * StringUtils.indexOfAnyBut(&quot;zzabyycdxx&quot;, '')  = 0
     * StringUtils.indexOfAnyBut(&quot;aba&quot;, 'ab')       = -1
     * </pre>
     * 
     * @param string ��Ҫ�����string,����Ϊnull
     * @param searchChars Ҫ�������ַ�, ����Ϊnull
     * @return ���ص�һ����������λ��, û���ʺϵĻ�������null��������-1
     * @since 2.0
     */
    public static int indexOfAnyBut(String string, char[] searchChars) {
        return org.apache.commons.lang.StringUtils.indexOfAnyBut(string, searchChars);
    }
    
    /**
     * <p>
     * �������ַ���str�е�һ�����ֲ����ַ���searchChars���ַ���λ�� .
     * </p>
     * <p>
     * ��һ������Ϊ<code>null</code>������<code>-1</code>. �ڶ�������Ϊ<code>null</code>������<code>-1</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.indexOfAnyBut(null, *)            = -1
     * StringUtils.indexOfAnyBut(&quot;&quot;, *)              = -1
     * StringUtils.indexOfAnyBut(*, null)            = -1
     * StringUtils.indexOfAnyBut(*, &quot;&quot;)              = -1
     * StringUtils.indexOfAnyBut(&quot;zzabyycdxx&quot;, &quot;za&quot;) = 3
     * StringUtils.indexOfAnyBut(&quot;zzabyycdxx&quot;, &quot;&quot;)   = 0
     * StringUtils.indexOfAnyBut(&quot;aba&quot;,&quot;ab&quot;)         = -1
     * </pre>
     * 
     * @param string ��Ҫ�����string,����Ϊnull
     * @param searchChars �ַ���A�п��ܰ������ַ���B, ����Ϊnull
     * @return ���ص�һ����������λ��, û���ʺϵĻ�������null��������-1
     * @since 2.0
     */
    public static int indexOfAnyBut(String string, String searchChars) {
        return org.apache.commons.lang.StringUtils.indexOfAnyBut(string, searchChars);
    }
    
    /**
     * <p>
     * �ַ���str���Ƿ�ֻ���ַ�����valid�е��ַ�.
     * </p>
     * <p>
     * ��һ������Ϊ<code>null</code> ���� <code>false</code>. �ڶ�������Ϊ<code>null</code> ���� <code>false</code>. ��һ������Ϊ ("") ����
     * <code>true</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.containsOnly(null, *)       = false
     * StringUtils.containsOnly(*, null)       = false
     * StringUtils.containsOnly(&quot;&quot;, *)         = true
     * StringUtils.containsOnly(&quot;ab&quot;, '')      = false
     * StringUtils.containsOnly(&quot;abab&quot;, 'abc') = true
     * StringUtils.containsOnly(&quot;ab1&quot;, 'abc')  = false
     * StringUtils.containsOnly(&quot;abz&quot;, 'abc')  = false
     * </pre>
     * 
     * @param string ��Ҫ�����string,����Ϊnull
     * @param valid �ַ��������, ����Ϊnull
     * @return true �ַ�����Ϊnull,�����ַ����е��ַ������ַ������е��ַ�
     */
    public static boolean containsOnly(String string, char[] valid) {
        return org.apache.commons.lang.StringUtils.containsOnly(string, valid);
    }
    
    /**
     * <p>
     * �ַ���str���Ƿ�ֻ���ַ���validChars�е��ַ�.
     * </p>
     * <p>
     * ��һ������Ϊ<code>null</code> ���� <code>false</code>. �ڶ�������Ϊ<code>null</code> ���� <code>false</code>. ��һ������Ϊ ("") ����
     * <code>true</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.containsOnly(null, *)       = false
     * StringUtils.containsOnly(*, null)       = false
     * StringUtils.containsOnly(&quot;&quot;, *)         = true
     * StringUtils.containsOnly(&quot;ab&quot;, &quot;&quot;)      = false
     * StringUtils.containsOnly(&quot;abab&quot;, &quot;abc&quot;) = true
     * StringUtils.containsOnly(&quot;ab1&quot;, &quot;abc&quot;)  = false
     * StringUtils.containsOnly(&quot;abz&quot;, &quot;abc&quot;)  = false
     * </pre>
     * 
     * @param string ��Ҫ�����string,����Ϊnull
     * @param validChars �ַ�������, ����Ϊnull
     * @return true �ַ�����Ϊnull,�����ַ���str�е��ַ������ַ���validChars�е��ַ�
     * @since 2.0
     */
    public static boolean containsOnly(String string, String validChars) {
        return org.apache.commons.lang.StringUtils.containsOnly(string, validChars);
    }
    
    /**
     * <p>
     * ����ַ���str���Ƿ񲻺����ַ�����invalidChar�е��ַ�.
     * </p>
     * <p>
     * ��һ������Ϊ<code>null</code> ���� <code>true</code>. �ڶ�������Ϊ<code>null</code> ���� <code>true</code>. ��������Ϊ��("") ʱ����true.
     * </p>
     * 
     * <pre>
     * StringUtils.containsNone(null, *)       = true
     * StringUtils.containsNone(*, null)       = true
     * StringUtils.containsNone(&quot;&quot;, *)         = true
     * StringUtils.containsNone(&quot;ab&quot;, '')      = true
     * StringUtils.containsNone(&quot;abab&quot;, 'xyz') = true
     * StringUtils.containsNone(&quot;ab1&quot;, 'xyz')  = true
     * StringUtils.containsNone(&quot;abz&quot;, 'xyz')  = false
     * </pre>
     * 
     * @param string ��Ҫ�����string,����Ϊnulll
     * @param invalidChars �ַ��������, ����Ϊnull
     * @return true �ַ���str�в������ַ�����invalidChar�е��ַ�, ���߲���Ϊnull
     * @since 2.0
     */
    public static boolean containsNone(String string, char[] invalidChars) {
        return org.apache.commons.lang.StringUtils.containsNone(string, invalidChars);
    }
    
    /**
     * <p>
     * ����ַ���str���Ƿ񲻺����ַ���invalidChar�е��ַ�.
     * </p>
     * <p>
     * ��һ������strΪ<code>null</code> ���� <code>true</code>. �ڶ�������invalidCharsΪ<code>null</code> ���� <code>true</code>.
     * ��������Ϊ��("") ʱ����true.
     * </p>
     * 
     * <pre>
     * StringUtils.containsNone(null, *)       = true
     * StringUtils.containsNone(*, null)       = true
     * StringUtils.containsNone(&quot;&quot;, *)         = true
     * StringUtils.containsNone(&quot;ab&quot;, &quot;&quot;)      = true
     * StringUtils.containsNone(&quot;abab&quot;, &quot;xyz&quot;) = true
     * StringUtils.containsNone(&quot;ab1&quot;, &quot;xyz&quot;)  = true
     * StringUtils.containsNone(&quot;abz&quot;, &quot;xyz&quot;)  = false
     * </pre>
     * 
     * @param string ��Ҫ�����string,����Ϊnull
     * @param invalidChars �ַ�������, ����Ϊnull
     * @return true �ַ���str�в������ַ���invalidChar�е��ַ�, ���߲���Ϊnull
     * @since 2.0
     */
    public static boolean containsNone(String string, String invalidChars) {
        return org.apache.commons.lang.StringUtils.containsNone(string, invalidChars);
    }
    
    /**
     * <p>
     * �ҳ��ַ���str�е�һ�γ����ַ�������searchStrs��Ԫ�ص�λ��.
     * </p>
     * <p>
     * ��һ������strΪ<code>null</code>����<code>-1</code>. �ڶ�������searchStrsΪ<code>null</code> ���߳���Ϊ0����<code>-1</code>.
     * �ڶ�������searchStrsΪ<code>null</code> �������������, �����Ϊ[""] ���� <code>0</code> �� <code>��һ������</code>��Ϊnullʱ. �������ʹ����
     * {@link String#indexOf(String)}.
     * </p>
     * 
     * <pre>
     * StringUtils.indexOfAny(null, *)                     = -1
     * StringUtils.indexOfAny(*, null)                     = -1
     * StringUtils.indexOfAny(*, [])                       = -1
     * StringUtils.indexOfAny(&quot;zzabyycdxx&quot;, [&quot;ab&quot;,&quot;cd&quot;])   = 2
     * StringUtils.indexOfAny(&quot;zzabyycdxx&quot;, [&quot;cd&quot;,&quot;ab&quot;])   = 2
     * StringUtils.indexOfAny(&quot;zzabyycdxx&quot;, [&quot;mn&quot;,&quot;op&quot;])   = -1
     * StringUtils.indexOfAny(&quot;zzabyycdxx&quot;, [&quot;zab&quot;,&quot;aby&quot;]) = 1
     * StringUtils.indexOfAny(&quot;zzabyycdxx&quot;, [&quot;&quot;])          = 0
     * StringUtils.indexOfAny(&quot;&quot;, [&quot;&quot;])                    = 0
     * StringUtils.indexOfAny(&quot;&quot;, [&quot;a&quot;])                   = -1
     * </pre>
     * 
     * @param string ��Ҫ�����string,����Ϊnull
     * @param searchStrs �ַ����������, ����Ϊnull
     * @return �ַ���str�е�һ�γ����ַ�������searchStrs��Ԫ�ص�λ��, -1 û���ʺϵ����
     */
    public static int indexOfAny(String string, String[] searchStrs) {
        return org.apache.commons.lang.StringUtils.indexOfAny(string, searchStrs);
    }
    
    /**
     * <p>
     * �ҳ��ַ���str���������ַ�������searchStrs��Ԫ�ص�λ��.
     * </p>
     * <p>
     * ��һ������strΪ<code>null</code>����<code>-1</code>. A <code>null</code> search array will return <code>-1</code>. A
     * <code>null</code> or zero length search array entry will be ignored, ����һ������str��Ϊnullʱ,�ڶ�������searchStrs����"" ����� ������
     * <code>str</code>�ĳ���. �������ʹ���� {@link String#indexOf(String)}
     * </p>
     * 
     * <pre>
     * StringUtils.lastIndexOfAny(null, *)                   = -1
     * StringUtils.lastIndexOfAny(*, null)                   = -1
     * StringUtils.lastIndexOfAny(*, [])                     = -1
     * StringUtils.lastIndexOfAny(*, [null])                 = -1
     * StringUtils.lastIndexOfAny(&quot;zzabyycdxx&quot;, [&quot;ab&quot;,&quot;cd&quot;]) = 6
     * StringUtils.lastIndexOfAny(&quot;zzabyycdxx&quot;, [&quot;cd&quot;,&quot;ab&quot;]) = 6
     * StringUtils.lastIndexOfAny(&quot;zzabyycdxx&quot;, [&quot;mn&quot;,&quot;op&quot;]) = -1
     * StringUtils.lastIndexOfAny(&quot;zzabyycdxx&quot;, [&quot;mn&quot;,&quot;op&quot;]) = -1
     * StringUtils.lastIndexOfAny(&quot;zzabyycdxx&quot;, [&quot;mn&quot;,&quot;&quot;])   = 10
     * </pre>
     * 
     * @param string ��Ҫ�����string,����Ϊnull
     * @param searchStrs �ַ����������, ����Ϊnull
     * @return �ַ���str���������ַ�������searchStrs��Ԫ�ص�λ��, -1 û���ʺϵ����
     */
    public static int lastIndexOfAny(String string, String[] searchStrs) {
        return org.apache.commons.lang.StringUtils.lastIndexOfAny(string, searchStrs);
    }
    
    /**
     * <p>
     * ���ַ���str��ָ��λ��start������ַ���.
     * </p>
     * <p>
     * �ڶ�������startΪ����ʱ��ȡstart�ľ���ֵ����str��ĩ�˿�����<code>n</code> ���ַ�.
     * </p>
     * <p>
     * A <code>null</code> String will return <code>null</code>. An empty ("") String will return "".
     * </p>
     * 
     * <pre>
     * StringUtils.substring(null, *)   = null
     * StringUtils.substring(&quot;&quot;, *)     = &quot;&quot;
     * StringUtils.substring(&quot;abc&quot;, 0)  = &quot;abc&quot;
     * StringUtils.substring(&quot;abc&quot;, 2)  = &quot;c&quot;
     * StringUtils.substring(&quot;abc&quot;, 4)  = &quot;&quot;
     * StringUtils.substring(&quot;abc&quot;, -2) = &quot;bc&quot;
     * StringUtils.substring(&quot;abc&quot;, -4) = &quot;abc&quot;
     * </pre>
     * 
     * @param string Ҫ��str�л�����ַ���,����Ϊnull
     * @param start λ�õĿ�ʼλ��, ����ʱȡstart�ľ���ֵ����str��ĩ�˿������ַ�
     * @return ����ʼλ��start��ʼ���Ӵ�, ����ĵ�һ���ַ���Ϊnullʱ����<code>null</code>
     */
    public static String substring(String string, int start) {
        return org.apache.commons.lang.StringUtils.substring(string, start);
    }
    
    /**
     * <p>
     * ���ַ���str�л�ôӿ�ʼλ��start������λend�����ַ��������ұ������쳣.
     * </p>
     * <p>
     * start/end ��ʹ�ø�������ʾ,������ַ���str��ĩ�˿�ʼ���� .
     * </p>
     * <p>
     * ���ص��ַ�����<code>start</code>λ�ÿ�ʼ �� <code>end</code> λ�ý���. �ַ����Ŀ�ʼλ����0��ʼ�� -- i.e.,Ҫ���ַ����ĵ�һλ��ʼ<code>start = 0</code>.
     * �����Ŀ�ʼλ��ƫ�����������str��ĩ�˿�ʼ�� .
     * </p>
     * <p>
     * �����ʼλ��<code>start</code>������<code>end</code>λ�õ����,������ "" .
     * </p>
     * 
     * <pre>
     * StringUtils.substring(null, *, *)    = null
     * StringUtils.substring(&quot;&quot;, * ,  *)    = &quot;&quot;;
     * StringUtils.substring(&quot;abc&quot;, 0, 2)   = &quot;ab&quot;
     * StringUtils.substring(&quot;abc&quot;, 2, 0)   = &quot;&quot;
     * StringUtils.substring(&quot;abc&quot;, 2, 4)   = &quot;c&quot;
     * StringUtils.substring(&quot;abc&quot;, 4, 6)   = &quot;&quot;
     * StringUtils.substring(&quot;abc&quot;, 2, 2)   = &quot;&quot;
     * StringUtils.substring(&quot;abc&quot;, -2, -1) = &quot;b&quot;
     * StringUtils.substring(&quot;abc&quot;, -4, 2)  = &quot;ab&quot;
     * </pre>
     * 
     * @param string Ҫ���л�����ַ�����string,����Ϊnull
     * @param start ���ַ����Ŀ�ʼλ��, ����������ַ�����ĩ�˿�ʼ����
     * @param end ���ַ����Ľ���λ��, ����������ַ�����ĩ�˿�ʼ����
     * @return �ӿ�ʼstart������end�����ַ���,��������strΪnull����<code>null</code>
     */
    public static String substring(String string, int start, int end) {
        return org.apache.commons.lang.StringUtils.substring(string, start, end);
    }
    
    /**
     * <p>
     * ���ַ���������߻��ָ������<code>len</code> ���ַ���.
     * </p>
     * <p>
     * ���ָ������<code>len</code> ������Ч��, ����strΪ<code>null</code>, str����Ϊ����ֵ�����׳��쳣. ���ָ���ĳ���Ϊ�������׳��쳣.
     * </p>
     * 
     * <pre>
     * StringUtils.left(null, *)    = null
     * StringUtils.left(*, -ve)     = &quot;&quot;
     * StringUtils.left(&quot;&quot;, *)      = &quot;&quot;
     * StringUtils.left(&quot;abc&quot;, 0)   = &quot;&quot;
     * StringUtils.left(&quot;abc&quot;, 2)   = &quot;ab&quot;
     * StringUtils.left(&quot;abc&quot;, 4)   = &quot;abc&quot;
     * </pre>
     * 
     * @param string ��Ҫת�����ַ���string, ����Ϊnull
     * @param len Ҫ������ַ����ĳ���, ����Ϊ0��������
     * @return ָ�����ȵ��ַ�������ߵ��ַ���, ���������ַ���strΪnull����<code>null</code>
     */
    public static String left(String string, int len) {
        return org.apache.commons.lang.StringUtils.left(string, len);
    }
    
    /**
     * <p>
     * ���ַ��������ұ߻��ָ������<code>len</code> ���ַ���.
     * </p>
     * <p>
     * ���ָ������<code>len</code> ������Ч��, ����strΪ <code>null</code>, str����Ϊ����ֵ�����׳��쳣 .���ָ���ĳ���lenΪ�������׳��쳣.
     * </p>
     * 
     * <pre>
     * StringUtils.right(null, *)    = null
     * StringUtils.right(*, -ve)     = &quot;&quot;
     * StringUtils.right(&quot;&quot;, *)      = &quot;&quot;
     * StringUtils.right(&quot;abc&quot;, 0)   = &quot;&quot;
     * StringUtils.right(&quot;abc&quot;, 2)   = &quot;bc&quot;
     * StringUtils.right(&quot;abc&quot;, 4)   = &quot;abc&quot;
     * </pre>
     * 
     * @param string ��Ҫת�����ַ���string, ����Ϊnull
     * @param len Ҫ������ַ����ĳ���, ����Ϊ0��������
     * @return �����ȵ��ַ������ұߵ��ַ���, ���������ַ���strΪnull����</code>
     */
    public static String right(String string, int len) {
        return org.apache.commons.lang.StringUtils.right(string, len);
    }
    
    /**
     * <p>
     * ���ַ������м���ָ������<code>len</code> ���ַ���.
     * </p>
     * <p>
     * ���<code>len</code>����Ϊ��Ч��,��pos��ʼ��ʣ����ַ��������� �����׳��쳣. ����ַ���strΪ<code>null</code>, ������<code>null</code> .
     * ���ָ���ĳ���lenΪ�������׳��쳣.
     * </p>
     * 
     * <pre>
     * StringUtils.mid(null, *, *)    = null
     * StringUtils.mid(*, *, -ve)     = &quot;&quot;
     * StringUtils.mid(&quot;&quot;, 0, *)      = &quot;&quot;
     * StringUtils.mid(&quot;abc&quot;, 0, 2)   = &quot;ab&quot;
     * StringUtils.mid(&quot;abc&quot;, 0, 4)   = &quot;abc&quot;
     * StringUtils.mid(&quot;abc&quot;, 2, 4)   = &quot;c&quot;
     * StringUtils.mid(&quot;abc&quot;, 4, 2)   = &quot;&quot;
     * StringUtils.mid(&quot;abc&quot;, -2, 2)  = &quot;ab&quot;
     * </pre>
     * 
     * @param string ��Ҫת�����ַ���string, ����Ϊnull
     * @param pos ���ص��Ӵ��Ŀ�ʼλ��, ��Ϊ��������0
     * @param len Ҫ���ص��Ӵ��ĳ���, ����Ϊ0����Ϊ����
     * @return �м�����ַ���,���������ַ���strΪnull����<code>null</code>
     */
    public static String mid(String string, int pos, int len) {
        return org.apache.commons.lang.StringUtils.mid(string, pos, len);
    }
    
    /**
     * <p>
     * ���ַ���str�л�õ�һ�����ָ����ַ���separator֮ǰ�����ַ���. �����ַ���separator����Ϊ�������.
     * </p>
     * <p>
     * �����ַ���strΪ<code>null</code>����<code>null</code>. �յ��ַ���("")�����ؿ��ַ���(""). �����ַ���separatorΪ<code>null</code>
     * �������ַ���str����.
     * </p>
     * 
     * <pre>
     * StringUtils.substringBefore(null, *)      = null
     * StringUtils.substringBefore(&quot;&quot;, *)        = &quot;&quot;
     * StringUtils.substringBefore(&quot;abc&quot;, &quot;a&quot;)   = &quot;&quot;
     * StringUtils.substringBefore(&quot;abcba&quot;, &quot;b&quot;) = &quot;a&quot;
     * StringUtils.substringBefore(&quot;abc&quot;, &quot;c&quot;)   = &quot;ab&quot;
     * StringUtils.substringBefore(&quot;abc&quot;, &quot;d&quot;)   = &quot;abc&quot;
     * StringUtils.substringBefore(&quot;abc&quot;, &quot;&quot;)    = &quot;&quot;
     * StringUtils.substringBefore(&quot;abc&quot;, null)  = &quot;abc&quot;
     * </pre>
     * 
     * @param string Ҫ������ַ���, ����Ϊnull
     * @param separator �����ַ���, ����Ϊnull
     * @return �ַ���str�л�õ�һ�����ָ����ַ���separator֮ǰ�����ַ���, ������ַ���strΪnullʱ����<code>null</code>
     * @since 2.0
     */
    public static String substringBefore(String string, String separator) {
        return org.apache.commons.lang.StringUtils.substringBefore(string, separator);
    }
    
    /**
     * <p>
     * ���ַ���str�л�õ�һ�����ָ����ַ���separator֮������ַ���. �����ַ���separator����Ϊ�������.
     * </p>
     * <p>
     * �����ַ���strΪ<code>null</code>����<code>null</code>. �յ��ַ���("")�����ؿ��ַ���(""). �����һ�������ַ�����Ϊ<code>null</code>
     * �������ַ���separatorΪ<code>null</code> �����ؿ��ַ���(""). .
     * </p>
     * 
     * <pre>
     * StringUtils.substringAfter(null, *)      = null
     * StringUtils.substringAfter(&quot;&quot;, *)        = &quot;&quot;
     * StringUtils.substringAfter(*, null)      = &quot;&quot;
     * StringUtils.substringAfter(&quot;abc&quot;, &quot;a&quot;)   = &quot;bc&quot;
     * StringUtils.substringAfter(&quot;abcba&quot;, &quot;b&quot;) = &quot;cba&quot;
     * StringUtils.substringAfter(&quot;abc&quot;, &quot;c&quot;)   = &quot;&quot;
     * StringUtils.substringAfter(&quot;abc&quot;, &quot;d&quot;)   = &quot;&quot;
     * StringUtils.substringAfter(&quot;abc&quot;, &quot;&quot;)    = &quot;abc&quot;
     * </pre>
     * 
     * @param string Ҫ������ַ���, ����Ϊnull
     * @param separator �����ַ���, ����Ϊnull
     * @return �ַ���str�л�õ�һ�����ָ����ַ���separator֮������ַ���, ������ַ���strΪnullʱ����<code>null</code>
     * @since 2.0
     */
    public static String substringAfter(String string, String separator) {
        return org.apache.commons.lang.StringUtils.substringAfter(string, separator);
    }
    
    /**
     * <p>
     * ���ַ���str�л�������ַָ��separator֮ǰ�����ַ���. �ָ��separator����Ϊ�������.
     * </p>
     * <p>
     * �����ַ���strΪ<code>null</code>����<code>null</code>. �յ��ַ���("")�����ؿ��ַ���(""). �ָ��separatorΪ <code>null</code>
     * �����������ַ���str����.
     * </p>
     * 
     * <pre>
     * StringUtils.substringBeforeLast(null, *)      = null
     * StringUtils.substringBeforeLast(&quot;&quot;, *)        = &quot;&quot;
     * StringUtils.substringBeforeLast(&quot;abcba&quot;, &quot;b&quot;) = &quot;abc&quot;
     * StringUtils.substringBeforeLast(&quot;abc&quot;, &quot;c&quot;)   = &quot;ab&quot;
     * StringUtils.substringBeforeLast(&quot;a&quot;, &quot;a&quot;)     = &quot;&quot;
     * StringUtils.substringBeforeLast(&quot;a&quot;, &quot;z&quot;)     = &quot;a&quot;
     * StringUtils.substringBeforeLast(&quot;a&quot;, null)    = &quot;a&quot;
     * StringUtils.substringBeforeLast(&quot;a&quot;, &quot;&quot;)      = &quot;a&quot;
     * </pre>
     * 
     * @param string Ҫ������ַ���, ����Ϊnull
     * @param separator �ָ��, ����Ϊnull
     * @return �ַ���str�л�������ַָ��separator֮ǰ�����ַ���, <code>null</code> ���������ַ���strΪnull
     * @since 2.0
     */
    public static String substringBeforeLast(String string, String separator) {
        return org.apache.commons.lang.StringUtils.substringBeforeLast(string, separator);
    }
    
    /**
     * <p>
     * ���ַ���str�л�������ָ����ַ���separator֮������ַ���. �����ַ���separator����Ϊ�������.
     * </p>
     * <p>
     * �����ַ���strΪ<code>null</code>����<code>null</code>. �յ��ַ���("")�����ؿ��ַ���(""). �����ַ���separatorΪ <code>null</code>
     * �����ؿյ��ַ���("").
     * </p>
     * 
     * <pre>
     * StringUtils.substringAfterLast(null, *)      = null
     * StringUtils.substringAfterLast(&quot;&quot;, *)        = &quot;&quot;
     * StringUtils.substringAfterLast(*, &quot;&quot;)        = &quot;&quot;
     * StringUtils.substringAfterLast(*, null)      = &quot;&quot;
     * StringUtils.substringAfterLast(&quot;abc&quot;, &quot;a&quot;)   = &quot;bc&quot;
     * StringUtils.substringAfterLast(&quot;abcba&quot;, &quot;b&quot;) = &quot;a&quot;
     * StringUtils.substringAfterLast(&quot;abc&quot;, &quot;c&quot;)   = &quot;&quot;
     * StringUtils.substringAfterLast(&quot;a&quot;, &quot;a&quot;)     = &quot;&quot;
     * StringUtils.substringAfterLast(&quot;a&quot;, &quot;z&quot;)     = &quot;&quot;
     * </pre>
     * 
     * @param string Ҫ������ַ���, ����Ϊnull
     * @param separator �����ַ���, ����Ϊnull
     * @return �ַ���str�л�������ָ����ַ���separator֮������ַ���, <code>null</code> ���������ַ���strΪnull
     * @since 2.0
     */
    public static String substringAfterLast(String string, String separator) {
        return org.apache.commons.lang.StringUtils.substringAfterLast(string, separator);
    }
    
    /**
     * <p>
     * ���ַ���str�з����Ƕ��������ͬ���ַ���tag�м�����ַ��� .
     * </p>
     * <p>
     * �����ַ���strΪ<code>null</code>����<code>null</code>. �ڶ�������tagΪ<code>null</code>����<code>null</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.substringBetween(null, *)            = null
     * StringUtils.substringBetween(&quot;&quot;, &quot;&quot;)             = &quot;&quot;
     * StringUtils.substringBetween(&quot;&quot;, &quot;tag&quot;)          = null
     * StringUtils.substringBetween(&quot;tagabctag&quot;, null)  = null
     * StringUtils.substringBetween(&quot;tagabctag&quot;, &quot;&quot;)    = &quot;&quot;
     * StringUtils.substringBetween(&quot;tagabctag&quot;, &quot;tag&quot;) = &quot;abc&quot;
     * </pre>
     * 
     * @param string �������ַ������ַ���, ����Ϊnull
     * @param tag ���ַ���֮ǰ��֮����ַ���, ����Ϊnull
     * @return ���ַ���, <code>null</code> ���û��ƥ������
     * @since 2.0
     */
    public static String substringBetween(String string, String tag) {
        return org.apache.commons.lang.StringUtils.substringBetween(string, tag);
    }
    
    /**
     * <p>
     * ���ַ���str�з����Ƕ���������ַ���open,close�м�����ַ���. ֻ���ص�һ��ƥ����Ӵ�.
     * </p>
     * <p>
     * A <code>null</code> input String returns <code>null</code>. A <code>null</code> open/close returns
     * <code>null</code> (no match). An empty ("") open/close returns an empty string.
     * </p>
     * 
     * <pre>
     * StringUtils.substringBetween(null, *, *)          = null
     * StringUtils.substringBetween(&quot;&quot;, &quot;&quot;, &quot;&quot;)          = &quot;&quot;
     * StringUtils.substringBetween(&quot;&quot;, &quot;&quot;, &quot;tag&quot;)       = null
     * StringUtils.substringBetween(&quot;&quot;, &quot;tag&quot;, &quot;tag&quot;)    = null
     * StringUtils.substringBetween(&quot;yabcz&quot;, null, null) = null
     * StringUtils.substringBetween(&quot;yabcz&quot;, &quot;&quot;, &quot;&quot;)     = &quot;&quot;
     * StringUtils.substringBetween(&quot;yabcz&quot;, &quot;y&quot;, &quot;z&quot;)   = &quot;abc&quot;
     * StringUtils.substringBetween(&quot;yabczyabcz&quot;, &quot;y&quot;, &quot;z&quot;)   = &quot;abc&quot;
     * </pre>
     * 
     * @param string �����Ӵ����ַ���, ����Ϊnull
     * @param open �Ӵ�ǰ����ַ���, ����Ϊnull
     * @param close �Ӵ�������ַ���, ����Ϊnull
     * @return �Ӵ�, <code>null</code> ���û��ƥ������
     * @since 2.0
     */
    public static String substringBetween(String string, String open, String close) {
        return org.apache.commons.lang.StringUtils.substringBetween(string, open, close);
    }
    
    /**
     * <p>
     * ���ַ���str�з����Ƕ���������ַ���open,close�м�����ַ���. ����ȫ��ƥ����Ӵ�������.
     * </p>
     * 
     * @param string �����Ӵ����ַ���, ����Ϊnull
     * @param open �Ӵ�ǰ����ַ���, ����Ϊnull
     * @param close �Ӵ�������ַ���, ����Ϊnull
     * @return ȫ���Ӵ�����, <code>null</code> ���û��ƥ������
     */
    public static String[] substringAllBetween(String string, String open, String close) {
        String strSub = getSubStringBetween(string, open, close);
        String[] strTest = strSub.split("&&");
        return strTest;
    }
    
    /**
     * <p>
     * ���ַ���str�з����Ƕ���������ַ���open,close�м�����ַ���. ����ȫ��ƥ����Ӵ�.
     * </p>
     * 
     * @param str �����Ӵ����ַ���, ����Ϊnull
     * @param open �Ӵ�ǰ����ַ���, ����Ϊnull
     * @param close �Ӵ�������ַ���, ����Ϊnull
     * @return ȫ���Ӵ�, <code>null</code> ���û��ƥ������
     */
    public static String getSubStringBetween(String str, String open, String close) {
        if (str == null || open == null || close == null) {
            return null;
        }
        StringBuffer sbBuffer = new StringBuffer();
        int iStart = str.indexOf(open);
        if (iStart != -1) {
            int iEnd = str.indexOf(close, iStart + open.length());
            if (iEnd != -1) {
                sbBuffer.append(str.substring(iStart + open.length(), iEnd));
                // ÿ���Ӵ���&�ָ���
                sbBuffer.append("&&");
                String strSubStr = str.substring(iEnd + 1, str.length());
                sbBuffer.append(getSubStringBetween(strSubStr, open, close));
            }
        }
        return sbBuffer.toString();
    }
    
    /**
     * <p>
     * ���ַ���str�з����Ƕ��������ͬ���ַ���tag�м�����ַ��� .
     * </p>
     * <p>
     * �����ַ���strΪ<code>null</code>����<code>null</code>. �ڶ�������tagΪ<code>null</code>����<code>null</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.getNestedString(null, *)            = null
     * StringUtils.getNestedString(&quot;&quot;, &quot;&quot;)             = &quot;&quot;
     * StringUtils.getNestedString(&quot;&quot;, &quot;tag&quot;)          = null
     * StringUtils.getNestedString(&quot;tagabctag&quot;, null)  = null
     * StringUtils.getNestedString(&quot;tagabctag&quot;, &quot;&quot;)    = &quot;&quot;
     * StringUtils.getNestedString(&quot;tagabctag&quot;, &quot;tag&quot;) = &quot;abc&quot;
     * </pre>
     * 
     * @param str ����Ƕ���ַ������ַ���, ����Ϊnull
     * @param tag ��Ƕ���ַ���ǰ����ַ���, ����Ϊnull
     * @return Ƕ���ַ���, <code>null</code> ���û��ƥ������
     * @deprecated Ӧʹ�ø��õķ��� {@link #substringBetween(String, String)}. �������� Commons Lang 3.0.��ȡ��
     */
    @Deprecated
    public static String getNestedString(String str, String tag) {
        return substringBetween(str, tag, tag);
    }
    
    /**
     * <p>
     * ���ַ���str�з����Ƕ���������ַ���open��close�м�����ַ���. ֻ���ص�һ��ƥ����Ӵ�.
     * </p>
     * <p>
     * �����ַ���strΪ<code>null</code>����<code>null</code>. <code>null</code>�� open/close �������� <code>null</code> (û��ƥ���).
     * �հ��ַ���("") open/close ����һ�����ַ�.
     * </p>
     * 
     * <pre>
     * StringUtils.getNestedString(null, *, *)          = null
     * StringUtils.getNestedString(&quot;&quot;, &quot;&quot;, &quot;&quot;)          = &quot;&quot;
     * StringUtils.getNestedString(&quot;&quot;, &quot;&quot;, &quot;tag&quot;)       = null
     * StringUtils.getNestedString(&quot;&quot;, &quot;tag&quot;, &quot;tag&quot;)    = null
     * StringUtils.getNestedString(&quot;yabcz&quot;, null, null) = null
     * StringUtils.getNestedString(&quot;yabcz&quot;, &quot;&quot;, &quot;&quot;)     = &quot;&quot;
     * StringUtils.getNestedString(&quot;yabcz&quot;, &quot;y&quot;, &quot;z&quot;)   = &quot;abc&quot;
     * StringUtils.getNestedString(&quot;yabczyabcz&quot;, &quot;y&quot;, &quot;z&quot;)   = &quot;abc&quot;
     * </pre>
     * 
     * @param str ����Ƕ���ַ������ַ���, ����Ϊnull
     * @param open Ƕ���ַ���֮ǰ���ַ���, ����Ϊnull
     * @param close Ƕ���ַ���֮����ַ���, ����Ϊnull
     * @return Ƕ���ַ���, <code>null</code> ���û��ƥ������
     * @deprecated Ӧʹ�ø��õķ��� {@link #substringBetween(String, String, String)}. �������� Commons Lang 3.0.��ȡ��
     */
    @Deprecated
    public static String getNestedString(String str, String open, String close) {
        return substringBetween(str, open, close);
    }
    
    /**
     * <p>
     * Splits the provided text into an array, using whitespace as the separator. Whitespace is defined by
     * {@link Character#isWhitespace(char)}.
     * </p>
     * <p>
     * The separator is not included in the returned String array. Adjacent separators are treated as one separator. For
     * more control over the split use the StrTokenizer class.
     * </p>
     * <p>
     * A <code>null</code> input String returns <code>null</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.split(null)       = null
     * StringUtils.split(&quot;&quot;)         = []
     * StringUtils.split(&quot;abc def&quot;)  = [&quot;abc&quot;, &quot;def&quot;]
     * StringUtils.split(&quot;abc  def&quot;) = [&quot;abc&quot;, &quot;def&quot;]
     * StringUtils.split(&quot; abc &quot;)    = [&quot;abc&quot;]
     * </pre>
     * 
     * @param string the String to parse, may be null
     * @return an array of parsed Strings, <code>null</code> if null String input
     */
    public static String[] split(String string) {
        return org.apache.commons.lang.StringUtils.split(string);
    }
    
    /**
     * <p>
     * Splits the provided text into an array, separator specified. This is an alternative to using StringTokenizer.
     * </p>
     * <p>
     * The separator is not included in the returned String array. Adjacent separators are treated as one separator. For
     * more control over the split use the StrTokenizer class.
     * </p>
     * <p>
     * A <code>null</code> input String returns <code>null</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.split(null, *)         = null
     * StringUtils.split(&quot;&quot;, *)           = []
     * StringUtils.split(&quot;a.b.c&quot;, '.')    = [&quot;a&quot;, &quot;b&quot;, &quot;c&quot;]
     * StringUtils.split(&quot;a..b.c&quot;, '.')   = [&quot;a&quot;, &quot;b&quot;, &quot;c&quot;]
     * StringUtils.split(&quot;a:b:c&quot;, '.')    = [&quot;a:b:c&quot;]
     * StringUtils.split(&quot;a\tb\nc&quot;, null) = [&quot;a&quot;, &quot;b&quot;, &quot;c&quot;]
     * StringUtils.split(&quot;a b c&quot;, ' ')    = [&quot;a&quot;, &quot;b&quot;, &quot;c&quot;]
     * </pre>
     * 
     * @param string the String to parse, may be null
     * @param separatorChar the character used as the delimiter, <code>null</code> splits on whitespace
     * @return an array of parsed Strings, <code>null</code> if null String input
     * @since 2.0
     */
    public static String[] split(String string, char separatorChar) {
        return org.apache.commons.lang.StringUtils.split(string, separatorChar);
    }
    
    /**
     * <p>
     * ����ָ���ķָ��separator���ַ����ָ�Ϊ�ַ�������. Ҳ����ѡ��ʹ�� StringTokenizer.
     * </p>
     * <p>
     * �ָ��separator����Ϊ����Ԫ���е����ݷ���. �ڽ��Ķ���ָ��separators ����Ϊ��һ���ָ��separator.
     * </p>
     * <p>
     * ������ַ���Ϊ<code>null</code>����<code>null</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.split(null, *)         = null
     * StringUtils.split(&quot;&quot;, *)           = []
     * StringUtils.split(&quot;a.b.c&quot;, '.')    = [&quot;a&quot;, &quot;b&quot;, &quot;c&quot;]
     * StringUtils.split(&quot;a..b.c&quot;, '.')   = [&quot;a&quot;, &quot;b&quot;, &quot;c&quot;]
     * StringUtils.split(&quot;a:b:c&quot;, '.')    = [&quot;a:b:c&quot;]
     * StringUtils.split(&quot;a\tb\nc&quot;, null) = [&quot;a&quot;, &quot;b&quot;, &quot;c&quot;]
     * StringUtils.split(&quot;a b c&quot;, ' ')    = [&quot;a&quot;, &quot;b&quot;, &quot;c&quot;]
     * </pre>
     * 
     * @param string ��Ҫ������ַ���, ����Ϊnull
     * @param separatorChars ��Ϊ�ָ������ַ�, ���Ϊ<code>null</code>����whitespace��Ϊ�ָ���
     * @return ����������, <code>null</code>���������ַ���Ϊnull
     * @since 2.0
     */
    public static String[] split(String string, String separatorChars) {
        return org.apache.commons.lang.StringUtils.split(string, separatorChars);
    }
    
    /**
     * <p>
     * ����ָ���ķָ��separator���ַ����ָ�Ϊ�ַ�������. Ҳ����ѡ��ʹ�� StringTokenizer.
     * </p>
     * <p>
     * �ָ��separator����Ϊ����Ԫ���е����ݷ���. �ڽ��Ķ���ָ��separators ����Ϊ��һ���ָ��separator.
     * </p>
     * <p>
     * ������ַ���Ϊ<code>null</code>����<code>null</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.split(null, *)         = null
     * StringUtils.split(&quot;&quot;, *)           = []
     * StringUtils.split(&quot;a.b.c&quot;, '.')    = [&quot;a&quot;, &quot;b&quot;, &quot;c&quot;]
     * StringUtils.split(&quot;a..b.c&quot;, '.')   = [&quot;a&quot;, &quot;b&quot;, &quot;c&quot;]
     * StringUtils.split(&quot;a:b:c&quot;, '.')    = [&quot;a:b:c&quot;]
     * StringUtils.split(&quot;a\tb\nc&quot;, null) = [&quot;a&quot;, &quot;b&quot;, &quot;c&quot;]
     * StringUtils.split(&quot;a b c&quot;, ' ')    = [&quot;a&quot;, &quot;b&quot;, &quot;c&quot;]
     * </pre>
     * 
     * @param string ��Ҫ������ַ���, ����Ϊnull
     * @param separatorChars ��Ϊ�ָ������ַ�, ���Ϊ<code>null</code>����whitespace��Ϊ�ָ���
     * @return �������ַ�������, <code>null</code>���������ַ���Ϊnull
     * @since 2.0
     */
    public static List<String> splitString(String string, String separatorChars) {
        return Arrays.asList(org.apache.commons.lang.StringUtils.split(string, separatorChars));
    }
    
    /**
     * <p>
     * Splits the provided text into an array with a maximum length, separators specified.
     * </p>
     * <p>
     * The separator is not included in the returned String array. Adjacent separators are treated as one separator.
     * </p>
     * <p>
     * A <code>null</code> input String returns <code>null</code>. A <code>null</code> separatorChars splits on
     * whitespace.
     * </p>
     * <p>
     * If more than <code>max</code> delimited substrings are found, the last returned string includes all characters
     * after the first <code>max - 1</code> returned strings (including separator characters).
     * </p>
     * 
     * <pre>
     * StringUtils.split(null, *, *)            = null
     * StringUtils.split(&quot;&quot;, *, *)              = []
     * StringUtils.split(&quot;ab de fg&quot;, null, 0)   = [&quot;ab&quot;, &quot;cd&quot;, &quot;ef&quot;]
     * StringUtils.split(&quot;ab   de fg&quot;, null, 0) = [&quot;ab&quot;, &quot;cd&quot;, &quot;ef&quot;]
     * StringUtils.split(&quot;ab:cd:ef&quot;, &quot;:&quot;, 0)    = [&quot;ab&quot;, &quot;cd&quot;, &quot;ef&quot;]
     * StringUtils.split(&quot;ab:cd:ef&quot;, &quot;:&quot;, 2)    = [&quot;ab&quot;, &quot;cd:ef&quot;]
     * </pre>
     * 
     * @param string the String to parse, may be null
     * @param separatorChars the characters used as the delimiters, <code>null</code> splits on whitespace
     * @param max the maximum number of elements to include in the array. A zero or negative value implies no limit
     * @return an array of parsed Strings, <code>null</code> if null String input
     */
    public static String[] split(String string, String separatorChars, int max) {
        return org.apache.commons.lang.StringUtils.split(string, separatorChars, max);
    }
    
    /**
     * <p>
     * Splits the provided text into an array, separator specified. This is an alternative to using StringTokenizer.
     * </p>
     * <p>
     * The separator is not included in the returned String array. Adjacent separators are treated as one separator. For
     * more control over the split use the StrTokenizer class.
     * </p>
     * <p>
     * A <code>null</code> input String returns <code>null</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.split(null, *)         = null
     * StringUtils.split(&quot;&quot;, *)           = []
     * StringUtils.split(&quot;a.b.c&quot;, '.')    = [&quot;a&quot;, &quot;b&quot;, &quot;c&quot;]
     * StringUtils.split(&quot;a..b.c&quot;, '.')   = [&quot;a&quot;, &quot;b&quot;, &quot;c&quot;]
     * StringUtils.split(&quot;a:b:c&quot;, '.')    = [&quot;a:b:c&quot;]
     * StringUtils.split(&quot;a\tb\nc&quot;, null) = [&quot;a&quot;, &quot;b&quot;, &quot;c&quot;]
     * StringUtils.split(&quot;a b c&quot;, ' ')    = [&quot;a&quot;, &quot;b&quot;, &quot;c&quot;]
     * </pre>
     * 
     * @param str the String to parse, may be null
     * @param separatorChar the character used as the delimiter, <code>null</code> splits on whitespace
     * @return an array of parsed Strings, <code>null</code> if null String input
     * @since 2.0
     */
    public static String[] splitByChar(String str, char separatorChar) {
        return splitWorker(str, separatorChar, false);
    }
    
    /**
     * Performs the logic for the <code>split</code> and <code>splitPreserveAllTokens</code> methods that do not return
     * a maximum array length.
     * 
     * @param str the String to parse, may be <code>null</code>
     * @param separatorChar the separate character
     * @param preserveAllTokens if <code>true</code>, adjacent separators are treated as empty token separators; if
     *            <code>false</code>, adjacent separators are treated as one separator.
     * @return an array of parsed Strings, <code>null</code> if null String input
     */
    private static String[] splitWorker(String str, char separatorChar, boolean preserveAllTokens) {
        // Performance tuned for 2.0 (1.0)
        
        if (str == null) {
            return new String[0];
        }
        int iLen = str.length();
        if (iLen == 0) {
            return EMPTY_STRING_ARRAY;
        }
        List<String> lstAr = new ArrayList<String>();
        int i = 0;
        int iStart = 0;
        boolean bMatch = false;
        boolean bLastMatch = false;
        while (i < iLen) {
            if (str.charAt(i) == separatorChar) {
                if (bMatch || preserveAllTokens) {
                    lstAr.add(str.substring(iStart, i));
                    bMatch = false;
                    bLastMatch = true;
                }
                iStart = ++i;
                continue;
            }
            bLastMatch = false;
            bMatch = true;
            i++;
        }
        if (bMatch || (preserveAllTokens && bLastMatch)) {
            lstAr.add(str.substring(iStart, i));
        }
        return lstAr.toArray(new String[lstAr.size()]);
    }
    
    /**
     * <p>
     * Splits the provided text into an array, separator string specified.
     * </p>
     * <p>
     * The separator(s) will not be included in the returned String array. Adjacent separators are treated as one
     * separator.
     * </p>
     * <p>
     * A <code>null</code> input String returns <code>null</code>. A <code>null</code> separator splits on whitespace.
     * </p>
     * 
     * <pre>
     * StringUtils.splitByWholeSeparator(null, *)               = null
     * StringUtils.splitByWholeSeparator(&quot;&quot;, *)                 = []
     * StringUtils.splitByWholeSeparator(&quot;ab de fg&quot;, null)      = [&quot;ab&quot;, &quot;de&quot;, &quot;fg&quot;]
     * StringUtils.splitByWholeSeparator(&quot;ab   de fg&quot;, null)    = [&quot;ab&quot;, &quot;de&quot;, &quot;fg&quot;]
     * StringUtils.splitByWholeSeparator(&quot;ab:cd:ef&quot;, &quot;:&quot;)       = [&quot;ab&quot;, &quot;cd&quot;, &quot;ef&quot;]
     * StringUtils.splitByWholeSeparator(&quot;ab-!-cd-!-ef&quot;, &quot;-!-&quot;) = [&quot;ab&quot;, &quot;cd&quot;, &quot;ef&quot;]
     * </pre>
     * 
     * @param string the String to parse, may be null
     * @param separator String containing the String to be used as a delimiter, <code>null</code> splits on whitespace
     * @return an array of parsed Strings, <code>null</code> if null String was input
     */
    public static String[] splitByWholeSeparator(String string, String separator) {
        return org.apache.commons.lang.StringUtils.splitByWholeSeparator(string, separator);
    }
    
    /**
     * <p>
     * Splits the provided text into an array, separator string specified. Returns a maximum of <code>max</code>
     * substrings.
     * </p>
     * <p>
     * The separator(s) will not be included in the returned String array. Adjacent separators are treated as one
     * separator.
     * </p>
     * <p>
     * A <code>null</code> input String returns <code>null</code>. A <code>null</code> separator splits on whitespace.
     * </p>
     * 
     * <pre>
     * StringUtils.splitByWholeSeparator(null, *, *)               = null
     * StringUtils.splitByWholeSeparator(&quot;&quot;, *, *)                 = []
     * StringUtils.splitByWholeSeparator(&quot;ab de fg&quot;, null, 0)      = [&quot;ab&quot;, &quot;de&quot;, &quot;fg&quot;]
     * StringUtils.splitByWholeSeparator(&quot;ab   de fg&quot;, null, 0)    = [&quot;ab&quot;, &quot;de&quot;, &quot;fg&quot;]
     * StringUtils.splitByWholeSeparator(&quot;ab:cd:ef&quot;, &quot;:&quot;, 2)       = [&quot;ab&quot;, &quot;cd:ef&quot;]
     * StringUtils.splitByWholeSeparator(&quot;ab-!-cd-!-ef&quot;, &quot;-!-&quot;, 5) = [&quot;ab&quot;, &quot;cd&quot;, &quot;ef&quot;]
     * StringUtils.splitByWholeSeparator(&quot;ab-!-cd-!-ef&quot;, &quot;-!-&quot;, 2) = [&quot;ab&quot;, &quot;cd-!-ef&quot;]
     * </pre>
     * 
     * @param string the String to parse, may be null
     * @param separator String containing the String to be used as a delimiter, <code>null</code> splits on whitespace
     * @param max the maximum number of elements to include in the returned array. A zero or negative value implies no
     *            limit.
     * @return an array of parsed Strings, <code>null</code> if null String was input
     */
    public static String[] splitByWholeSeparator(String string, String separator, int max) {
        return org.apache.commons.lang.StringUtils.splitByWholeSeparator(string, separator, max);
    }
    
    // -----------------------------------------------------------------------
    /**
     * <p>
     * Splits the provided text into an array, using whitespace as the separator, preserving all tokens, including empty
     * tokens created by adjacent separators. This is an alternative to using StringTokenizer. Whitespace is defined by
     * {@link Character#isWhitespace(char)}.
     * </p>
     * <p>
     * The separator is not included in the returned String array. Adjacent separators are treated as separators for
     * empty tokens. For more control over the split use the StrTokenizer class.
     * </p>
     * <p>
     * A <code>null</code> input String returns <code>null</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.splitPreserveAllTokens(null)       = null
     * StringUtils.splitPreserveAllTokens(&quot;&quot;)         = []
     * StringUtils.splitPreserveAllTokens(&quot;abc def&quot;)  = [&quot;abc&quot;, &quot;def&quot;]
     * StringUtils.splitPreserveAllTokens(&quot;abc  def&quot;) = [&quot;abc&quot;, &quot;&quot;, &quot;def&quot;]
     * StringUtils.splitPreserveAllTokens(&quot; abc &quot;)    = [&quot;&quot;, &quot;abc&quot;, &quot;&quot;]
     * </pre>
     * 
     * @param string the String to parse, may be <code>null</code>
     * @return an array of parsed Strings, <code>null</code> if null String input
     * @since 2.1
     */
    public static String[] splitPreserveAllTokens(String string) {
        return org.apache.commons.lang.StringUtils.splitPreserveAllTokens(string);
    }
    
    /**
     * <p>
     * Splits the provided text into an array, separator specified, preserving all tokens, including empty tokens
     * created by adjacent separators. This is an alternative to using StringTokenizer.
     * </p>
     * <p>
     * The separator is not included in the returned String array. Adjacent separators are treated as separators for
     * empty tokens. For more control over the split use the StrTokenizer class.
     * </p>
     * <p>
     * A <code>null</code> input String returns <code>null</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.splitPreserveAllTokens(null, *)         = null
     * StringUtils.splitPreserveAllTokens(&quot;&quot;, *)           = []
     * StringUtils.splitPreserveAllTokens(&quot;a.b.c&quot;, '.')    = [&quot;a&quot;, &quot;b&quot;, &quot;c&quot;]
     * StringUtils.splitPreserveAllTokens(&quot;a..b.c&quot;, '.')   = [&quot;a&quot;, &quot;&quot;, &quot;b&quot;, &quot;c&quot;]
     * StringUtils.splitPreserveAllTokens(&quot;a:b:c&quot;, '.')    = [&quot;a:b:c&quot;]
     * StringUtils.splitPreserveAllTokens(&quot;a\tb\nc&quot;, null) = [&quot;a&quot;, &quot;b&quot;, &quot;c&quot;]
     * StringUtils.splitPreserveAllTokens(&quot;a b c&quot;, ' ')    = [&quot;a&quot;, &quot;b&quot;, &quot;c&quot;]
     * StringUtils.splitPreserveAllTokens(&quot;a b c &quot;, ' ')   = [&quot;a&quot;, &quot;b&quot;, &quot;c&quot;, &quot;&quot;]
     * StringUtils.splitPreserveAllTokens(&quot;a b c  &quot;, ' ')   = [&quot;a&quot;, &quot;b&quot;, &quot;c&quot;, &quot;&quot;, &quot;&quot;]
     * StringUtils.splitPreserveAllTokens(&quot; a b c&quot;, ' ')   = [&quot;&quot;, a&quot;, &quot;b&quot;, &quot;c&quot;]
     * StringUtils.splitPreserveAllTokens(&quot;  a b c&quot;, ' ')  = [&quot;&quot;, &quot;&quot;, a&quot;, &quot;b&quot;, &quot;c&quot;]
     * StringUtils.splitPreserveAllTokens(&quot; a b c &quot;, ' ')  = [&quot;&quot;, a&quot;, &quot;b&quot;, &quot;c&quot;, &quot;&quot;]
     * </pre>
     * 
     * @param string the String to parse, may be <code>null</code>
     * @param separatorChar the character used as the delimiter, <code>null</code> splits on whitespace
     * @return an array of parsed Strings, <code>null</code> if null String input
     * @since 2.1
     */
    public static String[] splitPreserveAllTokens(String string, char separatorChar) {
        return org.apache.commons.lang.StringUtils.splitPreserveAllTokens(string, separatorChar);
    }
    
    /**
     * <p>
     * Splits the provided text into an array, separators specified, preserving all tokens, including empty tokens
     * created by adjacent separators. This is an alternative to using StringTokenizer.
     * </p>
     * <p>
     * The separator is not included in the returned String array. Adjacent separators are treated as separators for
     * empty tokens. For more control over the split use the StrTokenizer class.
     * </p>
     * <p>
     * A <code>null</code> input String returns <code>null</code>. A <code>null</code> separatorChars splits on
     * whitespace.
     * </p>
     * 
     * <pre>
     * StringUtils.splitPreserveAllTokens(null, *)           = null
     * StringUtils.splitPreserveAllTokens(&quot;&quot;, *)             = []
     * StringUtils.splitPreserveAllTokens(&quot;abc def&quot;, null)   = [&quot;abc&quot;, &quot;def&quot;]
     * StringUtils.splitPreserveAllTokens(&quot;abc def&quot;, &quot; &quot;)    = [&quot;abc&quot;, &quot;def&quot;]
     * StringUtils.splitPreserveAllTokens(&quot;abc  def&quot;, &quot; &quot;)   = [&quot;abc&quot;, &quot;&quot;, def&quot;]
     * StringUtils.splitPreserveAllTokens(&quot;ab:cd:ef&quot;, &quot;:&quot;)   = [&quot;ab&quot;, &quot;cd&quot;, &quot;ef&quot;]
     * StringUtils.splitPreserveAllTokens(&quot;ab:cd:ef:&quot;, &quot;:&quot;)  = [&quot;ab&quot;, &quot;cd&quot;, &quot;ef&quot;, &quot;&quot;]
     * StringUtils.splitPreserveAllTokens(&quot;ab:cd:ef::&quot;, &quot;:&quot;) = 
     * [&quot;ab&quot;, &quot;cd&quot;, &quot;ef&quot;, &quot;&quot;, &quot;&quot;]
     * StringUtils.splitPreserveAllTokens(&quot;ab::cd:ef&quot;, &quot;:&quot;)  = [&quot;ab&quot;, &quot;&quot;, cd&quot;, &quot;ef&quot;]
     * StringUtils.splitPreserveAllTokens(&quot;:cd:ef&quot;, &quot;:&quot;)     = [&quot;&quot;, cd&quot;, &quot;ef&quot;]
     * StringUtils.splitPreserveAllTokens(&quot;::cd:ef&quot;, &quot;:&quot;)    = [&quot;&quot;, &quot;&quot;, cd&quot;, &quot;ef&quot;]
     * StringUtils.splitPreserveAllTokens(&quot;:cd:ef:&quot;, &quot;:&quot;)    = [&quot;&quot;, cd&quot;, &quot;ef&quot;, &quot;&quot;]
     * </pre>
     * 
     * @param string the String to parse, may be <code>null</code>
     * @param separatorChars the characters used as the delimiters, <code>null</code> splits on whitespace
     * @return an array of parsed Strings, <code>null</code> if null String input
     * @since 2.1
     */
    public static String[] splitPreserveAllTokens(String string, String separatorChars) {
        return org.apache.commons.lang.StringUtils.splitPreserveAllTokens(string, separatorChars);
    }
    
    /**
     * <p>
     * Splits the provided text into an array with a maximum length, separators specified, preserving all tokens,
     * including empty tokens created by adjacent separators.
     * </p>
     * <p>
     * The separator is not included in the returned String array. Adjacent separators are treated as separators for
     * empty tokens. Adjacent separators are treated as one separator.
     * </p>
     * <p>
     * A <code>null</code> input String returns <code>null</code>. A <code>null</code> separatorChars splits on
     * whitespace.
     * </p>
     * <p>
     * If more than <code>max</code> delimited substrings are found, the last returned string includes all characters
     * after the first <code>max - 1</code> returned strings (including separator characters).
     * </p>
     * 
     * <pre>
     * StringUtils.splitPreserveAllTokens(null, *, *)            = null
     * StringUtils.splitPreserveAllTokens(&quot;&quot;, *, *)              = []
     * StringUtils.splitPreserveAllTokens(&quot;ab de fg&quot;, null, 0)   = [&quot;ab&quot;, &quot;cd&quot;, &quot;ef&quot;]
     * StringUtils.splitPreserveAllTokens(&quot;ab   de fg&quot;, null, 0) = [&quot;ab&quot;, &quot;cd&quot;, &quot;ef&quot;]
     * StringUtils.splitPreserveAllTokens(&quot;ab:cd:ef&quot;, &quot;:&quot;, 0)    = [&quot;ab&quot;, &quot;cd&quot;, &quot;ef&quot;]
     * StringUtils.splitPreserveAllTokens(&quot;ab:cd:ef&quot;, &quot;:&quot;, 2)    = [&quot;ab&quot;, &quot;cd:ef&quot;]
     * StringUtils.splitPreserveAllTokens(&quot;ab   de fg&quot;, null, 2) = [&quot;ab&quot;, &quot;  de fg&quot;]
     * StringUtils.splitPreserveAllTokens(&quot;ab   de fg&quot;, null, 3) = [&quot;ab&quot;, &quot;&quot;, &quot; de fg&quot;]
     * StringUtils.splitPreserveAllTokens(&quot;ab   de fg&quot;, null, 4) = [&quot;ab&quot;, &quot;&quot;, &quot;&quot;, &quot;de fg&quot;]
     * </pre>
     * 
     * @param string the String to parse, may be <code>null</code>
     * @param separatorChars the characters used as the delimiters, <code>null</code> splits on whitespace
     * @param max the maximum number of elements to include in the array. A zero or negative value implies no limit
     * @return an array of parsed Strings, <code>null</code> if null String input
     * @since 2.1
     */
    public static String[] splitPreserveAllTokens(String string, String separatorChars, int max) {
        return org.apache.commons.lang.StringUtils.splitPreserveAllTokens(string, separatorChars, max);
    }
    
    /**
     * ��ָ����λ���ϣ���ȡ���÷ָ���ָ���ַ�����
     * 
     * <pre>
     * ProjectUtils.getSplitIndexString(&quot;000;111;222&quot;,&quot;;&quot;,0)=&quot;000&quot;
     * ProjectUtils.getSplitIndexString(&quot;&quot;,&quot;;&quot;,0)=&quot;&quot;
     * ProjectUtils.getSplitIndexString(&quot;000&quot;,&quot;;&quot;,0)=&quot;000&quot;
     * ProjectUtils.getSplitIndexString(&quot;&quot;,&quot;&quot;,0) = &quot;&quot;
     * </pre>
     * 
     * @param source ��Ҫ���ָ���ַ�����
     * @param splitString ��ָ���ķָ���š�
     * @param position �ָ�����ڵ�����
     * @return ����ָ��λ�����汻�ָ���ŷָ���ַ�����
     */
    public static String getSplitIndexString(String source, String splitString, int position) {
        String[] strSplitStrings = org.apache.commons.lang.StringUtils.split(source, splitString);
        if (strSplitStrings.length > position) {
            return strSplitStrings[position];
        }
        return EMPTY;
    }
    
    /**
     * <p>
     * ��������arrayΪһ���ַ���. �������е�null������߿��ַ���������Ϊ��һ���յ��ַ������� .
     * </p>
     * 
     * <pre>
     * StringUtils.concatenate(null)            = null
     * StringUtils.concatenate([])              = &quot;&quot;
     * StringUtils.concatenate([null])          = &quot;&quot;
     * StringUtils.concatenate([&quot;a&quot;, &quot;b&quot;, &quot;c&quot;]) = &quot;abc&quot;
     * StringUtils.concatenate([null, &quot;&quot;, &quot;a&quot;]) = &quot;a&quot;
     * </pre>
     * 
     * @param array ��Ҫ���ӵ�����, ����Ϊnull
     * @return ���Ӻ���ַ���, <code>null</code> ��������Ϊnull
     * @deprecated Ӧʹ�ø��õķ���{@link #join(Object[])} ������. �������� Commons Lang 3.0.��ȡ��
     */
    @Deprecated
    public static String concatenate(Object[] array) {
        return join(array, null);
    }
    
    /**
     * <p>
     * ��������arrayΪһ���ַ��� .
     * </p>
     * <p>
     * �����Ӻ���ַ����в������ָ��separator. �������е�null������߿��ַ���������Ϊ��һ���յ��ַ������� .
     * </p>
     * 
     * <pre>
     * StringUtils.join(null)            = null
     * StringUtils.join([])              = &quot;&quot;
     * StringUtils.join([null])          = &quot;&quot;
     * StringUtils.join([&quot;a&quot;, &quot;b&quot;, &quot;c&quot;]) = &quot;abc&quot;
     * StringUtils.join([null, &quot;&quot;, &quot;a&quot;]) = &quot;a&quot;
     * </pre>
     * 
     * @param array ��Ҫ���ӵ�����, ����Ϊnull
     * @return ���Ӻ���ַ���, <code>null</code> ������������Ϊnull
     * @since 2.0
     */
    public static String join(Object[] array) {
        return org.apache.commons.lang.StringUtils.join(array);
    }
    
    /**
     * <p>
     * ��һ������array�͸������ַ��ָ��separator����Ϊһ���ַ��� .
     * </p>
     * <p>
     * �����ӵ�����arrayǰ����ӷָ���. �������е�null������߿��ַ���������Ϊ��һ���յ��ַ������� .
     * </p>
     * 
     * <pre>
     * StringUtils.join(null, *)               = null
     * StringUtils.join([], *)                 = &quot;&quot;
     * StringUtils.join([null], *)             = &quot;&quot;
     * StringUtils.join([&quot;a&quot;, &quot;b&quot;, &quot;c&quot;], ';')  = &quot;a;b;c&quot;
     * StringUtils.join([&quot;a&quot;, &quot;b&quot;, &quot;c&quot;], null) = &quot;abc&quot;
     * StringUtils.join([null, &quot;&quot;, &quot;a&quot;], ';')  = &quot;;;a&quot;
     * </pre>
     * 
     * @param array �����ӵ�����, ����Ϊnull
     * @param separator �ַ��ָ��separator
     * @return ���Ӻ���ַ���, <code>null</code> ������������Ϊnull
     * @since 2.0
     */
    public static String join(Object[] array, char separator) {
        return org.apache.commons.lang.StringUtils.join(array, separator);
    }
    
    /**
     * <p>
     * ��һ������array�͸������ַ����ָ��separator����Ϊһ���ַ��� .
     * </p>
     * <p>
     * �����ӵ�����arrayǰ����ӷָ���. <code>null</code> �ָ��������ɿ��ַ��� (""). �������е�null������߿��ַ���������Ϊ��һ���յ��ַ������� .
     * </p>
     * 
     * <pre>
     * StringUtils.join(null, *)                = null
     * StringUtils.join([], *)                  = &quot;&quot;
     * StringUtils.join([null], *)              = &quot;&quot;
     * StringUtils.join([&quot;a&quot;, &quot;b&quot;, &quot;c&quot;], &quot;--&quot;)  = &quot;a--b--c&quot;
     * StringUtils.join([&quot;a&quot;, &quot;b&quot;, &quot;c&quot;], null)  = &quot;abc&quot;
     * StringUtils.join([&quot;a&quot;, &quot;b&quot;, &quot;c&quot;], &quot;&quot;)    = &quot;abc&quot;
     * StringUtils.join([null, &quot;&quot;, &quot;a&quot;], ',')   = &quot;,,a&quot;
     * </pre>
     * 
     * @param array �����ӵ�����, ����Ϊnull
     * @param separator �ַ����ָ��separator, null ���� ""
     * @return ���Ӻ���ַ���, <code>null</code> ������������Ϊnull
     */
    public static String join(Object[] array, String separator) {
        return org.apache.commons.lang.StringUtils.join(array, separator);
    }
    
    /**
     * <p>
     * ��<code>Iterator</code>�е�����Ԫ�غ͸������ַ��ָ��separator����Ϊһ���ַ��� .
     * </p>
     * <p>
     * �����ӵ�����ǰ����ӷָ���. ��iteration�е�null������߿��ַ���������Ϊ��һ���յ��ַ������� .
     * </p>
     * <p>
     * ����: {@link #join(Object[],char)}.
     * </p>
     * 
     * @param iterator ��Ҫ�������ӵ�<code>Iterator</code>, ����Ϊnull
     * @param separator ���ڼ�����ַ�
     * @return ���Ӻ���ַ���, <code>null</code> ��������iteratorΪnull
     * @since 2.0
     */
    public static String join(Iterator<?> iterator, char separator) {
        return org.apache.commons.lang.StringUtils.join(iterator, separator);
    }
    
    /**
     * <p>
     * ��<code>Iterator</code>�е�����Ԫ�غ͸������ַ����ָ��separator����Ϊһ���ַ��� .
     * </p>
     * <p>
     * �����ӵ�����ǰ����ӷָ���. <code>null</code>�ķָ���separator ���������ַ���("").
     * </p>
     * <p>
     * ����: {@link #join(Object[],String)}.
     * </p>
     * 
     * @param iterator ��Ҫ�������ӵ� <code>Iterator</code>, ����Ϊnull
     * @param separator ���ڼ�����ַ�, null����""
     * @return ���Ӻ���ַ���, <code>null</code> ��������iteratorΪnull
     */
    public static String join(Iterator<?> iterator, String separator) {
        return org.apache.commons.lang.StringUtils.join(iterator, separator);
    }
    
    /**
     * <p>
     * ɾ����{@link Character#isWhitespace(char)}����Ŀհ��ַ� .
     * </p>
     * 
     * <pre>
     * StringUtils.deleteWhitespace(null)         = null
     * StringUtils.deleteWhitespace(&quot;&quot;)           = &quot;&quot;
     * StringUtils.deleteWhitespace(&quot;abc&quot;)        = &quot;abc&quot;
     * StringUtils.deleteWhitespace(&quot;   ab  c  &quot;) = &quot;abc&quot;
     * </pre>
     * 
     * @param string ��Ҫ�Ƴ��հ׵��ַ���, ����Ϊnull
     * @return �Ƴ��հ׵��ַ���, <code>null</code> ������ַ���Ϊnull
     */
    public static String deleteWhitespace(String string) {
        return org.apache.commons.lang.StringUtils.deleteWhitespace(string);
    }
    
    /**
     * <p>
     * �滻һ���ַ���text�еĲ����ַ���replΪһ�µ��ַ���with,ֻ�滻��ʼ�ĵ�һ��.
     * </p>
     * <p>
     * ����Ĳ�����Ϊ<code>null</code>ʱ������������в���.
     * </p>
     * 
     * <pre>
     * StringUtils.replaceOnce(null, *, *)        = null
     * StringUtils.replaceOnce(&quot;&quot;, *, *)          = &quot;&quot;
     * StringUtils.replaceOnce(&quot;aba&quot;, null, null) = &quot;aba&quot;
     * StringUtils.replaceOnce(&quot;aba&quot;, null, null) = &quot;aba&quot;
     * StringUtils.replaceOnce(&quot;aba&quot;, &quot;a&quot;, null)  = &quot;aba&quot;
     * StringUtils.replaceOnce(&quot;aba&quot;, &quot;a&quot;, &quot;&quot;)    = &quot;aba&quot;
     * StringUtils.replaceOnce(&quot;aba&quot;, &quot;a&quot;, &quot;z&quot;)   = &quot;zba&quot;
     * </pre>
     * 
     * @see #replace(String text, String repl, String with, int max)
     * @param text Ҫ�����滻���ַ���, ����Ϊnull
     * @param repl Ҫ���滻���ַ���, ����Ϊnull
     * @param with �滻����ַ���, ����Ϊnull
     * @return �����滻��������ַ���, <code>null</code> ���������ַ���Ϊnull
     */
    public static String replaceOnce(String text, String repl, String with) {
        return org.apache.commons.lang.StringUtils.replaceOnce(text, repl, with);
    }
    
    /**
     * <p>
     * �滻�ַ���text�����г��ֵ��ַ���repl�滻Ϊ�µ��ַ���with.
     * </p>
     * <p>
     * <code>null</code> ���ݸ�������������ᱻ�������.
     * </p>
     * 
     * <pre>
     * StringUtils.replace(null, *, *)        = null
     * StringUtils.replace(&quot;&quot;, *, *)          = &quot;&quot;
     * StringUtils.replace(&quot;aba&quot;, null, null) = &quot;aba&quot;
     * StringUtils.replace(&quot;aba&quot;, null, null) = &quot;aba&quot;
     * StringUtils.replace(&quot;aba&quot;, &quot;a&quot;, null)  = &quot;aba&quot;
     * StringUtils.replace(&quot;aba&quot;, &quot;a&quot;, &quot;&quot;)    = &quot;aba&quot;
     * StringUtils.replace(&quot;aba&quot;, &quot;a&quot;, &quot;z&quot;)   = &quot;zbz&quot;
     * </pre>
     * 
     * @see #replace(String text, String repl, String with, int max)
     * @param text Ҫ�����滻���ַ���, ����Ϊnull
     * @param repl Ҫ���滻���ַ���, ����Ϊnull
     * @param with �滻����ַ���, ����Ϊnull
     * @return �����滻��������ַ���, <code>null</code> ���������ַ���Ϊnull
     */
    public static String replace(String text, String repl, String with) {
        return org.apache.commons.lang.StringUtils.replace(text, repl, with);
    }
    
    /**
     * <p>
     * ���ַ���text�г���ָ������<code>max</code>���ַ���replΪ�滻�µ��ַ���with, .
     * </p>
     * <p>
     * <code>null</code> ���ݸ�������������ᱻ�������.
     * </p>
     * 
     * <pre>
     * StringUtils.replace(null, *, *, *)         = null
     * StringUtils.replace(&quot;&quot;, *, *, *)           = &quot;&quot;
     * StringUtils.replace(&quot;abaa&quot;, null, null, 1) = &quot;abaa&quot;
     * StringUtils.replace(&quot;abaa&quot;, null, null, 1) = &quot;abaa&quot;
     * StringUtils.replace(&quot;abaa&quot;, &quot;a&quot;, null, 1)  = &quot;abaa&quot;
     * StringUtils.replace(&quot;abaa&quot;, &quot;a&quot;, &quot;&quot;, 1)    = &quot;abaa&quot;
     * StringUtils.replace(&quot;abaa&quot;, &quot;a&quot;, &quot;z&quot;, 0)   = &quot;abaa&quot;
     * StringUtils.replace(&quot;abaa&quot;, &quot;a&quot;, &quot;z&quot;, 1)   = &quot;zbaa&quot;
     * StringUtils.replace(&quot;abaa&quot;, &quot;a&quot;, &quot;z&quot;, 2)   = &quot;zbza&quot;
     * StringUtils.replace(&quot;abaa&quot;, &quot;a&quot;, &quot;z&quot;, -1)  = &quot;zbzz&quot;
     * </pre>
     * 
     * @param text Ҫ�����滻���ַ���, ����Ϊnull
     * @param repl Ҫ���滻���ַ���, ����Ϊnull
     * @param with �滻����ַ���, ����Ϊnull
     * @param max Ҫ�滻���ַ����ĸ���, ���� <code>-1</code> ��ʶû�и�������
     * @return �����滻��������ַ���, <code>null</code> ���������ַ���Ϊnull
     */
    public static String replace(String text, String repl, String with, int max) {
        return org.apache.commons.lang.StringUtils.replace(text, repl, with, max);
    }
    
    // Replace, character based
    // -----------------------------------------------------------------------
    /**
     * <p>
     * �滻�ַ���str�����г��ֵ��ַ�searchCharΪһ���µ��ַ�replaceChar. һ�� null-safe �İ汾 {@link String#replace(char, char)}.
     * </p>
     * <p>
     * <code>null</code> �ַ��������뷵�� <code>null</code>. �յ��ַ��� ("") string ����һ�����ַ���.
     * </p>
     * 
     * <pre>
     * StringUtils.replaceChars(null, *, *)        = null
     * StringUtils.replaceChars(&quot;&quot;, *, *)          = &quot;&quot;
     * StringUtils.replaceChars(&quot;abcba&quot;, 'b', 'y') = &quot;aycya&quot;
     * StringUtils.replaceChars(&quot;abcba&quot;, 'z', 'y') = &quot;abcba&quot;
     * </pre>
     * 
     * @param string Ҫ�����滻���ַ���, ����Ϊnull
     * @param searchChar ��Ҫ�滻���ַ�, ����Ϊnull
     * @param replaceChar �滻����ַ�, ����Ϊnull
     * @return �滻����ַ���, <code>null</code> ���������ַ���Ϊnull
     * @since 2.0
     */
    public static String replaceChars(String string, char searchChar, char replaceChar) {
        return org.apache.commons.lang.StringUtils.replaceChars(string, searchChar, replaceChar);
    }
    
    /**
     * <p>
     * �滻�ַ���str�еĶ���ַ�searchChars�滻Ϊ�µ��ַ�replaceChars. ���������������ɾ���ַ�.
     * </p>
     * <p>
     * ����:<br />
     * <code>replaceChars(&quot;hello&quot;, &quot;ho&quot;, &quot;jy&quot;) = jelly</code>.
     * </p>
     * <p>
     * <code>null</code> �ַ������뷵�� <code>null</code>. ���ַ��� ("") �����ؿ��ַ���. ����null���߿յ���Ҫ�滻���ַ�searchChars���·���ַ���str����.
     * </p>
     * <p>
     * Ҫ���滻���ַ�searchChars�ĳ���ͨ��Ӧ�õ����滻���ַ�replaceChars�ĳ���. ������滻���ַ�searchChars�ĳ��ȸ���,���滻���ַ�searchChars�ж�����ַ�����ɾ��
     * ����滻���ַ�replaceChars�ĳ��ȸ���,�滻���ַ�replaceChars�ж�����ַ��������� .
     * </p>
     * 
     * <pre>
     * StringUtils.replaceChars(null, *, *)           = null
     * StringUtils.replaceChars(&quot;&quot;, *, *)             = &quot;&quot;
     * StringUtils.replaceChars(&quot;abc&quot;, null, *)       = &quot;abc&quot;
     * StringUtils.replaceChars(&quot;abc&quot;, &quot;&quot;, *)         = &quot;abc&quot;
     * StringUtils.replaceChars(&quot;abc&quot;, &quot;b&quot;, null)     = &quot;ac&quot;
     * StringUtils.replaceChars(&quot;abc&quot;, &quot;b&quot;, &quot;&quot;)       = &quot;ac&quot;
     * StringUtils.replaceChars(&quot;abcba&quot;, &quot;bc&quot;, &quot;yz&quot;)  = &quot;ayzya&quot;
     * StringUtils.replaceChars(&quot;abcba&quot;, &quot;bc&quot;, &quot;y&quot;)   = &quot;ayya&quot;
     * StringUtils.replaceChars(&quot;abcba&quot;, &quot;bc&quot;, &quot;yzx&quot;) = &quot;ayzya&quot;
     * </pre>
     * 
     * @param string ��Ҫ���滻���ַ���, ����Ϊnull
     * @param searchChars �ַ�����Ҫ���滻���ַ�, ����Ϊnull
     * @param replaceChars �滻���ַ�, ����Ϊnull
     * @return �滻����ַ���, <code>null</code> ���������ַ���Ϊnull
     * @since 2.0
     */
    public static String replaceChars(String string, String searchChars, String replaceChars) {
        return org.apache.commons.lang.StringUtils.replaceChars(string, searchChars, replaceChars);
    }
    
    /**
     * <p>
     * ���ַ���overlay�����ַ���text�еĲ����ַ�. ��start����end�����в��Ϸ�������ʱ���׳�IndexOutOfBoundsException�쳣
     * </p>
     * 
     * <pre>
     * StringUtils.overlayString(null, *, *, *)           = NullPointerException
     * StringUtils.overlayString(*, null, *, *)           = NullPointerException
     * StringUtils.overlayString(&quot;&quot;, &quot;abc&quot;, 0, 0)         = &quot;abc&quot;
     * StringUtils.overlayString(&quot;abcdef&quot;, null, 2, 4)    = &quot;abef&quot;
     * StringUtils.overlayString(&quot;abcdef&quot;, &quot;&quot;, 2, 4)      = &quot;abef&quot;
     * StringUtils.overlayString(&quot;abcdef&quot;, &quot;zzzz&quot;, 2, 4)  = &quot;abzzzzef&quot;
     * StringUtils.overlayString(&quot;abcdef&quot;, &quot;zzzz&quot;, 4, 2)  = &quot;abcdzzzzcdef&quot;
     * StringUtils.overlayString(&quot;abcdef&quot;, &quot;zzzz&quot;, -1, 4) = IndexOutOfBoundsException
     * StringUtils.overlayString(&quot;abcdef&quot;, &quot;zzzz&quot;, 2, 8)  = IndexOutOfBoundsException
     * </pre>
     * 
     * @param text ��Ҫ�������ַ����ַ���, ����Ϊnull
     * @param overlay ���ǵ��ַ�, ����Ϊnull
     * @param start �����ַ�������ʼλ��,��������Ч������
     * @param end �����ַ����Ľ���λ��,��������Ч������
     * @return ���Ǻ���ַ���, <code>null</code> ���������ַ���Ϊnull
     * @deprecated ʹ�� {@link #overlay(String, String, int, int)} ������. �������� Commons Lang 3.0. ��ȡ��
     */
    @Deprecated
    public static String overlayString(String text, String overlay, int start, int end) {
        return new StringBuffer(start + overlay.length() + text.length() - end + 1).append(text.substring(0, start))
            .append(overlay).append(text.substring(end)).toString();
    }
    
    /**
     * <p>
     * ���ַ���overlay�����ַ���text�еĲ����ַ�.
     * </p>
     * <p>
     * <code>null</code>���ַ������뷵��<code>null</code>. start��end��������Ϊ����ʱ����0����. start��end���������ַ���str�ĳ���ʱ��str�ĳ���������.
     * start��������ѡ������λ�ò�����С����һ��.
     * </p>
     * 
     * <pre>
     * StringUtils.overlay(null, *, *, *)            = null
     * StringUtils.overlay(&quot;&quot;, &quot;abc&quot;, 0, 0)          = &quot;abc&quot;
     * StringUtils.overlay(&quot;abcdef&quot;, null, 2, 4)     = &quot;abef&quot;
     * StringUtils.overlay(&quot;abcdef&quot;, &quot;&quot;, 2, 4)       = &quot;abef&quot;
     * StringUtils.overlay(&quot;abcdef&quot;, &quot;&quot;, 4, 2)       = &quot;abef&quot;
     * StringUtils.overlay(&quot;abcdef&quot;, &quot;zzzz&quot;, 2, 4)   = &quot;abzzzzef&quot;
     * StringUtils.overlay(&quot;abcdef&quot;, &quot;zzzz&quot;, 4, 2)   = &quot;abzzzzef&quot;
     * StringUtils.overlay(&quot;abcdef&quot;, &quot;zzzz&quot;, -1, 4)  = &quot;zzzzef&quot;
     * StringUtils.overlay(&quot;abcdef&quot;, &quot;zzzz&quot;, 2, 8)   = &quot;abzzzz&quot;
     * StringUtils.overlay(&quot;abcdef&quot;, &quot;zzzz&quot;, -2, -3) = &quot;zzzzabcdef&quot;
     * StringUtils.overlay(&quot;abcdef&quot;, &quot;zzzz&quot;, 8, 10)  = &quot;abcdefzzzz&quot;
     * </pre>
     * 
     * @param string ��Ҫ�������ַ����ַ���, ����Ϊnull
     * @param overlay ���ǵ��ַ�, ����Ϊnull
     * @param start �����ַ�������ʼλ��
     * @param end �����ַ����Ľ���λ��
     * @return ���Ǻ���ַ���, <code>null</code> ���������ַ���Ϊnull
     * @since 2.0
     */
    public static String overlay(String string, String overlay, int start, int end) {
        return org.apache.commons.lang.StringUtils.overlay(string, overlay, start, end);
    }
    
    /**
     * <p>
     * ����ַ���str��ĩβ�л��о�ȥ��һ������,������еı���������. ���еĶ���Ϊ &quot;<code>\n</code>&quot;, &quot;<code>\r</code>&quot;, ���� &quot;
     * <code>\r\n</code>&quot;.
     * </p>
     * <p>
     * ע��: ��������� 2.0. �����ı� ���ں� Perl chomp ��ƥ����.
     * </p>
     * 
     * <pre>
     * StringUtils.chomp(null)          = null
     * StringUtils.chomp(&quot;&quot;)            = &quot;&quot;
     * StringUtils.chomp(&quot;abc \r&quot;)      = &quot;abc &quot;
     * StringUtils.chomp(&quot;abc\n&quot;)       = &quot;abc&quot;
     * StringUtils.chomp(&quot;abc\r\n&quot;)     = &quot;abc&quot;
     * StringUtils.chomp(&quot;abc\r\n\r\n&quot;) = &quot;abc\r\n&quot;
     * StringUtils.chomp(&quot;abc\n\r&quot;)     = &quot;abc\n&quot;
     * StringUtils.chomp(&quot;abc\n\rabc&quot;)  = &quot;abc\n\rabc&quot;
     * StringUtils.chomp(&quot;\r&quot;)          = &quot;&quot;
     * StringUtils.chomp(&quot;\n&quot;)          = &quot;&quot;
     * StringUtils.chomp(&quot;\r\n&quot;)        = &quot;&quot;
     * </pre>
     * 
     * @param string ��Ҫȥ�����е��ַ���, ����Ϊnull
     * @return ȥ�����е��ַ���, <code>null</code> ���������ַ���Ϊnull
     */
    public static String chomp(String string) {
        return org.apache.commons.lang.StringUtils.chomp(string);
    }
    
    /**
     * <p>
     * ����ַ���<code>str</code>��ĩ����ָ���ķָ���<code>separator</code> ��ȥ��һ�� , ����ʣ��ı���.
     * </p>
     * <p>
     * ע��: ��������� 2.0. �����ı� ���ں� Perl chomp ��ƥ����. ��ǰ�İ汾ʹ���� {@link #substringBeforeLast(String, String)}. �������ʹ����
     * {@link String#endsWith(String)}.
     * </p>
     * 
     * <pre>
     * StringUtils.chomp(null, *)         = null
     * StringUtils.chomp(&quot;&quot;, *)           = &quot;&quot;
     * StringUtils.chomp(&quot;foobar&quot;, &quot;bar&quot;) = &quot;foo&quot;
     * StringUtils.chomp(&quot;foobar&quot;, &quot;baz&quot;) = &quot;foobar&quot;
     * StringUtils.chomp(&quot;foo&quot;, &quot;foo&quot;)    = &quot;&quot;
     * StringUtils.chomp(&quot;foo &quot;, &quot;foo&quot;)   = &quot;foo&quot;
     * StringUtils.chomp(&quot; foo&quot;, &quot;foo&quot;)   = &quot; &quot;
     * StringUtils.chomp(&quot;foo&quot;, &quot;foooo&quot;)  = &quot;foo&quot;
     * StringUtils.chomp(&quot;foo&quot;, &quot;&quot;)       = &quot;foo&quot;
     * StringUtils.chomp(&quot;foo&quot;, null)     = &quot;foo&quot;
     * </pre>
     * 
     * @param string ��Ҫȥ���ָ������ַ���, ����Ϊnull
     * @param separator ָ���ķָ���, ����Ϊnull
     * @return ȥ���ָ������ַ���, <code>null</code>���������ַ���Ϊnull
     */
    public static String chomp(String string, String separator) {
        return org.apache.commons.lang.StringUtils.chomp(string, separator);
    }
    
    /**
     * <p>
     * ����ַ���str��ĩ������ָ�����ַ���sep������ ��ô��ɾȥstr��ĩ�˵�sep�ַ���.
     * </p>
     * 
     * @param str ��Ҫ������ַ���,����Ϊnull
     * @param sep Ҫȥ�����ַ���,����Ϊnull
     * @return ȥ���ַ�������ַ���
     * @deprecated ʹ�� {@link #chomp(String,String)} ������. ��������Commons Lang 3.0.��ȡ��
     */
    @Deprecated
    public static String chompLast(String str, String sep) {
        if (str.length() == 0) {
            return str;
        }
        String strSub = str.substring(str.length() - sep.length());
        if (sep.equals(strSub)) {
            return str.substring(0, str.length() - sep.length());
        }
        return str;
    }
    
    /**
     * <p>
     * ȥ���ַ���str��������ָ���ַ�sepǰ�����е��ַ�, ����ָ���ַ�sep����������ַ���.
     * </p>
     * 
     * @param str ��Ҫ������ַ���, ����Ϊnull
     * @param sep Ҫȥ�����ַ���, ����Ϊnull
     * @return ȥ���ַ�������ַ���
     * @deprecated ʹ�� {@link #substringAfterLast(String, String)} ������. (��Ȼ�������ָ��� separator) ��������Commons Lang 3.0.��ȡ��
     */
    @Deprecated
    public static String getChomp(String str, String sep) {
        int iIdx = str.lastIndexOf(sep);
        if (iIdx == str.length() - sep.length()) {
            return sep;
        } else if (iIdx != -1) {
            return str.substring(iIdx);
        } else {
            return EMPTY;
        }
    }
    
    /**
     * <p>
     * ȥ���ַ���str�е�һ������ָ���ַ�sepǰ�����е��ַ�, �����ַ���str�е�һ���ַ���sep������ַ���.
     * </p>
     * 
     * @param str ��Ҫ������ַ���, ����Ϊnull
     * @param sep Ҫȥ�����ַ���, ����Ϊnull
     * @return ȥ���ַ�������ַ���
     * @deprecated ʹ�� {@link #substringAfter(String,String)} ������. ��������Commons Lang 3.0.��ȡ��
     */
    @Deprecated
    public static String prechomp(String str, String sep) {
        int iIdx = str.indexOf(sep);
        if (iIdx != -1) {
            return str.substring(iIdx + sep.length());
        }
        return str;
    }
    
    /**
     * <p>
     * ȥ���ַ���str�е�һ������ָ���ַ�sep��������е��ַ� �����ַ���str�е�һ���ַ���sepǰ����ַ���,����seq�ַ���.
     * </p>
     * 
     * <pre>
     * StringUtils.getPrechomp(&quot;accbcabc&quot;, &quot;bc&quot;) = &quot;accbc&quot;
     * </pre>
     * 
     * @param str ��Ҫ������ַ���, ����Ϊnull
     * @param sep ���бȽϵ��ַ���, ����Ϊnull
     * @return ȥ���ַ�������ַ���
     * @deprecated ʹ�� {@link #substringBefore(String,String)} ������ (�������ָ���separator). ��������Commons Lang 3.0.��ȡ��
     */
    @Deprecated
    public static String getPrechomp(String str, String sep) {
        int iIdx = str.indexOf(sep);
        if (iIdx != -1) {
            return str.substring(0, iIdx + sep.length());
        }
        return EMPTY;
    }
    
    /**
     * <p>
     * ȥ���ַ���strĩ�˵��ַ�.
     * </p>
     * <p>
     * ����ַ���str������<code>\r\n</code>����������ʽ�Ļ���, ȥ������.
     * </p>
     * 
     * <pre>
     * StringUtils.chop(null)          = null
     * StringUtils.chop(&quot;&quot;)            = &quot;&quot;
     * StringUtils.chop(&quot;abc \r&quot;)      = &quot;abc &quot;
     * StringUtils.chop(&quot;abc\n&quot;)       = &quot;abc&quot;
     * StringUtils.chop(&quot;abc\r\n&quot;)     = &quot;abc&quot;
     * StringUtils.chop(&quot;abc&quot;)         = &quot;ab&quot;
     * StringUtils.chop(&quot;abc\nabc&quot;)    = &quot;abc\nab&quot;
     * StringUtils.chop(&quot;a&quot;)           = &quot;&quot;
     * StringUtils.chop(&quot;\r&quot;)          = &quot;&quot;
     * StringUtils.chop(&quot;\n&quot;)          = &quot;&quot;
     * StringUtils.chop(&quot;\r\n&quot;)        = &quot;&quot;
     * </pre>
     * 
     * @param string ��Ҫȥ���ַ����ַ���, ����Ϊnull
     * @return ȥ��ĩβ�ַ����ַ���, <code>null</code> ���������ַ���Ϊnull
     */
    public static String chop(String string) {
        return org.apache.commons.lang.StringUtils.chop(string);
    }
    
    /**
     * <p>
     * ����ַ���str�Ľ�β��<code>\n</code>��ȥ��<code>\n</code>. ���<code>\n</code>ǰ����<code>\r</code>,ͬ��ȥ��<code>\r</code>.
     * </p>
     * 
     * @param str the String to chop a newline from, ����Ϊnull
     * @return ȥ�����е��ַ���
     * @deprecated ʹ�� {@link #chomp(String)} ������. ��������Commons Lang 3.0.��ȡ��
     */
    @Deprecated
    public static String chopNewline(String str) {
        int iLastIdx = str.length() - 1;
        if (iLastIdx <= 0) {
            return EMPTY;
        }
        char chLast = str.charAt(iLastIdx);
        if (chLast == '\n') {
            if (str.charAt(iLastIdx - 1) == '\r') {
                iLastIdx--;
            }
        } else {
            iLastIdx++;
        }
        return str.substring(0, iLastIdx);
    }
    
    /**
     * <p>
     * ����һ���ַ���ָ���Ĵ���<code>repeat</code> .
     * </p>
     * 
     * <pre>
     * StringUtils.repeat(null, 2) = null
     * StringUtils.repeat(&quot;&quot;, 0)   = &quot;&quot;
     * StringUtils.repeat(&quot;&quot;, 2)   = &quot;&quot;
     * StringUtils.repeat(&quot;a&quot;, 3)  = &quot;aaa&quot;
     * StringUtils.repeat(&quot;ab&quot;, 2) = &quot;abab&quot;
     * StringUtils.repeat(&quot;a&quot;, -2) = &quot;&quot;
     * </pre>
     * 
     * @param string Ҫ���Ƶ��ַ���, ����Ϊnull
     * @param repeat �ַ���strҪ�ظ��Ĳ���,����Ϊ0
     * @return ��ԭ���ַ�������repeat����д����ַ���, <code>null</code> ���������ַ���Ϊnull
     */
    public static String repeat(String string, int repeat) {
        return org.apache.commons.lang.StringUtils.repeat(string, repeat);
    }
    
    /**
     * <p>
     * �ظ�һ���ַ�padCharָ���Ĵ���repeat .
     * </p>
     * 
     * <pre>
     * StringUtils.padding(0, 'e')  = &quot;&quot;
     * StringUtils.padding(3, 'e')  = &quot;eee&quot;
     * StringUtils.padding(-2, 'e') = IndexOutOfBoundsException
     * </pre>
     * 
     * @param repeat Ҫ�ظ��Ĵ���
     * @param padChar Ҫ�ظ����ַ�
     * @return �ظ�����ַ���
     */
    public static String padding(int repeat, char padChar) {
        // be careful of synchronization in this method
        // we are assuming that get and set from an array index is atomic
        String strPad = CONSTANTS_PADDING[padChar];
        if (strPad == null) {
            strPad = String.valueOf(padChar);
        }
        while (strPad.length() < repeat) {
            strPad = strPad.concat(strPad);
        }
        CONSTANTS_PADDING[padChar] = strPad;
        return strPad.substring(0, repeat);
    }
    
    /**
     * <p>
     * Ϊ�ַ���str���ұ����(' ').
     * </p>
     * <p>
     * ���(' ')����ַ����ĳ���Ϊ����<code>size</code>ָ���ĳ���.
     * </p>
     * 
     * <pre>
     * StringUtils.rightPad(null, *)   = null
     * StringUtils.rightPad(&quot;&quot;, 3)     = &quot;   &quot;
     * StringUtils.rightPad(&quot;bat&quot;, 3)  = &quot;bat&quot;
     * StringUtils.rightPad(&quot;bat&quot;, 5)  = &quot;bat  &quot;
     * StringUtils.rightPad(&quot;bat&quot;, 1)  = &quot;bat&quot;
     * StringUtils.rightPad(&quot;bat&quot;, -1) = &quot;bat&quot;
     * </pre>
     * 
     * @param string Ҫ���(' ')���ַ���, ����Ϊnull
     * @param size Ҫ��ӵĳ���
     * @return Ҫ���(' ')�ĺ��ַ���,���û��Ӿͷ���ԭ�ַ���. <code>null</code>���������ַ���Ϊnull
     */
    public static String rightPad(String string, int size) {
        return org.apache.commons.lang.StringUtils.rightPad(string, size);
    }
    
    /**
     * <p>
     * Ϊ�ַ���str���ұ����ָ�����ַ�padChar.
     * </p>
     * <p>
     * ���ָ�����ַ�����ַ����ĳ���Ϊ����<code>size</code>ָ���ĳ���.
     * </p>
     * 
     * <pre>
     * StringUtils.rightPad(null, *, *)     = null
     * StringUtils.rightPad(&quot;&quot;, 3, 'z')     = &quot;zzz&quot;
     * StringUtils.rightPad(&quot;bat&quot;, 3, 'z')  = &quot;bat&quot;
     * StringUtils.rightPad(&quot;bat&quot;, 5, 'z')  = &quot;batzz&quot;
     * StringUtils.rightPad(&quot;bat&quot;, 1, 'z')  = &quot;bat&quot;
     * StringUtils.rightPad(&quot;bat&quot;, -1, 'z') = &quot;bat&quot;
     * </pre>
     * 
     * @param string Ҫ����ַ����ַ���, ����Ϊnull
     * @param size ����ַ����ַ����ĳ���
     * @param padChar ��ӵ��ַ�
     * @return ����ַ�����ַ������û��Ӿͷ���ԭ�ַ���, <code>null</code>���������ַ���Ϊnull
     * @since 2.0
     */
    public static String rightPad(String string, int size, char padChar) {
        return org.apache.commons.lang.StringUtils.rightPad(string, size, padChar);
    }
    
    /**
     * <p>
     * Ϊ�ַ���str���ұ����ָ�����ַ���padStr.
     * </p>
     * <p>
     * ���ָ�����ַ���padStr����ַ����ĳ���Ϊ����<code>size</code>ָ���ĳ���.
     * </p>
     * 
     * <pre>
     * StringUtils.rightPad(null, *, *)      = null
     * StringUtils.rightPad(&quot;&quot;, 3, &quot;z&quot;)      = &quot;zzz&quot;
     * StringUtils.rightPad(&quot;bat&quot;, 3, &quot;yz&quot;)  = &quot;bat&quot;
     * StringUtils.rightPad(&quot;bat&quot;, 5, &quot;yz&quot;)  = &quot;batyz&quot;
     * StringUtils.rightPad(&quot;bat&quot;, 8, &quot;yz&quot;)  = &quot;batyzyzy&quot;
     * StringUtils.rightPad(&quot;bat&quot;, 1, &quot;yz&quot;)  = &quot;bat&quot;
     * StringUtils.rightPad(&quot;bat&quot;, -1, &quot;yz&quot;) = &quot;bat&quot;
     * StringUtils.rightPad(&quot;bat&quot;, 5, null)  = &quot;bat  &quot;
     * StringUtils.rightPad(&quot;bat&quot;, 5, &quot;&quot;)    = &quot;bat  &quot;
     * </pre>
     * 
     * @param string Ҫ����ַ������ַ���, ����Ϊnull
     * @param size ����ַ������ַ����ĳ���
     * @param padStr Ҫ��ӵ��ַ���, null����ַ�������(" ")
     * @return ����ַ�������ַ���,���û��Ӿͷ���ԭ�ַ���, <code>null</code> ���������ַ���Ϊnull
     */
    public static String rightPad(String string, int size, String padStr) {
        return org.apache.commons.lang.StringUtils.rightPad(string, size, padStr);
    }
    
    /**
     * <p>
     * Ϊ�ַ���str��������(' ').
     * </p>
     * <p>
     * ���(' ')����ַ����ĳ���Ϊ����<code>size</code>ָ���ĳ���.
     * </p>
     * 
     * <pre>
     * StringUtils.leftPad(null, *)   = null
     * StringUtils.leftPad(&quot;&quot;, 3)     = &quot;   &quot;
     * StringUtils.leftPad(&quot;bat&quot;, 3)  = &quot;bat&quot;
     * StringUtils.leftPad(&quot;bat&quot;, 5)  = &quot;  bat&quot;
     * StringUtils.leftPad(&quot;bat&quot;, 1)  = &quot;bat&quot;
     * StringUtils.leftPad(&quot;bat&quot;, -1) = &quot;bat&quot;
     * </pre>
     * 
     * @param string Ҫ���(' ')���ַ���, ����Ϊnull
     * @param size Ҫ��ӵĳ���
     * @return Ҫ���(' ')�ĺ��ַ���,���û��Ӿͷ���ԭ�ַ���, <code>null</code> i���������ַ���Ϊnull
     */
    public static String leftPad(String string, int size) {
        return org.apache.commons.lang.StringUtils.leftPad(string, size);
    }
    
    /**
     * <p>
     * Ϊ�ַ���str��������ָ�����ַ�padChar.
     * </p>
     * <p>
     * ���ָ�����ַ�����ַ����ĳ���Ϊ����<code>size</code>ָ���ĳ���.
     * </p>
     * 
     * <pre>
     * StringUtils.leftPad(null, *, *)     = null
     * StringUtils.leftPad(&quot;&quot;, 3, 'z')     = &quot;zzz&quot;
     * StringUtils.leftPad(&quot;bat&quot;, 3, 'z')  = &quot;bat&quot;
     * StringUtils.leftPad(&quot;bat&quot;, 5, 'z')  = &quot;zzbat&quot;
     * StringUtils.leftPad(&quot;bat&quot;, 1, 'z')  = &quot;bat&quot;
     * StringUtils.leftPad(&quot;bat&quot;, -1, 'z') = &quot;bat&quot;
     * </pre>
     * 
     * @param string Ҫ����ַ����ַ���, ����Ϊnull
     * @param size ����ַ����ַ����ĳ���
     * @param padChar ��ӵ��ַ�
     * @return ����ַ�����ַ���,���û��Ӿͷ���ԭ�ַ���, <code>null</code>���������ַ���Ϊnull
     * @since 2.0
     */
    public static String leftPad(String string, int size, char padChar) {
        return org.apache.commons.lang.StringUtils.leftPad(string, size, padChar);
    }
    
    /**
     * <p>
     * Ϊ�ַ���str��������ָ�����ַ���padStr.
     * </p>
     * <p>
     * ���ָ�����ַ���padStr����ַ����ĳ���Ϊ����<code>size</code>ָ���ĳ���.
     * </p>
     * 
     * <pre>
     * StringUtils.leftPad(null, *, *)      = null
     * StringUtils.leftPad(&quot;&quot;, 3, &quot;z&quot;)      = &quot;zzz&quot;
     * StringUtils.leftPad(&quot;bat&quot;, 3, &quot;yz&quot;)  = &quot;bat&quot;
     * StringUtils.leftPad(&quot;bat&quot;, 5, &quot;yz&quot;)  = &quot;yzbat&quot;
     * StringUtils.leftPad(&quot;bat&quot;, 8, &quot;yz&quot;)  = &quot;yzyzybat&quot;
     * StringUtils.leftPad(&quot;bat&quot;, 1, &quot;yz&quot;)  = &quot;bat&quot;
     * StringUtils.leftPad(&quot;bat&quot;, -1, &quot;yz&quot;) = &quot;bat&quot;
     * StringUtils.leftPad(&quot;bat&quot;, 5, null)  = &quot;  bat&quot;
     * StringUtils.leftPad(&quot;bat&quot;, 5, &quot;&quot;)    = &quot;  bat&quot;
     * </pre>
     * 
     * @param string Ҫ����ַ������ַ���, ����Ϊnull
     * @param size ����ַ������ַ����ĳ���
     * @param padStr Ҫ��ӵ��ַ���, null����ַ�������(" ")
     * @return ����ַ�������ַ���,���û��Ӿͷ���ԭ�ַ���, <code>null</code> ���������ַ���Ϊnull
     */
    public static String leftPad(String string, int size, String padStr) {
        return org.apache.commons.lang.StringUtils.leftPad(string, size, padStr);
    }
    
    /**
     * <p>
     * ���ַ���str�ŵ�ָ������<code>size</code>���м�, ԭ�ַ�����ǰ����(' ')������� .
     * <p>
     * <p>
     * ���size������С���ַ���str�ĳ��Ⱦ�ֱ�ӷ����ַ���str. �ַ�������strΪ<code>null</code>����<code>null</code>. size����Ϊ��������0.
     * </p>
     * <p>
     * ��ͬ�ں���<code>center(str, size, " ")</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.center(null, *)   = null
     * StringUtils.center(&quot;&quot;, 4)     = &quot;    &quot;
     * StringUtils.center(&quot;ab&quot;, -1)  = &quot;ab&quot;
     * StringUtils.center(&quot;ab&quot;, 4)   = &quot; ab &quot;
     * StringUtils.center(&quot;abcd&quot;, 2) = &quot;abcd&quot;
     * StringUtils.center(&quot;a&quot;, 4)    = &quot; a  &quot;
     * </pre>
     * 
     * @param string ��Ҫ�����м���ַ���, ����Ϊnull
     * @param size �µ��ַ����ĳ���, ��������0
     * @return �����м����ַ���, <code>null</code> ���������ַ���Ϊnull
     */
    public static String center(String string, int size) {
        return org.apache.commons.lang.StringUtils.center(string, size);
    }
    
    /**
     * <p>
     * ���ַ���str�ŵ�ָ������<code>size</code>���м�. ԭ�ַ�����ǰ����ָ�����ַ�padChar�������.
     * </p>
     * <p>
     * ���size������С���ַ���str�ĳ��Ⱦ�ֱ�ӷ����ַ���str. �ַ�������strΪ<code>null</code>����<code>null</code>. size����Ϊ��������0.
     * </p>
     * 
     * <pre>
     * StringUtils.center(null, *, *)     = null
     * StringUtils.center(&quot;&quot;, 4, ' ')     = &quot;    &quot;
     * StringUtils.center(&quot;ab&quot;, -1, ' ')  = &quot;ab&quot;
     * StringUtils.center(&quot;ab&quot;, 4, ' ')   = &quot; ab&quot;
     * StringUtils.center(&quot;abcd&quot;, 2, ' ') = &quot;abcd&quot;
     * StringUtils.center(&quot;a&quot;, 4, ' ')    = &quot; a  &quot;
     * StringUtils.center(&quot;a&quot;, 4, 'y')    = &quot;yayy&quot;
     * </pre>
     * 
     * @param string ��Ҫ�����м���ַ���, ����Ϊnull
     * @param size �µ��ַ����ĳ���, ��������0
     * @param padChar �ַ���str���������ַ�
     * @return �����м����ַ���, <code>null</code> ���������ַ���Ϊnull
     * @since 2.0
     */
    public static String center(String string, int size, char padChar) {
        return org.apache.commons.lang.StringUtils.center(string, size, padChar);
    }
    
    /**
     * <p>
     * ���ַ���str�ŵ�ָ������<code>size</code>���м�. ԭ�ַ�����ǰ����ָ�����ַ���padStr�������.
     * </p>
     * <p>
     * ���size������С���ַ���str�ĳ��Ⱦ�ֱ�ӷ����ַ���str. �ַ�������strΪ<code>null</code>����<code>null</code>. size����Ϊ��������0.
     * </p>
     * 
     * <pre>
     * StringUtils.center(null, *, *)     = null
     * StringUtils.center(&quot;&quot;, 4, &quot; &quot;)     = &quot;    &quot;
     * StringUtils.center(&quot;ab&quot;, -1, &quot; &quot;)  = &quot;ab&quot;
     * StringUtils.center(&quot;ab&quot;, 4, &quot; &quot;)   = &quot; ab&quot;
     * StringUtils.center(&quot;abcd&quot;, 2, &quot; &quot;) = &quot;abcd&quot;
     * StringUtils.center(&quot;a&quot;, 4, &quot; &quot;)    = &quot; a  &quot;
     * StringUtils.center(&quot;a&quot;, 4, &quot;yz&quot;)   = &quot;yayz&quot;
     * StringUtils.center(&quot;abc&quot;, 7, null) = &quot;  abc  &quot;
     * StringUtils.center(&quot;abc&quot;, 7, &quot;&quot;)   = &quot;  abc  &quot;
     * </pre>
     * 
     * @param string ��Ҫ�����м���ַ���, ����Ϊnull
     * @param size �µ��ַ����ĳ���, ��������0
     * @param padStr �ַ���str���������ַ���,���벻Ϊnull�����ǿհ�
     * @return �����м����ַ���, <code>null</code>���������ַ���Ϊnull
     */
    public static String center(String string, int size, String padStr) {
        return org.apache.commons.lang.StringUtils.center(string, size, padStr);
    }
    
    /**
     * <p>
     * ���ַ����е�ÿ���ַ�ת��Ϊ��д{@link String#toUpperCase()}.
     * </p>
     * <p>
     * <code>null</code>�ַ������뷵��<code>null</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.upperCase(null)  = null
     * StringUtils.upperCase(&quot;&quot;)    = &quot;&quot;
     * StringUtils.upperCase(&quot;aBc&quot;) = &quot;ABC&quot;
     * </pre>
     * 
     * @param string ��Ҫת�����ַ���, ����Ϊnull
     * @return ��д����ַ���,<code>null</code> ���������ַ���Ϊnull
     */
    public static String upperCase(String string) {
        return org.apache.commons.lang.StringUtils.upperCase(string);
    }
    
    /**
     * <p>
     * ���ַ����е�ÿ���ַ�ת��ΪСд{@link String#toLowerCase()}.
     * </p>
     * <p>
     * <code>null</code>�ַ������뷵��<code>null</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.lowerCase(null)  = null
     * StringUtils.lowerCase(&quot;&quot;)    = &quot;&quot;
     * StringUtils.lowerCase(&quot;aBc&quot;) = &quot;abc&quot;
     * </pre>
     * 
     * @param string ��Ҫת�����ַ���, ����Ϊnull
     * @return Сд����ַ���, <code>null</code> ���������ַ���Ϊnull
     */
    public static String lowerCase(String string) {
        return org.apache.commons.lang.StringUtils.lowerCase(string);
    }
    
    /**
     * <p>
     * ���ַ���str�ĵ�һ���ַ�ת��Ϊ��д�� {@link Character#toTitleCase(char)}. �������ַ�����ı�.
     * </p>
     * <p>
     * For a word based alorithm, �ο�{@link WordUtils#capitalize(String)}. <code>null</code>�ַ������뷵��<code>null</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.capitalize(null)  = null
     * StringUtils.capitalize(&quot;&quot;)    = &quot;&quot;
     * StringUtils.capitalize(&quot;cat&quot;) = &quot;Cat&quot;
     * StringUtils.capitalize(&quot;cAt&quot;) = &quot;CAt&quot;
     * </pre>
     * 
     * @param string ��Ҫ��д���ַ����ַ���, ����Ϊnull
     * @return ��д���ַ����ַ���, <code>null</code> ���������ַ���Ϊnull
     * @see WordUtils#capitalize(String)
     * @see #uncapitalize(String)
     * @since 2.0
     */
    public static String capitalize(String string) {
        return org.apache.commons.lang.StringUtils.capitalize(string);
    }
    
    /**
     * <p>
     * ���ַ���str�ĵ�һ���ַ�ת��Ϊ��д�� {@link Character#toTitleCase(char)}. �������ַ�����ı�.
     * </p>
     * 
     * @param str ��Ҫ�ı��string, ����Ϊnull
     * @return the ��д���string, ����null����<code>null</code>
     * @deprecated ʹ�ñ�׼������ {@link #capitalize(String)}. �������� Commons Lang 3.0. ���Ƴ�
     */
    @Deprecated
    public static String capitalise(String str) {
        return capitalize(str);
    }
    
    /**
     * <p>
     * ���ַ���str�ĵ�һ���ַ�ת��ΪСд�� {@link Character#toLowerCase(char)}. �������ַ�����ı�.
     * </p>
     * <p>
     * For a word based alorithm, �ο�{@link WordUtils#uncapitalize(String)}. <code>null</code>�ַ������뷵��<code>null</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.uncapitalize(null)  = null
     * StringUtils.uncapitalize(&quot;&quot;)    = &quot;&quot;
     * StringUtils.uncapitalize(&quot;Cat&quot;) = &quot;cat&quot;
     * StringUtils.uncapitalize(&quot;CAT&quot;) = &quot;cAT&quot;
     * </pre>
     * 
     * @param string ҪСд���ַ����ַ���, ����Ϊnull
     * @return Сд���ַ����ַ���, <code>null</code> ���������ַ���Ϊnull
     * @see WordUtils#uncapitalize(String)
     * @see #capitalize(String)
     * @since 2.0
     */
    public static String uncapitalize(String string) {
        return org.apache.commons.lang.StringUtils.uncapitalize(string);
    }
    
    /**
     * <p>
     * ���ַ���str�ĵ�һ���ַ�ת��ΪСд�� {@link Character#toLowerCase(char)}. �������ַ�����ı�.
     * </p>
     * 
     * @param str ҪСд���ַ����ַ���, ����Ϊnull
     * @return Сд���ַ����ַ���, <code>null</code> ���������ַ���Ϊnull
     * @deprecated ʹ�ñ�׼������ {@link #uncapitalize(String)}. �������� Commons Lang 3.0. ��ȡ��
     */
    @Deprecated
    public static String uncapitalise(String str) {
        return uncapitalize(str);
    }
    
    /**
     * <p>
     * ���ַ���str�е��ַ����д�Сд�Ľ���, �ַ����д�д��ת��ΪСд,Сд��ת��Ϊ��д.
     * </p>
     * <ul>
     * <li>��д���ַ�ת��ΪСд</li>
     * <li>�����ַ�ת��ΪСд</li>
     * <li>Сд���ַ�ת��Ϊ��д</li>
     * </ul>
     * <p>
     * For a word based alorithm, �ο�{@link WordUtils#swapCase(String)}. <code>null</code>�ַ������뷵��<code>null</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.swapCase(null)                 = null
     * StringUtils.swapCase(&quot;&quot;)                   = &quot;&quot;
     * StringUtils.swapCase(&quot;The dog has a BONE&quot;) = &quot;tHE DOG HAS A bone&quot;
     * </pre>
     * <p>
     * ע��: ��������� Lang version 2.0. �����ı� It no longer performs a word based alorithm. ���ʹ�õ���ASCII, ��û�иı�.
     * ��WordUtils������Ч��.
     * </p>
     * 
     * @param string Ҫ���д�Сдת�����ַ���, ����Ϊnull
     * @return ת�����ַ���, <code>null</code> ���������ַ���Ϊnull
     */
    public static String swapCase(String string) {
        return org.apache.commons.lang.StringUtils.swapCase(string);
    }
    
    /**
     * <p>
     * �ҳ��ַ���str��ƥ���ַ���sub������.
     * </p>
     * <p>
     * <code>null</code>�ַ�����հ�("")���ַ�������<code>0</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.countMatches(null, *)       = 0
     * StringUtils.countMatches(&quot;&quot;, *)         = 0
     * StringUtils.countMatches(&quot;abba&quot;, null)  = 0
     * StringUtils.countMatches(&quot;abba&quot;, &quot;&quot;)    = 0
     * StringUtils.countMatches(&quot;abba&quot;, &quot;a&quot;)   = 2
     * StringUtils.countMatches(&quot;abba&quot;, &quot;ab&quot;)  = 1
     * StringUtils.countMatches(&quot;abba&quot;, &quot;xxx&quot;) = 0
     * </pre>
     * 
     * @param string ��Ҫ�����ַ���, ����Ϊnull
     * @param sub ƥ������ַ���, ����Ϊnull
     * @return �ַ���str�г����ַ���sub�Ĵ���, 0 ���������<code>null</code>
     */
    public static int countMatches(String string, String sub) {
        return org.apache.commons.lang.StringUtils.countMatches(string, sub);
    }
    
    /**
     * <p>
     * ����ַ���str���Ƿ�ֻ������unicode����ĸ.
     * </p>
     * <p>
     * <code>null</code> ����<code>false</code>. �հ��ַ���("") ����<code>true</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.isAlpha(null)   = false
     * StringUtils.isAlpha(&quot;&quot;)     = true
     * StringUtils.isAlpha(&quot;  &quot;)   = false
     * StringUtils.isAlpha(&quot;abc&quot;)  = true
     * StringUtils.isAlpha(&quot;ab2c&quot;) = false
     * StringUtils.isAlpha(&quot;ab-c&quot;) = false
     * </pre>
     * 
     * @param string Ҫ�����ַ���, ����Ϊnull
     * @return <code>true</code> ���ֻ���ַ�,�������벻Ϊnull
     */
    public static boolean isAlpha(String string) {
        return org.apache.commons.lang.StringUtils.isAlpha(string);
    }
    
    /**
     * <p>
     * �鿴�ַ������Ƿ�ֻ��unicode����ĸ�����ǿհ�(" ").
     * </p>
     * <p>
     * <code>null</code>����<code>false</code> �հ��ַ�("")����<code>true</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.isAlphaSpace(null)   = false
     * StringUtils.isAlphaSpace(&quot;&quot;)     = true
     * StringUtils.isAlphaSpace(&quot;  &quot;)   = true
     * StringUtils.isAlphaSpace(&quot;abc&quot;)  = true
     * StringUtils.isAlphaSpace(&quot;ab c&quot;) = true
     * StringUtils.isAlphaSpace(&quot;ab2c&quot;) = false
     * StringUtils.isAlphaSpace(&quot;ab-c&quot;) = false
     * </pre>
     * 
     * @param string Ҫ�����ַ���, ����Ϊnull
     * @return <code>true</code> ���ֻ���ַ�����(" "),�������벻Ϊnull
     */
    public static boolean isAlphaSpace(String string) {
        return org.apache.commons.lang.StringUtils.isAlphaSpace(string);
    }
    
    /**
     * <p>
     * �鿴�ַ������Ƿ�ֻ��unicode����ĸ��������.
     * </p>
     * <p>
     * <code>null</code>����<code>false</code>. �յ��ַ���("")����<code>true</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.isAlphanumeric(null)   = false
     * StringUtils.isAlphanumeric(&quot;&quot;)     = true
     * StringUtils.isAlphanumeric(&quot;  &quot;)   = false
     * StringUtils.isAlphanumeric(&quot;abc&quot;)  = true
     * StringUtils.isAlphanumeric(&quot;ab c&quot;) = false
     * StringUtils.isAlphanumeric(&quot;ab2c&quot;) = true
     * StringUtils.isAlphanumeric(&quot;ab-c&quot;) = false
     * </pre>
     * 
     * @param string Ҫ�����ַ���, ����Ϊnull
     * @return <code>true</code>ֻ��unicode����ĸ��������,�������벻Ϊnull
     */
    public static boolean isAlphanumeric(String string) {
        return org.apache.commons.lang.StringUtils.isAlphanumeric(string);
    }
    
    /**
     * <p>
     * �鿴�ַ������Ƿ�ֻ��unicode����ĸ,���� ���߿հ�(<code>' '</code>).
     * </p>
     * <p>
     * <code>null</code> ����<code>false</code>. �յ��ַ��� ("") ����<code>true</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.isAlphanumeric(null)   = false
     * StringUtils.isAlphanumeric(&quot;&quot;)     = true
     * StringUtils.isAlphanumeric(&quot;  &quot;)   = true
     * StringUtils.isAlphanumeric(&quot;abc&quot;)  = true
     * StringUtils.isAlphanumeric(&quot;ab c&quot;) = true
     * StringUtils.isAlphanumeric(&quot;ab2c&quot;) = true
     * StringUtils.isAlphanumeric(&quot;ab-c&quot;) = false
     * </pre>
     * 
     * @param string Ҫ�����ַ���, ����Ϊnull
     * @return <code>true</code> ֻ��unicode����ĸ�������ֻ��߿հ� �������벻Ϊnull
     */
    public static boolean isAlphanumericSpace(String string) {
        return org.apache.commons.lang.StringUtils.isAlphanumericSpace(string);
    }
    
    /**
     * <p>
     * �鿴�ַ������Ƿ�ֻ��unicode������. С���㲻��Ϊ��unicode������.
     * </p>
     * <p>
     * <code>null</code> ���� <code>false</code>. �յ��ַ���("") ���� <code>true</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.isNumeric(null)   = false
     * StringUtils.isNumeric(&quot;&quot;)     = true
     * StringUtils.isNumeric(&quot;  &quot;)   = false
     * StringUtils.isNumeric(&quot;123&quot;)  = true
     * StringUtils.isNumeric(&quot;12 3&quot;) = false
     * StringUtils.isNumeric(&quot;ab2c&quot;) = false
     * StringUtils.isNumeric(&quot;12-3&quot;) = false
     * StringUtils.isNumeric(&quot;12.3&quot;) = false
     * </pre>
     * 
     * @param string Ҫ�����ַ���, ����Ϊnull
     * @return <code>true</code> ֻ��unicode������,�������벻Ϊnull
     */
    public static boolean isNumeric(String string) {
        return org.apache.commons.lang.StringUtils.isNumeric(string);
    }
    
    /**
     * <p>
     * �鿴�ַ������Ƿ�ֻ��unicode������ �Ϳհ�(<code>' '</code>). С���㲻��Ϊ��unicode������.
     * </p>
     * <p>
     * <code>null</code> ���� <code>false</code>. �յ��ַ���("") ���� <code>true</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.isNumeric(null)   = false
     * StringUtils.isNumeric(&quot;&quot;)     = true
     * StringUtils.isNumeric(&quot;  &quot;)   = true
     * StringUtils.isNumeric(&quot;123&quot;)  = true
     * StringUtils.isNumeric(&quot;12 3&quot;) = true
     * StringUtils.isNumeric(&quot;ab2c&quot;) = false
     * StringUtils.isNumeric(&quot;12-3&quot;) = false
     * StringUtils.isNumeric(&quot;12.3&quot;) = false
     * </pre>
     * 
     * @param string Ҫ�����ַ���, ����Ϊnull
     * @return <code>true</code> ֻ��unicode�����ֻ��߿հ�,�������벻Ϊnull
     */
    public static boolean isNumericSpace(String string) {
        return org.apache.commons.lang.StringUtils.isNumericSpace(string);
    }
    
    /**
     * <p>
     * �鿴�ַ������Ƿ�ֻ�пհ��ַ�.
     * </p>
     * <p>
     * <code>null</code> ���� <code>false</code>. �յ��ַ���("") ���� <code>true</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.isWhitespace(null)   = false
     * StringUtils.isWhitespace(&quot;&quot;)     = true
     * StringUtils.isWhitespace(&quot;  &quot;)   = true
     * StringUtils.isWhitespace(&quot;abc&quot;)  = false
     * StringUtils.isWhitespace(&quot;ab2c&quot;) = false
     * StringUtils.isWhitespace(&quot;ab-c&quot;) = false
     * </pre>
     * 
     * @param string Ҫ�����ַ���, ����Ϊnull
     * @return <code>true</code> ֻ�пհ��ַ�,�������벻Ϊnull
     * @since 2.0
     */
    public static boolean isWhitespace(String string) {
        return org.apache.commons.lang.StringUtils.isWhitespace(string);
    }
    
    /**
     * <p>
     * ��������ַ���Ϊnullʱ����(""),������������ַ������� .
     * </p>
     * 
     * <pre>
     * StringUtils.defaultString(null)  = &quot;&quot;
     * StringUtils.defaultString(&quot;&quot;)    = &quot;&quot;
     * StringUtils.defaultString(&quot;bat&quot;) = &quot;bat&quot;
     * </pre>
     * 
     * @see String#valueOf(Object)
     * @param string Ҫ�����ַ���, ����Ϊnull
     * @return ����������ַ���, �������Ϊ<code>null</code>����""
     */
    public static String defaultString(String string) {
        return org.apache.commons.lang.StringUtils.defaultString(string);
    }
    
    /**
     * <p>
     * ���������ַ����Ƿ�Ϊ<code>null</code>�Ǿͷ���ָ����Ĭ��ֵdefaultStr, ���Ǿͷ����ַ����Լ�����
     * </p>
     * 
     * <pre>
     * StringUtils.defaultString(null, &quot;null&quot;)  = &quot;null&quot;
     * StringUtils.defaultString(&quot;&quot;, &quot;null&quot;)    = &quot;&quot;
     * StringUtils.defaultString(&quot;bat&quot;, &quot;null&quot;) = &quot;bat&quot;
     * </pre>
     * 
     * @see String#valueOf(Object)
     * @param string Ҫ�����ַ���, ����Ϊnull
     * @param defaultStr Ĭ�Ϸ��ص��ַ��� �������Ϊ<code>null</code>, ����Ϊnull
     * @return ��Ϊ<code>null</code>�Ƿ����ַ���str����
     */
    public static String defaultString(String string, String defaultStr) {
        return org.apache.commons.lang.StringUtils.defaultString(string, defaultStr);
    }
    
    /**
     * <p>
     * �ַ����е�ÿ���ַ����з���{@link StringBuffer#reverse()}.
     * </p>
     * <p>
     * <A code>null</code>����<code>null</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.reverse(null)  = null
     * StringUtils.reverse(&quot;&quot;)    = &quot;&quot;
     * StringUtils.reverse(&quot;bat&quot;) = &quot;tab&quot;
     * </pre>
     * 
     * @param string Ҫ���з�����ַ���, ����Ϊnull
     * @return ������ַ���, <code>null</code> ���������ַ���Ϊnull
     */
    public static String reverse(String string) {
        return org.apache.commons.lang.StringUtils.reverse(string);
    }
    
    // -----------------------------------------------------------------------
    /**
     * <p>
     * ��һ���ַ�������ʡ����д. ����ת�� "Now is the time for all good men" Ϊ "Now is the time for..."
     * </p>
     * <p>
     * ��������:
     * <ul>
     * <li>��������ַ���<code>str</code>�ĳ���С�ڲ���<code>maxWidth</code> �����ַ����Լ�����.</li>
     * <li>��д����ʽΪ<code>(substring(str, 0, max-3) + "...")</code>.</li>
     * <li>�������<code>maxWidth</code>С��<code>4</code>, �׳��쳣 <code>IllegalArgumentException</code>.</li>
     * <li>��������᷵��һ�� <code>maxWidth</code>ָ���ĳ��ȵ���д�ַ���.</li>
     * </ul>
     * </p>
     * 
     * <pre>
     * StringUtils.abbreviate(null, *)      = null
     * StringUtils.abbreviate(&quot;&quot;, 4)        = &quot;&quot;
     * StringUtils.abbreviate(&quot;abcdefg&quot;, 6) = &quot;abc...&quot;
     * StringUtils.abbreviate(&quot;abcdefg&quot;, 7) = &quot;abcdefg&quot;
     * StringUtils.abbreviate(&quot;abcdefg&quot;, 8) = &quot;abcdefg&quot;
     * StringUtils.abbreviate(&quot;abcdefg&quot;, 4) = &quot;a...&quot;
     * StringUtils.abbreviate(&quot;abcdefg&quot;, 3) = IllegalArgumentException
     * </pre>
     * 
     * @param string ��Ҫת�����ַ���, ����Ϊnull
     * @param maxWidth ���ص��ַ����ĳ���, ���ٱ���Ϊ4
     * @return ���Ե��ַ���, <code>null</code> ���������ַ���Ϊnull
     * @since 2.0
     */
    public static String abbreviate(String string, int maxWidth) {
        return org.apache.commons.lang.StringUtils.abbreviate(string, maxWidth);
    }
    
    /**
     * <p>
     * ��һ���ַ�������ʡ����д. ����ת��"Now is the time for all good men"Ϊ"...is the time for..."
     * </p>
     * <p>
     * ����<code>abbreviate(String, int)</code>, ���������ָ������ַ�������ʼλ��. ע�� ����߿�ʼ��offset���ַ��ڽ���в�һ���������,
     * ��һ���ַ�������(...)����offset��λ�õ��ַ�һ�����ڽ����.
     * <p>
     * ��������᷵��һ��<code>maxWidth</code>ָ���ĳ��ȵ���д�ַ���.
     * </p>
     * 
     * <pre>
     * StringUtils.abbreviate(null, *, *)                = null
     * StringUtils.abbreviate(&quot;&quot;, 0, 4)                  = &quot;&quot;
     * StringUtils.abbreviate(&quot;abcdefghijklmno&quot;, -1, 10) = &quot;abcdefg...&quot;
     * StringUtils.abbreviate(&quot;abcdefghijklmno&quot;, 0, 10)  = &quot;abcdefg...&quot;
     * StringUtils.abbreviate(&quot;abcdefghijklmno&quot;, 1, 10)  = &quot;abcdefg...&quot;
     * StringUtils.abbreviate(&quot;abcdefghijklmno&quot;, 4, 10)  = &quot;abcdefg...&quot;
     * StringUtils.abbreviate(&quot;abcdefghijklmno&quot;, 5, 10)  = &quot;...fghi...&quot;
     * StringUtils.abbreviate(&quot;abcdefghijklmno&quot;, 6, 10)  = &quot;...ghij...&quot;
     * StringUtils.abbreviate(&quot;abcdefghijklmno&quot;, 8, 10)  = &quot;...ijklmno&quot;
     * StringUtils.abbreviate(&quot;abcdefghijklmno&quot;, 10, 10) = &quot;...ijklmno&quot;
     * StringUtils.abbreviate(&quot;abcdefghijklmno&quot;, 12, 10) = &quot;...ijklmno&quot;
     * StringUtils.abbreviate(&quot;abcdefghij&quot;, 0, 3)        = IllegalArgumentException
     * StringUtils.abbreviate(&quot;abcdefghij&quot;, 5, 6)        = IllegalArgumentException
     * </pre>
     * 
     * @param string ��Ҫת�����ַ���, ����Ϊnull
     * @param offset ��߿�ʼ���ַ���ƫ��λ��
     * @param maxWidth ���صĽ������󳤶�, ���ٱ���Ϊ 4
     * @return ��д���ַ���, <code>null</code> ���������ַ���Ϊnull
     * @since 2.0
     */
    public static String abbreviate(String string, int offset, int maxWidth) {
        return org.apache.commons.lang.StringUtils.abbreviate(string, offset, maxWidth);
    }
    
    /**
     * <p>
     * �Ƚ������ַ���str1,str2 ����str2��ͬ��str1��λ��. (���صڶ����ַ���str2�Ĵӿ�ʼ�� ��һ���ַ���str1��ͬ��λ�õ�ĩβ��ʣ�ಿ��.)
     * </p>
     * <p>
     * ����, <code>difference("i am a machine", "i am a robot") -> "robot"</code>.
     * </p>
     * 
     * <pre>
     * StringUtils.difference(null, null) = null
     * StringUtils.difference(&quot;&quot;, &quot;&quot;) = &quot;&quot;
     * StringUtils.difference(&quot;&quot;, &quot;abc&quot;) = &quot;abc&quot;
     * StringUtils.difference(&quot;abc&quot;, &quot;&quot;) = &quot;&quot;
     * StringUtils.difference(&quot;abc&quot;, &quot;abc&quot;) = &quot;&quot;
     * StringUtils.difference(&quot;ab&quot;, &quot;abxyz&quot;) = &quot;xyz&quot;
     * StringUtils.difference(&quot;abcde&quot;, &quot;abxyz&quot;) = &quot;xyz&quot;
     * StringUtils.difference(&quot;abcde&quot;, &quot;xyz&quot;) = &quot;xyz&quot;
     * </pre>
     * 
     * @param str1 ��һ���ַ���, ����Ϊnull
     * @param str2 �ڶ����ַ���, ����Ϊnull
     * @return ���صڶ����ַ���str2��ͬ�ڵ�һ���ַ���str1���ַ���; �����ַ�����Ⱦͷ���("")
     * @since 2.0
     */
    public static String difference(String str1, String str2) {
        return org.apache.commons.lang.StringUtils.difference(str1, str2);
    }
    
    /**
     * <p>
     * �Ƚ������ַ���str1,str2 �������ǿ�ʼ����ͬʱ��λ�� .
     * </p>
     * <p>
     * ����, <code>indexOfDifference("i am a machine", "i am a robot") -> 7</code>
     * </p>
     * 
     * <pre>
     * StringUtils.indexOfDifference(null, null) = -1
     * StringUtils.indexOfDifference(&quot;&quot;, &quot;&quot;) = -1
     * StringUtils.indexOfDifference(&quot;&quot;, &quot;abc&quot;) = 0
     * StringUtils.indexOfDifference(&quot;abc&quot;, &quot;&quot;) = 0
     * StringUtils.indexOfDifference(&quot;abc&quot;, &quot;abc&quot;) = -1
     * StringUtils.indexOfDifference(&quot;ab&quot;, &quot;abxyz&quot;) = 2
     * StringUtils.indexOfDifference(&quot;abcde&quot;, &quot;abxyz&quot;) = 2
     * StringUtils.indexOfDifference(&quot;abcde&quot;, &quot;xyz&quot;) = 0
     * </pre>
     * 
     * @param str1 ��һ���ַ���,����Ϊnull
     * @param str2 �ڶ����ַ���,����Ϊnull
     * @return �ַ��� str2 ���ַ��� str1 ��ʼ��ͬ��λ��; -1 ��ʾ�������
     * @since 2.0
     */
    public static int indexOfDifference(String str1, String str2) {
        return org.apache.commons.lang.StringUtils.indexOfDifference(str1, str2);
    }
    
    /**
     * <p>
     * �������ַ���֮���Levenshtein-Distance.
     * </p>
     * <p>
     * ���ַ���sҪ����ַ���t��Ҫ�Ķ����ַ��ĸ�,һ�θĶ�һ���ַ� (ɾ��,��������û�).
     * </p>
     * <p>
     * Levenshtein distance ���㷨������Բο� <a href="http://www.merriampark.com/ld.htm">http://www.merriampark.com/ld.htm</a>
     * </p>
     * 
     * <pre>
     * StringUtils.getLevenshteinDistance(null, *)             = IllegalArgumentException
     * StringUtils.getLevenshteinDistance(*, null)             = IllegalArgumentException
     * StringUtils.getLevenshteinDistance(&quot;&quot;,&quot;&quot;)               = 0
     * StringUtils.getLevenshteinDistance(&quot;&quot;,&quot;a&quot;)              = 1
     * StringUtils.getLevenshteinDistance(&quot;aaapppp&quot;, &quot;&quot;)       = 7
     * StringUtils.getLevenshteinDistance(&quot;frog&quot;, &quot;fog&quot;)       = 1
     * StringUtils.getLevenshteinDistance(&quot;fly&quot;, &quot;ant&quot;)        = 3
     * StringUtils.getLevenshteinDistance(&quot;elephant&quot;, &quot;hippo&quot;) = 7
     * StringUtils.getLevenshteinDistance(&quot;hippo&quot;, &quot;elephant&quot;) = 7
     * StringUtils.getLevenshteinDistance(&quot;hippo&quot;, &quot;zzzzzzzz&quot;) = 8
     * StringUtils.getLevenshteinDistance(&quot;hello&quot;, &quot;hallo&quot;)    = 1
     * </pre>
     * 
     * @param s ��һ���ַ���, ����Ϊnull
     * @param t �ڶ����ַ���, ����Ϊnull
     * @return ����Ҫ�Ķ����ַ��ĸ���
     */
    public static int getLevenshteinDistance(String s, String t) {
        return org.apache.commons.lang.StringUtils.getLevenshteinDistance(s, t);
    }
    
    /**
     * <p>
     * ����������ʽ�����ַ�
     * </p>
     * 
     * @param string �ַ���
     * @param regex ������ʽ
     * @return ���˺���ַ�
     */
    public static String filterSpecialChar(String string, String regex) {
        if (string == null) {
            return null;
        }
        
        Pattern objPattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher objMatcher = objPattern.matcher(string);
        return objMatcher.replaceAll("").trim();
    }
    
    /**
     * ����������ʽ,�ж��Ƿ�ƥ���ַ�
     * 
     * @param string �ַ���
     * @param regex ������ʽ
     * @return boolean
     */
    public static boolean isMatch(String string, String regex) {
        if (string == null || regex == null || regex.trim().length() == 0) {
            return false;
        }
        Pattern objPattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher objMatcher = objPattern.matcher(string);
        return objMatcher.find();
    }
    
    /**
     * ��Դ�ַ���(source)��ȡǰlen���ַ������lenС��Դ�ַ����ĳ��ȣ����ڷ���ֵ������ַ���concat��
     * 
     * <pre>
     * String strSource = &quot;a�л����񹲺͹�&quot;;
     * ProjectUtils.getFixedLengthString(strSource,10,&quot;...&quot;)= &quot;a�л�����...&quot;
     * ProjectUtils.getFixedLengthString(strSource,10,null)= &quot;a�л�����&quot;
     * ProjectUtils.getFixedLengthString(strSource,10,&quot;&quot;)=&quot;a�л�����&quot;
     * ProjectUtils.getFixedLengthString(strSource,10,&quot; &quot;)=&quot;a�л�����&quot;
     * ProjectUtils.getFixedLengthString(strSource,-1,&quot;&quot;)=&quot;&quot;
     * ProjectUtils.getFixedLengthString(strSource,0,&quot;&quot;)=&quot;&quot;
     * ProjectUtils.getFixedLengthString(strSource,0,null)=&quot;&quot;
     * ProjectUtils.getFixedLengthString(strSource,-1,null)=&quot;&quot;
     * </pre>
     * 
     * @param source Դ�ַ�����Ϣ
     * @param len ��Ҫ��ȡ���ַ�����
     * @param concat ��Ҫ����ַ���
     * @return ���ػ�ȡ���ַ�����Ϣ��
     * @throws UnsupportedEncodingException ��֧��GBK����ʱ�׳�
     */
    public static String getFixedLengthString(String source, int len, String concat)
        throws UnsupportedEncodingException {
        String strRet = "";
        if (source == null || concat == null) {
            return "";
        }
        if (len <= 0) {
            return strRet;
        }
        for (int i = 1; i <= source.length(); i++) {
            strRet = source.substring(0, i);
            if (strRet.getBytes("GBK").length >= len) {
                break;
            }
        }
        if (strRet.getBytes("GBK").length < source.getBytes("GBK").length) {
            strRet += concat;
        }
        return strRet;
    }
    
    /**
     * ȡһ���ַ����ĳ��ȣ�һ�������������ֽڣ�
     * 
     * <pre>
     * ProjectUtils.getStringCharsCount(&quot;abc&quot;) = 3��
     * ProjectUtils.getStringCharsCount(&quot;abc��&quot;) = 5��
     * ProjectUtils.getStringCharsCount(&quot;�úܺü���&quot;) = 10��
     * </pre>
     * 
     * @param pstrSrc ��Ҫ���㳤�ȵ��ַ���
     * @return �ַ�������
     */
    public static int getStringCharsCount(String pstrSrc) {
        int iSize = pstrSrc.length();
        int iHZCnt = 0;
        for (int i = 0; i < iSize; i++) {
            if (pstrSrc.charAt(i) < 0 || pstrSrc.charAt(i) > 255) {
                iHZCnt++;
            }
        }
        iSize += iHZCnt;
        return iSize;
    }
    
    /**
     * ��������������ת��Ϊ����ķ���
     * 
     * @param lArray ��������������
     * @return �ַ���
     */
    public static String toString(long[] lArray) {
        if (lArray == null) {
            return "null";
        }
        if (lArray.length == 0) {
            return "[]";
        }
        
        StringBuffer sbBufer = new StringBuffer();
        sbBufer.append('[');
        sbBufer.append(lArray[0]);
        
        for (int i = 1; i < lArray.length; i++) {
            sbBufer.append(", ");
            sbBufer.append(lArray[i]);
        }
        
        sbBufer.append("]");
        return sbBufer.toString();
    }
    
    /**
     * ������������ת��Ϊ����ķ���
     * 
     * @param iArray ������������
     * @return String �ַ���
     */
    public static String toString(int[] iArray) {
        if (iArray == null) {
            return "null";
        }
        if (iArray.length == 0) {
            return "[]";
        }
        
        StringBuffer sbBuffer = new StringBuffer();
        sbBuffer.append('[');
        sbBuffer.append(iArray[0]);
        
        for (int i = 1; i < iArray.length; i++) {
            sbBuffer.append(", ");
            sbBuffer.append(iArray[i]);
        }
        
        sbBuffer.append("]");
        return sbBuffer.toString();
    }
    
    /**
     * ��������������ת��Ϊ����ķ���
     * 
     * @param sArray ��������������
     * @return �ַ���
     */
    public static String toString(short[] sArray) {
        if (sArray == null) {
            return "null";
        }
        if (sArray.length == 0) {
            return "[]";
        }
        
        StringBuffer sbBuffer = new StringBuffer();
        sbBuffer.append('[');
        sbBuffer.append(sArray[0]);
        
        for (int i = 1; i < sArray.length; i++) {
            sbBuffer.append(", ");
            sbBuffer.append(sArray[i]);
        }
        
        sbBuffer.append("]");
        return sbBuffer.toString();
    }
    
    /**
     * �ַ���������ת��Ϊ����ķ���
     * 
     * @param cArray �ַ���������
     * @return �ַ���
     */
    public static String toString(char[] cArray) {
        if (cArray == null) {
            return "null";
        }
        if (cArray.length == 0) {
            return "[]";
        }
        
        StringBuffer sbBuffer = new StringBuffer();
        sbBuffer.append('[');
        sbBuffer.append(cArray[0]);
        
        for (int i = 1; i < cArray.length; i++) {
            sbBuffer.append(", ");
            sbBuffer.append(cArray[i]);
        }
        
        sbBuffer.append("]");
        return sbBuffer.toString();
    }
    
    /**
     * byte��������ת��Ϊ����ķ���
     * 
     * @param bArray byte��������
     * @return �ַ���
     */
    public static String toString(byte[] bArray) {
        if (bArray == null) {
            return "null";
        }
        if (bArray.length == 0) {
            return "[]";
        }
        
        StringBuffer sbBuffer = new StringBuffer();
        sbBuffer.append('[');
        sbBuffer.append(bArray[0]);
        
        for (int i = 1; i < bArray.length; i++) {
            sbBuffer.append(", ");
            sbBuffer.append(bArray[i]);
        }
        
        sbBuffer.append("]");
        return sbBuffer.toString();
    }
    
    /**
     * boolean��������ת��Ϊ����ķ���
     * 
     * @param bArray boolean��������
     * @return �ַ���
     */
    public static String toString(boolean[] bArray) {
        if (bArray == null) {
            return "null";
        }
        if (bArray.length == 0) {
            return "[]";
        }
        
        StringBuffer sbBuffer = new StringBuffer();
        sbBuffer.append('[');
        sbBuffer.append(bArray[0]);
        
        for (int i = 1; i < bArray.length; i++) {
            sbBuffer.append(", ");
            sbBuffer.append(bArray[i]);
        }
        
        sbBuffer.append("]");
        return sbBuffer.toString();
    }
    
    /**
     * ������������ת��Ϊ����ķ���
     * 
     * @param fArray ������������
     * @return �ַ���
     */
    public static String toString(float[] fArray) {
        if (fArray == null) {
            return "null";
        }
        if (fArray.length == 0) {
            return "[]";
        }
        
        StringBuffer sbBuffer = new StringBuffer();
        sbBuffer.append('[');
        sbBuffer.append(fArray[0]);
        
        for (int i = 1; i < fArray.length; i++) {
            sbBuffer.append(", ");
            sbBuffer.append(fArray[i]);
        }
        
        sbBuffer.append("]");
        return sbBuffer.toString();
    }
    
    /**
     * ˫������������ת��Ϊ����ķ���
     * 
     * @param dArray ˫������������
     * @return �ַ���
     */
    public static String toString(double[] dArray) {
        if (dArray == null) {
            return "null";
        }
        if (dArray.length == 0) {
            return "[]";
        }
        
        StringBuffer sbBuffer = new StringBuffer();
        sbBuffer.append('[');
        sbBuffer.append(dArray[0]);
        
        for (int i = 1; i < dArray.length; i++) {
            sbBuffer.append(", ");
            sbBuffer.append(dArray[i]);
        }
        
        sbBuffer.append("]");
        return sbBuffer.toString();
    }
    
    /**
     * Object��������ת��Ϊ����ķ���
     * 
     * @param objArray Object��������
     * @return �ַ���
     */
    public static String toString(Object[] objArray) {
        if (objArray == null) {
            return "null";
        }
        if (objArray.length == 0) {
            return "[]";
        }
        
        StringBuffer sbBuffer = new StringBuffer();
        
        for (int i = 0; i < objArray.length; i++) {
            if (i == 0) {
                sbBuffer.append('[');
            } else {
                sbBuffer.append(", ");
            }
            
            sbBuffer.append(String.valueOf(objArray[i]));
        }
        
        sbBuffer.append("]");
        return sbBuffer.toString();
    }
    
    /**
     * �Ƿ���������ַ�
     * 
     * @param cnStr ָ���ַ���
     * @return true:�� false:��
     */
    public static boolean isContainChineseCharacter(String cnStr) {
        if (StringUtils.isEmpty(cnStr)) {
            return false;
        }
        char[] chArray = cnStr.toCharArray();
        boolean bIsContainChineseCharacter = false;
        for (int i = 0; i < chArray.length; i++) {
            byte[] bBytes = ("" + chArray[i]).getBytes();
            if (bBytes.length == 2) {
                int[] iInts = new int[2];
                iInts[0] = bBytes[0] & 0xff;
                iInts[1] = bBytes[1] & 0xff;
                if (iInts[0] >= 0x81 && iInts[0] <= 0xFE && iInts[1] >= 0x40 && iInts[1] <= 0xFE) {
                    bIsContainChineseCharacter = true;
                    break;
                }
            }
        }
        return bIsContainChineseCharacter;
    }
    
    /**
     * �õ��ַ����ĳ��ȣ�һ�����ֳ���Ϊ2
     * 
     * @param str ָ���ַ���
     * @return int �ַ����ĳ���
     */
    public static int getStringLength(String str) {
        if (StringUtils.isEmpty(str)) {
            return 0;
        }
        int iLen = 0;
        char[] chArs = str.toCharArray();
        for (int i = 0; i < chArs.length; i++) {
            char chTemp = chArs[i];
            String strTemp = String.valueOf(chTemp);
            if (StringUtils.isContainChineseCharacter(strTemp)) {
                iLen += 2;
            } else {
                iLen++;
            }
        }
        return iLen;
    }
    
    /**
     * �滻�����ַ��ķ���,�滻<,>��"��
     * 
     * @param strInput Ҫ�滻���ַ���
     * @return strOutPut
     */
    public static String replaceIllegalString(String strInput) {
        // �滻<>��"��
        String strOutPut =
            strInput.replaceAll("<", "&lt ").replaceAll(">", "&gt ").replaceAll("\"", "&#34 ").replaceAll("'", "&#39 ");
        return strOutPut;
    }
}
