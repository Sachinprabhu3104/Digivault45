package com.digivault.bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/creditcard")
@CrossOrigin(origins = "http://127.0.0.1:3000") // allow frontend calls
public class CreditCardController {
    @Autowired
    private CreditCardRepository creditCardRepository;

    @PostMapping("/apply")
    public ResponseEntity<String> applyForCreditCard(@RequestBody CreditCard creditCard) {
        // Ensure status is set to default 'N' if not provided
        if (creditCard.getStatus() == null) {
            creditCard.setStatus("N");
        }

        creditCardRepository.save(creditCard);
        return ResponseEntity.ok("Credit Card application submitted successfully.");
    }
}


