package com.digivault.bank;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Accounts, Long>{
    List<Accounts> findByUserId(Long userId);

}
