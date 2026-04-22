package com.digivault.bank;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountService {

    @Autowired
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Accounts> fetchAccounts() {
        return accountRepository.findAll();
    }

    public List<Accounts> getAccountsByUserId(Long userId) {
        return accountRepository.findByUserId(userId);
    }

    // NEW method to save a single account
    public Accounts saveAccount(Accounts account) {
        return accountRepository.save(account);
    }
}

