package cn.liliu.marry.utils;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.crypto.Cipher;
import java.math.BigInteger;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RSATools {
    /**
     * 签名算法
     */
    public static final String PUBLIC_RSA = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDR4CjCoBNVFBjCzCo5urwBPGzW\n" +
            "wGU563u9osEn9B6BYMwM7DUjc8wMYm/8c360kDlLVPwG2Jndgun/KhyB19mqcUZv\n" +
            "xF/TTskO4D/G0ikuJCdWA0i/+dd5tLrzlmDLD/A5IhtqfoZaHaCf+zdoUCCaw3vf\n" +
            "XH1rervJbY7WKzJYFwIDAQAB";
    public static final String PRIVATE_RSA = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBANHgKMKgE1UUGMLM\n" +
            "Kjm6vAE8bNbAZTnre72iwSf0HoFgzAzsNSNzzAxib/xzfrSQOUtU/AbYmd2C6f8q\n" +
            "HIHX2apxRm/EX9NOyQ7gP8bSKS4kJ1YDSL/513m0uvOWYMsP8DkiG2p+hlodoJ/7\n" +
            "N2hQIJrDe99cfWt6u8ltjtYrMlgXAgMBAAECgYAy23flGbc1kaYiZikBTj/KqOLS\n" +
            "81JUQ7z7ihn2XZCa12L66q5Bxgi3I49xhGc6yAwqNhDQc+JtLBEZ9RFtYWnsE+4s\n" +
            "oDcaw/3Dx6x1pQNUt4PT5BNsfFDlSEm1XhzQHtOWoUTR1ojaSX1vZAnbaKMUq2Vf\n" +
            "b8QPuKVJKcM/Nb59SQJBAPdF459tv8TFl1L8j+eE1D+Gnr7PWxTxibqjaliBiHu0\n" +
            "ua2qrKlPS6AlsADxfzD0p12Cjth3jNUab+ZAdG+yIFUCQQDZSGKEN/Cz1gt6G7c1\n" +
            "CSMWgpTOAQixStJ5fNKrsatU926tJJblypKWTzCgezY/Wu9w94tFPnmUeoUdrpoS\n" +
            "U9K7AkEAoMa8fcjqS5L+FWNKXgqrxrJNPVutqSxzlPr0BqASkfysThMPOPbqATMA\n" +
            "AV0EilxJBjABmRYCZ/1MjLWT/5weEQJBAIWExYUaGv9neIYAogQlKTqb43TzjbPk\n" +
            "lpGw8oQvGWmM4qXi5hcu9AUJhIgZLqyf5KM2eo6CZZOn9kTXFjZM7CECQQC76wOb\n" +
            "RJOjRbP+VXIjU4skFyIhlqJTwEvtop6kEJAe50RR7bzzlwds9qnI9/O6t/G9AtfN\n" +
            "vCnlLWVMkWagPhOi";


    //生成密钥对
    public static KeyPair genKeyPair(int keyLength) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        return keyPairGenerator.generateKeyPair();
    }

    //公钥加密
    public static byte[] encrypt(byte[] content, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");//java默认"RSA"="RSA/ECB/PKCS1Padding"
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(content);
    }

    //私钥解密
    public static byte[] decrypt(byte[] content, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(content);
    }


}
