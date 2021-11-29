package spring.webalk.zh.gyakorlas.excpetions;

import spring.webalk.zh.gyakorlas.excpetions.NoSuchEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/*
 * The @ControllerAdvice annotation was first introduced in Spring 3.2. It allows you to handle exceptions across
 * the whole application, not just to an individual controller. You can think of it as an interceptor of exceptions
 * thrown by methods annotated with @RequestMapping or one of the shortcuts.
 */

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value= {NoSuchEntity.class})
    protected ResponseEntity<Object> handleNoSuchElement(
    		NoSuchEntity ex, WebRequest request){
        return handleExceptionInternal(ex, ex.getMessage(),
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
