package edu.sharif.web.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "Form")
@Table(name = "form")
public class Form {

    @Id
    @SequenceGenerator(
            name = "form_id_sequence",
            sequenceName = "actual_form_id_sequence",
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "form_id_sequence"
    )
    private Long id;

    @Column(
        name = "name",
        columnDefinition = "TEXT",
        nullable = false,
        unique = true
    )
    private String name;

    @Column(
        name = "published",
        columnDefinition = "BOOLEAN",
        nullable = false
    )
    private Boolean published;

//    @Transient
//    private List<Field> fields;

    public Form() { // for JPA
    }

    public Form(String name, Boolean published) {
        this.name = name;
        this.published = published;
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

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

//    public void setFields(List<Field> fields) {
//        this.fields = fields;
//    }
//
//    public List<Field> getFields() {
//        return fields;
//    }

    @Override
    public String toString() {
        return "Form{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", published=" + published +
                '}';
    }

//    @Override
//    public String toString() {
//        return "Form{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", published=" + published +
//                ", fields=" + fields +
//                '}';
//    }
}
