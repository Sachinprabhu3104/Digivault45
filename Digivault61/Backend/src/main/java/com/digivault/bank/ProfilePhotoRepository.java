package com.digivault.bank;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfilePhotoRepository extends JpaRepository<ProfilePhoto, Long> {

    Optional<ProfilePhoto> findByUserId(Long userId); // ✅ Custom and valid




}
