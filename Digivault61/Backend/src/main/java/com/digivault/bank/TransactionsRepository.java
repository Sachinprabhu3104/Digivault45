package com.digivault.bank;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsRepository extends JpaRepository<Transactions, Long>{
    List<Transactions> findByAccountNo(String accountNo);


}
