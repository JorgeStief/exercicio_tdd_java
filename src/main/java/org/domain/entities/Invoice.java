package org.example.domain.entities;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Invoice {
    private String customerName;
    private LocalDateTime date;
    private double amount;
}