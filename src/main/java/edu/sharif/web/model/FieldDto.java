package edu.sharif.web.model;

public record FieldDto(
        Long id,
        String name,
        String label,
        FieldType type,
        String defaultValue
) {
}
