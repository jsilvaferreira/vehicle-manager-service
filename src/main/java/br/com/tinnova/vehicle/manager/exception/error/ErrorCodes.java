package br.com.tinnova.vehicle.manager.exception.error;

    public enum ErrorCodes{

        VEHICLE_NOT_FOUND(404001, "Vehicles not found"),
        ENDPOINT_NOT_FOUND(404002, "EndPoint Not Found"),
        ENTITY_NOT_FOUND(404003, "Entity not found");

        private final Integer code;
        private final String message;

        ErrorCodes(final Integer code, final String message) {
            this.code = code;
            this.message = message;
        }

        public Integer getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }


