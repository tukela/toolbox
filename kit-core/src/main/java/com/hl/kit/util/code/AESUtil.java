package com.hl.kit.util.code;


import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.impl.util.Base64;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * AES加解密工具类
 * 
 * @author caozj
 *
 */
public class AESUtil {

	private static final String AES = "AES";
	private static final String DEFAULT_CHARSET = "UTF-8";

	/**
	 * 加密字符串
	 * 
	 * @param source
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String source, String key) throws Exception {
		byte[] bt = encrypt(source.getBytes(DEFAULT_CHARSET), key.getBytes(DEFAULT_CHARSET));
		return new String(Base64.encode(bt), DEFAULT_CHARSET);
	}

	/**
	 * 解密字符串
	 * 
	 * @param source
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String source, String key) throws Exception {
		byte[] bt = decrypt(Base64.decode(source.getBytes(DEFAULT_CHARSET)), key.getBytes(DEFAULT_CHARSET));
		return new String(bt, DEFAULT_CHARSET);
	}

	/**
	 * 加密文件
	 * 
	 * @param sourceFile
	 * @param destFile
	 * @param key
	 * @throws Exception
	 */
	public static void encrypt(File sourceFile, File destFile, String key) throws Exception {
		byte[] content = FileUtils.readFileToByteArray(sourceFile);
		byte[] des = encrypt(content, key.getBytes(DEFAULT_CHARSET));
		FileUtils.writeByteArrayToFile(destFile, des);
	}

	/**
	 * 解密文件
	 * 
	 * @param sourceFile
	 * @param destFile
	 * @param key
	 * @throws Exception
	 */
	public static void decrypt(File sourceFile, File destFile, String key) throws Exception {
		byte[] content = FileUtils.readFileToByteArray(sourceFile);
		byte[] des = decrypt(content, key.getBytes(DEFAULT_CHARSET));
		FileUtils.writeByteArrayToFile(destFile, des);
	}

	/**
	 * 加密
	 * 
	 * @param content
	 *            需要加密的内容
	 * @param password
	 *            加密密码
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 * @throws NoSuchPaddingException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws UnsupportedEncodingException
	 */
	public static byte[] encrypt(byte[] content, byte[] password)
			throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
		KeyGenerator kgen = KeyGenerator.getInstance(AES);
		kgen.init(128, new SecureRandom(password));
		SecretKey secretKey = kgen.generateKey();
		byte[] enCodeFormat = secretKey.getEncoded();
		SecretKeySpec key = new SecretKeySpec(enCodeFormat, AES);
		Cipher cipher = Cipher.getInstance(AES);// 创建密码器
		cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
		return cipher.doFinal(content);
	}

	/**
	 * 解密
	 * 
	 * @param content
	 *            待解密内容
	 * @param password
	 *            解密密钥
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 * @throws NoSuchPaddingException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 */
	public static byte[] decrypt(byte[] content, byte[] password) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		KeyGenerator kgen = KeyGenerator.getInstance(AES);
		kgen.init(128, new SecureRandom(password));
		SecretKey secretKey = kgen.generateKey();
		byte[] enCodeFormat = secretKey.getEncoded();
		SecretKeySpec key = new SecretKeySpec(enCodeFormat, AES);
		Cipher cipher = Cipher.getInstance(AES);// 创建密码器
		cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
		return cipher.doFinal(content);
	}
}
