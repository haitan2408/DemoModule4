package com.codegym.service.impl;

import com.codegym.dao.DTO.CourseDTO;
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
            CourseDTO courseDTO=new CourseDTO(course.getId(), course.getNameCourse());
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
    public boolean editCourse(Long id, CourseDTO courseDTO) {
        Course course=courseRepository.findByIdAndDeletedIsFalse(id);
        List<Course> courseList=courseRepository.findAllByDeletedIsFalse();
        if(course!=null) {
            for(Course temp: courseList) {
                if(temp.getNameCourse().equals(courseDTO.getNameCourse())) {
                    return false;
                }
            }
            course.setNameCourse(courseDTO.getNameCourse());
            courseRepository.save(course);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCourse(long idCourse) {
        Course course =courseRepository.findByIdAndDeletedIsFalse(idCourse);
        if(course!=null) {
            course.setDeleted(true);
            courseRepository.save(course);
            return true;
        }
        return false;
    }

    @Override
    public CourseDTO findCourseById(long idCourse) {
        Course course=courseRepository.findByIdAndDeletedIsFalse(idCourse);
        if(course!=null) {
            return new CourseDTO(course.getId(),course.getNameCourse());
        }
        return null;
    }

    @Override
    public Page<CourseDTO> pageFindAll(Pageable pageable) {
        Page<Course> courses = courseRepository.findAllByDeletedIsFalse(pageable);
        Page<CourseDTO> courseDTOPage = courses.map(course -> {
            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setId(course.getId());
            courseDTO.setNameCourse(course.getNameCourse());
            return courseDTO;
        });
        return courseDTOPage;
    }

    @Override
    public Page<CourseDTO> pageFindALLSearchNameOfCourse(Pageable pageable, String search) {
        Page<Course> coursePage = courseRepository.findAllByDeletedIsFalseAndNameCourseContaining(pageable, search);
        Page<CourseDTO> courseDTOPage = coursePage.map(course -> {
            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setId(course.getId());
            courseDTO.setNameCourse(course.getNameCourse());
            return courseDTO;
        });
        return courseDTOPage;
    }
}
