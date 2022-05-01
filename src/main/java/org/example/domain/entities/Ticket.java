package org.example.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Ticket {
    private double amountPaid;
    private LocalDateTime date;
    private String code;
}