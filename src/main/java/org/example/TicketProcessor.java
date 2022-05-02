package org.example;

import lombok.val;
import org.example.domain.entities.Ticket;
import org.example.domain.entities.Invoice;

import java.util.List;

public class TicketProcessor {
    public String evaluatesPayments(Invoice invoice, List<Ticket> tickets) {
        val amount = tickets.stream().mapToDouble(Ticket::getAmountPaid).sum();
        return amount >= invoice.getAmount() ? "PAGO" : "NAO_PAGO";
    }
}