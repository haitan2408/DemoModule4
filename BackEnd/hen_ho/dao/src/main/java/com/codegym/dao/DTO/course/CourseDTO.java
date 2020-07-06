package com.codegym.dao.DTO.course;

import javax.validation.constraints.NotBlank;

public class CourseDTO {
    private long id;

    @NotBlank(message = "Tên của khóa học không được để trống.")
    private String nameCourse;

    private boolean deleted;

    public CourseDTO() {
    }

    public CourseDTO(long id, String nameCourse, boolean deleted) {
        this.id = id;
        this.nameCourse = nameCourse;
        this.deleted = deleted;
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean delete) {
        this.deleted = delete;
    }
}
