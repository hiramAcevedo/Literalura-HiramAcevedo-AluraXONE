package com.hiramwoki.literalura_hiramAcevedo.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

@Service
public class GutendexApiService {

    private static final String API_URL = "https://gutendex.com/books/";
    private final HttpClient httpClient;

    public GutendexApiService() {
        this.httpClient = HttpClient.newHttpClient();
    }

    public String buscarLibroPorTitulo(String titulo) throws IOException, InterruptedException {
        String encodedTitulo = URLEncoder.encode(titulo, StandardCharsets.UTF_8);
        String url = API_URL + "?search=" + encodedTitulo;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return response.body();
        } else {
            throw new IOException("Error en la respuesta de la API: " + response.statusCode());
        }
    }

}
