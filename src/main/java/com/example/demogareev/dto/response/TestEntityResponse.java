package com.example.demogareev.dto.response;

import java.time.LocalDateTime;

public class TestEntityResponse extends Response {

    public TestEntityResponse(Boolean success, LocalDateTime dateTime, String message) {
        super.setSuccess(success);
        super.setTimestamp(dateTime);
        super.setMessage(message);
    }
}
