package com.emazon.user.configuration.exceptionhandler;


import com.emazon.user.domain.exception.AgeNotValidException;
import com.emazon.user.domain.exception.EmailInvalidException;
import com.emazon.user.domain.exception.InvalidDocumentException;
import com.emazon.user.domain.exception.PhoneNumberInvalidException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

import static com.emazon.user.configuration.constants.ConstConfig.*;

@ControllerAdvice
@RequiredArgsConstructor
public class ControllerAdvisor {

    @ExceptionHandler(AgeNotValidException.class)
    public ResponseEntity<ExceptionResponse> exceptionHandlerAgeNotValid(Exception ex) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                    String.format(MESSAGE_AGE_INVALID_EXCEPTION,ex.getMessage()),
                    HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()
                )
        );

    }

    @ExceptionHandler(EmailInvalidException.class)
    public ResponseEntity<ExceptionResponse> exceptionHandlerEmailInvalid(Exception ex) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                String.format(MESSAGE_EMAIL_INVALID_EXCEPTION,ex.getMessage()),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()
        ));
    }

    @ExceptionHandler(InvalidDocumentException.class)
    public ResponseEntity<ExceptionResponse> exceptionHandlerInvalidDocument(Exception ex) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                String.format(MESSAGE_DOCUMENT_INVALID_EXCEPTION,ex.getMessage()),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()
        ));
    }

    @ExceptionHandler(PhoneNumberInvalidException.class)
    public ResponseEntity<ExceptionResponse> exceptionHandlerPhoneNumberInvalid(Exception ex) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                String.format(MESSAGE_PHONE_INVALID_EXCEPTION, ex.getMessage()),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()
        ));
    }
}
