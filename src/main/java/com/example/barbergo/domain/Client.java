package com.example.barbergo.domain;

import java.util.UUID;

public class Client {
    private UUID id;
    private String name;
    private String email;
    private String phone;
    private String password;

    public Client(UUID id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }
}
