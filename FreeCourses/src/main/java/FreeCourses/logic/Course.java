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
@Table(name = "courses")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "thematic")
    private String thematic;

    @Column(name = "status")
    private boolean status;

    @Column(name = "price")
    private float price;

    @OneToMany(mappedBy = "course", orphanRemoval = true, cascade = CascadeType.PERSIST)
    private List<Section> sectionsList;

    public Course() {
    }

    public Course(String name, String thematic, boolean status) {
        this.name = name;
        this.thematic = thematic;
        this.status = status;
        this.sectionsList = new ArrayList<>();
    }

    public Course(String name, String thematic, float price) {
        this.name = name;
        this.thematic = thematic;
        this.price = price;
        this.sectionsList = new ArrayList<>();
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<Section> getSectionsList() {
        return sectionsList;
    }

    public void setSectionsList(List<Section> sectionsList) {
        this.sectionsList = sectionsList;
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", name=" + name + ", thematic=" + thematic + ", status=" + status + ", price=" + price + ", sectionsList=" + sectionsList + '}';
    }
}
