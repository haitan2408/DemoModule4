package com.codegym.service;

import com.codegym.dao.DTO.CourseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CourseService {
    List<CourseDTO> getAllCourse();

    boolean createCourse(CourseDTO courseDTO);

    boolean editCourse(Long id, CourseDTO courseDTO);

    boolean deleteCourse(long idCourse);

    CourseDTO findCourseById(long idCourse);

    Page<CourseDTO> pageFindAll(Pageable pageable);

    Page<CourseDTO> pageFindALLSearchNameOfCourse(Pageable pageable, String search);
}
