package com.digivault.bank;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ChatbotRepository extends JpaRepository<Chatbot, Integer> {
    List<Chatbot> findByQuestionIgnoreCase(String question);
}

