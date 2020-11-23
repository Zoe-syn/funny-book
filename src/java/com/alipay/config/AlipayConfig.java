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
	public static String app_id = "2016110200787304";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCs1GYx5BrfhJGyttRlLWz8nsvwv8ubcoEtmwiN8ojv6DOWFWUuJuJiedO6zQ/gO26xp6G99eFK5k6VDd54MFr4lg9yRK6KhxytTEXNxIHbuCZuFGiji26hD5r0+cX8vYbUclOKBNkbHWI1X5m6wOHmSDQQ6109IPMY0ioiVhxwSSEdSIB5Zbs7Q+MW2z72jQskji+B0df4a6YnO4AcPnqlM0RP7SYSkrT4cCozm7cq5+VvyL8EwLDScDPSicboHcO5UkYpcct2WvfZyCoxoNZjG5AdlWymM0Sro/UAXZM7fp59Y6yRkyo+VBWfrPiOBsMcNim3ajCeLrjavcigxCuvAgMBAAECggEACfJ/n0d9tHew2xRizR/8Md4B5u1jDqNcg/90UpcvAn/e2DiLBkj+pqRUZ1/+Fe3VxSvcx04rlWAEDdgqgchmtAAPC4igcyCrqd3F9r3kq3zB2XwbOa6Aw4xeYtMtbgqKhBfAbyUwSbs7N880zebkGZj2RjMFvsrysu8Ftcw2/s9eXlt446UtwXN43FeYrgjCXmtkZO9ky62tnWMH37LUq7zfYs5AZ0DsfIKy5SeltX2dFmAGYM/OvGwC1fC7bCwjNL3CdZKu28/1Nlv6VKXPst9ISkabnjBjsrxvOSZ3M7H8AEhlMPdFEOMst3eWXhO5qu7gGQKK0x5S8XtOUhxuIQKBgQDosc+jsvdX/C6yxD4aybHblE7Lv8v5fz7g8cSbN2dFvXXd9Zpz1xz24Hji37d1HeictJz50sS8KJUFP2JVFq39XgCrD3yqfQaWWXVxDcMsF2pNyLxccvLwYNxKsebYNnXhtgRNZLPoGjBx6DpuUTeKRdelcy9aO6T5E6eUc3zYjQKBgQC+I62UWfkEDVHXkDUY7yJI3cUJEDjJ53817xvdYP4Am59TXxkyiY3r4Bj7Uy0XFKT60aC5dw/N07+KvlkIJ0CUngktMyCJDPTAoaI34EJbyxU36OBDuebi4BTnAlYhN/2gqcFGG3dq2gKuqvBhIcqf0Syhl++mfiaFbIiB/mX8KwKBgAHQeRz+pT0TY03Th+RvlCpxIpgmG7ILUvMwD2dibDS4AHZFlvm2QKyQHYEvW1/XZtvp8JtmEFCjRF4xG1QshBjIpdqvmTo/FVEQy4ChKddrK1IF8aoK32gOaUlPz8v5yLuEzs3HrjtuENiiheocSgGS/9ZzangapPOoOpNGvz91AoGAOgZpUnyiobnu3/oCOjnAHLyRBNMOgY9EIxF1T3nqCgVz+d1rsyCHTxR0iz425HRIZMLUacUL7aRRL+YnBXX1H2WbJ1AS/cAWcTLibmrh1WGEeCt5RTHWZCY+OsFbx4duvzkO4nY/Wzxs1SEVeo71ZxBOroHPgN++obkdb45TUUECgYAAzaFWLOm3cuz6Y5iERhvbV5crXf6yIt30WKL3NDo6aEn3vAiWXMZliCfa7iNvgftyNLXiV/3NTFUNwppNVDhuAJXrqjMqg8CS0GqfhBhwCCkwRvIQ8d5foBXcOb5seHUV/Onbmryq0pZMowVnGKS1Xp/If1gGBCMY3ou76PTnwg==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArNRmMeQa34SRsrbUZS1s/J7L8L/Lm3KBLZsIjfKI7+gzlhVlLibiYnnTus0P4DtusaehvfXhSuZOlQ3eeDBa+JYPckSuioccrUxFzcSB27gmbhRoo4tuoQ+a9PnF/L2G1HJTigTZGx1iNV+ZusDh5kg0EOtdPSDzGNIqIlYccEkhHUiAeWW7O0PjFts+9o0LJI4vgdHX+GumJzuAHD56pTNET+0mEpK0+HAqM5u3Kuflb8i/BMCw0nAz0onG6B3DuVJGKXHLdlr32cgqMaDWYxuQHZVspjNEq6P1AF2TO36efWOskZMqPlQVn6z4jgbDHDYpt2owni642r3IoMQrrwIDAQAB";

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

