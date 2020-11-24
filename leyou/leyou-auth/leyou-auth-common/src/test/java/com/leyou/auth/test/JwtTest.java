package com.leyou.auth.test;

import com.leyou.auth.pojo.UserInfo;
import com.leyou.auth.utils.JwtUtils;
import com.leyou.auth.utils.RsaUtils;
import org.junit.Before;
import org.junit.Test;

import java.security.PrivateKey;
import java.security.PublicKey;

public class JwtTest {

    private static final String pubKeyPath = "C:\\tmp\\rsa\\rsa.pub";

    private static final String priKeyPath = "C:\\tmp\\rsa\\rsa.pri";

    private PublicKey publicKey;

    private PrivateKey privateKey;

    @Test
    public void testRsa() throws Exception {
        RsaUtils.generateKey(pubKeyPath, priKeyPath, "234");
    }

    @Before
    public void testGetRsa() throws Exception {
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
    }

    @Test
    public void testGenerateToken() throws Exception {
        // 生成token
        String token = JwtUtils.generateToken(new UserInfo(20L, "jack"), privateKey, 5);
        System.out.println("token = " + token);
    }

    @Test
    public void testParseToken() throws Exception {
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6MjAsInVzZXJuYW1lIjoiamFjayIsImV4cCI6MTYwMTI3MTg2MH0.cjJZRV6Du9tWU1exadvpNQiDvphyYkvpWA6WHFCMLZEhJ984cRCtTFwgE4yQJtGSjgwCAAedqyxOB4q1-HS7csLyiLHQo6gIpdEG0nDv5H0D5gucDfmxnuTPbJOXhAt3pqQqR6gyM46sB5Fu7w9AfKf526ufMsm9fwpWe7gdDRk";
        // 解析token
        UserInfo user = JwtUtils.getUserInfo(publicKey, token);
        System.out.println("id: " + user.getId());
        System.out.println("userName: " + user.getUsername());
    }
}
