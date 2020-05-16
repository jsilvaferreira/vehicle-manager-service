package br.com.tinnova.vehicle.manager.infrastructure.exception.error;

    public enum ErrorCodes{

        //NotFound
        VEHICLE_NOT_FOUND(404001, "Vehicles not found"),
        ENDPOINT_NOT_FOUND(404002, "EndPoint Not Found"),
        ENTITY_NOT_FOUND(404003, "Vehicle not found"),

        //BadRequest
        PAYLOAD_IS_MANDATORY(400001, "Payload is mandatory");

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


