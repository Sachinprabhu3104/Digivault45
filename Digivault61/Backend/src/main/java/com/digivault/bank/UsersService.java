package com.digivault.bank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private final UsersRepository usersRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private EmailService emailService;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    // Return Map instead of Users
    public Map<String, String> saveUser(Users user) {
        // 1. Save the new user
        Users savedUser = usersRepository.save(user);

        // 2. Generate a unique account number
        String accountNo = "DV" + System.currentTimeMillis();  // e.g., DV1690001234567

        // 3. Create a new account automatically
        Accounts account = new Accounts();
        account.setUserId(savedUser.getUserId());
        account.setAccountNo(accountNo);
        account.setAccountType("Savings"); // default type
        account.setBalance("0");            // starting balance
        accountService.saveAccount(account); // save to DB

        // 4. Send registration email with UserID, temp password & account number
        emailService.sendRegistrationEmail(
            savedUser.getEmailId(),
            String.valueOf(savedUser.getUserId()),
            savedUser.getPassword(),
            accountNo
        );

        // 5. Return credentials to frontend
        Map<String, String> credentials = new HashMap<>();
        credentials.put("userId", String.valueOf(savedUser.getUserId()));
        credentials.put("password", savedUser.getPassword());
        credentials.put("accountNo", accountNo);

        return credentials;
    }

    public boolean loginUser(Long userId, String password) {
        Optional<Users> user = usersRepository.findById(userId);
        return user.isPresent() && user.get().getPassword().equals(password);
    }

    public boolean changePassword(Long userId, String newPassword) {
        Optional<Users> optionalUser = usersRepository.findById(userId);
        if (optionalUser.isPresent()) {
            Users user = optionalUser.get();
            user.setPassword(newPassword);
            usersRepository.save(user);
            return true;
        }
        return false;
    }

    public List<Users> fetchUsers() {
        return usersRepository.findAll();
    }
}
