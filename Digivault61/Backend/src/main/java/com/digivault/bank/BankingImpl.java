package com.digivault.bank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankingImpl{

    @Autowired
    private final BankingRepository bankingRepository;

    public BankingImpl(BankingRepository bankingRepository) {
        this.bankingRepository = bankingRepository;
    } 



    /**
     * Get all the products.
     *
     * @return the list of entities
     */
    public List<User> fetchUser() {
        return bankingRepository.findAll();
    }

}