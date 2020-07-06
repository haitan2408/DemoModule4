package com.codegym.dao.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "class_student")
public class ClassStudent extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_class")
    private String nameClass;

    @Column(name = "start_day")
    private LocalDate startDay;

    @Column(name="deleted")
    private Boolean deleted;

    @ManyToOne
    @JoinColumn(name="instrustor_id")
    private Instructor instructor;

    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;


    public ClassStudent() {
    }

    public ClassStudent(String nameClass, LocalDate startDay, Boolean deleted, Instructor instructor, Course course) {
        this.nameClass = nameClass;
        this.startDay = startDay;
        this.deleted = deleted;
        this.instructor = instructor;
        this.course=course;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public LocalDate getStartDay() {
        return startDay;
    }

    public void setStartDay(LocalDate startDay) {
        this.startDay = startDay;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
