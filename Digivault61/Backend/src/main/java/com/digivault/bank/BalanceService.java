package com.digivault.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BalanceService {

@Autowired
    private final BalanceRepository balanceRepository;

    public BalanceService(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    } 


       /**
     * Save a new user.
     *
     * @param ph the user to save
     * @return the saved user
     */
    public Balance saveAcc(Balance ph) {
        return balanceRepository.save(ph);
    }

}
