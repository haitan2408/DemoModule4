package com.codegym.dao.DTO.instructor;

import com.codegym.dao.entity.User;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class InstructorDTO {

    private Long id;

    @NotBlank(message = "Tên của giáo viên không được để trống")
    private String nameInstructor;

    private String level;

    @NotBlank(message = "Địa chỉ không được để trống")
    private String address;

    @NotBlank(message = "Số điện thoại của giáo viên không được để trống")
    @Pattern(regexp = "^(0)+([0-9]{9})$", message = "Số điện thoại không đúng định dạng (0xxxxxxxxx)")
    private String phoneNumber;

    @Pattern(regexp = "^[a-z][a-z0-9_\\.]{1,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$", message = "Email không đúng định dạng")
    private String email;

    private String description;

    @NotBlank(message = "Chuyên ngành của giáo viên không được để trống")
    private String specialize;

    @Min(value = 1000,message = "Lương tối thiểu phải được 1000")
    private Double salary;

    private Boolean deleted;

    @NotBlank(message = "username không được để trống")
    private String username;

    @NotBlank(message = "password không được để trống")
    @Size(min = 5, max = 30, message = "Password tối thiểu phải 5 kí tự và nhiều nhất 30 kí tự")
    private String password;


    public InstructorDTO(String nameInstructor, String level, String address, String phoneNumber, String email,
                         String description, String specialize, Double salary, Boolean deleted, User user) {
        this.nameInstructor = nameInstructor;
        this.level = level;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.salary = salary;
        this.specialize = specialize;
        this.description = description;
        this.deleted = deleted;
        this.username = user.getUserName();
        this.password = user.getPassword();
    }

    public InstructorDTO() {
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

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
