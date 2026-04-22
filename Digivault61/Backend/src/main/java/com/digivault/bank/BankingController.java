package com.digivault.bank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:3000") // Allow frontend access

@RestController
@RequestMapping("/api/v1")
public class BankingController {

    private final AccountService accountService;
    private final CustomerService customerService;
    private final TransactionsService transactionsService;
    private final UsersService usersService;
    private final BalanceService balanceService;


    // private final CardsService cardsService;
    public BankingController(
            AccountService accountService,
            CustomerService customerService,
            TransactionsService transactionsService,
            UsersService usersService,
            ChatbotService chatbotService,
            BalanceService balanceService) {
        this.accountService = accountService;
        this.customerService = customerService;
        this.transactionsService = transactionsService;
        this.usersService = usersService;
        this.balanceService = balanceService;
    }

    // Fetch Users
    @GetMapping("/fetchUsers")
    public ResponseEntity<List<Users>> fetchUsers() {
        List<Users> users = usersService.fetchUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody Users user) {
    Map<String, String> credentials = usersService.saveUser(user);
    return ResponseEntity.ok(credentials);
}

    @PostMapping("/login")
    public Map<String, Object> loginUser(@RequestBody Map<String, String> loginRequest) {
        String userId = loginRequest.get("userId");
        String password = loginRequest.get("password");

        Long userIdF = Long.parseLong(userId);
        boolean isAuthenticated = usersService.loginUser(userIdF, password);
        Map<String, Object> response = new HashMap<>();

        if (isAuthenticated) {
            response.put("message", "Login successful");
            response.put("status", "success");
        } else {
            response.put("message", "Invalid credentials");
            response.put("status", "error");
        }

        return response;
    }

    // Fetch Accounts
    @GetMapping("/fetchAccounts")
    public ResponseEntity<List<Accounts>> fetchAccounts() {
        List<Accounts> accounts = accountService.fetchAccounts();
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/accounts/{userId}")
    public ResponseEntity<List<Accounts>> getAccountsByUserId(@PathVariable Long userId) {
        List<Accounts> accounts = accountService.getAccountsByUserId(userId);
        return ResponseEntity.ok(accounts);
    }

    @Autowired
    private AccountRepository accRepository;
    @PostMapping("/updateBalance")
    public ResponseEntity<String> updateBalance(@RequestBody Balance ph) {
        // Ensure status is set to default 'N' if not provided
        ph.setBalance(ph.getBalance());
        ph.setAccountNo(ph.getAccountNo());
        balanceService.saveAcc(ph);
        return ResponseEntity.ok("Balance Updated successfully.");
    }

    // Fetch Customer Support Requests
    @GetMapping("/fetchCustomersupport")
    public ResponseEntity<List<Customersupport>> fetchCustomersupport() {
        List<Customersupport> customerSupport = customerService.fetchCustomersupport();
        return ResponseEntity.ok(customerSupport);
    }

    @PostMapping("/submitCustomersupport")
public ResponseEntity<String> submitCustomerSupport(@RequestBody Customersupport support) {
    customerService.saveSupportRequest(support); // You handle saving it to DB
    return ResponseEntity.ok("Support request received");
}


    // Fetch Transactions
    @GetMapping("/fetchTransactions")
    public ResponseEntity<List<Transactions>> fetchTransactions() {
        List<Transactions> transactions = transactionsService.fetchTransactions();
        System.out.println("Fetched Transactions: " + transactions);
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/transactions/{accountNo}")
    public ResponseEntity<List<Transactions>> getTransactionsByAccountNo(@PathVariable String accountNo) {
        List<Transactions> transactions = transactionsService.getTransactionsByAccountNo(accountNo);
        return ResponseEntity.ok(transactions);

    }


    @PostMapping("/transfer")
    public Transactions saveTransaction(@RequestBody Transactions transactionDetails) {
        return transactionsService.saveTransaction(transactionDetails);
    }
    
    @Autowired
    private ChatbotRepository chatbotRepository;

    @GetMapping("/chatbot")
    public ChatbotResponse getChatbotResponse(@RequestParam String message) {
        // Find matching response in database
        List<Chatbot> chatbotList = chatbotRepository.findByQuestionIgnoreCase(message);

        // If response found in DB, return it
        if (!chatbotList.isEmpty()) {
            return new ChatbotResponse(chatbotList.get(0).getAnswer());
        }

        // If no match found, return default response
        return new ChatbotResponse("I'm sorry, I don't understand your question.");
    }

    // Response DTO class
    static class ChatbotResponse {
        private String response;

        public ChatbotResponse(String response) {
            this.response = response;
        }

        public String getResponse() {
            return response;
        }
    }

    @Autowired
    private PayeeDetailsService service;

    @PostMapping("/addPayee")
    public PayeeDetails addPayee(@RequestBody PayeeDetails payeeDetails) {
        return service.savePayee(payeeDetails);
    }

    // Endpoint for changing the password
    @PutMapping("/api/v1/users/change-password")
    public ResponseEntity<?> changePassword(@RequestBody PasswordChangeRequest request) {
        // Validate the request
        if (request.getUserId() == null || request.getNewPassword() == null || request.getNewPassword().isEmpty()) {
            return ResponseEntity.status(HttpStatus.SC_BAD_REQUEST).body("User ID and new password must be provided");
        }

        // Call service to change the password
        boolean result = usersService.changePassword(request.getUserId(), request.getNewPassword());

        if (result) {
            return ResponseEntity.ok().body("Password changed successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.SC_BAD_REQUEST).body("Failed to change password. User not found.");
        }

}
}
