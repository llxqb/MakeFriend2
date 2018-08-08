package cn.liliu.marry.test;

import cn.liliu.marry.entity.Constant;
import cn.liliu.marry.utils.RSATools;
import org.junit.Test;

import javax.crypto.Cipher;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;


public class DBTest {
    @Test
    public void test01() {
        String data = "你好";
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            RSAPublicKey  pubKey = (RSAPublicKey) RSATools.keyStrToPublicKey(Constant.PUBLIC_RSA);
            RSAPrivateKey privKey = (RSAPrivateKey) RSATools.keyStrToPrivate(Constant.PRIVATE_RSA);

            cipher.init(Cipher.ENCRYPT_MODE, pubKey);
            byte[]  cipherText = cipher.doFinal(data.getBytes());
            //加密后的东西
            String encodeValue = Base64.getEncoder().encodeToString(cipherText);
            System.out.println("cipher: " + encodeValue );
            //解密
            cipher.init(Cipher.DECRYPT_MODE, privKey);
            byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(encodeValue.getBytes()));
            System.out.println("plain : " + new String(plainText));

//           String encodeValue =  Base64.getEncoder().encodeToString(RSATools.publicEncrypt(data.getBytes(),pubKey));
//            RSATools.privateDecrypt();


        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

}
