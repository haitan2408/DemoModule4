package com.codegym.dao.DTO.instructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class InstructorListDTO {

    private Long id;

    private String nameInstructor;

    private String address;

    private String phoneNumber;

    private Double salary;

    private boolean deleted;

    public InstructorListDTO(Long id, String nameInstructor, String address, String phoneNumber, Double salary, boolean deleted) {
        this.id = id;
        this.nameInstructor = nameInstructor;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.deleted = deleted;
    }

    public InstructorListDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameInstructor() {
        return nameInstructor;
    }

    public void setNameInstructor(String nameInstructor) {
        this.nameInstructor = nameInstructor;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
