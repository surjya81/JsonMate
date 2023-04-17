package com.bluebird.jsonmate.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebird.jsonmate.entity.Template;
import com.bluebird.jsonmate.repository.TemplateRepository;
import com.bluebird.jsonmate.service.TemplateService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/templates")
@Tag(name = "Templates")
public class TemplateController {
    @Autowired
    private TemplateRepository templateRepository;
    
    @Autowired
    private TemplateService templateService;

    @GetMapping("/")
    @Operation(description ="Get all templates")
    public List<Template> getAllTemplates() {
        return templateRepository.findAll();
    }

    @PostMapping("/")
    @Operation(description ="Create a new template")
    public Template createTemplate(@RequestBody Template template) {
        return templateRepository.save(template);
    }

    @GetMapping("/{id}")
    @Operation(description ="Get a template by ID")
    public ResponseEntity<Template> getTemplateById(@PathVariable(value = "id") Long templateId) {
        Optional<Template> templateOptional = templateRepository.findById(templateId);
        if (templateOptional.isPresent()) {
        	templateService.modify(templateId);
            return ResponseEntity.ok(templateOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    @Operation(description ="Update a template by ID")
    public ResponseEntity<Template> updateTemplate(@PathVariable(value = "id") Long templateId, @RequestBody Template templateDetails) {
        Optional<Template> templateOptional = templateRepository.findById(templateId);
        if (templateOptional.isPresent()) {
            Template template = templateOptional.get();
            template.setName(templateDetails.getName());
            template.setDescription(templateDetails.getDescription());
            template.setData(templateDetails.getData());
            return ResponseEntity.ok(templateRepository.save(template));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(description ="Delete a template by ID")
    public ResponseEntity<?> deleteTemplate(@PathVariable(value = "id") Long templateId) {
        Optional<Template> templateOptional = templateRepository.findById(templateId);
        if (templateOptional.isPresent()) {
            templateRepository.delete(templateOptional.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
