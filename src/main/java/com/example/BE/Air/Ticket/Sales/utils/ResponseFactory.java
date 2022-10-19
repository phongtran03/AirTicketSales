package com.example.BE.Air.Ticket.Sales.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public final class ResponseFactory {
    private ResponseFactory(){
    }

    public static <I> ResponseEntity<BaseResponse<I>> success(I data) {
        BaseResponse response = BaseResponse.builder()
                .code(HttpStatus.OK.value())
                .success(true)
                .data(data)
                .message("Success")
                .build();
        return ResponseEntity.ok(response);
    }

    public static <I> ResponseEntity<BaseResponse<I>> success(HttpStatus status, I data, String message) {
        BaseResponse response = BaseResponse.builder()
                .code(status.value())
                .success(true)
                .message(message)
                .data(data).build();
        return new ResponseEntity<>(response, status);
    }

    public static <I> ResponseEntity<BaseResponse<I>> error(HttpStatus status, I data, String message) {
        BaseResponse<I> response = BaseResponse.<I>builder()
                .code(status.value())
                .success(false)
                .message(message)
                .data(data).build();
        return new ResponseEntity<>(response, status);
    }
}
