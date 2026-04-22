package com.digivault.bank;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface VirtualCardRepository extends JpaRepository<VirtualCard, Long> {
    Optional<VirtualCard> findByUserId(Integer userId);
}
