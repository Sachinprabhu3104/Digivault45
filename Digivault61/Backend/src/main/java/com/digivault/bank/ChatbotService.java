package com.digivault.bank;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ChatbotService {

    private final ChatbotRepository chatbotRepository;

    public ChatbotService(ChatbotRepository chatbotRepository) {
        this.chatbotRepository = chatbotRepository;
    }

    public String getResponse(String userMessage) {
        userMessage = userMessage.toLowerCase().trim();

        // Fetch chatbot response from database
        List<Chatbot> responses = chatbotRepository.findByQuestionIgnoreCase(userMessage);

        if (!responses.isEmpty()) {
            return responses.get(0).getAnswer(); // Return first matched answer from DB
        }

        // If no response in DB, use default responses
        if (userMessage.contains("hello") || userMessage.contains("hi")) {
            return "Hello! How can I assist you with your banking needs?";
        } else if (userMessage.contains("balance")) {
            return "You can check your account balance in the 'My Accounts' section.";
        } else if (userMessage.contains("loan")) {
            return "We offer personal, home, and car loans. Visit the 'Loan Services' page for details.";
        } else if (userMessage.contains("support")) {
            return "You can contact customer support at +91 8369157342.";
        } else {
            return "I'm not sure how to answer that. Please contact support for further assistance.";
        }
    }
}
