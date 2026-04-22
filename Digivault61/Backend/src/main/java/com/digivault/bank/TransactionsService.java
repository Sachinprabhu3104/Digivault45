package com.digivault.bank;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionsService {
    @Autowired
    private final TransactionsRepository transactionsRepository;

    public TransactionsService(TransactionsRepository transactionsRepository) {
        this.transactionsRepository = transactionsRepository;
    } 

    /**
     * Get all the products.
     *
     * @return the list of entities
     */
    public List<Transactions> fetchTransactions() {
        return transactionsRepository.findAll();
    }

    public List<Transactions> getTransactionsByAccountNo(String accountNo) {
        return transactionsRepository.findByAccountNo(accountNo);
    }

    public Transactions saveTransaction(Transactions transactionDetails) {
        return transactionsRepository.save(transactionDetails);
    }
}
