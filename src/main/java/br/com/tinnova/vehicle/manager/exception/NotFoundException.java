package br.com.tinnova.vehicle.manager.exception;

import br.com.tinnova.vehicle.manager.exception.error.ErrorCodes;

public class NotFoundException extends BaseException{

        public NotFoundException(ErrorCodes errorCodes) {
        super(errorCodes.getCode(), errorCodes.getMessage());
    }
}