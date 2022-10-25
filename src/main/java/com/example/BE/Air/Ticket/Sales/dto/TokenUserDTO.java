package com.example.BE.Air.Ticket.Sales.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TokenUserDTO {
    private String username;
    private String token;
}
