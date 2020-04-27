package com.alipay.config;

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

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016101100659429";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCYxIouH2D1yXCwtG9Wj3Koh+N4NQjhgSbbE4B7CN1W3Clgayyz/mByr11pYyakUzsvR5IVD+zU6t8PZgcenfJwIeu8xFd742E9X1NoJeE2Dbq0FKoJcUq4WCR5yRDcb+OzkslgUt12pB7P5AsQ4HUS/eohqN4/7ImxVTEXCXy2wxiSDEIpu4LYXUIsaJxa0BGEoOoIXKTheq9kCLNtfeZilOs7BQgscoVFEn4TieD5jxgBkeMMWBq8D3wCmaRmAqTYR+H7i/Hhw+veKSkMCG7fr8xnbXQ9XjecbeL70JWa3/Q/+BGmwGivbqHlGrQHW3OOucWO5ue2KeRXXhNFAfWNAgMBAAECggEAVy15ST7A3yIYO86L5tKvdLsvNM7XBZDlMombfRqe7M1wk0Q123VjZq7qWJSrXYTdtmpaU8iltw9dQXVQxMkPq6u/0hYdcmZcfGBkwX80WNtW2yMbsY3EPRSXpCP4ikMTpssyPdSr6uNXbf1Nz1C3nqHltVWfls0N+nOKMwJH+CbT7X9YlUAtnK57OuSvO4JT0v7TheVZmJ+/5TZowV4YgdGz8HD83GLwZz1/SHc8AxPRGJOADuAnTxmR3dREL/g0fbl5wob7h1YG156slAwjQ4H84X6dfO5XapjTNLdCE3e49EOlD6SsYy2oFzSAZnLlczHEyahfXhDRl4EQifBqAQKBgQDf/9CEM9xva6VVKHSVmQdnlX+UMDHCHUYYD4JrRwsY2pH3hDZZWxX9J0NAWDfklF79E4/WtqLLkyel1vH22RymlF+MRyVuAwJvl0lljHVwZCLAjGGnKLNQ8Erfvg5BBIzJftjF/XRozrez81SIcYXNGLztlndt2CYmsuWpw5o4gQKBgQCul55b33SPZ3X1zw/Lzjzz9jCd7NxzhR5cjTFsXoEHIGcR9GuuGnYwR2MqxWLH0N6QrS5IoziCDuijQQEDZKkDjpg+Z2iTOnZyvnmbInnUT/dqovCzknfSDi1yKZVaSMHue7x2twzttH6x8rNznBwIQ1pazgkpgLNt9pfpulmXDQKBgDEjpHGsEtqaic2Rr2m2BWrS4Ab5P6Eu3NagaGLyVdvg7w6WgXm+wqcjetxdvf02E1R/exmGPVZddOArtC8L1/4vJHrYjLyCioFCdgaB9q1uOjV1VmLeSeAiprpIrkXTIrN9UT616FipqKEga1X3WXvxxlh0nsSJG21352wDjgyBAoGAGi/3usQLka7tDI+gSOuITPdyV129uz4OTceH0D9kjxMXIqRMunKRo7AxeardpCb6Gy0+sfp5cViXIFWRt1aT20q6HzIXh23PcmqLhu9m4qeT7tS90dF4U3N48ZS3KDGdlQ3OOOg/8i+OiVZkAEU8FykzFketLCJ3x1ijdJVU9skCgYEAw19dF+VoEXStdvGixckzf9srCMveojSVoOTMuoZd2NR9zrYIIzWuRC7JsJ0qM9HXxt0Mrdzm7ZZ3fWK0glXuJBqksMcoeyQ1cxBOYVsYeLCB45cB5h+zyf6Bd7jgkOJhs2r47XT67miJUIF3U7bbqzXMjQvV3ORGn5naGH5WnnM=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCYxIouH2D1yXCwtG9Wj3Koh+N4NQjhgSbbE4B7CN1W3Clgayyz/mByr11pYyakUzsvR5IVD+zU6t8PZgcenfJwIeu8xFd742E9X1NoJeE2Dbq0FKoJcUq4WCR5yRDcb+OzkslgUt12pB7P5AsQ4HUS/eohqN4/7ImxVTEXCXy2wxiSDEIpu4LYXUIsaJxa0BGEoOoIXKTheq9kCLNtfeZilOs7BQgscoVFEn4TieD5jxgBkeMMWBq8D3wCmaRmAqTYR+H7i/Hhw+veKSkMCG7fr8xnbXQ9XjecbeL70JWa3/Q/+BGmwGivbqHlGrQHW3OOucWO5ue2KeRXXhNFAfWNAgMBAAECggEAVy15ST7A3yIYO86L5tKvdLsvNM7XBZDlMombfRqe7M1wk0Q123VjZq7qWJSrXYTdtmpaU8iltw9dQXVQxMkPq6u/0hYdcmZcfGBkwX80WNtW2yMbsY3EPRSXpCP4ikMTpssyPdSr6uNXbf1Nz1C3nqHltVWfls0N+nOKMwJH+CbT7X9YlUAtnK57OuSvO4JT0v7TheVZmJ+/5TZowV4YgdGz8HD83GLwZz1/SHc8AxPRGJOADuAnTxmR3dREL/g0fbl5wob7h1YG156slAwjQ4H84X6dfO5XapjTNLdCE3e49EOlD6SsYy2oFzSAZnLlczHEyahfXhDRl4EQifBqAQKBgQDf/9CEM9xva6VVKHSVmQdnlX+UMDHCHUYYD4JrRwsY2pH3hDZZWxX9J0NAWDfklF79E4/WtqLLkyel1vH22RymlF+MRyVuAwJvl0lljHVwZCLAjGGnKLNQ8Erfvg5BBIzJftjF/XRozrez81SIcYXNGLztlndt2CYmsuWpw5o4gQKBgQCul55b33SPZ3X1zw/Lzjzz9jCd7NxzhR5cjTFsXoEHIGcR9GuuGnYwR2MqxWLH0N6QrS5IoziCDuijQQEDZKkDjpg+Z2iTOnZyvnmbInnUT/dqovCzknfSDi1yKZVaSMHue7x2twzttH6x8rNznBwIQ1pazgkpgLNt9pfpulmXDQKBgDEjpHGsEtqaic2Rr2m2BWrS4Ab5P6Eu3NagaGLyVdvg7w6WgXm+wqcjetxdvf02E1R/exmGPVZddOArtC8L1/4vJHrYjLyCioFCdgaB9q1uOjV1VmLeSeAiprpIrkXTIrN9UT616FipqKEga1X3WXvxxlh0nsSJG21352wDjgyBAoGAGi/3usQLka7tDI+gSOuITPdyV129uz4OTceH0D9kjxMXIqRMunKRo7AxeardpCb6Gy0+sfp5cViXIFWRt1aT20q6HzIXh23PcmqLhu9m4qeT7tS90dF4U3N48ZS3KDGdlQ3OOOg/8i+OiVZkAEU8FykzFketLCJ3x1ijdJVU9skCgYEAw19dF+VoEXStdvGixckzf9srCMveojSVoOTMuoZd2NR9zrYIIzWuRC7JsJ0qM9HXxt0Mrdzm7ZZ3fWK0glXuJBqksMcoeyQ1cxBOYVsYeLCB45cB5h+zyf6Bd7jgkOJhs2r47XT67miJUIF3U7bbqzXMjQvV3ORGn5naGH5WnnM=";
	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/test5/returnxxx";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
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

