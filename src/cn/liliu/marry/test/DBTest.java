package cn.liliu.marry.test;

import cn.liliu.marry.entity.Constant;
import cn.liliu.marry.utils.RSAUtils;
import org.junit.Test;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;


public class DBTest {
    @Test
    public void test01() {
        String data = "你好";
        PublicKey publicKey = RSAUtils.keyStrToPublicKey(Constant.PUBLIC_RSA);
        //公钥加密
        String encodeValue = RSAUtils.encryptDataByPublicKey(data.getBytes(), publicKey);
        System.out.println("encodeValue:"+encodeValue);

//        PrivateKey privateKey = RSAUtils.keyStrToPrivate(Constant.PRIVATE_RSA);
//        //私钥解密
//        String decodeValue = Base64.getEncoder().encodeToString(RSAUtils.decryptDataByPrivate(encodeValue,privateKey));
//        System.out.println("decodeValue:"+decodeValue);
    }

}
