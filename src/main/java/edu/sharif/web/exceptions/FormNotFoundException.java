package edu.sharif.web.exceptions;

public class FormNotFoundException extends RuntimeException {
    public FormNotFoundException(Long formId) {

      super("Form with id" + formId + " not found");
    }
}