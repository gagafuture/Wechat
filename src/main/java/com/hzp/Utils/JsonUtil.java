package com.hzp.Utils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @description:
 * @author: GAGA
 * @time: 2020/5/2 16:31
 */
public class JsonUtil {
    public static String getJsonRequest(HttpServletRequest request) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8));
        StringBuilder stringBuilder = new StringBuilder();
        String temp;
        while ((temp = br.readLine())!=null){
            stringBuilder.append(temp);
        }
        br.close();
        return stringBuilder.toString();
    }
}
