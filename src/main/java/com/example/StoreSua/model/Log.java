package com.example.StoreSua.model;

import java.time.LocalDateTime;

public class Log {
    private LocalDateTime timestamp;
    private String message;

    public Log(LocalDateTime timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }
}
