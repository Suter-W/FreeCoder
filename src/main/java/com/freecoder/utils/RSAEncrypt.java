package com.freecoder.utils;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RSAEncrypt {
//    private static Map<Integer, String> keyMap = new HashMap<Integer, String>();  //用于封装随机产生的公钥与私钥

    public static void main(String[] args) throws Exception {
        //生成公钥和私钥
        String[] keyMap = new String[2];
        String keyDir = "docs";

        genKeyPair(keyDir);

        keyMap[0] = loadKey(keyDir + "/id_rsa.pub");
        keyMap[1] = loadKey(keyDir + "/id_rsa");
        //加密字符串
        String message = "123456789";
        System.out.println("随机生成的公钥为:" + keyMap[0]);
        System.out.println("随机生成的私钥为:" + keyMap[1]);
        String messageEn = encrypt(message, keyMap[0]);
        System.out.println(message + "\t加密后的字符串为:" + messageEn);
        String messageDe = decrypt(messageEn, keyMap[1]);
        System.out.println("还原后的字符串为:" + messageDe);
    }

    /**
     * 随机生成密钥对
     *
     * @throws NoSuchAlgorithmException
     */
    public static String[] genKeyPair(String keyDir) throws NoSuchAlgorithmException {
        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        // 初始化密钥对生成器，密钥大小为96-1024位
        keyPairGen.initialize(1024, new SecureRandom());
        // 生成一个密钥对，保存在keyPair中
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();   // 得到私钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  // 得到公钥
        String publicKeyString = new String(Base64.encodeBase64(publicKey.getEncoded()));
        // 得到私钥字符串
        String privateKeyString = new String(Base64.encodeBase64((privateKey.getEncoded())));
        // 将公钥和私钥保存到Map
        String[] keyMap = new String[2];
        keyMap[0] = publicKeyString;  //0表示公钥
        keyMap[1] = privateKeyString;  //1表示私钥
        exportKey(keyMap[1], keyDir + "/id_rsa");
        exportKey(keyMap[0], keyDir + "/id_rsa.pub");
        return keyMap;
    }

    /**
     * RSA公钥加密
     *
     * @param str       加密字符串
     * @param publicKey 公钥
     * @return 密文
     * @throws Exception 加密过程中的异常信息
     */
    public static String encrypt(String str, String publicKey) throws Exception {
        //base64编码的公钥
        byte[] decoded = Base64.decodeBase64(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
        //RSA加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        String outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes("UTF-8")));
        return outStr;
    }

    /**
     * RSA私钥解密
     *
     * @param str        加密字符串
     * @param privateKey 私钥
     * @return 铭文
     * @throws Exception 解密过程中的异常信息
     */
    public static String decrypt(String str, String privateKey) throws Exception {
        //64位解码加密后的字符串
        byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
        //base64编码的私钥
        byte[] decoded = Base64.decodeBase64(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
        //RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        String outStr = new String(cipher.doFinal(inputByte));
        return outStr;
    }


    /**
     * @param keyFilePath 密钥文件路径
     * @return String 密钥
     * @throws Exception
     */
    public static String loadKey(String keyFilePath) {
        StringBuffer key = new StringBuffer();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(keyFilePath));
            String line;
            while ((line = reader.readLine()) != null) {
                key.append(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return key.toString();
    }

    /**
     * @param key         密钥
     * @param keyFilePath 密钥存储文件路径
     * @return
     */
    public static Boolean exportKey(String key, String keyFilePath) {
        Path filePath = Paths.get(keyFilePath);
        Path directoryPath = filePath.getParent();
        File directory = new File(directoryPath.toString());
        if (!directory.exists()) {
            if (!directory.mkdirs()) {
                return false;
            }
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(keyFilePath));
            writer.write(key);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

