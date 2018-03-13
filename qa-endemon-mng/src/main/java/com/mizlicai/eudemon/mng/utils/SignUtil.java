package com.mizlicai.eudemon.mng.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isBlank;


/**
 * 签名加密 包括md5 和 rsa
 * Created by chars on  2016/11/4 20:09
 */
public class SignUtil {




    private static final String SIGN = "sign";

    //md5 密钥
    private static final String MD5_KEY = "cashier";

    /**
     * 生产MD5签名
     *
     * @param json 待签名json对象
     *             //     * @param md5_key md5密钥
     * @return 签名
     */
    public static String addSignMD5(JSONObject json) {
        if (json == null) {
            return "";
        }
        try {
            // 生成待签名串
            String sign_src = genSignData(json);
            sign_src += "key=" + MD5_KEY;
            return Md5Util.encrypt(sign_src);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * MD5签名验证
     *
     * @param json 待签名json对象
     *             //     * @param md5_key md5密钥
     * @return 检验成功true 失败false
     */
    public static boolean checkSignMD5(JSONObject json) {
        String sign = json.getString("sign");
        if (isBlank(sign)) {
            return false;
        }
        try {
            // 生成待签名串
            String sign_src = genSignData(json);
            sign_src += "key=" + MD5_KEY;

            return sign.equals(Md5Util.encrypt(sign_src));
        } catch (Exception e) {

            return false;
        }
    }


    /**
     * 生成待签名串
     *
     * @param json 待签名json对象
     * @return 待签名串
     */
    private static String genSignData(JSONObject json) {
        StringBuilder content = new StringBuilder();
        List<String> keys = new ArrayList<>(json.keySet());
        // 按照key做首字母升序排列
        keys.sort(String.CASE_INSENSITIVE_ORDER);
        for (String key : keys) {
            if (isBlank(key)) {
                continue;
            }
            if (SIGN.equals(key)) {
                continue;
            }
            String value = json.getString(key);
            // 空串不参与签名
            if (isBlank(value)) {
                continue;
            }
            content.append("&").append(key).append("=").append(value);
        }
        String sign_src = content.toString();
        if (sign_src.startsWith("&")) {
            sign_src = sign_src.replaceFirst("&", "");
        }
        return sign_src;
    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        JSONObject json = new JSONObject();
        json.put("aa", "aa");
        json.put("ab", "ab");
        json.put("bb", "bb");
        json.put("ba", "ba");
        json.put("bc", "bc");
        json.put(SIGN, addSignMD5(json));


        System.out.println(checkSignMD5(json));
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }

}
