package com.ada.mybatisdemo202312.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NameNotFoundException.class)
    public ResponseEntity<ErrorObject> handleNameNotFoundException(NameNotFoundException ex, WebRequest request) {
        ErrorObject errorObject = new ErrorObject();

        errorObject.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorObject.setMessage(ex.getMessage());
        errorObject.setTimestamp(new Date());
        return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<Map<String, String>> errors = new ArrayList<>();
        e.getBindingResult().getFieldErrors().forEach(fieldError -> {
            Map<String, String> error = new HashMap<>();
            error.put("field", fieldError.getField());
            error.put("message", fieldError.getDefaultMessage());
            errors.add(error);
        });
        ErrorResponse errorResponse =
                new ErrorResponse() {
                    @Override
                    public HttpStatusCode getStatusCode() {
                        return null;
                    }

                    @Override
                    public ProblemDetail getBody() {
                        return null;
                    }
                };
        return ResponseEntity.badRequest().body(errorResponse);
//
//        /**
//         * エラーレスポンスのクラス
//         */
//        final class ErrorResponse {
//            private final HttpStatus status;
//            private final String message;
//            private final List<Map<String, String>> errors;
//
//            public ErrorResponse(HttpStatus status, String message, List<Map<String, String>> errors) {
//                this.status = status;
//                this.message = message;
//                this.errors = errors;
//            }
//
//            public HttpStatus getStatus() {
//                return status;
//            }
//
//            public String getMessage() {
//                return message;
//            }
//
//            public List<Map<String, String>> getErrors() {
//                return errors;
//            }
//
//        }
    }
}
