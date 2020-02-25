package com.codegym.dao.DTO;

import javax.validation.constraints.NotBlank;

public class CourseDTO {
    private long id;

    @NotBlank(message = "Tên của khóa học không được để trống.")
    private String nameCourse;

    public CourseDTO(long id, String nameCourse) {
        this.id = id;
        this.nameCourse = nameCourse;
    }

    public CourseDTO(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public CourseDTO() {
    }
}
