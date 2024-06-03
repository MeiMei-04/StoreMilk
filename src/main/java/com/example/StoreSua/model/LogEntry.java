package com.example.StoreSua.model;

import java.time.Instant;

public class LogEntry {
    private Instant timestamp;
    private String level;
    private String logger;
    private String message;



    public LogEntry(Instant start, String info, String logger, String format) {
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLogger() {
        return logger;
    }

    public void setLogger(String logger) {
        this.logger = logger;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
