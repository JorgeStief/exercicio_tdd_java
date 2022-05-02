package org.example;

import lombok.val;
import org.example.domain.entities.Ticket;
import org.example.domain.entities.Invoice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

class TicketProcessorTest {
    private TicketProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new TicketProcessor();
    }

    @Test
    void normalFlow() {
        val invoice = new Invoice("Jorge", LocalDateTime.now(), 100.0);

        val values = new double[]{10.0, 60.0, 30.0};
        val tickets = Arrays.stream(values).mapToObj(v -> new Boleto(v, LocalDateTime.now(), Double.toString(v))).collect(Collectors.toList());

        String resultado = processor.evaluatesPayments(invoice, tickets);

        Assertions.assertEquals("PAGO", resultado);
    }
} 