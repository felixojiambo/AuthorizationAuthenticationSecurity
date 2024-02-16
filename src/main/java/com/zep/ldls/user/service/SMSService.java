package com.zep.ldls.user.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
@Service
public class SMSService {

    @Value("${sms.api.url}")
    private String smsApiUrl;

    @Value("${sms.api.key}")
    private String apiKey;

    public void sendOTP(String phoneNumber, String otp) {
        try {
            // Construct the request payload
            String payload = "apiKey=" + apiKey + "&phoneNumber=" + phoneNumber + "&otp=" + otp;

            // Create HTTP connection
            URL url = new URL(smsApiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            // Send the request
            try (OutputStream outputStream = connection.getOutputStream()) {
                outputStream.write(payload.getBytes());
            }

            // Read the response
            StringBuilder response = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
            }

            // Process the response (optional)
            System.out.println("Response from SMS provider: " + response.toString());

            // Close connection
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace(); // Handle any exceptions
        }
    }
}
