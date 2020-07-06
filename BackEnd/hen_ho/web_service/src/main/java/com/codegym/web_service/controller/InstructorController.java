package com.codegym.web_service.controller;

import com.codegym.dao.DTO.course.CourseDTO;
import com.codegym.dao.DTO.instructor.InstructorDTO;
import com.codegym.dao.DTO.instructor.InstructorListDTO;
import com.codegym.dao.entity.Instructor;
import com.codegym.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @GetMapping(value = "/api/admin/instructor",  params = {"page", "size", "search"})
    public ResponseEntity<Page<InstructorListDTO>> getAllInstructor(@RequestParam("page") int page,
                                                             @RequestParam("size") int size,
                                                             @RequestParam("search") String search) {
        Page<InstructorListDTO> instructorListDTOS = instructorService.getAllInstructor(PageRequest.of(page, size), search);
        if (instructorListDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(instructorListDTOS, HttpStatus.OK);
    }

    @PostMapping("/api/admin/instructor")
    public ResponseEntity<?> createCourse(@Valid @RequestBody InstructorDTO instructorDTO) {
        if (instructorService.createInstructor(instructorDTO)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
