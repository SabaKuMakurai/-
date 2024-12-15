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
	public static String app_id = "9021000142669471";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCh5QuxNwkeqrLB63pnYzaa6VxK/FPkvkuiYUglqkYLgbfw949cGqIfs0cFJqbCqQJh/Yt3nAbnsWW2jrgeTYLCcboNpT4pV7whADpUISCcdUbc5EJfecci/ijsWCOTZEevMw7NrI0sp3OB9q6R0jiOdMfBRAwKi93C2ZzBMZQb02Kp8iGyPtQjakynbx5hBQZBkx4yprFyRreiaPA+AkvRxIgmRXSDv8PZHW0XCfZ34sp2MMgQE4DyPiLivl4c6HcJP7saKmEJ0w2KIRexMFzFRapTKHC9l1acZFDwrcqzs/x0GASQ2A2IHa6EezdMfVsgyz0BI+oSu6Cnx0z1+wFNAgMBAAECggEBAIfZG+uTw/pQwHlKsEarEPoCkah2fas3J15VhWXdsLMdIY15Hnnp+1rgY9rlqQ81JMO3Lt2qNn0a9b+vmL4MyomBRt8GZtfoP/vtJgTMW4IOQu0+OJfHJxus7AgOmaOnhSN1k5lwjnIG/Tz0E15XaY/YXHpHMFd1MBu94PSYNrD1XhrMSo3WJ6mV+Mr9xzFlMb1E4u6Dko0ixdYHc77+/AMwUGG9Ph8iamHAOVasDAzufwkYF4VlzCOibgUVAbnEXpDy8d4ZsfM0PHO/6zcD3x+pmsVEjr6JuvmlfU/ceG5+33ko8jiMBrTbyKeENWC5hzR89dHaL3cec8/ml4Xlj50CgYEA+lhaOazmoDFbJvHAhlos2RzHQRz7dsqsus3i6oeXNI9GTPKOku2ZBXvHHD3GPXBKAS+EXPQHq2RECC36+68zkrV03yDYNhllZlLRskxo4Us8NLND6W/yFUAEzuUZYTFRcF6PXs8fmmjGIzxGUfXgHC1OnFPxBuvi+ReblIncR28CgYEApY04HaznJotrc8f7vOnKODiGzI6aM0hFp7/HZT0S+BQtd3QFrxvuz0o3OBV2hoypURilxv2KJOsEPXt1VlvbvfxyGJCiNApaGAm9QLm3arOmc7UO3fCLkz9jVa9OfZitTxGumVuYTgazNe2/pbsYiGxPZsuiUNzUeq07HhyPBQMCgYEA1Db/TPLvkY4lSe8XGAzrBaTql5y84edO4w/SsqL8H1bw7huTlqOI2ughUiRfnwdIBJdGKhHHSpe1QAXSQ3YyTsQ5bUgHYFzI4yODlRRGt+yx/a6U/BakbTUWnlgA2q4W7h2KhYEothjpFUdsCOBX+SrC/6v8nrRpdGR5w0HWFEsCgYAbGOVRfiaLmZBp8BbVUhMGZsIxozm8IR09mtdhS8DaGDtk7PmtMs5A4a3uIR04YreoDXe8/WzqJAmaoqWPEBQEodhvCuVxzSv3+Ugf2wYZkfQxxjX7v86ouFxi/wHC7wWXBpbkhSiFxPT6Y8LVtq0KT2gjtDsKL0scFVSy1gvWzwKBgQDn9gc9tyiUDXi5yrsPPEIi4W/I9LgXCQgGdVboxc6KCOcPAUE5RATqkzX1JKu1P4kdR5fEcgYCN+YJ1e63KbO7Qpaf/7DpBDw9MRJRb4ehLF4DRC+yHMr2ahF0Q4FEWLLwnutayHcAqiR3GH7pdmf5mQjSPNugM+PeG824OwhNnw==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyZMv0uyP7k/LiXYRfNywz4ra3XeOdc3LO6Z5lBb9kywLqeThkcG9tYjRF1mgTfxO+yo1yfiM0mE8gGuRAXl5dT9tTWYWG49DwFfWCa102qCPr/X72z2FjTHLMk4tek6xhsMnAhrKpt7glPWtMcTaHCmn19pk/CwZbOjdQnArHR0RiVmq7eN9wwXRU9Cce/Z9hly3z8fenMlikJhYVuLbPTOxYw2rzZhPIUPhb86ybhtQDFzYBoIVnuCIi/Q8hDYStbHWRYbohn79mR9ubDlDXouTF6HFEgRMtYxMLg1SARvSF28s3BNUPfDvomKL2knhmYrfv9SsaRo/Kb6d741MNQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi-sandbox.dl.alipaydev.com/gateway.do";
	
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

