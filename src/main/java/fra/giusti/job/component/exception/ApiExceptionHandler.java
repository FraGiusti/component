package fra.giusti.job.component.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler({EntityNotFoundException.class})
    protected ResponseEntity<ApiErrorResponse> handleApiException(EntityNotFoundException ex) {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(HttpStatus.NOT_FOUND, "Error is: " + ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiErrorResponse);
    }


}
