package com.fabrickdemo.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fabrickdemo.rest.dto.FabricGenericResponse;
import com.fabrickdemo.rest.service.FabrickGenericService;


@ExtendWith(MockitoExtension.class)
public class FabrickGenericServiceTest {

    @Mock
    private RestTemplate restTemplate;
    @Mock
    protected FabrickApiConfig apiConfig;


    @InjectMocks
    private FabrickGenericService service = new FabrickGenericService();

    @Test
    public void givenMockingIsDoneByMockito_whenGetIsCalled_shouldReturnMockedObject() {

        FabricGenericResponse<Object> res = new FabricGenericResponse<Object>();
        res.setStatus("OK");
        Object payload = new Object();
        res.setPayload(payload);
        ResponseEntity<FabricGenericResponse<Object>> myEntity = 
            new ResponseEntity<FabricGenericResponse<Object>>(res,HttpStatus.ACCEPTED);

        Mockito
        .when(restTemplate.exchange(
            ArgumentMatchers.eq("http:\\test"),
            ArgumentMatchers.eq(HttpMethod.GET),
            ArgumentMatchers.any(),
            ArgumentMatchers.<ParameterizedTypeReference<FabricGenericResponse<Object>>>any()))
         .thenReturn(myEntity);

        Object servicePayload = service.callFabrick("http:\\test", HttpMethod.GET);
        assertEquals(servicePayload, payload);
    }
}

