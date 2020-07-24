package com.xiaobudian.demo.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * Description:
 *
 * @Author Lorrain
 * @CreateTime 2019-05-09 14:19
 */
public class SignUtils {

    private static StringBuilder getDecryptStr(Map<String, String> data, String appSecret){
        Set<String> keySet = data.keySet();
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        Arrays.sort(keyArray);

        StringBuilder sb = new StringBuilder();
        for (String k : keyArray) {
            if (k.equals("sign")){
                continue;
            }

            if (data.get(k).trim().length() > 0){
                sb.append(k).append("=").append(data.get(k).trim()).append("&");
            }
        }

        sb.append("appSecret=").append(appSecret);
        return sb;
    }

    public static String genSignWithMD5(Map<String, String> data, String appSecret) throws Exception{
        StringBuilder sb = getDecryptStr(data, appSecret);
        return MD5(sb.toString()).toUpperCase(Locale.ROOT);
    }

    public static String MD5(String data) throws Exception {

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1,3));
        }
        return sb.toString().toUpperCase(Locale.ROOT);

    }


}