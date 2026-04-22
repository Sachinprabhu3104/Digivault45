package com.digivault.bank;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.Random;

@Service
public class VirtualCardService {

    private final VirtualCardRepository virtualCardRepository;

    public VirtualCardService(VirtualCardRepository virtualCardRepository) {
        this.virtualCardRepository = virtualCardRepository;
    }

    public VirtualCard getOrCreateVirtualCard(Integer userId) {
        Optional<VirtualCard> existingCard = virtualCardRepository.findByUserId(userId);

        if (existingCard.isPresent()) {
            return existingCard.get();
        }

        VirtualCard newCard = new VirtualCard(null, null, null, null, null);
        newCard.setUserId(userId);
        newCard.setCardNumber(generateCardNumber());
        newCard.setExpiryDate("2031/04");
        newCard.setCvv(generateCvv());
        newCard.setStatus(VirtualCard.Status.ACTIVE);

        return virtualCardRepository.save(newCard);
    }

    private String generateCardNumber() {
        Random random = new Random();
        return String.format("%04d-%04d-%04d-%04d",
                random.nextInt(10000), random.nextInt(10000),
                random.nextInt(10000), random.nextInt(10000));
    }

    private String generateCvv() {
        Random random = new Random();
        return String.format("%03d", random.nextInt(1000));
    }

    public VirtualCard createVirtualCard(Integer userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createVirtualCard'");
    }

    public Object getCardByUserId(Integer userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCardByUserId'");
    }
}
