/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FreeCourses.logic;

import java.util.List;
import javax.persistence.*;
/**
 *
 * @author felig
 */
@Entity
@Table(name = "students")
public class Student extends User {
    
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name="students_enrollments",joinColumns = @JoinColumn(name = "id"))
    private List<Enrollment> enrollmentsList;

    public Student() {
    }

//    public Student(String id, String password, int type) {
//        super(id, password, type);
//    }
//
//    public Student(String id, String name, String email, String phone, List<Enrollment> enrollmentsList) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.phone = phone;
//        this.enrollmentsList = enrollmentsList;
//    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Enrollment> getEnrollmentsList() {
        return enrollmentsList;
    }

    public void setEnrollmentsList(List<Enrollment> enrollmentsList) {
        this.enrollmentsList = enrollmentsList;
    }

//    @Override
//    public String toString() {
//        return "Student{" + "id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", enrollmentsList=" + enrollmentsList + '}';
//    }
}

