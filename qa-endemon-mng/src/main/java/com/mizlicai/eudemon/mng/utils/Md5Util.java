//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.mizlicai.eudemon.mng.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {
    public Md5Util() {
    }

    public static String encrypt(String plaintext) {
        if(plaintext == null) {
            return null;
        } else {
            MessageDigest messageDigest = null;

            try {
                messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.reset();
                messageDigest.update(plaintext.getBytes("UTF-8"));
            } catch (NoSuchAlgorithmException var8) {
                System.out.println("NoSuchAlgorithmException caught!");
            } catch (UnsupportedEncodingException var9) {
                var9.printStackTrace();
            }

            byte[] byteArray = messageDigest.digest();
            StringBuffer md5StrBuff = new StringBuffer();
            byte[] arr$ = byteArray;
            int len$ = byteArray.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                byte element = arr$[i$];
                if(Integer.toHexString(255 & element).length() == 1) {
                    md5StrBuff.append("0").append(Integer.toHexString(255 & element));
                } else {
                    md5StrBuff.append(Integer.toHexString(255 & element));
                }
            }

            return md5StrBuff.toString();
        }
    }
    public static void main(String[] args) {
    	//f4e6d9f41b89d531d9e0627450891c36
		System.out.println(Md5Util.encrypt("admin"));
	}

}
