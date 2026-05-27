package ra.edu.ptit_cntt2_it211_session12_ex4.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ra.edu.ptit_cntt2_it211_session12_ex4.model.dto.ErrorResponse;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleStudentNotFound(StudentNotFoundException e) {
        log.warn("Xử lý StudentNotFoundException: {}", e.getMessage());

        return new ResponseEntity<>(new ErrorResponse(
                e.getMessage(),
                404
        ), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        log.error("Lỗi không mong muốn trong ControllerAdvice: {}", e.getMessage());

        return new ResponseEntity<>(new ErrorResponse(
                "Lỗi hệ thống!",
                500
        ), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
