package com.codegym.service.impl;

import com.codegym.dao.DTO.instructor.InstructorDTO;
import com.codegym.dao.DTO.instructor.InstructorListDTO;
import com.codegym.dao.entity.Instructor;
import com.codegym.dao.entity.User;
import com.codegym.dao.repository.InstructorRepository;
import com.codegym.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private UserServiceImpl userService;

    @Override
    public Page<InstructorListDTO> getAllInstructor(Pageable pageable, String search) {
        Page<Instructor> instructorPage = instructorRepository.findAllByDeletedIsFalseAndNameInstructorContaining(pageable, search);
        Page<InstructorListDTO> instructorListDTOS = instructorPage.map(instructor -> {
            InstructorListDTO instructorListDTO = new InstructorListDTO(
                    instructor.getId(), instructor.getNameInstructor(), instructor.getAddress(),
                    instructor.getPhoneNumber(), instructor.getSalary(), instructor.getDeleted()
            );
            return instructorListDTO;
        });
        return instructorListDTOS;
    }

    @Override
    public boolean createInstructor(InstructorDTO instructorDTO) {
        User user = userService.saveMember(instructorDTO.getUsername(), instructorDTO.getPassword());
        if (user != null) {
            Instructor instructor = new Instructor(instructorDTO.getNameInstructor(), instructorDTO.getLevel(),
                    instructorDTO.getAddress(), instructorDTO.getPhoneNumber(), instructorDTO.getEmail(), instructorDTO.getDescription(),
                    instructorDTO.getSpecialize(), instructorDTO.getSalary(), false, user);
            instructorRepository.save(instructor);
            return true;
        } else {
            return false;
        }

    }
}
