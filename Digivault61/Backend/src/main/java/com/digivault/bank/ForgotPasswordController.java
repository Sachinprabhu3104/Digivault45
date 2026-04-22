package com.digivault.bank;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://127.0.0.1:3000")
@RestController
@RequestMapping("/api/v1")
public class ForgotPasswordController {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private EmailService emailService;

    @PostMapping("/verify-user")
public ResponseEntity<String> verifyUserAndSendReset(@RequestBody Map<String, String> request) {
    String email = request.get("email");
    String mobile = request.get("mobile");

    Optional<Users> user = usersRepository.findByEmailId(email);

    if (user.isPresent() && user.get().getMobileNo().equals(mobile)) {
        // Generate token
        String token = UUID.randomUUID().toString();

        // Send email
        emailService.sendResetPasswordEmail(email, token);
        return ResponseEntity.ok("Reset link sent to email.");
    } else {
        return ResponseEntity.badRequest().body("Email or mobile number is incorrect.");
    }
}
}

