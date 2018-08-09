package cn.liliu.marry.utils;

import cn.liliu.marry.entity.Constant;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.crypto.Cipher;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RSATools {
    static RSAPublicKey pubKey = null;
    static RSAPrivateKey privKey = null;

    public RSATools() {
        pubKey = (RSAPublicKey) RSATools.keyStrToPublicKey(Constant.PUBLIC_RSA);
        privKey = (RSAPrivateKey) RSATools.keyStrToPrivate(Constant.PRIVATE_RSA);
    }

    /*
            将字符串形式的公钥转换为公钥对象
         */
    public static PublicKey keyStrToPublicKey(String publicKeyStr){
        PublicKey publicKey = null;
        byte[] keyBytes = Base64.decode(publicKeyStr);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            publicKey = keyFactory.generatePublic(keySpec);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return publicKey;
    }

    /*
      将字符串形式的私钥，转换为私钥对象
   */
    public static PrivateKey keyStrToPrivate(String privateKeyStr){
        PrivateKey privateKey = null;
        byte[] keyBytes = Base64.decode(privateKeyStr);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            privateKey = keyFactory.generatePrivate(keySpec);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return privateKey;
    }

    //公钥加密
    public static String encodeValue(String value) {
        String encode = "";
        if (value != null && !value.equals("")) {
            //公钥加密
            try {
                Cipher cipher = Cipher.getInstance("RSA");
                cipher.init(Cipher.ENCRYPT_MODE, pubKey);
                byte[]  cipherText = cipher.doFinal(value.getBytes());
                //加密后的东西
                encode = java.util.Base64.getEncoder().encodeToString(cipherText);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return encode;
    }

    //私钥解密
    public static String dencodeValue(String value) {
        String dencode = "";
        if (value != null && !value.equals("")) {
            try {
                Cipher cipher = Cipher.getInstance("RSA");
                //开始解密
                cipher.init(Cipher.DECRYPT_MODE, privKey);
                byte[] plainText = cipher.doFinal(java.util.Base64.getDecoder().decode(value.getBytes()));
                dencode = new String(plainText);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dencode;
    }
}
