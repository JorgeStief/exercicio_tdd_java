package org.example.domain.entities;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Ticket {
    private double amountPaid;
    private LocalDateTime date;
    private String code;
}