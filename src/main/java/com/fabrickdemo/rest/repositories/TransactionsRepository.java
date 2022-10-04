package com.fabrickdemo.rest.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabrickdemo.rest.model.TransactionModel;

@Repository
public interface TransactionsRepository extends JpaRepository<TransactionModel, Long> {

}

