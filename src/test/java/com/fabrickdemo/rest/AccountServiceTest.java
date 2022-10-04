package com.fabrickdemo.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import com.fabrickdemo.rest.dto.FabricGenericResponse;
import com.fabrickdemo.rest.dto.TransactionDTO;
import com.fabrickdemo.rest.dto.TransactionsDTO;
import com.fabrickdemo.rest.service.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;


@SpringBootTest
@TestPropertySource("classpath:application.tests.properties")
public class AccountServiceTest {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    static FabrickApiConfig apiConfig;  
    
    @Autowired
	private AccountService service;

    private MockRestServiceServer mockServer;

    @BeforeEach
    public void init() {
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }
    private ObjectMapper mapper = new ObjectMapper();
    
    @Test
    public void givenPayload_whenGetBalanceIsCalled_shouldReturnMockedObject() {

        FabricGenericResponse<String> res = new FabricGenericResponse<String>();
        res.setStatus("OK");
        String payload = "Test OK";
        res.setPayload(payload);

        try {
            mockServer.expect(ExpectedCount.once(), 
            requestTo(new URI("http://test/accounts/1/balance")))
            .andExpect(method(HttpMethod.GET))
            .andRespond(withSuccess(mapper.writeValueAsString(res), MediaType.APPLICATION_JSON)
        );       
        } catch (Exception e) {
        }
        
        ResponseEntity<?> servicePayload = service.getBalance("1");
        assertEquals((String)servicePayload.getBody(), payload);
    }

    @Test
    public void givenPayload_whenGetTransactionsIsCalled_shouldReturnMockedObject() {

        //TransactionsDTO transactions

        FabricGenericResponse<TransactionsDTO> res = new FabricGenericResponse<TransactionsDTO>();
        res.setStatus("OK");
        TransactionsDTO payload = new TransactionsDTO();
        payload.setList(new ArrayList<TransactionDTO>());
        res.setPayload(payload);

        try {
            mockServer.expect(ExpectedCount.once(), 
            requestTo(new URI("http://test/accounts/1/transactions?fromAccountingDate=2022-01-01&toAccountingDate=2022-01-02")))
            .andExpect(method(HttpMethod.GET))
            .andRespond(withSuccess(mapper.writeValueAsString(res), MediaType.APPLICATION_JSON)
        );       
        } catch (Exception e) {
        }
        
        ResponseEntity<?> servicePayload = service.getTransactions("1", "2022-01-01", "2022-01-02");
        assertEquals(servicePayload.getBody(), payload.getList());
    }    
}

