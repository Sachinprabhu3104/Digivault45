package com.digivault.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class EmailService {
@Autowired
    private JavaMailSender mailSender;

    public void sendResetPasswordEmail(String toEmail, String token) {
        String subject = "Reset Your DigiVault Password";
        String resetLink = "http://127.0.0.1:3000/Frontend/reset-password.html";
        String body = "Click the link to reset your password:\n" + resetLink;

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("sachinprabhu894@gmail.com");
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
    }

    // Registration email
    public void sendRegistrationEmail(String toEmail, String userId, String tempPassword, String accountNo) {
        String subject = "Welcome to DigiVault Banking System";

        String body = "Dear " + userId + ",\n\n" +
                      "Welcome to DigiVault Banking System!\n\n" +
                      "Your account has been successfully created.\n" +
                      "Account Number: " + accountNo + "\n" +
                      "Temporary Password: " + tempPassword + "\n\n" +
                      "Please log in and change your password immediately for security purposes.\n\n" +
                      "Regards,\n" +
                      "DigiVault Support Team";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("sachinprabhu894@gmail.com");
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
    }
}
