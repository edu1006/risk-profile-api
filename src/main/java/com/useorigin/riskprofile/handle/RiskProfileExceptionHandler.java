package com.useorigin.riskprofile.handle;

import com.useorigin.riskprofile.userprofile.response.ErrorHandleMessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RiskProfileExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
            = {IllegalArgumentException.class, IllegalStateException.class})
    protected ResponseEntity<ErrorHandleMessageResponse> handleConflict(
            RuntimeException ex, WebRequest request) {
        ErrorHandleMessageResponse error = new ErrorHandleMessageResponse();
        error.setCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage(ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }



}
