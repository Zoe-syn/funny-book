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
	public static String app_id = "2016101500690722";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCykIaeBkn48nXbylxEJG7FmAPlvondJ5VW9pL9Uk68S9aXKbFd5XB8857fKGxIBoHtuIN2PC09kNzt8JStRyFNfkrc1QkGbtLnULsF7N/ydZSMKewWa8YJPe0B6aIVx1cn/mzbPjDS0Eylb7/oAXOc5S/gYaIH+hls2OLLLHelQnNse/yzh5UzrNXNzsuZD9FEShd11kmXH/c02LCQJ7DyciLvXld/WJRvxnF2WrqJZtldNQ2faceQa9KODKdJ5rW9+xGxb5m9UaUlDKWbo6EV05oGf19KYSYEiToObCzCZLYHjbAR2MecEyXNAyDNG6d4frC3d8A1ZSqI1eAvaPTlAgMBAAECggEAUf1iknS4yoIp8727F97Srg/a2kbe7pkaTU/ytjZwyKzZ35bZRg/v0q/aJwVcksXKKukqE8QV0csOZoKtAdNDS13N6hA3kKiaVnQPK+1T9vRePO2S5cieqeexR8uLDQz2y/pa6WBo8qOKTfw91b205Dmn/hNWXutLeVss57WHSm2tKlsNiCy85q8ZWzCKMnes07R1y2EekmY3qEl5Na6erw16cazqZvhmWdLnxA8Vp5oWemJMmbVRsUeqpc7nY2+bxppeVXXeNpzHhRatZg1D3m3zooVK6iWHJNKgVFdYytSPcAzXsQxQ1VSKCJCKK1u4z/+NSDEDCXk/NJUbcfFCgQKBgQD/t5GSiijcvPxHGVKwykc64CFGC5AlaDFh3TPwDwtaMu/+evo7UcVS5rvuhy5XvzgMmKJwSEFWGBux6fnGmUWxcWadw1lgop+3lOCNjX8C23uN/XS2r9a3rN+mi78ARNwes90JYxjMmyVv3lQKcMcxeKDxTcOe4Gs/3x9xl6YbPQKBgQCywxqZxlOMxnzVQvtlNBsdHgPIIGgEgaZShazWj/LjcZSkNOX/fhkUqoyFzTAuvJLLGK+MQgJ41QfIUrs1eGM6FIQTspGDSIpm9nHVC8W6nFT3gwcSx2Md2AnnBr7kq7MKPNH3uTsU0U9ygvXYKBRQmqB8El2ilj3MdrNVyzT6yQKBgQCNK3Y+A+/TDLHpPl2cI892/UzhMnj9bav1bvzBRkzqGrzLLHEAVoAs6BxP7mjzICl9KrZibkFDmkOP0K+HqA4Fi6ku5y1sX9r0qkfdXYQEu85V8NqCEEjlVZaShwuGxn0OphUcnYyPSAc+3upeaSxOb13KWTfpedM7i538Q8/7sQKBgAMKlLpHCIbdnaQXNqW7JDbzmsbd3kctWYIP6ifgXRaHiSreB4e4Qn76g9eG7SnuZWT1L49oVBhwL2i2F59KRA3p6XFYWWdtZYVo7fjc8WlCXaO0Y/tqzwHj+g8nKzpCvZIQBNZ9HUc2ZG6jUcFytR3F87MIsPUiLzz6TATKp0UZAoGAMcN1ziQg32Htze2SBhIXyLHSd4Rwbo9tKcO9jZHghQg66ZjSKY3qftPcaODcBpThE6KrL2R0TYzh/EDerb7+SYC0wmO8HtTE4E5kvtL3khkDaaocFui8CI2OFScWhj7zAHRI0QG7h3XIonNTlSaQIiE4J3wi8KlBtKshHWqIJ8c=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmnaD3NaP1ffeQ5wXa83LsVTetRFEal4W/DW0d6Szw+eWe+OOiWB699JrZDGgd+d+4SCwfRM0SHQhMhX0lr/juDaV2B/olksDfGk3y0X9J1+rHdDPjN8uA87CKoo4R9zjmzXnmjH0siNWLP1fSdhjLVSBeeiDhkK5rtXZzHDe2bbj82z0wT09c+gAbmpduR6zy1KIAw3iL+NFwBVE79mFrAWRIc5s+ineuSh/tkcS8aMUy4qzOdnQYwPuHhN/r0vXYxv20Lpc+520uANnqKh/kvRm/7mn73cJrd1mwDq9zuFPO53uxuNC3Rtlm0ge4h/sR2BAeuN0ceFJXsSrAsM/rwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

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

