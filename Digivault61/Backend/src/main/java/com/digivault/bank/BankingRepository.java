package com.digivault.bank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankingRepository  extends JpaRepository<User, Long>{


}


