package edu.sharif.web.exceptions;

public class FormAlreadyExistsException extends RuntimeException {
    public FormAlreadyExistsException(String name) {
        super("A form with the name '" + name + "' already exists");
    }
}
