package com.example.BE.Air.Ticket.Sales.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "plane")
@AllArgsConstructor
@NoArgsConstructor
public class Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String national;
    private String color;
    private String dots;
    private String size;
    private String capacityEnergy;
    private String engine;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "plane_id")
    private Airfield airfield;
}
