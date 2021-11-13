package io.catalyte.exceptions;

public class ResourceNotFound extends RuntimeException {

    public ResourceNotFound() {
    }

    public ResourceNotFound(String message) {
        super(message);
    }
}
