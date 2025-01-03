package edu.sharif.web.dtos;

import edu.sharif.web.enums.FieldType;

public record FieldDto(
        Long id,
        String name,
        String label,
        FieldType type,
        String defaultValue
) {
}
