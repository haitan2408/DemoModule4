package com.codegym.dao.repository;

import com.codegym.dao.entity.Instructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    Page<Instructor> findAllByDeletedIsFalseAndNameInstructorContaining(Pageable pageable, String search);

    List<Instructor> findAllByDeletedIsFalse();
}
