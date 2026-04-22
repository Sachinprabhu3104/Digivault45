package com.digivault.bank;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfilrPhotoService {

    @Autowired
    private final ProfilePhotoRepository phRepository;

    public ProfilrPhotoService(ProfilePhotoRepository phRepository) {
        this.phRepository = phRepository;
    } 

   /**
     * Save a new user.
     *
     * @param ph the user to save
     * @return the saved user
     */
    public ProfilePhoto saveUser(ProfilePhoto ph) {
        return phRepository.save(ph);
    }

}
