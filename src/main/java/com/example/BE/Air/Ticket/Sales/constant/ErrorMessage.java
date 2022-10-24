package com.example.BE.Air.Ticket.Sales.constant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ErrorMessage {
   public static final String SUCCESS = "Success";
   public static final String FAILED = "Failed";
   public static final String USER_DOES_NOT_EXIST = "User does not exist";
   public static final String USER_OR_EMAIL_ALREADY_EXIST = "User or email already exists";


}
