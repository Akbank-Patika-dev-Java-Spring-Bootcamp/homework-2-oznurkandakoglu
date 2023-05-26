package com.example.homework2.general;

import com.example.homework2.exception.ProductCommentsNotFoundException;
import com.example.homework2.exception.UserCommentsNotFoundException;
import com.example.homework2.exception.UsernameAndPhoneNumberNotMatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<GenericErrorMessage> handleUsernameAndPhoneNumberNotMatchingException(UsernameAndPhoneNumberNotMatchException e, WebRequest webRequest) {

        String message = e.getErrorMessage();
        String description = webRequest.getDescription(false);

        var genericErrorMessage = new GenericErrorMessage(LocalDateTime.now(), message, description);

        return ResponseEntity.internalServerError().body(genericErrorMessage);
    }

    @ExceptionHandler
    public final ResponseEntity<GenericErrorMessage> handleUserCommentsNotFoundException(UserCommentsNotFoundException e, WebRequest webRequest) {

        String message = e.getErrorMessage();
        String description = webRequest.getDescription(false);

        var genericErrorMessage = new GenericErrorMessage(LocalDateTime.now(), message, description);

        return ResponseEntity.internalServerError().body(genericErrorMessage);
    }
    @ExceptionHandler
    public final ResponseEntity<GenericErrorMessage> handleProductCommentsNotFoundException(ProductCommentsNotFoundException e, WebRequest webRequest) {

        String message = e.getErrorMessage();
        String description = webRequest.getDescription(false);

        var genericErrorMessage = new GenericErrorMessage(LocalDateTime.now(), message, description);

        return ResponseEntity.internalServerError().body(genericErrorMessage);
    }

}

