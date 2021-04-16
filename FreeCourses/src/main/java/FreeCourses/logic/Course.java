/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FreeCourses.logic;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author felig
 */
@Entity
@Table(name = "courses")
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "thematic")
    private String thematic;
    @Column(name = "status")
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name="courses_sections",joinColumns = @JoinColumn(name = "id"))
    private List<Section> sectionsList;

    public Course() {
        
    }
    public Course(int id, String name, String thematic, boolean status, List<Section> sectionsList) {
        this.id = id;
        this.name = name;
        this.thematic = thematic;
        this.status = status;
        this.sectionsList = sectionsList;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThematic() {
        return thematic;
    }

    public void setThematic(String thematic) {
        this.thematic = thematic;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Section> getGroupsList() {
        return sectionsList;
    }

    public void setGroupsList(List<Section> sectionsList) {
        this.sectionsList = sectionsList;
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", name=" + name + ", thematic=" + thematic + ", sectionsList=" + sectionsList + '}';
    }
}
