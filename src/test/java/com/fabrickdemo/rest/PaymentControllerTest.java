package com.fabrickdemo.rest;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.fabrickdemo.rest.controller.AccountController;
import com.fabrickdemo.rest.repositories.TransactionsRepository;
import com.fabrickdemo.rest.service.PaymentsService;

@WebMvcTest(AccountController.class)
public class PaymentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PaymentsService service;

    @MockBean
    protected TransactionsRepository transactionRepository; 
	
	@Test
	public void moneyTransfersShouldReturnMessageFromService() throws Exception {

        ResponseEntity<?> res = new ResponseEntity<>(
            "Test OK",
            HttpStatus.OK);
        doReturn(res).when(service).moneyTransfer("1", Object.class);
	
		this.mockMvc.perform(post("/accounts/1/payments/money-transfers")
					.content("{ \"Test\": \"OK\" }")
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON)					
				).andDo(print()).andExpect(status().isOk());
	}

}