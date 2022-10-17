package com.example.BE.Air.Ticket.Sales.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "flights")
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String addressStart;
    private String addressEnd;
    private Timestamp timeStart;
    private Timestamp timeEnd;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "flights_id")
    private Passenger passenger;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
    private List<Ticket> tickets;


    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "flights_id", insertable=false, updatable=false, nullable=false)
    private Airfield airfield;


}
