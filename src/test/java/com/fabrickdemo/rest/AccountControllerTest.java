package com.fabrickdemo.rest;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.fabrickdemo.rest.controller.AccountController;
import com.fabrickdemo.rest.repositories.TransactionsRepository;
import com.fabrickdemo.rest.service.AccountService;

@WebMvcTest(AccountController.class)
public class AccountControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AccountService service;

    @MockBean
    protected TransactionsRepository transactionRepository;        

	@Test
	public void balanceShouldReturnMessageFromService() throws Exception {
        
        ResponseEntity<?> res = new ResponseEntity<>(
            "Test OK",
            HttpStatus.OK);
        doReturn(res).when(service).getBalance("1");

		this.mockMvc.perform(get("/accounts/1/balance")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Test OK")));
	}
 
	@Test
	public void transactionsShouldReturnMessageFromService() throws Exception {
        String fromAccountingDate = "2019-04-01";
        String toAccountingDate = "2019-04-06";
        ResponseEntity<?> res = new ResponseEntity<>(
            "Test OK",
            HttpStatus.OK);
        doReturn(res).when(service).getTransactions("1", fromAccountingDate, toAccountingDate);

		this.mockMvc.perform(
				get("/accounts/1/transactions")
				.param("fromAccountingDate", fromAccountingDate)
                .param("toAccountingDate", toAccountingDate)
				)
				.andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Test OK")));
	}

}