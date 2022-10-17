package com.example.BE.Air.Ticket.Sales.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "airfield")
@AllArgsConstructor
@NoArgsConstructor
public class Airfield {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;
    private String national;
    private String type;
    private String size;

    @OneToMany(mappedBy = "airfield")
    private List<Flight> flights;

    @OneToMany(mappedBy = "airfield")
    private List<Plane> planes;

}
