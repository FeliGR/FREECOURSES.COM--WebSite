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
@Table(name = "professors")
public class Professor implements Serializable {

    @Id
    @Column(name = "id", unique = true, columnDefinition = "varchar(64)")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "specialty")
    private String specialty;

    @OneToMany(mappedBy = "professor")
    private List<Section> sectionsList;

    public Professor() {
        this.sectionsList = new ArrayList<>();
    }

    public Professor(String id, String name, String phone, String specialty, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.specialty = specialty;
        this.email = email;
        this.sectionsList = new ArrayList<>();
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

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public List<Section> getSectionsList() {
        return sectionsList;
    }

    public void setSectionsList(List<Section> sectionsList) {
        this.sectionsList = sectionsList;
    }

    @Override
    public String toString() {
        return "Professor{" + "id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", specialty=" + specialty + ", sectionsList=" + sectionsList + '}';
    }
}
