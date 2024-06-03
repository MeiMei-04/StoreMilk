package com.example.StoreSua.service;

import com.example.StoreSua.model.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogService {
    private static final Logger logger = LoggerFactory.getLogger(LogService.class);
    private List<Log> logs = new ArrayList<>();

    public void addLog(Log log) {
        logs.add(log);
        logger.info(log.getMessage());
    }

    public List<Log> getAllLogs() {
        return logs;
    }
}
