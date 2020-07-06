package com.codegym.service;

import com.codegym.dao.DTO.instructor.InstructorDTO;
import com.codegym.dao.DTO.instructor.InstructorListDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface InstructorService {
    Page<InstructorListDTO> getAllInstructor(Pageable pageable, String search);

    boolean createInstructor(InstructorDTO instructorDTO);
}
