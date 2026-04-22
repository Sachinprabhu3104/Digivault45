package com.digivault.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/profile")
@CrossOrigin(origins = "http://127.0.0.1:3000") // Allow React frontend
public class ProfilePictureController {
    @Autowired
    private ProfilePhotoRepository phRepository;

    // Upload profile picture and save file path in DB
    @PostMapping("/upload")
    public ResponseEntity<String> uploadProfilePicture(@RequestBody ProfilePhoto ph) {
        // Ensure status is set to default 'N' if not provided
        ph.setUserId(ph.getUserId());
        ph.setProfilePicture(ph.getProfilePicture());
        phRepository.save(ph);
        return ResponseEntity.ok("Profile picture uploaded successfully.");
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getProfilePicture(@PathVariable Long userId) {
    Optional<ProfilePhoto> photo = phRepository.findById(userId);
    if (photo.isPresent()) {
        return ResponseEntity.ok(photo.get().getProfilePicture()); // return base64 image
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Profile picture not found");
}

}

