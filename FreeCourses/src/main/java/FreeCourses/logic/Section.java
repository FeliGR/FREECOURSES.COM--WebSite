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
    
    @OneToMany(mappedBy = "enrollment")
    private List<Enrollment> enrollmentsList;
    @ManyToOne
    @JoinColumn(name = "id_course", nullable = false)
    private Course course;

    public Section() {
    }

    public Section(String schedule) {

        this.schedule = schedule;
    }

    public Section(String schedule, Course course) {
        this.schedule = schedule;
        this.course = course;
        this.enrollmentsList = new ArrayList<>();
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
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

    @Override
    public String toString() {
        return "Group{" + "id=" + id + ", schedule=" + schedule + ", enrollmentsList=" + enrollmentsList + '}';
    }
}
