package com.fabrickdemo.rest;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fabrickdemo.rest.controller.AccountController;
import com.fabrickdemo.rest.controller.PaymentController;

@SpringBootTest
class RestApplicationTests {
	@Autowired
	private AccountController controller;
	@Autowired
    private PaymentController payment;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
		assertThat(payment).isNotNull();
	}

}
