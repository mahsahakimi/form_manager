package edu.sharif.web.controllers;

import edu.sharif.web.dtos.FieldDto;
import edu.sharif.web.dtos.FormDto;
import edu.sharif.web.services.FormService;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/forms/")
public class FromController {

    private final FormService formService;

    // @Autowired
    public FromController(FormService formService) {
        this.formService = formService;
    }

    @GetMapping
    List<FormDto> getForms() {
        return formService.getForms();
    }

    @GetMapping(path = "/published")
    List<FormDto> getPublishedForms() {
        return formService.getPublishedForms();
    }

     @GetMapping(path = "{form_id}")
     FormDto getFormById(@PathVariable(name = "form_id") Long formId) {

        return formService.getFormById(formId);
     }

    @PostMapping
    void addForm( @RequestBody FormDto formDto) {

        formService.addForm(formDto);
    }

    @PutMapping(path = "{form_id}")
    void editForm(@PathVariable("form_id") Long formId, @RequestBody FormDto formDto) {
        formService.editForm(formId, formDto);
    }

    @PostMapping(path = "{form_id}/publish")
    void publishForm(@PathVariable("form_id") Long formId) {

        formService.publishForm(formId);
    }

    @DeleteMapping(path = "{form_id}")
    void deleteCustomer(@PathVariable("form_id") Long formId) {

        formService.deleteForm(formId);
    }

    @GetMapping(path = "{form_id}/fields")
    List<FieldDto> getFormFields(@PathVariable(name = "form_id") Long formId) {
        return formService.getFormFields(formId);
    }

    @PutMapping(path = "{form_id}/fields")
    void editFormFields(@PathVariable("form_id") Long formId, @RequestBody List<FieldDto> fieldDtos) {
         formService.editFormFields(formId, fieldDtos);
    }

}
