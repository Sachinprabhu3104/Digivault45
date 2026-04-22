package com.digivault.bank;

import jakarta.persistence.*;

@Entity
@Table(name = "chatbot")
public class Chatbot {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "question", nullable = false, length = 255)
    private String question;

    @Column(name = "answer", nullable = false, columnDefinition = "TEXT")
    private String answer;

    // Constructors
    public Chatbot() {}

    public Chatbot(Long id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    // toString() method
    @Override
    public String toString() {
        return "Chatbot [id=" + id + ", question=" + question + ", answer=" + answer + "]";
    }
}
