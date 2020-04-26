package org.study.asdl.utils.alipay;


import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;

/**
 * 配置公共参数
 * @author Niu Li
 * @date 2016/10/29
 */
public final class AliPayConfig {
    /**
     * 应用号
     */
    public static String APP_ID = "2016073000129148";
    /**
     * 商户的私钥
     */
    public static String APP_PRIVATE_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALvK+SgVaWgLqnmsfk8TSAHLh473aDWLaJhwDg4zWndHArZcNZ9VzbbpP6F7KKvoM1o1V2N/SN81ZAMjZ0mfn2TtihQyvy3hIG8DC1tNPSEPaYvrpKREzAGOU60Q5VZ0Q4nzlXeIaXwI8gRfghG3Wdxn2U+/rMluDHkZ6zJc2+r1AgMBAAECgYEAjZcjNvK178nj9it1bJ+oChpwEf4+Zyi+azkJj/FuQ0KaK+7oS0OBgGjrHhDjAIJpvZk8U3uT8R+rUaZu6RbeMQr7nwFl7MFJua5RyZDn1RsKzvEKeh4f2Cu7w3ofIf781WEq5bzep5L4dhMDH1yP4iJmESWUPwplpOulVvK27z0CQQDj0sI0KXdAQ50WgQFIoHjY+/VJFwsJhl+p8f8WsDPFqhUIsPADn1aMlY4MSXiKVaGTd/i+f8ROPJ+xkN7/niiTAkEA0wTKCLa0PnyTdriOB6apQ9TQ/2rNpzWfQy+PKZVBMkqqM8pl1Y5/UBXveJLkmZL/0uHGWkiyrF6IW3ol+tz7VwJACihZdE3s/TaGiHxT/FL7UGFbfFjEqzYMid06TF6q0ENXEL4i1WaDS11XqgCUmUZcH+EXfBbiP8LANACLkMYSdQJAD8LY0EPNPKmTXhe0zA9/rwhTP/CbQbT4m00PFV0HjJkVE183sfa9vZ6Vz1yxZGMdZoPki9PIPKWm66Y49f7RawJAIKXGne7TuPS63RR7qA1k7/hK12CQUk7EQRkuwPHy1OS9Q/lzsJb3+ZVmGTOa4kF/5EgxtlDXmnsxgZZdNELt1Q==";
	/**
     * 编码
     */
    public static String CHARSET = "UTF-8";
    /**
     * 支付宝公钥
     */
    public static String ALIPAY_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC7yvkoFWloC6p5rH5PE0gBy4eO92g1i2iYcA4OM1p3RwK2XDWfVc226T+heyir6DNaNVdjf0jfNWQDI2dJn59k7YoUMr8t4SBvAwtbTT0hD2mL66SkRMwBjlOtEOVWdEOJ85V3iGl8CPIEX4IRt1ncZ9lPv6zJbgx5GesyXNvq9QIDAQAB";
    //public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoQjoEpF0v7/pL4rjXg/1HREwEd4WRDDj7Y1Oj5RU3QT+p2X+eeEums04quiJwrswh3IKe3CeY3qxeLdYGoM2NUTUTVNRm0/xW6bTcAaSgQOahSFC7O7esOWl3jZSGHe0wW+tz/98wwDmJtdhS8BmbgqlBPKXuGh2TB7YuYa0I6jAmOz0MQXfFd3UdkFBePLpG/MC5SnD5epeh3jOwDdI9Z/VwPPSHfbG1QbV46upLFC6/mdPOev2b4T6Qc8iAN7LoLdsjokTx/xHJTlRaMqqnisNXCgkOql7pnGy3kYstVflNIfJkQtjWnRqldH2JZXYCfpNTrk9cKpVyhTygB8f4QIDAQAB";
    /**
     * 支付宝网关地址
     */
    public static String GATEWAY = "https://openapi.alipaydev.com/gateway.do";
    //public static String GATEWAY = "https://openapi.alipay.com/gateway.do";
    /**
     * 成功付款回调
     */
    public static String PAY_NOTIFY = "http://商户网关地址/alipay.trade.wap.pay-JAVA-UTF-8/notify_url.jsp";
    //public static String PAY_NOTIFY = "http://localhost:8080/heat/payment/aliPayNotify";
    /**
     * 支付成功回调
     */
    public static String REFUND_NOTIFY = "http://niuli.tunnel.qydev.com/notify/alipay_pay";
    /**
     * 前台通知地址
     * 前台根据返回的参数获取订单详情
     */
    public static String RETURN_URL = "http://商户网关地址/alipay.trade.wap.pay-JAVA-UTF-8/return_url.jsp";
    //public static String RETURN_URL = "http://localhost:8080/heat/wx/html/payment_list.html";
    /**
     * 参数类型
     */
    public static String PARAM_TYPE = "json";
    /**
     * 成功标识
     */
    public static final String SUCCESS_REQUEST = "TRADE_SUCCESS";
    /**
     * 交易关闭回调(当该笔订单全部退款完毕,则交易关闭)
     */
    public static final String TRADE_CLOSED = "TRADE_CLOSED";
    /**
     * 收款方账号
     */
    public static final String SELLER_ID = "yjeslc3497@sandbox.com";
    //public static final String SELLER_ID = "1554816903@qq.com";
    
    /**
     * 加密方式
     */
    public static final String SIGN_TYPE = "RSA";
    //public static final String SIGN_TYPE = "RSA2";
    
    /**
     * 支付宝请求客户端入口
     */
    private volatile static AlipayClient alipayClient = null;

    /**
     * 不可实例化
     */
    private AliPayConfig(){};

    /**
     * 双重锁单例
     * @return 支付宝请求客户端实例
     */
    public static AlipayClient getInstance(){
        if (alipayClient == null){
            synchronized (AliPayConfig.class){
                if (alipayClient == null){
                    alipayClient = new DefaultAlipayClient(GATEWAY,APP_ID,APP_PRIVATE_KEY,PARAM_TYPE,CHARSET,ALIPAY_PUBLIC_KEY,SIGN_TYPE);
                }
            }
        }
        return alipayClient;
    }

}
