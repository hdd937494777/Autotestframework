package com.miz.testframework.objckeck.comparers;


import com.miz.testframework.util.StringUtil;

/**
 * "Y" flag 校验器
 */
public class SimpleComparer implements Comparer {

    /**
     * 按字符串比较
     * 
     * <pre>
     * compare("null",null)     = true
     * compare("null","null")   = true
     * compare("abc","abc")     = true
     * </pre>
     * 
     * @param expect
     * @param actual
     * @return
     */
    public boolean compare(String expect, Object actual) {
        return StringUtil.equals(expect, String.valueOf(actual));
    }

}
