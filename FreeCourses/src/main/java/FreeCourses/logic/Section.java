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
@Table(name = "sections")
public class Section implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "schedule")
    private String schedule;
    
    @OneToMany(mappedBy = "section")
    private List<Enrollment> enrollmentsList;
    
    @ManyToOne()
    @JoinColumn(name = "id_course", nullable = false)
    private Course course;
    
    @ManyToOne
    @JoinColumn(name = "id_professor", nullable = true)
    private Professor professor;

    public Section() {
        this.enrollmentsList = new ArrayList<>();
    }

    public Section(String schedule) {
        this.schedule = schedule;
        this.enrollmentsList = new ArrayList<>();
    }

    public Section(String schedule, Course course, Professor professor) {
        this.schedule = schedule;
        this.course = course;
        this.professor = professor;
        this.enrollmentsList = new ArrayList<>();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public List<Enrollment> getEnrollmentsList() {
        return enrollmentsList;
    }

    public void setEnrollmentsList(List<Enrollment> enrollmentsList) {
        this.enrollmentsList = enrollmentsList;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "Group{" + "id=" + id + ", schedule=" + schedule + ", enrollmentsList=" + enrollmentsList + '}';
    }
}
