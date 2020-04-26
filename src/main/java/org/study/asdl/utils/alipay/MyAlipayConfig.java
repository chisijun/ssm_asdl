/**  
 * @Title: MyAlipayConfig.java
 * @Package org.study.heat.utils.alipay
 * @Description: TODO
 * @author chisj chisj@foxmail.com
 * @date 2019年6月17日
 */
package org.study.asdl.utils.alipay;

/**
 * ClassName: MyAlipayConfig 
 * @Description: TODO
 * @author chisj chisj@foxmail.com
 * @date 2019年6月17日
 */
public class MyAlipayConfig {

	// 商户appid
		public static String APPID = "2016073000129148";
		// 私钥 pkcs8格式的
		public static String RSA_PRIVATE_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALvK+SgVaWgLqnmsfk8TSAHLh473aDWLaJhwDg4zWndHArZcNZ9VzbbpP6F7KKvoM1o1V2N/SN81ZAMjZ0mfn2TtihQyvy3hIG8DC1tNPSEPaYvrpKREzAGOU60Q5VZ0Q4nzlXeIaXwI8gRfghG3Wdxn2U+/rMluDHkZ6zJc2+r1AgMBAAECgYEAjZcjNvK178nj9it1bJ+oChpwEf4+Zyi+azkJj/FuQ0KaK+7oS0OBgGjrHhDjAIJpvZk8U3uT8R+rUaZu6RbeMQr7nwFl7MFJua5RyZDn1RsKzvEKeh4f2Cu7w3ofIf781WEq5bzep5L4dhMDH1yP4iJmESWUPwplpOulVvK27z0CQQDj0sI0KXdAQ50WgQFIoHjY+/VJFwsJhl+p8f8WsDPFqhUIsPADn1aMlY4MSXiKVaGTd/i+f8ROPJ+xkN7/niiTAkEA0wTKCLa0PnyTdriOB6apQ9TQ/2rNpzWfQy+PKZVBMkqqM8pl1Y5/UBXveJLkmZL/0uHGWkiyrF6IW3ol+tz7VwJACihZdE3s/TaGiHxT/FL7UGFbfFjEqzYMid06TF6q0ENXEL4i1WaDS11XqgCUmUZcH+EXfBbiP8LANACLkMYSdQJAD8LY0EPNPKmTXhe0zA9/rwhTP/CbQbT4m00PFV0HjJkVE183sfa9vZ6Vz1yxZGMdZoPki9PIPKWm66Y49f7RawJAIKXGne7TuPS63RR7qA1k7/hK12CQUk7EQRkuwPHy1OS9Q/lzsJb3+ZVmGTOa4kF/5EgxtlDXmnsxgZZdNELt1Q==";
		// 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
		//public static String notify_url = "http://商户网关地址/alipay.trade.wap.pay-JAVA-UTF-8/notify_url.jsp";
		public static String notify_url = "http://localhost:8080/heat/payment/aliPayNotify";
		// 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
		//public static String return_url = "http://商户网关地址/alipay.trade.wap.pay-JAVA-UTF-8/return_url.jsp";
		public static String return_url = "http://localhost:8080/heat/wx/html/payment_list.html";
		
		// 请求网关地址
		//public static String URL = "https://openapi.alipay.com/gateway.do";
		public static String URL = "https://openapi.alipaydev.com/gateway.do";
		// 编码
		public static String CHARSET = "UTF-8";
		// 返回格式
		public static String FORMAT = "json";
		// 支付宝公钥
		public static String ALIPAY_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC7yvkoFWloC6p5rH5PE0gBy4eO92g1i2iYcA4OM1p3RwK2XDWfVc226T+heyir6DNaNVdjf0jfNWQDI2dJn59k7YoUMr8t4SBvAwtbTT0hD2mL66SkRMwBjlOtEOVWdEOJ85V3iGl8CPIEX4IRt1ncZ9lPv6zJbgx5GesyXNvq9QIDAQAB";
		// 日志记录目录
		public static String log_path = "/log";
		// RSA2
		public static String SIGNTYPE = "RSA";
	
}
