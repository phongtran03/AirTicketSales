package com.example.BE.Air.Ticket.Sales.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse<T> {
    private T message;
    private T data;

}
