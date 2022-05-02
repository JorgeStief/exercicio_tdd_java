package org.example;

import org.example.domain.entities.Ticket;
import org.example.domain.entities.Invoice;

import java.util.List;

public class TicketProcessor {
    public String evaluatesPayments(Invoice invoice, List<Ticket> tickets) {
        return "PAGO";
    }
}