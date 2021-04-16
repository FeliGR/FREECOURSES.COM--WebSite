/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FreeCourses;
import java.io.Serializable;
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
    @Column(name = "courseName")
    private String courseName;
     @Column(name = "schedule")
    private String schedule;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name="sections_enrollments",joinColumns = @JoinColumn(name = "id"))
    private List<Enrollment> enrollmentsList;
     
    public Section() {
    }

    public Section(int id, String courseName, String schedule) {
        this.id = id;
        this.courseName = courseName;
        this.schedule = schedule;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
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
        return "Group{" + "id=" + id + ", courseName=" + courseName + ", schedule=" + schedule + ", enrollmentsList=" + enrollmentsList + '}';
    }
}
