package com.briup.ssm.common.util;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓


	//沙箱APPID
	public static final  String app_id = "2016091900544477";
	//沙箱私钥
	public static final  String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCCsazegYDMsCJJJefWQxaQ7ChDVFE7Ho9a3VD/kesXIjzm5hK9zHnJhmCNDwDPw9wMp/m738aB9QIRg76NQUduEdaopj/eR6FUW9OY+u3QJ87IoOvtEseLRud9NP2S2h/e0Cq/kFcZXKCIzWFmbyWlc4mY9S/diAeLbHNYh+zwMWVyzlpc8ep+sIpbmTS4+8ALJZtKlllbM/HAS3UNDdxoOugNckR4vOx8FcEILsNlDNlFOZAhZyVE/HnKMDM0ooQM2jxCwKjdhQJsvEEQYylVqYzn9172Fq8iiuWkPVdtzC8zYRCYgrXvdCuBd2zPm8NdAWiyaOd7YBOluA7F2btbAgMBAAECggEATq7phIwzHwhrm95WVYjObTHAi8iXnyAm7m2P9k3DW4ohYGHjpqEUMV/VgRcnRe6E7Jm0oId424TGWgUXE7PZbUsQETkF+qzlVAR0wAVSZ5+PvvojD/featulQpxEjcUEqwBovCwKRBqgC7yahzEjWRjWHmB/EMB0ylvglcw/udsgl8uFWJACLk9UzX3wmguCjIiOtU94sXp30hE8pag6LaG+Vrw4AvswQ3mc7yFFODaAFLoC+LCGtQ0PgeoC/pXHxZcmkc/zbYJCVqgkDrUMl05WYIzye2tGY1Az7BMM1kIukE/DjL2Ko5XH3asVdbp2HU8iUxOGIVP90xqXOZkwAQKBgQDpGli7QzyH27hnZdgkaxrVCYbkLbQbgoi7qTIoKq4FNjDVXop7RLH35CYCFl1MGQSoiKyCy9yvoV8uwuPCrbj60zNzlwm0b/DnhY0SKS4jsr9Da8WLZMhfOS9kDRj/bJF5+ub1x/w2JZtrtZ4HS6f8kvM9VTOJtj0VdWIq+LMSGwKBgQCPiCJiCFZT5/6NfdVsVWDWFoSV6Ci+JtGPs8vC36TF0iTHXVg46PdQXzDv4xauJuUm58Zo+4NnfAmkn/GtGOsn4TX3Hsy4ph58vWJK/eIAx+e08AbutkcImhszIf85oZ//OOcvmX9+815icnK00onPxT72nQPJzoSU4Kg/2vSPwQKBgBS/NJCOPm/1HWeOh/tN0RiO/YOHkdU0/Ah/2af7jHuIRDZpcLfh+FkQ5FUhOnKQc3qwl3IYxO6Y1UjrLaxhG+qvK5ApLEL0B6QDnfe01Jd2zFEq4W0zriXTiCVGiSgKuLP7odzUTN1g4YFnq8YIdM4lIiMeVzT1lGA5j2A1vHJrAoGBAIn0sA+Hsen97zXx/4Ob4HKFvDQVq6twxjWX+743lTkqTX1t49D3YlZW2EOKAo+rBM/LMHJRZLC/kMkxjmnwrH1tQqBecyj7SgxdPy+TLHnRqozHs/IXMtk6ve/8ukKbbZwzBkpDAD92DX8UP9o7DoisLmN88Voz7EzoTe7qNexBAoGBAKdExX4BcwjwPu2pBYb6e8FzXLjRhtj6wNUvXduG17ZISNF6AUuOvZcX05bHLIDn+OYxP/7SLmNfc+l9pfhnx/4M+NlDUX2s1z6FBJ1tS0mX2fhVQR6fx4+W0fz8cotAaAhwGSc2T3mPYjX9O0OSR+122zM4hjqS0QzzqSimIayz";
	//支付宝公钥
	public static final  String alipay_public_key ="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgrGs3oGAzLAiSSXn1kMWkOwoQ1RROx6PWt1Q/5HrFyI85uYSvcx5yYZgjQ8Az8PcDKf5u9/GgfUCEYO+jUFHbhHWqKY/3kehVFvTmPrt0CfOyKDr7RLHi0bnfTT9ktof3tAqv5BXGVygiM1hZm8lpXOJmPUv3YgHi2xzWIfs8DFlcs5aXPHqfrCKW5k0uPvACyWbSpZZWzPxwEt1DQ3caDroDXJEeLzsfBXBCC7DZQzZRTmQIWclRPx5yjAzNKKEDNo8QsCo3YUCbLxBEGMpVamM5/de9havIorlpD1XbcwvM2EQmIK173QrgXdsz5vDXQFosmjne2ATpbgOxdm7WwIDAQAB";
	//沙箱网关地址
	public static final  String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

//	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

//	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问http://localhost:8888/ssm/index
	public static String return_url = "http://localhost:8888/ssm/index";//http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";

	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

