package edu.sharif.web.models;

//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;

import edu.sharif.web.enums.FieldType;
import jakarta.persistence.*;
// import lombok.Getter;
// import lombok.Setter;

@Entity(name = "Field")
@Table(name = "field")
// @Getter
// @Setter
public class Field {
    @Id
    @SequenceGenerator(
            name = "field_id_sequence",
            sequenceName = "actual_field_id_sequence",
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "field_id_sequence"
    )
    private Long id;

    @Column(
            name = "name",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String name;

    @Column(
            name = "label",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String label;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "type",
            columnDefinition = "TEXT",
            nullable = false
    )
    private FieldType type;

    @Column(
            name = "default_value",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String defaultValue;

//    @Transient
    @ManyToOne
    @JoinColumn(name = "form_id")
    private Form form;

    public Field() { // for JPA
    }

    @Override
    public String toString() {
        return "Field{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", label='" + label + '\'' +
                ", form=" + form +
                '}';
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public FieldType getType() {
        return type;
    }

    public void setType(FieldType type) {
        this.type = type;
    }

    //    @Enumerated(EnumType.STRING)
//    private FieldType type;
//     private String defaultValue;

}
