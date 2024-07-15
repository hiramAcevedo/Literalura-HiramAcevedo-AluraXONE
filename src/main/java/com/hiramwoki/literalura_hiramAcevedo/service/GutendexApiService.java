package com.hiramwoki.literalura_hiramAcevedo.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class GutendexApiService {
    private static final String API_URL = "https://gutendex.com/books/";
    private final HttpClient httpClient;

    public GutendexApiService() {
        this.httpClient = HttpClient.newHttpClient();
    }

    public String getBooks() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return response.body();
        } else {
            throw new IOException("Unexpected response status: " + response.statusCode());
        }
    }
}
