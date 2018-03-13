package com.mizlicai.cashier.util;

/**
 * Created by MaiBenBen on 2017/6/2.
 */
public class StringUtil {

    public static String removeSpaces(String str){
        return str.replaceAll("[\\s]+", "");
    }
}
