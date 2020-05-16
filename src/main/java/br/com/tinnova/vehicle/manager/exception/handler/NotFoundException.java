package br.com.tinnova.vehicle.manager.exception.handler;

import br.com.tinnova.vehicle.manager.exception.error.ErrorCodes;

public class NotFoundException extends RuntimeException{

    private Integer code;
    private String message;

    public NotFoundException(ErrorCodes errorCodes) {
        super(errorCodes.getMessage());
        this.code = errorCodes.getCode();
        this.message = errorCodes.getMessage();
    }


}