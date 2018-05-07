package com.kobe.mall.common.utils;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import javax.crypto.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * 加解密工具类
 * Created by zhongcy on 2016/3/24.
 */
public class DESUtils {
    private static Logger logger = LoggerFactory.getLogger(DESUtils.class);
    private static Key key;

    static {
        try {
            KeyGenerator generator = KeyGenerator.getInstance("DES");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            String KEY_STR = "mysql";
            secureRandom.setSeed(KEY_STR.getBytes());
            generator.init(secureRandom);
            key = generator.generateKey();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    /**
     * 加密方法
     *
     * @param str 明文
     * @return 返回结果
     */
    public static String getEncryptString(String str) {
        Encoder base64Encoder = Base64.getEncoder();
        try {
            byte[] strBytes = str.getBytes("UTF-8");
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptStrBytes = cipher.doFinal(strBytes);
            return new String(base64Encoder.encode(encryptStrBytes));
        } catch (UnsupportedEncodingException | IllegalBlockSizeException | InvalidKeyException | BadPaddingException | NoSuchAlgorithmException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getDecryptString(String str) {
        Decoder base64Decoder = Base64.getDecoder();
        try {
            byte[] strByte = base64Decoder.decode(str);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] encryptStrBytes = cipher.doFinal(strByte);
            return new String(encryptStrBytes, "UTF-8");
        } catch (IOException | IllegalBlockSizeException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void test() {
        System.out.println(getEncryptString("kode"));
        System.out.println(getEncryptString(""));
        System.out.println(getDecryptString("W61oVuV0H/w="));
        System.out.println(getDecryptString("9mlenn6m+7g="));
        System.out.println(getEncryptString("31586db9d50be8a130d5df38ced89497"));
        System.out.println(getEncryptString(null));
    }
}
