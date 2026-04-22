package com.digivault.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://127.0.0.1:3000")
public class ResetPasswordController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ResetTokenRepository resetTokenRepository;

    // ✅ POST endpoint to reset password using token
    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody Map<String, String> request) {
        String token = request.get("token");
        String newPassword = request.get("newPassword");

        if (token == null || newPassword == null) {
            return ResponseEntity.badRequest().body("Token or password is missing.");
        }

        Optional<ResetToken> optionalToken = resetTokenRepository.findByToken(token);

        if (optionalToken.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid token.");
        }

        ResetToken resetToken = optionalToken.get();

        if (resetToken.getExpiryDate().isBefore(LocalDateTime.now())) {
            return ResponseEntity.badRequest().body("Token has expired.");
        }

        Users user = resetToken.getUser();
        user.setPassword(newPassword); // 🔐 In production, hash the password
        usersRepository.save(user);

        resetTokenRepository.delete(resetToken); // 🔒 Invalidate token after use

        return ResponseEntity.ok("Password reset successfully.");
    }
}
