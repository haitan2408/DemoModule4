package com.codegym.dao.repository;

import com.codegym.dao.entity.ClassStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassStudentRepository extends JpaRepository<ClassStudent, Long> {
}
