package com.digivault.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayeeDetailsService {

    @Autowired
    private PayeeDetailsRepository repository;

    public PayeeDetails savePayee(PayeeDetails payeeDetails) {
        return repository.save(payeeDetails);
    }
}
