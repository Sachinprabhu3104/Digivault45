package com.digivault.bank;

import jakarta.persistence.*;

@Entity
@Table(name = "customersupport")
public class Customersupport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long Id;

    @Column(name = "user_id")
    public Long userId;

    @Column(name = "query")
    public String query;

    @Column(name = "response")
    public String response;

    public Customersupport() {
    }

    public Customersupport(Long id, Long userId, String query, String response) {
        this.Id = id;
        this.userId = userId;
        this.query = query;
        this.response = response;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "Customersupport [id=" + Id + ", user_id=" + userId + ", query=" + query + ", response=" + response + "]";
    }
}
