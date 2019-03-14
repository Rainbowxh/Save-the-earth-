//package com.example.finalpaper.Handler;
//
//import com.example.finalpaper.Entity.apiError;
//import org.springframework.dao.DuplicateKeyException;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.converter.HttpMessageNotReadableException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
//
//import javax.validation.ConstraintViolation;
//import javax.validation.ConstraintViolationException;
//import java.util.ArrayList;
//import java.util.List;
//
//@RestControllerAdvice
//public class NormalExceptionHandler {
//    @ExceptionHandler({ HttpMessageNotReadableException.class })
//    public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
//        apiError apiError = new apiError(
//                HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), "error occurred");
//        return new ResponseEntity<Object>(
//                apiError, new HttpHeaders(), apiError.getStatus());
//    }
//
//    @ExceptionHandler({ConstraintViolationException.class})
//    public ResponseEntity<Object> handleConstrainViolation(ConstraintViolationException ex,WebRequest request){
//        List<String> errors = new ArrayList<String>();
//        for (ConstraintViolation<?> violation : ex.getConstraintViolations()){
//            errors.add(violation.getClass().getName()+" "+violation.getPropertyPath()+":"+violation.getMessage());
//        }
//
//        apiError apiError = new apiError(HttpStatus.BAD_REQUEST,ex.getLocalizedMessage(),ex.getCause().toString(),errors);
//        return new ResponseEntity<Object>(apiError,new HttpHeaders(),apiError.getStatus());
//    }
//
//    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
//    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex, WebRequest request){
//        String error =
//                ex.getName() + " should be of type " + ex.getRequiredType().getName();
//        apiError apiError = new apiError(HttpStatus.BAD_REQUEST,ex.getLocalizedMessage(),error);
//        return new ResponseEntity<Object>(apiError,new HttpHeaders(),apiError.getStatus());
//
//    }
//
//    @ExceptionHandler({NullPointerException.class})
//    public ResponseEntity<Object> handleMethodNullPointerException(NullPointerException ex, WebRequest request){
//        String error = "访问请求的页面不存在";
//        apiError apiError = new apiError(HttpStatus.BAD_REQUEST,ex.getLocalizedMessage(),error);
//        return new ResponseEntity<Object>(apiError,new HttpHeaders(),apiError.getStatus());
//
//    }
//
//    @ExceptionHandler({DuplicateKeyException.class})
//    public ResponseEntity<Object> handleDuplicateKeyException(DuplicateKeyException ex, WebRequest request){
//        String reason = ex.getCause().toString();
//        apiError apiError = new apiError(HttpStatus.BAD_REQUEST,ex.getLocalizedMessage(),reason);
//        return new ResponseEntity<Object>(apiError,new HttpHeaders(),apiError.getStatus());
//
//    }
//
//
//}
