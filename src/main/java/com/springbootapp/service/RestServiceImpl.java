package com.springbootapp.service;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

public class RestServiceImpl implements RestService {

	
    @Override
    public <T> T callService(String url, Class<T> clazz) {
        HttpEntity<T> httpEntity = new HttpEntity<>(buildHttpHeaders());
        ResponseEntity<T> responseEntity;
        RestTemplate restTemplate= new RestTemplate();
        try {
            responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, clazz);
        } catch (RestClientException e) {
            throw e;
        }

        HttpStatus statusCode = responseEntity.getStatusCode();

        if (statusCode == HttpStatus.OK) {
            return responseEntity.getBody();
        }
     
        throw new ResponseStatusException(statusCode);
    }

    private HttpHeaders buildHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }

}
