package com.example.barbergo.application.haircut.dtos;

public record CreateHaircutRequest(String name, String description, Integer duration, Double price) {

}
