/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FreeCourses.logic;

import javax.persistence.*;

/**
 *
 * @author felig
 */
@Entity
@Table(name = "managers")
public class Administrator extends User {
    @Column(name = "name")
    private String name;
    
    public Administrator() {
    }

    public Administrator(String name) {
        this.name = name;
    }

//    public Administrator(String name, String id, String password, int type) {
//        super(id, password, type);
//        this.name = name;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Administrator{" + "name=" + name + '}';
    }
}
