/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FreeCourses.logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
/**
 *
 * @author felig
 */
@Entity
@Table(name = "students")
public class Student  implements Serializable {
    
    @Id
    @Column(name = "id", unique = true, columnDefinition = "varchar(64)")
    private String id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "phone")
    private String phone;
    
    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollmentsList;

    public Student() {
        this.enrollmentsList = new ArrayList<>();
    }

    public Student(String id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.enrollmentsList = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
   
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
    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", enrollmentsList=" + enrollmentsList + '}';
    }
}

