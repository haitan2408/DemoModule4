package com.codegym.dao.entity;

import javax.persistence.*;
import java.util.Set;

@Table
@Entity(name = "instructor")
public class Instructor extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_instructor")
    private String nameInstructor;

    @Column(name = "level")
    private String level;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "description")
    private String description;

    @Column(name = "specialize")
    private String specialize;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "deleted")
    private boolean deleted;

    @OneToMany(mappedBy="instructor")
    private Set<ClassStudent> classStudents;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id_user")
    private User user;


    public Instructor(String nameInstructor, String level, String address, String phoneNumber, String email,
                      String description, String specialize, Double salary, boolean deleted, User user) {
        this.nameInstructor = nameInstructor;
        this.level = level;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.salary = salary;
        this.specialize = specialize;
        this.description = description;
        this.deleted = deleted;
        this.user = user;
    }

    public Instructor() {
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpecialize() {
        return specialize;
    }

    public void setSpecialize(String specialize) {
        this.specialize = specialize;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Set<ClassStudent> getClassStudents() {
        return classStudents;
    }

    public void setClassStudents(Set<ClassStudent> classStudents) {
        this.classStudents = classStudents;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
