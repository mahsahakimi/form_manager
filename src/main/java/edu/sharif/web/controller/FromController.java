package edu.sharif.web.controller;

import edu.sharif.web.model.Form;
import edu.sharif.web.model.FormDto;
import edu.sharif.web.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;

@RestController
@RequestMapping("/forms/")
public class FromController {

    private final FormService formService;

    @Autowired
    public FromController(FormService formService) {
        this.formService = formService;
    }

    @GetMapping
    List<Form> getForms() {
        return formService.getForms();
    }

    @GetMapping(path = "/published")
    List<Form> getPublishedForms() {
        return formService.getPublishedForms();
    }

     @GetMapping(path = "{form_id}")
     Form getFormById(@PathVariable(name = "form_id") Long formId) {
         return formService.getFormById(formId);
     }

    @PostMapping
    void addForm(@RequestBody FormDto formDto) {
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

//    @GetMapping(path = "{form_id}/fields")
//    List<Field> getFormFields(@PathVariable(name = "form_id") Long formId) {
//        return formService.getFormFields(formId);
//    }

//    @PutMapping(path = "{form_id}/fields")
//    void editFormFields(@PathVariable("form_id") Long formId, @RequestBody FormDto formDto) {
//        formService.editFormFields(formId, formDto);
    // }

}