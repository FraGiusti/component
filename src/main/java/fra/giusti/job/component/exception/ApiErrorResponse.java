package fra.giusti.job.component.exception;


import org.springframework.http.HttpStatus;

import java.time.Clock;
import java.time.Instant;
public class ApiErrorResponse {

    private final HttpStatus status;
    private final String message;
    private final Instant timestamp = Instant.now(Clock.systemDefaultZone());

    public ApiErrorResponse(HttpStatus status, String message) {
        this.status= status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public Instant getTimestamp() {
        return this.timestamp;
    }
}

