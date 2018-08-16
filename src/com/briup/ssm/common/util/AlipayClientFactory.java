package com.briup.ssm.common.util;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;

public class AlipayClientFactory {

	/**
	 * 支付宝网关 (固定)
	 */
	private static final String serverUrl = "https://openapi.alipaydev.com/gateway.do"; 
	/**
	 * APPID 即创建应用后生成
	 */
	private static final String appId = "2016080700191109"; //支付宝上
	/**
	 * 开发者私钥，由开发者自己生成
	 */
	private static final String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIMBJPDx0NL34JxOABDHovgct2LrsoTMM5VeCaNxDExjQWZZtLRatyx7JpXxVF7EElcmJzVMoSp0PFNmXQpQem9SGPFXQAVW7s5Vlk8tmDP3E+l2sTfisldUHtmc+V0M1UOfe+oI0SYQv2SBoVDhIsNEJ0hYrRpQ+OP5Th3yWOTvAgMBAAECgYByKEwdnksfnBtheWL7PEwaM0Pm8obky+Djd0ek4j0aT5/M5bzfMPHP1BziqqKf1fI5eSjPfFAw44syDdBjzY9yNQRYxVlIxWXcytFJtrMHqRokYn7CBFg9jtKDy1VZOomdXqdMbcB2/Z1Fjl7rz9gfumMcxivlGICN/ZEWooCFMQJBALkAYBntZiU9/flknroCjJKBz1cy0O4LoO1IuP/5EtrY2PZaJNHdbTFWkazJPBs4t7dHwNz0CIxi/Kbn/FkaU9cCQQC1R8nhF4NU0qld7/9/q8UKYWw2BwWzEsNMS1dzRqNbFW0A/3kjp5lOM50ZdBXxslYqkbkZvO/ON0N4pitok1SpAkEAlL9ehbpBhPRBPsLOdNUT3cCNy5jKMHwdGmx8gyPrKxdr6zgznqIg56ipXHo439JMtQr2YTG9pdL5PeINHj9y5QJAemeK7S5PQ4srSX6waqi1V5kI1EJRmuTkcjO9TN05mFsTS0U1qtmULrWzMmisGJNukzfqYHKvCfNO37x0OxygYQJANKL2lmwr8+crl2yMMXgaJ6WvQNhKKEUylAqVQI3UOygjfciiRqjrFnGCOngf0h3aH+2Nf3KW6EdzYZDeeELNiQ==";
	/**
	 * 	参数返回格式，只支持json json（固定）
	 */
	private static final String format = "json";
	/**
	 * 编码集，支持GBK/UTF-8
	 */
	public static final String charset = "utf-8";
	/**
	 * 支付宝公钥，由支付宝生成
	 */
	public static final String alipayPulicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDIgHnOn7LLILlKETd6BFRJ0GqgS2Y3mn1wMQmyh9zEyWlz5p1zrahRahbXAfCfSqshSNfqOmAQzSHRVjCqjsAw1jyqrXaPdKBmr90DIpIxmIyKXv4GGAkPyJ/6FTFY99uhpiq0qadD/uSzQsefWo0aTvP/65zi3eof7TcZ32oWpwIDAQAB";
	/**
	 * 生成签名字符串所使用的签名算法类型，目前支持RSA2和RSA，推荐使用RSA2
	 */
	public static final String signType = "RSA";
	
	/**
	 * alipayClient只需要初始化一次，后续调用不同的API都可以使用同一个alipayClient对象。 
	 * @return
	 */
	public static AlipayClient getAlipayClient() {
		return AlipatClientSingletonFactory.alipayClient;
	}
	
	private static class AlipatClientSingletonFactory{
		public static final AlipayClient alipayClient = new DefaultAlipayClient(serverUrl, appId, privateKey, format,
				charset, alipayPulicKey, signType);
	}
			
}
