// <<<< lzr new >>>>

package com.dcorepay.entities;

/**
 * Created by liziran on 16/8/17.
 * 支付宝通道
 */
public class MchParentAli {
    private static final long serialVersionUID = 3414236822200268877L;

    private String name;    //通道名称
    private String aliAppid; //支付宝分配给银行的应用ID
    private String aliPid; //支付宝分配给银行的PID
    private String rsaPrivateKey; //银行用于支付宝支付的RSA私钥
    private String rsaPublicKey; //银行用于支付宝支付的RSA公钥
    private String aliRsaPublicKey; //支付宝分配给银行的RSA公钥
    private String status; //1 正常 9 停用
    private String remarks; //备注


    public MchParentAli(){
        this.name = "支付宝标准费率通道";
        this.aliAppid="2016102602341662";
        this.aliPid="2088521147287694";
        this.rsaPrivateKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAKaXOxyQdyHTPK50PaoWPtEBXJ2oOXoGBrQNrVGDHKF5tcy6QquB02SIXSuv3vg/YTpmU3hiI0ahhl4jZekdKt5tP2+jEnYcQCZaSFBENS/xeg8hXIJ7oTrWpAfIg5wmuTNAykE6kXpyhZMu6uE/d9rDLlI2wJKlgYU8SiOr2tfrAgMBAAECgYAW5dKKKpE1ZQOCNxgCuOwJblZ8lRLRYuKo/PhFq+/Tghcq/K8NQ9r6hoPH7XSISq3iiQ4QDe0rWChP6C2pzQiHMVedPFx7Tue8JF4vo5OumTTpf23qN2u2E1ZpVp4Wh8tVByfFIDsoOG7DhW37DKU7gRRFDNlRXb9KNGTVdwaUgQJBAM8f2Fw8DkHEr2CjFDLcHVh2xUIz9IFin7+DQLpYDyqRKcfapDPK4U6RNt9P6q6TJYxXE9hcdEid49WDfbqfz18CQQDN5ssAFO/xIZLSs6vgJSyau141y/mXZ5nA1WQDgDUPM363UmP18Y4gHk8BWmGTKK6rQI+6vjOIhbwf3neuC971AkAyiC1sC0bbKtYyuHa0Fdme/JMRnMVZT6tzuNzw2Y0RsIrF9IS9EhE37tu5TbEO2F1/yLrRvXStRsAQFl11S4n3AkAFBUGh6ODI4mawGI1yU7W4uCTd7vFRDcej+hAMPc4NZtYKJkolrxQmGFcY01lZuz43EsXuacDb7Vbe+A+3ALcZAkBVVOyN2XNoMxiQ+7vzKW6hmAIOYhWyvZtS3eA3wNSeM24+CaoRfJ9ZvW4gZF9WIavZif8uXw/dt/ydR+sVlFVZ";
        this.rsaPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCmlzsckHch0zyudD2qFj7RAVydqDl6Bga0Da1RgxyhebXMukKrgdNkiF0rr974P2E6ZlN4YiNGoYZeI2XpHSrebT9voxJ2HEAmWkhQRDUv8XoPIVyCe6E61qQHyIOcJrkzQMpBOpF6coWTLurhP3fawy5SNsCSpYGFPEojq9rX6wIDAQAB";
        this.aliRsaPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB";
        this.status = "1";
        this.remarks="";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAliAppid() {
        return aliAppid;
    }

    public void setAliAppid(String aliAppid) {
        this.aliAppid = aliAppid;
    }

    public String getAliPid() {
        return aliPid;
    }

    public void setAliPid(String aliPid) {
        this.aliPid = aliPid;
    }

    public String getRsaPrivateKey() {
        return rsaPrivateKey;
    }

    public void setRsaPrivateKey(String rsaPrivateKey) {
        this.rsaPrivateKey = rsaPrivateKey;
    }

    public String getRsaPublicKey() {
        return rsaPublicKey;
    }

    public void setRsaPublicKey(String rsaPublicKey) {
        this.rsaPublicKey = rsaPublicKey;
    }

    public String getAliRsaPublicKey() {
        return aliRsaPublicKey;
    }

    public void setAliRsaPublicKey(String aliRsaPublicKey) {
        this.aliRsaPublicKey = aliRsaPublicKey;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
