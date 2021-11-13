package io.catalyte.exceptions;

public class ServiceUnavailable extends RuntimeException {

    public ServiceUnavailable() {}

    public ServiceUnavailable(String message) {
        super(message);
    }
}