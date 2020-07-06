package com.codegym.web_service.controller;

import com.codegym.dao.DTO.course.CourseDTO;
import com.codegym.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping(value = "/api/admin/course", params = {"page", "size", "search"})
    public ResponseEntity<Page<CourseDTO>> getAllCourse(@RequestParam("page") int page,
                                          @RequestParam("size") int size,
                                          @RequestParam("search") String search) {
        Page<CourseDTO> courseDTOPage = courseService.pageFindALLSearchNameOfCourseOfAdmin(PageRequest.of(page, size), search);
        if (courseDTOPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(courseDTOPage, HttpStatus.OK);
    }

    @PostMapping("/api/admin/course")
    public ResponseEntity<?> createCourse(@Valid @RequestBody CourseDTO courseDTO) {
        if (courseService.createCourse(courseDTO)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/api/admin/course/{idCourse}")
    public ResponseEntity<?> editCourse(@Valid @RequestBody CourseDTO courseDTO, @PathVariable("idCourse") long id) {
        if (courseService.editCourseOfAdmin(id, courseDTO)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/api/admin/course/{idCourse}")
    public ResponseEntity<?> deleteCourse(@PathVariable long idCourse) {
        if (courseService.deleteCourseOfAdmin(idCourse)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/admin/course/{idCourse}")
    public ResponseEntity<?> findCourseById(@PathVariable long idCourse) {
        CourseDTO courseDTO = courseService.findCourseById(idCourse);
        if (courseDTO != null) {
            return new ResponseEntity<>(courseDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
