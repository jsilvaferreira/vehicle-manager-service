package br.com.tinnova.vehicle.manager.infrastructure.exception;

import br.com.tinnova.vehicle.manager.infrastructure.exception.error.ErrorCodes;

public class NotFoundException extends BaseException{

        public NotFoundException(ErrorCodes errorCodes) {
        super(errorCodes.getCode(), errorCodes.getMessage());
    }
}