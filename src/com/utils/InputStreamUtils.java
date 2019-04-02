package com.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class InputStreamUtils {
    public static  String getInputString (InputStream ips) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader( ips, "utf-8"));
        StringBuffer sb = new StringBuffer();
        String temp;
        while ((temp = br.readLine()) != null) {
            sb.append(temp);
        }
        br.close();
        return sb.toString();

    }


}
