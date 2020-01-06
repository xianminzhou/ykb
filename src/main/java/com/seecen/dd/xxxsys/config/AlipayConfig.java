package com.seecen.dd.xxxsys.config;

/**
 * @Classname AlipayController
 * @Description notify_url 和 return_url 需要外网可以访问，建议natapp 内网穿透
 */
public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016092700605500";//在后台获取（必须配置）

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQDI422iRmxcIzHkSrT6TBomi+ddPBR8apFBNyZovgnTPsrhGb6dJEfgjZJNaB0+tNFnHAiQ4ZPiy4CbsWFlGpgchUPE2eZJHOhJFJJm5FXI5UPQW9yuzxYyMVZFA5dobJAN18vjAU2Vkm1X2bdaJFKDfH61WAyuLzL9LbopYfRD87NlSkJmSbZfUukBqf0wOLqgBvzbJuojWMtwlgmhLi7g08jptTPtWKnBXoluWO32+YCFpM2DPEhswmormybxsC24IERqvfHX0zAMRJXYKRe8O7rEg2xZZhUJnBCFTrqGuZC0Ax9mOjLn8t6pmcSB2SMHBNJtg0SuRkwXrFfC5sg9AgMBAAECggEAMggCTAICBsh1Kog4noXJlYQOcTf/WiUoW/eiRz/dLpFa8cj5oiVhCVn47/JYJj/eTzG6KGsl67wHIb+BpC6FZ8UA5cvnAJqEd376H0oK22fOBdx7D8ZfnsyO0c1dLhKrpebyzmyKqA+5z8FXWsnlCv48iGmPbuouZsO2s4vDzBA6lLxA6AWmbZA29XTMBBzFpjoCmGY/fh2k6yfHdagt0VtG05ZpyHpMS2zau0el+2sJ4gcR9v0JbEMinSKMO8s5PAX2Rds+HwFC597oo9cVDBGvlwHc6uzJv/lQcRG5mdAercWQsGDzjlrzKPJKH7RTcu8jo5JOjmNCq+Xu4Ml2uQKBgQDxhdgKI2/AQLLWv6StUv4eTb5srpCG7GxpvlMPAZxTSie5ennnwq3byVOmZG1tEPhKFVhvpDYlkl6/u6gcGwITIB38J+fVd8koEczW4rNO0+9rFvxv026vnvhJpRvPHvxFtvC27XhjmIfU3agCmNy3mDX65FVHxleOKej/MmWLKwKBgQDU7g0HqqxQGO/9l1DrOBd7Pj6DJlT0QfqLR1idHz79aUu5YGf593jihQ7mTIqF5pWxEtYDPv8aZP+2GitL3E25HJXuHDql3DzRiTLCFX3tPuVFOJ/s+8Kvp4J89xBnSZk2ETz32+NH/xs2Z5K5kO1QL18I7jAOZhmzTtb4eIimNwKBgBuVmsgFphTCDurh9m/pQ6a4YGBPS6htRjCJkTjsiSsmFAVmDJhArtSkWM5vN+Q2BPWJHJGboqeF4RZq21diakk+6M3MzPifdrUB23BLcgk1wWlstaYb8s9SC691kQiF1HAt5a4uzwoo+JKCQlcRmFvLoZanD2pkJ8nP1ZGX8usDAoGAYOKgUyi5lwiByqWbUCwJoy5DS3GZnjqXQeCI1ZVuF+hdaFARf4+3FXrtuKSDM0IkQpoLfxafBOeH4tgtcysewmfbYKi/ltCLa9w9mEonLlg8Ai8ttasofrx9h1bzw8udRxi44R7QX+YX/71I6d6j3KRxXaLjgum6L/hjoFNX+ikCgYA1h9DECmRMcW5JK7BgczRMsKtwPXmiIXg01+VBILblaF3XqQvq48A7pmGG9uOcNaw3Bp5qQTdYFw76TVczo+xovqY+a9uFHk2/Kp6et1EKKYtwfgOfMkNG6jRCXD+bLVzDNEes4Fe96rBYhAe+yeP0K20h5UDKPr5eMmUCYqBMAA==";//教程查看获取方式（必须配置）

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.html 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA8jVCAWpHgm7rZNtEmn5QoykMmrYBYhrZWyVaB8Ioxh31ijMYcKZ+ozY+L7LofzDSam0Q21yOHrbPukVqMw/ELBNdzz0LeNfdU4QryQsZVVrLg06FIP887F+yACxUTknuU4zA5eWLOVKxp5n2inwSJNnSkwsxSKDLmYCmHTilEIYwYIGMbbhWdlVncL+xDMghhQXg/W64mCex6wPCcdTizZqJOFVO/JydRST4lZET4X1hvOIKaVssVuaQxbszjSAodNBdITHZ528F9k6+NXvqOrgzpDa25Orfbl+yxK9N9EuKgcDYOwpfUhKk9PdESku8zBXeigh5Qewj4h3XYZKWvQIDAQAB" ;

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:9091/alipay/alipayNotifyNotice";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:9091/alipay/alipayReturnNotice";
//    public static String return_url = "http://login.calidray.com/?#/sign";
    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";//注意：沙箱测试环境，正式环境为：https://openapi.alipay.com/gateway.do
}
