package com.codegym.service;

import com.codegym.dao.DTO.course.CourseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CourseService {
    List<CourseDTO> getAllCourse();

    boolean createCourse(CourseDTO courseDTO);

    boolean editCourseOfAdmin(Long id, CourseDTO courseDTO);

    boolean deleteCourseOfAdmin(long idCourse);

    CourseDTO findCourseById(long idCourse);

    Page<CourseDTO> pageFindALLSearchNameOfCourseOfAdmin(Pageable pageable, String search);
}
