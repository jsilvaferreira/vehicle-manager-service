package br.com.tinnova.vehicle.manager.exception;

import br.com.tinnova.vehicle.manager.exception.error.ErrorCodes;

public class BadRequestException extends BaseException{

    public BadRequestException(ErrorCodes errorCodes) {
        super(errorCodes.getCode(), errorCodes.getMessage());
    }
}
