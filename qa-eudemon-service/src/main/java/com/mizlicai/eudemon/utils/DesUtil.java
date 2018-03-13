package com.mizlicai.eudemon.utils;

import com.alibaba.fastjson.JSONObject;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.Date;

/**
 * Created by huangyt on 2017/6/16.
 */
public class DesUtil {
    private final static String DES = "DES";

    private final static String RES_KEY = "mizlicai_cashier";

    /**
     * Description 根据键值进行加密
     *
     * @param bytes 需加密bytes数组
     * @param key   加密键bytes数组
     * @return 加密后数组
     * @throws Exception
     */
    private static byte[] encrypt(final byte[] bytes, final byte[] key)
            throws Exception {
        // 生成一个可信任的随机数源
        final SecureRandom sr = new SecureRandom();

        // 从原始密钥数据创建DESKeySpec对象
        final DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        final SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        final SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成加密操作
        final Cipher cipher = Cipher.getInstance(DES);

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

        return cipher.doFinal(bytes);
    }

    /**
     * Description 根据键值进行加密
     *
     * @param jsonData 需加密字符串 //* @param key 加密键byte数组
     * @return 密文
     * @throws Exception
     */
    public static String encrypt(final String jsonData) throws Exception {
        //return TripleDesEncryptUtil.encrypt(jsonData);
        byte[] bytes = encrypt(jsonData.getBytes("UTF-8"),
                RES_KEY.getBytes());
        return new BASE64Encoder().encode(bytes);
    }
}
