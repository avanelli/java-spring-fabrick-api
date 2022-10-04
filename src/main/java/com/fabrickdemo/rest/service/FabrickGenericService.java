package com.fabrickdemo.rest.service;

import com.fabrickdemo.rest.FabrickApiConfig;
import com.fabrickdemo.rest.dto.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.ResolvableType;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

//@Service
public class FabrickGenericService {

    @Autowired
    private FabrickApiConfig apiConfig;

    @Autowired
    private RestTemplate restTemplate;

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    protected String createUrl(String accountId, String servicePath) {
        return apiConfig.getUrl() + "accounts/" + accountId + servicePath;
    }

    public Object callFabrick(String url, HttpMethod httpMethod) {
        return this.callFabrick(url, HttpMethod.GET, null, Object.class);
    }

    public <T,R> R callFabrick(String url, HttpMethod httpMethod, T postData, Class<R> responseType) {

        ResolvableType resolvableType = ResolvableType.forClassWithGenerics(FabricGenericResponse.class, responseType);
        ParameterizedTypeReference<FabricGenericResponse<R>> typeRef = ParameterizedTypeReference.forType(resolvableType.getType());

        ResponseEntity<FabricGenericResponse<R>> responseEntity = restTemplate.exchange(url, httpMethod, getHeaders(postData), typeRef);
        FabricGenericResponse<R> res = (FabricGenericResponse<R>) responseEntity.getBody();
        return res.getPayload();
    }

    public <T> HttpEntity<Object> getHeaders ( T requestData ){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("X-Time-Zone", "Europe/Rome");
        headers.add("Auth-Schema", "S2S");
        headers.add("Api-Key", apiConfig.getApikey());
        
        HttpEntity<Object> requestEntity=new HttpEntity<>(requestData, headers);
        return requestEntity;
    }
    
}
