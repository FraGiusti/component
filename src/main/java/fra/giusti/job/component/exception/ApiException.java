package fra.giusti.job.component.exception;

import org.springframework.http.HttpStatus;

// your custom ApiException class
public class ApiException extends RuntimeException {

    private final HttpStatus status;

    public ApiException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return this.status;
    }
}
