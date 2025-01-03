package edu.sharif.web.service;

import edu.sharif.web.model.Field;
import edu.sharif.web.model.FieldDto;
import edu.sharif.web.model.Form;
import edu.sharif.web.model.FormDto;
import edu.sharif.web.repository.FormRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;


@Service
public class FormService {

    private final FormRepository formRepository;

    @Autowired
    public FormService(FormRepository formRepository) {
        this.formRepository = formRepository;
    }

//    private final List<Customer> customers = new ArrayList<>(
//            List.of(
//                    new Customer(1L, "Ali", "ali@xyz.com", LocalDate.of(2003, Month.APRIL, 20), 22),
//                    new Customer(2L, "Sara", "sara@xyz.com", LocalDate.of(2000, Month.DECEMBER, 2), 25)
//            )
//    );

    public List<Form> getForms() {
        return this.formRepository.findAll();
    }

    public Form getFormById(Long formId) {
        return this.formRepository.findById(formId)
                 .orElseThrow(
                         () -> new RuntimeException("Form with id" + formId + " not found")
                 );
    }

    public List<Form> getPublishedForms() {
         return this.formRepository.findByPublishedTrue();
     }

    @Transactional
    public void addForm(FormDto formDto) {
        Form form = new Form(
                formDto.name(),
                formDto.published()
        );

        Optional<Form> existingForm = this.formRepository.findByName(form.getName());
        if (existingForm.isPresent()) {
            throw new RuntimeException("A form with the name '" + form.getName() + "' already exists");
        }
        else
            this.formRepository.save(form);
    }

    @Transactional
    public void editForm(Long formId, FormDto formDto) {
        Form oldForm = formRepository.findById(formId)
                .orElseThrow(
                        () -> new RuntimeException("Form with id" + formId + " not found")
                );

        oldForm.setName(formDto.name());
        oldForm.setPublished(formDto.published());
        this.formRepository.save(oldForm);
    }

    @Transactional
    public void publishForm(Long formId) {
        Form oldForm = formRepository.findById(formId)
                .orElseThrow(
                        () -> new RuntimeException("Form with id" + formId + " not found")
                );
        oldForm.setPublished(!oldForm.getPublished());
        this.formRepository.save(oldForm);
    }

    @Transactional
    public void deleteForm(Long formId) {
        formRepository.deleteById(formId);
    }

    public List<FieldDto> getFormFields(Long formId) {
        Form form = formRepository.findById(formId)
                .orElseThrow(
                        () -> new RuntimeException("Form with id" + formId + " not found")
                );
        return form.getFieldDtos();
    }

    @Transactional
    public void editFormFields(Long formId, @NotNull List<FieldDto> fieldDtos) {
        Form form = formRepository.findById(formId)
                .orElseThrow(
                        () -> new RuntimeException("Form with id" + formId + " not found")
                );
        List<Field> existingFields = form.getFields();

        List<Field> updatedFields = fieldDtos.stream()
                .map(fieldDto -> {
                    if (fieldDto.id() != null) {
                        Field existingField = existingFields.stream()
                                .filter(f -> f.getId().equals(fieldDto.id()))
                                .findFirst()
                                .orElseThrow(
                                        () -> new RuntimeException("Field with id" + fieldDto.id() + " not found in form " + formId)
                                );
                        existingField.setName(fieldDto.name());
                        existingField.setLabel(fieldDto.label());
                        existingField.setType(fieldDto.type());
                        existingField.setDefaultValue(fieldDto.defaultValue());
                        return existingField;
                    } else {
                        Field newField = new Field();
                        newField.setName(fieldDto.name());
                        newField.setLabel(fieldDto.label());
                        newField.setType(fieldDto.type());
                        newField.setDefaultValue(fieldDto.defaultValue());
                        newField.setForm(form);
                        return newField;
                    }
                }).collect(Collectors.toList());

        existingFields.clear();
        existingFields.addAll(updatedFields);
        formRepository.save(form);
    }

}
