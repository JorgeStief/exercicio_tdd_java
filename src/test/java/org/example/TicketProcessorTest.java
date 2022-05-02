package org.example;

import lombok.val;
import org.example.domain.entities.Ticket;
import org.example.domain.entities.Invoice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class TicketProcessorTest {
    private TicketProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new TicketProcessor();
    }

    @Test
    void invoicePaid() {
        val invoice = new Invoice("Jorge", LocalDateTime.now(), 100.0);

        val values = new double[]{10.0, 60.0, 30.0};
        val tickets = getTickets(values)
        String result = processor.evaluatesPayments(invoice, tickets);

        Assertions.assertEquals("PAGO", result);
    }

    @Test
    void invoiceNotPaid() {
        val invoice = new Fatura("Jorge", LocalDateTime.now(), 100.0);

        val values = new double[]{10.0};
        val tickets = getTickets(values);

        String result = processador.avaliaPagamentos(invoice, tickets);

        Assertions.assertEquals("NAO_PAGO", result);
    }

    private List<Ticket> getTickets(double[] values) {
        return Arrays.stream(values).mapToObj(v -> new Ticket(v, LocalDateTime.now(), Double.toString(v))).collect(Collectors.toList());
    }
} 