package com.ricardoagnello.gerenciador_pedidos.exceptions;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {

    private String message;
    private String details;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime timestamp;

    public ErrorResponse(String message, String details, LocalDateTime timestamp) {
        super();
        this.message = message;
        this.details = details;
        this.timestamp = timestamp;

    }

}
