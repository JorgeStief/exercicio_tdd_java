package org.example.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Invoice {
    private String customerName;
    private LocalDateTime date;
    private double amount;
}