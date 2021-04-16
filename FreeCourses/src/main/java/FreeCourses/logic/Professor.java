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
@Table(name = "professors")
public class Professor extends User{
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "specialty")
    private String specialty;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name="professors_sections",joinColumns = @JoinColumn(name = "id"))
    private List<Section> sectionsList;

    public Professor() {
    }

//    public Professor(String id, String password, int type) {
//        super(id, password, type);
//    }

    public Professor(String name, String email, String phone, String specialty, List<Section> sectionsList) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.specialty = specialty;
        this.sectionsList = sectionsList;
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

    public List<Section> getGroupsList() {
        return sectionsList;
    }

    public void setGroupsList(List<Section> sectionsList) {
        this.sectionsList = sectionsList;
    }

    @Override
    public String toString() {
        return "Professor{" + "name=" + name + ", email=" + email + ", phone=" + phone + ", specialty=" + specialty + ", sectionsList=" + sectionsList + '}';
    }
}
