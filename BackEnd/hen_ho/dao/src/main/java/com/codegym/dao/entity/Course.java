package com.codegym.dao.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_course")
    private String nameCourse;

    @Column(name = "deleted")
    private boolean deleted;

    @OneToMany(mappedBy="course")
    private Set<ClassStudent> classStudents;

    public Course(String nameCourse, boolean deleted) {
        this.nameCourse = nameCourse;
        this.deleted = deleted;
    }

    public Course(String nameCourse, boolean deleted, Set<ClassStudent> classStudents) {
        this.classStudents = classStudents;
        this.nameCourse = nameCourse;
        this.deleted = deleted;
    }

    public Course() {
    }

    public Set<ClassStudent> getClassStudents() {
        return classStudents;
    }

    public void setClassStudents(Set<ClassStudent> classStudents) {
        this.classStudents = classStudents;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
