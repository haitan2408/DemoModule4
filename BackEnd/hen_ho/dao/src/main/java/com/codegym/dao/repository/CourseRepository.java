package com.codegym.dao.repository;

import com.codegym.dao.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    List<Course> findAllByDeletedIsFalse();
    Course findByIdAndDeletedIsFalse(Long id);
    Page<Course> findAllByNameCourseContaining(Pageable pageable,String name);
}
