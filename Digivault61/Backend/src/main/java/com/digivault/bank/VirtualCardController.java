package com.digivault.bank;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://127.0.0.1:3000")
public class VirtualCardController {

    private final VirtualCardService virtualCardService;

    public VirtualCardController(VirtualCardService virtualCardService) {
        this.virtualCardService = virtualCardService;
    }

    // ✅ Get or create Virtual Card (Fetch on frontend page load)
    @GetMapping("/virtualCard/{userId}")
    public ResponseEntity<VirtualCard> getOrCreateVirtualCard(@PathVariable Integer userId) {
        VirtualCard card = virtualCardService.getOrCreateVirtualCard(userId);
        return ResponseEntity.ok(card);
    }

    // ✅ Corrected POST request (userId from request body)
    @PostMapping("/generateVirtualCard")
    public ResponseEntity<VirtualCard> generateVirtualCard(@RequestBody Map<String, Integer> requestBody) {
        Integer userId = requestBody.get("userId");

        if (userId == null) {
            return ResponseEntity.badRequest().build(); // Handle missing userId
        }

        VirtualCard card = virtualCardService.getOrCreateVirtualCard(userId);
        return ResponseEntity.ok(card);
    }
}
