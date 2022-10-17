package com.example.BE.Air.Ticket.Sales.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "passenger")
@AllArgsConstructor
@NoArgsConstructor
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String male;
    private String national;
    private String address;
    private String idNumber;

    @OneToMany(mappedBy = "passenger", cascade = CascadeType.ALL)
    private List<Voucher> vouchers;

    @OneToMany(mappedBy = "passenger", cascade = CascadeType.ALL)
    private List<Flight> flights;
}
