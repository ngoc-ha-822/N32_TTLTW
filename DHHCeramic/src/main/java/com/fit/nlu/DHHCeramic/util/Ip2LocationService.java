package com.fit.nlu.DHHCeramic.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Ip2LocationService {
    private static final String API_KEY = "BE7C37A2FCCDD7AF95B0EF63980DFF38";
    private static final String API_URL = "https://api.ip2location.io/?key=" + API_KEY + "&ip=";

    public static String getIpLocation(String ip) {
        try {
            URL url = new URL(API_URL + ip);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            StringBuilder response = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                response.append(output);
            }

            conn.disconnect();

            // Đảm bảo rằng dữ liệu trả về không rỗng
            if (response.length() == 0) {
                throw new RuntimeException("Empty response from IP2Location API");
            }

            return response.toString();
        } catch (IOException e) {
            // Xử lý lỗi mạng hoặc khi không thể kết nối đến API
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to IP2Location API");
        }
    }
}

