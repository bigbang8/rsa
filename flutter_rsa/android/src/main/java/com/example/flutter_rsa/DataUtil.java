package com.example.flutter_rsa;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class DataUtil {



    public static Map getSignMap(TreeMap<String, String> paramsMap) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = sdf.format(date);
        paramsMap.put("timestamp", format);
        paramsMap.put("partnerId", Constant.pannerId);
        try {
            String linkString = android.src.main.java.com.example.flutter_rsa.RSAEncrypt.createLinkString(paramsMap);
            String sign = android.src.main.java.com.example.flutter_rsa.RSASignature.sign(linkString, android.src.main.java.com.example.flutter_rsa.RSAEncrypt.loadPrivateKeyByStr(Constant.privateKey),
                    "UTF-8");
            paramsMap.put("sign", sign);
            for (String name : paramsMap.keySet()) {
                String value = paramsMap.get(name);
                paramsMap.put(name, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paramsMap;


    }


}
