package com.example.BE.Air.Ticket.Sales.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_token")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserToken extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String token;
}
