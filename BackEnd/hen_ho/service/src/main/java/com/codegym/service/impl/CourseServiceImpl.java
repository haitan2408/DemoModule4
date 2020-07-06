package com.codegym.service.impl;

import com.codegym.dao.DTO.course.CourseDTO;
import com.codegym.dao.entity.Course;
import com.codegym.dao.repository.CourseRepository;
import com.codegym.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<CourseDTO> getAllCourse() {
        List<Course> courseList=courseRepository.findAllByDeletedIsFalse();
        List<CourseDTO> courseDTOS=new ArrayList<>();
        for (Course course:courseList) {
            CourseDTO courseDTO=new CourseDTO(course.getId(), course.getNameCourse(), course.isDeleted());
            courseDTOS.add(courseDTO);
        }
        return courseDTOS;
    }

    @Override
    public boolean createCourse(CourseDTO courseDTO) {
        List<Course> courseList=courseRepository.findAllByDeletedIsFalse();
        for (Course course:courseList) {
            if(courseDTO.getNameCourse().equals(course.getNameCourse())) {
                return false;
            }
        }
        Course course=new Course(courseDTO.getNameCourse(),false);
        courseRepository.save(course);
        return true;
    }

    @Override
    public boolean editCourseOfAdmin(Long id, CourseDTO courseDTO) {
        Course course=courseRepository.findById(id).orElse(null);
        if(course!=null) {
            course.setNameCourse(courseDTO.getNameCourse());
            course.setDeleted(courseDTO.isDeleted());
            courseRepository.save(course);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCourseOfAdmin(long idCourse) {
        Course course =courseRepository.findById(idCourse).orElse(null);
        if(course!=null) {
           courseRepository.delete(course);

            return true;
        }
        return false;
    }

    @Override
    public CourseDTO findCourseById(long idCourse) {
        Course course=courseRepository.findByIdAndDeletedIsFalse(idCourse);
        if(course!=null) {
            return new CourseDTO(course.getId(),course.getNameCourse(),course.isDeleted());
        }
        return null;
    }

    @Override
    public Page<CourseDTO> pageFindALLSearchNameOfCourseOfAdmin(Pageable pageable, String search) {
        Page<Course> coursePage = courseRepository.findAllByNameCourseContaining(pageable, search);
        Page<CourseDTO> courseDTOPage = coursePage.map(course -> {
            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setId(course.getId());
            courseDTO.setNameCourse(course.getNameCourse());
            courseDTO.setDeleted(course.isDeleted());
            return courseDTO;
        });
        return courseDTOPage;
    }
}
