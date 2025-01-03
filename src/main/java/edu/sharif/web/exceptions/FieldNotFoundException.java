package edu.sharif.web.exceptions;

public class FieldNotFoundException extends RuntimeException {
    public FieldNotFoundException(Long fieldId, Long formId) {
        super("Field with id" + fieldId + " not found in form " + formId);
    }
}
