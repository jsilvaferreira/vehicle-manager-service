package br.com.tinnova.vehicle.manager.exception.handler;

import br.com.tinnova.vehicle.manager.endpoint.resource.ErrorResource;
import br.com.tinnova.vehicle.manager.exception.BadRequestException;
import br.com.tinnova.vehicle.manager.exception.NotFoundException;
import br.com.tinnova.vehicle.manager.exception.error.ErrorCodes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

@ControllerAdvice
@ResponseBody
public class ExceptionAdvice extends ExceptionHandlerExceptionResolver {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFoundException(final NotFoundException exception){
        return handleExceptionNotFoundException(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity handleException(final NoHandlerFoundException exception) {
        return handleExceptionNotFoundException(new NotFoundException(ErrorCodes.ENDPOINT_NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity handleBadRequestException(final BadRequestException exception){
        return handleExceptionBadRequestException(exception, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity handleExceptionNotFoundException(NotFoundException exception, HttpStatus status) {
        ErrorResource errorResource = new ErrorResource();
        errorResource.setCode(exception.getCode());
        errorResource.setMessage(exception.getMessage());
        return ResponseEntity.status(status).body(errorResource);
    }

    private ResponseEntity handleExceptionBadRequestException(BadRequestException exception, HttpStatus status) {
        ErrorResource errorResource = new ErrorResource();
        errorResource.setCode(exception.getCode());
        errorResource.setMessage(exception.getMessage());
        return ResponseEntity.status(status).body(errorResource);
    }
}
