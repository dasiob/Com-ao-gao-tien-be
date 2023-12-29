package com.example.cagt_be.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DashBoardService {
    private final String momJokeURl = "https://www.ba-bamail.com/handlers/general.ashx?action=jokes_generator&cid=88";

    public Object getMomJoke() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(momJokeURl, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            String responseBody = response.getBody();
            return extractJokeFromGenerator(responseBody);
        } else {
            return "Failed to load mom joke from web!";
        }
    }

    private String extractJokeFromGenerator(String jsonResponse) throws Exception {
        int bodyStartIndex = jsonResponse.indexOf("\"Body\":\"") + "\"Body\":\"".length();
        int bodyEndIndex = jsonResponse.indexOf("\",", bodyStartIndex);
        if (bodyStartIndex >= 0 && bodyEndIndex >= 0) {
            return jsonResponse.substring(bodyStartIndex, bodyEndIndex);
        } else {
            return "Failed to process mom joke!";
        }
    }
}
