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

    private Invoice invoiceEx;

    @BeforeEach
    void setUp() {
        processor = new TicketProcessor();
        invoiceEx = new Invoice("Jorge", LocalDateTime.now(), 100.0);
    }

    @Test
    void invoicePaid() {

        val values = new double[]{10.0, 60.0, 30.0};
        val tickets = getTickets(values)
        String result = processor.evaluatesPayments(invoiceEx, tickets);

        Assertions.assertEquals("PAGO", result);
    }

    @Test
    void invoiceNotPaid() {
        val invoice = new Ticket("Jorge", LocalDateTime.now(), 100.0);

        val values = new double[]{10.0};
        val tickets = getTickets(values);

        String result = processador.evaluatesPayments(invoiceEx, tickets);

        Assertions.assertEquals("NAO_PAGO", result);
    }

     @Test
    void testCollection() {
        val collection = new Object[][]{
                {1500.0, new double[]{500.0, 400.0, 600.0}, "PAGO"},
                {1500.0, new double[]{1000.0, 500.0, 250.0}, "PAGO"},
                {2000.0, new double[]{500.0, 400.0}, "NAO_PAGO"}
        };

        for (Object[] entry : collection) {
            invoiceEx.setAmount((Double) entry[0]);
            val tickets = getTickets((double[]) entry[1]);

            Assertions.assertEquals(entry[2], processor.evaluatesPayments(invoiceEx, tickets));
        }
    }

    private List<Ticket> getTickets(double[] values) {
        return Arrays.stream(values).mapToObj(v -> new Ticket(v, LocalDateTime.now(), Double.toString(v))).collect(Collectors.toList());
    }
} 