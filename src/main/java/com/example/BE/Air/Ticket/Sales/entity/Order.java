package com.example.BE.Air.Ticket.Sales.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Timestamp flyingStart;
    private Timestamp flyingEnd;
    private int seats;
    private double pay;

    @OneToOne(mappedBy = "order")
    private Voucher voucher;

    @OneToOne(mappedBy = "order")
    private Invoice invoice;
}
