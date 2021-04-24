/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FreeCourses.logic;

import java.io.Serializable;
import javax.persistence.*;
/**
 *
 * @author felig
 */
@Entity
@Table(name = "enrollments")
public class Enrollment implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "grade")
    private float grade;
    
    @ManyToOne
    @JoinColumn(name = "id_section", nullable = false)
    private Section section;
    
    @ManyToOne
    @JoinColumn(name = "id_student", nullable = false)
    private Student student;
    
    public Enrollment(){
    }

    public Enrollment(float grade, Section section, Student student) {
        this.grade = grade;
        this.section = section;
        this.student = student;
    }

    public Enrollment(Section section, Student student) {
        this.section = section;
        this.student = student;
    }

    public Enrollment(float grade) {
        this.grade = grade;
    }

    public Enrollment(int id, float grade) {
        this.id = id;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Enrollment{" + "id=" + id + ", grade=" + grade + '}';
    }
}
